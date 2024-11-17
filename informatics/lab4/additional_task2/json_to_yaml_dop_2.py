# myJson.json
import re
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
fileFinal = open("resultFinal_dop_2.yaml", "w+")
for i in fileStart:
    if re.match(r'\s\s+\n',i):
        continue
    fileFinal.write(i[2:])
fileFinal.close()
