FROM openjdk:17-jdk-alpine

# Устанавливаем рабочую директорию
WORKDIR /app

# Копируем файлы собранного приложения в контейнер
COPY ./target/*.jar app.jar

# Указываем порт, который будет использоваться приложением
EXPOSE 8080

# Команда для запуска приложения при старте контейнера
CMD ["java", "-jar", "app.jar"]