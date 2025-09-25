from typing import Union
from fastapi import FastAPI
import requests

app = FastAPI()

@app.get("/")
def init():
    return {"Hello": "World!"}

@app.get("/{city}")
def get_weather(city):
    try:
        chave_api = "3786cd5678c040322f407dfe9826c5f9"#os.environ.get("API_KEY")
        link = f"https://api.openweathermap.org/data/2.5/weather?q={city}&appid={chave_api}"

        if chave_api == '':
            return {"error": "Chave API Errada"}

        response = requests.get(link)
        dados = response.json()

        if response.status_code != 200:
            return {"error": response.status_code}
        
        else:
            dados_clima = {
                "city": city,
                "temperature": str(int(dados["main"]["temp"] - 273.15)),
                "state": str(dados["weather"][0]["main"]).lower()
            }
            return dados_clima
        
    except Exception as err:
        print(err)
        return {"404": "!!City Not Found!!"}
