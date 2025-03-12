# Usa una imagen base con OpenJDK 17
FROM openjdk:17-jdk-slim

# Directorio de trabajo en el contenedor
WORKDIR /app

# Copiar los archivos del proyecto (incluyendo gradlew) al contenedor
COPY . .

# Asegúrate de que gradlew tenga permisos de ejecución
RUN chmod +x gradlew

# Exponer el puerto 8081 para la aplicación
EXPOSE 8081

# Comando para ejecutar la aplicación con Gradle
CMD ["./gradlew", "bootRun", "--args=--server.port=8081"]
