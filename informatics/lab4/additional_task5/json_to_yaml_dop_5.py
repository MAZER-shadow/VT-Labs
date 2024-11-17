import json
import csv

json_data = json.load(open('myJson.json', 'r', encoding='utf-8'))

writer = csv.writer(open('resultFinal_dop_5.csv', 'w', encoding='utf-8', newline=''), delimiter=';')

writer.writerow(['номер_недели'] + json_data['номер_недели'])
writer.writerow('')  # переписываем номера недели
writer.writerow('')  # переписываем номера недели
writer.writerow('')  # переписываем номера недели

for day in json_data['день_недели']:  # заходим в цикл, где будем спускаться для записи ниже
    writer.writerow(['день_недели'] + [day])  # записываем переменные, в которых копаемся
    writer.writerow('')
    writer.writerow(['пара'] + [i for i in json_data['день_недели'][day]])
    atr = []  # список для добавления туда атрибутов например [[информатика, лабораторная], [10:00, 11:30]]
    for j in json_data['день_недели'][day]['пара_1']:
        atr.append(
            [])  # цикл для добавления в наш список атрибутов непосредственно нужное количество списков для атрибутов
    for i in json_data['день_недели'][day]:
        s = 0  # список для захода в пары конкретного дня
        for j in json_data['день_недели'][day][i]:  # список для захода в непосредственно атрибутов у пар
            atr[s].append(
                json_data['день_недели'][day][i][j])  # добавляем в список атрибутов под нужным номером наш атрибут
            s += 1
    s = 0
    for j in json_data['день_недели'][day]['пара_1']:
        writer.writerow([j] + atr[s])
        s += 1  # записываем название атрибута + значения атрибутов
    writer.writerow('')
    writer.writerow('')
