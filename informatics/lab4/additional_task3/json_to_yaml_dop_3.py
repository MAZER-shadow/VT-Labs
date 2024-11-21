import re


class JSON_Validator:
    def validate(self, json_str):
        json_str = json_str.strip() # Удаляем лишние пробелы вокруг строки
        try:
            if json_str.startswith("{"):
                self.validate_object(json_str) # Если это объект
            elif json_str.startswith("["):
                self.validate_array(json_str) # Если это массив
            elif json_str.startswith("\""):
                self.validate_string(json_str) # Если это строка
            elif re.match(r"^-?\d+(\.\d+)?([eE][+-]?\d+)?$", json_str):
                self.validate_number(json_str) # Если это число
            elif json_str in ["true", "false", "null"]:
                pass  # Если это литерал JSON: true, false, null — они всегда верны очевидно
            else:
                raise ValueError("Invalid JSON syntax") # Если не удалось определить тип, это ошибка
            return True  # Если ошибок не было, JSON корректен
        except ValueError as e:
            print(f"json validation error: {e}") # Выводим сообщение об ошибке
            return False

    def validate_object(self, json_str):
        if not (json_str.startswith("{") and json_str.endswith("}")): # Объект должен начинаться с { и заканчиваться на }
            raise ValueError("Ошибка синтаксиса")
        content = json_str[1:-1].strip() # Убираем внешние фигурные скобки и пробелы
        if not content:  # Пустой объект "{}" считается корректным
            return
        # Разделяем содержимое объекта на ключ-значение по верхнему уровню
        pairs = self.split_top_level(content, ",")
        for pair in pairs:
            if ":" not in pair:
                raise ValueError("ошибка ключ знеачения ':'") # Каждая пара должна содержать ":"
            key, value = map(str.strip, pair.split(":", 1)) # Разделяем ключ и значение
            self.validate_string(key)  # Ключи должны быть строками
            self.validate(value)       # Значения проверяются рекурсивно

    def validate_array(self, json_str):
        if not (json_str.startswith("[") and json_str.endswith("]")):
            raise ValueError("ошибка синтаксиса массивов") # Массив должен начинаться с [ и заканчиваться на ]
        content = json_str[1:-1].strip() # Убираем внешние квадратные скобки и пробелы
        if not content:  # Пустой объект "[]" считается корректным
            return
        # Разделяем элементы массива по верхнему уровню
        elements = self.split_top_level(content, ",")
        for element in elements:
            self.validate(element) # Рекурсивно проверяем каждый элемент массива

    def validate_string(self, json_str):
        if not (json_str.startswith("\"") and json_str.endswith("\"")):
            raise ValueError("ошибка синтаксиса строк") # Строка должна начинаться и заканчиваться на "
        string_content = json_str[1:-1] # Извлекаем содержимое строки
        if "\\" in string_content:# Если есть символы экранирования
            if not re.match(r'(\\["\\/bfnrt]|\\u[0-9a-fA-F]{4})', string_content):# Проверяем, корректны ли последовательности экранирования
                raise ValueError("ошибка ескейп последовательности")

    def validate_number(self, json_str):
        if not re.match(r"^-?\d+(\.\d+)?([eE][+-]?\d+)?$", json_str):# Число может быть целым, дробным или с экспонентой
            raise ValueError("ошибка числа")

    def split_top_level(self, s, delimiter): # Разделяет строку по верхнему уровню, игнорируя вложенные структуры.
        parts = []  # Результирующий список
        depth = 0 # Глубина вложенности (для фигурных скобок и массивов)
        current = [] # Текущий элемент, который накапливается
        for char in s:
            if char in "{[":
                depth += 1 # Увеличиваем глубину для вложенных объектов или массивов
            elif char in "}]":
                depth -= 1 # Уменьшаем глубину при выходе из объектов или массивов
            elif char == delimiter and depth == 0:
                parts.append("".join(current).strip()) # Если встретили разделитель на верхнем уровне, фиксируем накопленный элемент
                current = []
                continue
            current.append(char) # Добавляем символ в текущий элемент
        if current:
            parts.append("".join(current).strip()) # Добавляем последний накопленный элемент
        return parts


