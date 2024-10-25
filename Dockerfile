FROM maven:3.8.1-openjdk-21 as build

WORKDIR /app
COPY . .

RUN mvn clean package -DskipTests

FROM openjdk:21-slim
COPY --from=build /app/target/*.jar app.jar

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
