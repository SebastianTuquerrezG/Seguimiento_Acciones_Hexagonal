# Usa la imagen base de OpenJDK 17
FROM openjdk:17

# Establece el directorio de trabajo en /app
WORKDIR /app

# Copia el JAR desde el directorio target (asegúrate de que la ruta es correcta)
COPY ./target/SeguimientoAcciones-0.0.1-SNAPSHOT.jar /app/seguimiento-acciones.jar

# Expone el puerto 8080
EXPOSE 8080

# Comando de entrada para ejecutar la aplicación Spring Boot
CMD ["java", "-jar", "seguimiento-acciones.jar"]