class YAML_Validator:
    def validate(self, yaml_str):

        self.lines = yaml_str.splitlines()  # Разделяем строку на строки
        self.current_line = 0
        self.indent_levels = [0] # Список для отслеживания уровней отступов
        self.validate_document()  # Начинаем проверку с документа

    def validate_document(self):
        while self.current_line < len(self.lines):
            line = self.lines[self.current_line].strip()
            if not line or line.startswith("#"):  # Пропускаем пустые строки и комментарии
                self.current_line += 1
                continue
            self.validate_key_value_or_list()

    def validate_key_value_or_list(self):
        line = self.lines[self.current_line]
        current_indent = len(line) - len(line.lstrip())
        # Проверяем уровень отступа
        if current_indent > self.indent_levels[-1]:
            self.indent_levels.append(current_indent)
        elif current_indent < self.indent_levels[-1]:
            while self.indent_levels and current_indent < self.indent_levels[-1]:
                self.indent_levels.pop()
            if current_indent != self.indent_levels[-1]:
                raise ValueError(f"Некорректный отступ в строке {self.current_line + 1}: {line}")

        line = line.strip()
        if line.startswith("-"):  # Список
            self.validate_list_item(line)
        elif ":" in line:  # Пара ключ-значение
            self.validate_key_value(line)
        else:
            raise ValueError(f"Некорректный синтаксис в строке {self.current_line + 1}: {line}")

        self.current_line += 1

    def validate_list_item(self, line):
        # Формат списка: "- значение"
        if not re.match(r"^- (\S.*)?$", line):
            raise ValueError(f"Некорректный элемент списка в строке {self.current_line + 1}: {line}")

    def validate_key_value(self, line):
        key, sep, value = line.partition(":")
        if not sep:
            raise ValueError(f"Пропущен ':' в строке {self.current_line + 1}: {line}")

        key = key.strip()
        value = value.strip()

        # Проверка ключа
        if not re.match(r"^[a-zA-Z\u0400-\u04FF0-9_\-\"']+$", key):
            raise ValueError(f"Некорректный ключ в строке {self.current_line + 1}: {key}")

        # Проверка значения
        if value:
            self.validate_value(value)

    def validate_value(self, value):
        if value in ["null", "true", "false"]:  # Литералы
            return
        if re.match(r"^-?\d+(\.\d+)?$", value):  # Числа
            return
        if value.startswith("\"") and value.endswith("\""):  # Строка в двойных кавычках
            return
        if value.startswith("'") and value.endswith("'"):  # Строка в одинарных кавычках
            return
        if not re.match(r"^[a-zA-Z\u0400-\u04FF0-9_\- ]+$", value):  # Простое значение
            raise ValueError(f"Некорректное значение в строке {self.current_line + 1}: {value}")

#!!!!!!!!!!!!!!!!!!!#
#!!!!!!!!!!!!!!!!!!!#
#!!!!!!!!!!!!!!!!!!!#
#!!!!!!!!!!!!!!!!!!!#
#!!!!!!!!!!!!!!!!!!!#
#!!!!!!!!!!!!!!!!!!!#
try:
    json = open("etalon.json").read()
    json_validator = JSON_Validator()
    if json_validator.validate(json):
        fileStart = open("myJson.json")
        fileResult = open("resultMidle.yaml", "w+")
        a1 = "////////////"
        a2 = "/////////////"  # ввод переменных для  подсчета пробелов для  вставления "- " в элементах массива
        a3 = "//////////////"
        countList = 0
        countQuotes = 0
        for i in fileStart.read():
            if i in ["{", "}", ","]:
                continue
            if i == "[":  # ввод ифов для вставки "- "
                countList += 1
                continue
            if i == "]":
                countList = 0
                continue
            if countList == 1:
                if a2 == " " and a3 == " " and i != " ":  # если у нас два пробела и не пробел то мы вставляем "- "
                    fileResult.write("-" + a2)
            if a1 == ":" and a2 == " " and a3 == "\"" and re.match(r'\d',i):
                countQuotes += 1
                fileResult.write("\'")
            a1 = a2
            a2 = a3
            a3 = i
            if i == "\"":
                if countQuotes == 1:
                    fileResult.write("\'")
                    countQuotes = 0
                continue
            fileResult.write(i)
        fileResult.close()
        fileStart.close()
        fileStart = open("resultMidle.yaml", "r")
        fileFinal = open("resultFinal_dop_3.yaml", "w+")
        for i in fileStart:
            if re.match(r'\s\s+\n',i):
                continue
            fileFinal.write(i[2:])
        fileFinal.close()
except FileNotFoundError:
    print("нет такого json")

# yaml = open("resultFinal_dop_2.yaml").read()
# yaml_validator = YAML_Validator()
# if yaml_validator.validate(yaml) == None:
#     print("YAML корректен")
