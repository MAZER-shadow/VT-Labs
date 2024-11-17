
import time


start_time = time.perf_counter()
for i in range(100):
    import json_to_yaml_main
    #subprocess.run(['python', 'json_to_yaml_main.py'])
end_time = time.perf_counter()

print(f"Основа - {end_time - start_time}")

start_time = time.perf_counter()
for i in range(100):
    import json_to_yaml_dop_1
end_time = time.perf_counter()

print(f"Доп 1  - {end_time - start_time}")

start_time = time.perf_counter()
for i in range(100):
    import json_to_yaml_dop_2
end_time = time.perf_counter()

print(f"Доп 2  - {end_time - start_time}")

start_time = time.perf_counter()
for i in range(100):
    import json_to_yaml_dop_3
end_time = time.perf_counter()

print(f"Доп 3  - {end_time - start_time}")