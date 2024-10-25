# Usando o JDK 21
FROM maven:3.8.1-openjdk-21 as build

WORKDIR /app
COPY . .

RUN mvn clean package -DskipTests

# Imagem final
FROM openjdk:21-jre-slim
COPY --from=build /app/target/*.jar app.jar

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
