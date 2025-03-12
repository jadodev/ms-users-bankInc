# Usa una imagen base con Java 17
FROM openjdk:17-jdk-slim

# Copia el archivo JAR generado al contenedor
COPY build/libs/mi-aplicacion-1.0.0.jar /app/mi-aplicacion.jar

# Expón el puerto 8081 (o el que necesites)
EXPOSE 8081

# Comando para ejecutar el JAR
ENTRYPOINT ["java", "-jar", "/app/mi-aplicacion.jar"]