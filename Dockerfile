# Usa una imagen base oficial de Maven con OpenJDK 17 para la construcción
FROM maven:3.8.6-openjdk-17 AS build

# Establece el directorio de trabajo
WORKDIR /app

# Copia los archivos de configuración del proyecto
COPY pom.xml .

# Descarga las dependencias necesarias (útil para caché)
RUN mvn dependency:go-offline

# Copia el código fuente del proyecto
COPY src ./src

# Compila el proyecto
RUN mvn clean package

# Usa una imagen más ligera de OpenJDK para ejecutar la aplicación
FROM openjdk:17-jdk-slim

# Establece el directorio de trabajo
WORKDIR /app

# Copia el archivo JAR generado desde la fase de construcción
COPY --from=build /app/target/Crud-0.0.1-SNAPSHOT.jar app.jar


# Comando para ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "app.jar"]


