FROM python:3.13.2-slim

WORKDIR /weatherapp

COPY ./BackEnd/requirements.txt /weatherapp/requirements.txt
RUN pip3 install -r requirements.txt

COPY ./BackEnd /weatherapp

CMD ["fastapi", "run", "main.py", "--port", "80"]