import yaml
import json

with open('myJson.json', 'r') as file:
    configuration = json.load(file)

with open('resultFinal_dop_1.yaml', 'w+') as yaml_file:
    yaml.dump(configuration, yaml_file, sort_keys=False, allow_unicode=True)