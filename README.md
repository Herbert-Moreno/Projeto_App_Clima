<img src="./GitAssets/App_Icon.png" width="20%"> # Projeto de Aplicativo mobile de Clima - Formalmente: WeatherApp

WeatherApp é um aplicativo de previsão do tempo desenvolvido em Flutter, utilizando a API do OpenWeather para obter dados meteorológicos e um backend FastAPI com Python 3.13 para processamento.

## 📷 Ilustrações

|    Tela Inicial    |    |    Tela Mockup    |
| ------------------ |    | ----------------- |
|<img src="./GitAssets/test.png" width="40%">| |<img src="./GitAssets/Mockup.png" width="40%">|


## 📱 Figma 

![](./GitAssets/Figma.png)

## 📌 Funcionalidades

- Exibição de previsão do tempo em tempo real.
- Busca por cidade na barra de pesquisa.
- Interface moderna e responsiva.
- Exibição da sensação térmica em tempo real.

## 🛠️ Tecnologias Utilizadas

### 📱 Frontend (Flutter)

- Flutter 3.29
- Dart
- Dart HTTP para requisições
- Figma para idealização e Mockups

### 🌐 Backend (FastAPI)

- FastAPI
- Python 3.13
- Requests para consumo da API OpenWeather

## 🚀 Como Rodar o Projeto

### 📲 Frontend Local
```bash
# Clone o repositório
git clone https://github.com/Herbert-Moreno/Projeto_App_Clima.git
cd Projeto_App_Clima

# Instale as dependências
dart pub get

# Execute o app
flutter run main.dart
```

### 🔧 Backend
```bash
# Clone o repositório do backend
git clone https://github.com/Herbert-Moreno/Projeto_App_Clima.git
cd Projeto_App_Clima

# Crie um ambiente virtual e instale dependências
python -m venv venv
source venv/bin/activate  # Linux/macOS
venv\Scripts\activate  # Windows
pip install -r requirements.txt
```
## Inciciando o Servidor FastApi

- termina:
![](./GitAssets/StartCommand.png)

- output:
![](./GitAssets/ServerRunning.png)


## 🌍 API Utilizada

- [OpenWeather](https://openweathermap.org/) - Utilizada para obter dados climáticos.
