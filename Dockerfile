# Utiliza una imagen base con OpenJDK 17 y Maven
FROM  maven:3.9.6 AS build

# Establece el directorio de trabajo
WORKDIR /app

# Copia los archivos de tu proyecto al directorio de trabajo
COPY . .

# Construye tu aplicación con Gradle
RUN gradle build --no-daemon

# Cambia a una imagen más ligera de OpenJDK 17 para la ejecución
FROM openjdk:17-jdk-slim

# Establece el directorio de trabajo
WORKDIR /app

# Copia el archivo JAR de tu aplicación al directorio de trabajo
COPY --from=build /app/target/miTiendaDeBarrioApp-1.0-SNAPSHOT.jar .
COPY --from=build /app/src/main/resources/application.properties .

# Exponer el puerto que utilizará la aplicación
EXPOSE 8081

# Define el comando de inicio de la aplicación
CMD ["java", "-jar", "miTiendaDeBarrioApp-1.0-SNAPSHOT.jar"]