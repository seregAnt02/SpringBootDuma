Описание проекта:
Сервис клиент-серверного приложения, протоколы HTTP, TCP/IP, UDP, функционал предполагает удаленное взаимодействие с локальными серверами. Развертыванием сети по протоколу Modbus RTU(RS485), и подключением в виде микроконтроллеров, датчиков, интерфейсов управления, расширений и т.д

Запуск web-приложения, с использованием Docker:
1) sudo docker build -t name-images . -> создание образа.
2) sudo docker run -d --name name-container -p 8180:8180 name-images -> запуск приложения из образа. 

