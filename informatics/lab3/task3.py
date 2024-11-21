import json
import re
k = []
my_json = {}
my_answers = ['']
string = input("введите ваше сообщение: ")
for i in re.finditer(r"Bitcoin [\W\w]* ₽([ \-.,\d]*) RUB[\W\w]*Ethereum", string):
    print(i.group(1))
    k.append(i.group(1))

if len(k) != 0:
    my_answers = k

my_json["answers"] = my_answers

with open('result.json', 'w', encoding="utf-8") as file:
    dumped_json = json.dumps(my_json, ensure_ascii=False)
    file.write(dumped_json)
