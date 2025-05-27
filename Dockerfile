# Etapa 1: Build con Maven y JDK 21
FROM maven:3.9.6-eclipse-temurin-17 AS build

WORKDIR /app

# Copiar pom y código fuente
COPY pom.xml .
COPY src ./src

# Construir el jar sin tests para acelerar (opcional)
RUN mvn clean package -DskipTests

# Etapa 2: Runtime con JDK 21 (alpine para imagen liviana)
FROM eclipse-temurin:17-jdk-alpine

WORKDIR /app

# Copiar el jar generado, renombrándolo explícitamente
COPY --from=build /app/target/*.jar app.jar

# Exponer puerto 8080 (ajusta si usas otro)
EXPOSE 8080

# Ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "app.jar"]
