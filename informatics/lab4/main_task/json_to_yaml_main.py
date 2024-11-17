# myJson.json
try:
    fileStart = open("myJson.json")
except FileNotFoundError:
    print("нет такого jsona")
fileResult = open("resultMidle.yaml", "w+")
a1 = "////////////"
a2 = "/////////////"  # ввод переменных для  подсчета пробелов для  вставления "- " в элементах массива
a3 = "//////////////"
countList = 0
countQuotes = 0
for i in fileStart.read():
    if i == "{" or i == "}" or i == ",":
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
    if a1 == ":" and a2 == " " and a3 == "\"" and i in ["0", "1", "2", "3", "4", "5", "6", "7", "8", "9"]:
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
fileFinal = open("resultFinal_main.yaml", "w+")
for i in fileStart:
    count = 0
    lengthStr = len(i)
    for j in i[:-1]:  # убирание строк из пробелов
        if j == " ":
            count += 1
    if count == lengthStr - 1:
        continue
    fileFinal.write(i[2:])
fileFinal.close()
