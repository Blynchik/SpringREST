import requests

id = int(input('Введите id сенсора: '))
URL = f'http://localhost:8080/sensors/{id}'
r = requests.get(url = URL)
sensor = r.json()

if r.status_code == 404:
    print(f'Ошибка сервера: {r.json()["message"]}')
    print(f'Время ошибки: {r.json()["timestamp"]}')
else:
    print(f'Сенсор: {sensor["name"]}')
