# Символы и ключевые слова JSON
JSON_COMMA = ','
JSON_COLON = ':'
JSON_LEFTBRACKET = '['
JSON_RIGHTBRACKET = ']'
JSON_LEFTBRACE = '{'
JSON_RIGHTBRACE = '}'
JSON_QUOTE = '"'
QUOTE = '"'

# Списки для проверки пробелов и синтаксиса
WHITESPACE = [' ', '\t', '\b', '\n', '\r']
SYNTAX = [JSON_COMMA, JSON_COLON, JSON_LEFTBRACKET, JSON_RIGHTBRACKET,
          JSON_LEFTBRACE, JSON_RIGHTBRACE]

# Длины ключевых слов JSON
FALSE_LEN = len('false')
TRUE_LEN = len('true')
NULL_LEN = len('null')

# Функция для лексического анализа строки JSON
def lex_string(string):
    """
    Анализ строки JSON на текстовую строку, заключённую в кавычки.
    """
    json_string = ''

    if string[0] == QUOTE:
        string = string[1:]
    else:
        return None, string

    for c in string:
        if c == QUOTE:
            return json_string, string[len(json_string) + 1:]
        else:
            json_string += c

    raise Exception('Ожидается закрывающая кавычка в строке')

# Функция для анализа чисел
def lex_number(string):
    """
    Анализ строки JSON на числовое значение.
    """
    json_number = ''
    number_characters = [str(d) for d in range(0, 10)] + ['-', 'e', '.']

    for c in string:
        if c in number_characters:
            json_number += c
        else:
            break

    rest = string[len(json_number):]

    if not len(json_number):
        return None, string

    if '.' in json_number:
        return float(json_number), rest

    return int(json_number), rest

# Функция для анализа ключевого слова null
def lex_null(string):
    """
    Анализ строки JSON на ключевое слово null.
    """
    strlen = len(string)
    if strlen >= NULL_LEN and string[:NULL_LEN] == 'null':
        return True, string[NULL_LEN]

    return None, string

# Функция для анализа булевых значений
def lex_bool(string):
    """
    Анализ строки JSON на булевые значения true или false.
    """
    string_len = len(string)

    if string_len >= TRUE_LEN and string[:TRUE_LEN] == 'true':
        return True, string[TRUE_LEN:]
    elif string_len >= FALSE_LEN and string[:FALSE_LEN] == 'false':
        return False, string[FALSE_LEN:]

    return None, string

# Лексический анализатор JSON
def lex(string):
    """
    Основной лексический анализатор JSON.
    Возвращает список токенов.
    """
    tokens = []

    while len(string):
        json_string, string = lex_string(string)
        if json_string is not None:
            tokens.append(json_string)
            continue

        json_number, string = lex_number(string)
        if json_number is not None:
            tokens.append(json_number)
            continue

        json_bool, string = lex_bool(string)
        if json_bool is not None:
            tokens.append(json_bool)
            continue

        json_null, string = lex_null(string)
        if json_null is not None:
            tokens.append(None)
            continue

        if string[0] in WHITESPACE:
            string = string[1:]
        elif string[0] in SYNTAX:
            tokens.append(string[0])
            string = string[1:]
        else:
            raise Exception(f"Неизвестный символ: {string[0]}")

    return tokens

# Парсер для массива JSON
def parse_array(tokens):
    """
    Парсер для массивов JSON.
    """
    json_array = []

    if not tokens or tokens[0] == JSON_RIGHTBRACKET:
        return json_array, tokens[1:]

    while True:
        json_value, tokens = parse(tokens)
        json_array.append(json_value)

        if not tokens:
            raise Exception('Неожиданный конец ввода в массиве')

        t = tokens[0]
        if t == JSON_RIGHTBRACKET:
            return json_array, tokens[1:]
        elif t != JSON_COMMA:
            raise Exception('Ожидается запятая после элемента массива')
        tokens = tokens[1:]

# Парсер для объекта JSON
def parse_object(tokens):
    """
    Парсер для объектов JSON.
    """
    json_object = {}

    if not tokens or tokens[0] == JSON_RIGHTBRACE:
        return json_object, tokens[1:]

    while True:
        if not tokens:
            raise Exception('Неожиданный конец ввода в объекте')

        json_key = tokens[0]
        if isinstance(json_key, str):
            tokens = tokens[1:]
        else:
            raise Exception('Ожидается ключ типа строка')

        if not tokens or tokens[0] != JSON_COLON:
            raise Exception('Ожидается двоеточие (:) в объекте')
        tokens = tokens[1:]

        json_value, tokens = parse(tokens)
        json_object[json_key] = json_value

        if not tokens:
            raise Exception('Неожиданный конец ввода в объекте')
        t = tokens[0]
        if t == JSON_RIGHTBRACE:
            return json_object, tokens[1:]
        elif t != JSON_COMMA:
            raise Exception(f'Ожидается запятая после пары ключ-значение, получено: {t}')
        tokens = tokens[1:]

