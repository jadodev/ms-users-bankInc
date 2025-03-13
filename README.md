# ms-users-bankInc

```textplain
  📦 ms_users (Microservicio de Usuarios)
├── 📂 src
│   ├── 📂 main
│   │   ├── 📂 java/com/jonathan/ms_users  # Paquete base del microservicio
│   │   │   ├── 📂 application            # Capa de aplicación (Casos de uso y lógica de negocio)
│   │   │   │   ├── 📂 dto                # Data Transfer Objects (DTOs)
│   │   │   │   │   ├── UserDto.java      # DTO para la entidad de usuario
│   │   │   │   ├── 📂 mapper             # Mapeadores entre capas
│   │   │   │   │   ├── UserMapper.java   # Mapeo entre DTO y dominio
│   │   │   │   ├── 📂 service            # Implementación de la lógica de negocio
│   │   │   │   │   ├── UserServiceApplication.java  
│   │   │   │
│   │   │   ├── 📂 domain                 # Capa de dominio (Reglas de negocio y modelos)
│   │   │   │   ├── 📂 entity             # Entidad del dominio
│   │   │   │   │   ├── User.java         # Entidad de usuario en el dominio
│   │   │   │   ├── 📂 port               # Definición de puertos de la arquitectura hexagonal
│   │   │   │   │   ├── 📂 in             # Puertos de entrada (casos de uso)
│   │   │   │   │   │   ├── UserInterfacePortIn.java  
│   │   │   │   │   ├── 📂 out            # Puertos de salida (acceso a infraestructura)
│   │   │   │   │   │   ├── UserInterfacePortOut.java  
│   │   │   │   ├── 📂 service            # Implementación de los casos de uso del dominio
│   │   │   │   │   ├── UserServiceDomain.java  
│   │   │   │
│   │   │   ├── 📂 infrastructure         # Capa de infraestructura (Adaptadores, persistencia, API)
│   │   │   │   ├── 📂 controller         # Controladores REST
│   │   │   │   │   ├── UserController.java  
│   │   │   │   ├── 📂 entity             # Entidad de persistencia
│   │   │   │   │   ├── UserEntity.java  
│   │   │   │   ├── 📂 mapper             # Mapeador de infraestructura
│   │   │   │   │   ├── UserMapperInfra.java  
│   │   │   │   ├── 📂 repository         # Repositorios de persistencia
│   │   │   │   │   ├── UserRepository.java  
│   │   │   │   │   ├── UserRepositoryJpa.java  
│   │   │   │
│   │   │   ├── MsUsersApplication.java   # Clase principal de la aplicación Spring Boot
│   │   │
│   │   ├── 📂 resources                   # Configuraciones y archivos de recursos
│   │   │   ├── application.properties     # Configuración de la aplicación
│   │
│   ├── 📂 test                            # Pruebas del microservicio
│
├── .gitattributes                         # Configuración de Git
├── .gitignore                             # Archivos ignorados por Git
├── Dockerfile                             # Archivo para construir el contenedor Docker
├── README.md                              # Documentación del proyecto

```

# Microservicio de Backend: Gestión de Usuarios

Este proyecto es un microservicio desarrollado en **Java** y **SpringBoot** que permite la creación y consulta de usuarios. Está diseñado para ser **altamente escalable**, forma parte de una **arquitectura de microservicios** y sigue una **arquitectura hexagonal** para garantizar la separación de responsabilidades, la facilidad de mantenimiento y la escalabilidad.

## Características Principales

- Creación y consulta de usuarios.
- Base de datos MySQL para almacenamiento de datos.
- **Arquitectura hexagonal** para una clara separación entre la lógica de negocio y las capas de infraestructura.
- Despliegue automatizado con **GitHub Actions**, **Docker** y **AWS**.
- Configuración flexible mediante variables de entorno o archivo `application.properties`.

## Estructura del Proyecto

El proyecto está estructurado siguiendo los principios de la **arquitectura hexagonal**, lo que permite una clara separación entre:

- **Capa de Dominio:** Contiene la lógica de negocio y las entidades principales.
- **Capa de Aplicación:** Gestiona los casos de uso y la orquestación de operaciones.
- **Capa de Infraestructura:** Se encarga de la interacción con bases de datos, APIs externas y otros servicios.

Esta estructura facilita la escalabilidad, el mantenimiento y la prueba del microservicio.

## Despliegue Local con Docker

Para ejecutar el proyecto localmente, puedes utilizar Docker. A continuación, se detallan los pasos necesarios para desplegar el microservicio en tu entorno local.

### Requisitos Previos

- **Docker** instalado en tu máquina. Puedes descargarlo desde [aquí](https://www.docker.com/get-started).

### Pasos para Desplegar el Proyecto

1. **Clona el repositorio** en tu máquina local:

   ```bash
   git clone https://github.com/jadodev/ms-users-bankInc.git
   cd ms-users-bankInc
  ``
2. **Configura el archivo application.properties:

   ```bash
    spring.datasource.url=jdbc:mysql://localhost:3306/users_db?createDatabaseIfNotExist=true&serverTimezone=UTC
    spring.datasource.username=root
    spring.datasource.password=root
    spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

    spring.jpa.hibernate.ddl-auto=update
    spring.jpa.show-sql=true
    spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect

    server.port=8081
  ```
3. **Levanta una instancia de MySQL con Docker:
  ```bash
    docker run -d --name mysql-db -e MYSQL_ROOT_PASSWORD=root -e MYSQL_DATABASE=users_db -p 3306:3306 mysql:8.0
  ```
4. **Construye la imagen de Docker para el micros:

  ```bash
    docker build -t ms-users .
  ```
5. **Ejecuta el contenedor para iniciar el microservicio:

  ```bash
    docker run -p 8081:8081 --env-file .env ms-users
  ```

### Una vez que el contenedor esté en ejecución, puedes acceder al microservicio en:

**http://localhost:8081
