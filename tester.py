import requests

id = int(input('Введите id сенсора: '))
URL = f'http://localhost:8080/sensors/{id}'
r = requests.get(url = URL)
sensor = r.json()
print(f'Сенсор: {sensor["name"]}')
print(f'Температура: {sensor["temperature"]}')
print(f'Дождь: {sensor["rain"]}')