# Универсальный парсер JSON
def parse(tokens):
    """
    Универсальный парсер JSON.
    """
    if not tokens:
        raise Exception('Неожиданный конец ввода')

    t = tokens[0]
    if t == JSON_LEFTBRACKET:
        return parse_array(tokens[1:])
    elif t == JSON_LEFTBRACE:
        return parse_object(tokens[1:])
    else:
        return t, tokens[1:]

def loads(string):
    return parse(lex(string))[0]

from enum import Enum, auto

class Type(Enum):
    NULL = auto()
    BOOL = auto()
    INT = auto()
    FLOAT = auto()
    STR = auto()
    ARR = auto()
    OBJ = auto()

    def to_type(value):
        if isinstance(value, bool):
            return Type.BOOL
        elif isinstance(value, int):
            return Type.INT
        elif isinstance(value, float):
            return Type.FLOAT
        elif isinstance(value, str):
            return Type.STR
        elif isinstance(value, type([])):
            return Type.ARR
        elif isinstance(value, type({})):
            return Type.OBJ
        return Type.NULL


# Импортируем Enum и auto для работы с перечислениями
from enum import Enum, auto

# Перечисление типов данных, поддерживаемых для преобразования
class Type(Enum):
    NULL = auto()  # Null значение
    BOOL = auto()  # Булево значение
    INT = auto()   # Целое число
    FLOAT = auto() # Число с плавающей точкой
    STR = auto()   # Строка
    ARR = auto()   # Массив
    OBJ = auto()   # Объект (словарь)

    # Метод для определения типа данных объекта
    def to_type(value):
        """
        Определяет тип данных переданного объекта.
        """
        if isinstance(value, bool):
            return Type.BOOL
        elif isinstance(value, int):
            return Type.INT
        elif isinstance(value, float):
            return Type.FLOAT
        elif isinstance(value, str):
            return Type.STR
        elif isinstance(value, list):  # Проверка, является ли объект списком
            return Type.ARR
        elif isinstance(value, dict):  # Проверка, является ли объект словарём
            return Type.OBJ
        return Type.NULL  # Если ничего не подошло, возвращается NULL


# Класс Yaml, который предоставляет методы для сериализации объектов в YAML-формат
class Yaml:
    @staticmethod
    def dump(obj):
        """
        Основной метод для преобразования объекта в YAML-формат.
        Создаёт экземпляр Yaml и вызывает метод to_string.
        """
        return Yaml.create(obj).to_string()

    def __init__(self, data_type, data):
        """
        Конструктор класса Yaml.
        :param data_type: Тип данных (из перечисления Type).
        :param data: Данные, которые нужно преобразовать.
        """
        self._data, self._data_type = data, data_type

    @staticmethod
    def create(obj):
        """
        Рекурсивно создаёт объект Yaml на основе переданных данных.
        :param obj: Объект для преобразования.
        :return: Экземпляр класса Yaml.
        """
        data_type = Type.to_type(obj)  # Определяем тип данных объекта
        data = obj
        if data_type == Type.ARR:  # Если это массив, рекурсивно обрабатываем элементы
            data = [Yaml.create(val) for val in obj]
        elif data_type == Type.OBJ:  # Если это объект, рекурсивно обрабатываем пары ключ-значение
            data = {key: Yaml.create(val) for key, val in obj.items()}
        return Yaml(data_type, data)

    def to_string(self, tabs=0, prefix=''):
        """
        Преобразует объект Yaml в строку в формате YAML.
        :param tabs: Текущий уровень отступов (используется для вложенных структур).
        :param prefix: Префикс для значения (например, пробел перед значением).
        :return: YAML-строка.
        """
        # Функция для создания отступов
        def pre(tabs):
            return "  " * tabs

        # Если объект пустой массив или словарь
        if ((self._data_type == Type.ARR or self._data_type == Type.OBJ) and len(self._data) == 0):
            return "[]" if self._data_type == Type.ARR else "{}"

        # Если это массив
        elif self._data_type == Type.ARR:
            return '' if tabs == 0 else '\n' + '\n'.join(
                ["{}- {}".format(pre(tabs - 1), val.to_string(tabs)) for val in self._data]) + '\n'

        # Если это объект (словарь)
        elif self._data_type == Type.OBJ:
            return '\n{}'.format(pre(tabs)).join(
                ["{}:\n{}{}".format(key, pre(tabs + 1), val.to_string(tabs + 1, prefix=' '))
                 if (val._data_type == Type.OBJ) else "{}:{}".format(key, val.to_string(tabs + 1, prefix=' '))
                 for key, val in self._data.items()])

        # Если это null
        elif self._data_type == Type.NULL:
            return prefix + "null"

        # Если это строка
        elif self._data_type == Type.STR:
            # Для строк с переносами
            if len(self._data.split('\n')) > 1:
                return " |\n" + '\n'.join(pre(tabs + 1) + val for val in self._data.split('\n'))
            else:
                return prefix + self._data

        # Для других типов (булевое, число)
        else:
            return prefix + str(self._data)

json_obj = open('myJson.json')
midRes = loads(json_obj.read())
print(midRes)
yaml = Yaml
fileFinal = open('resultFinal_dop_3_var2.yaml', 'w+')
fileFinal.write(yaml.dump(midRes))
fileFinal.close()