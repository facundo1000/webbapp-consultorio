FROM openjdk:17 AS build
COPY . .
RUN mvn clean package -DskipTests

FROM openjdk:17.0.1-jdk-slim
COPY --from=build /target/webbapp-consultorio.jar webbapp-consultorio.jar
EXPOSE 8080
ENTRYPOINT["java","-jar","webbapp-consultorio"]