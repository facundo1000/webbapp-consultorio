FROM maven:3.8.5-openjdk-17 AS build
COPY . .
RUN mvn clean install -DskipTests

FROM openjdk:17.0.1-jdk-slim
#COPY --from=build /target/webbapp-consultorio.jar webbapp-consultorio.jar
COPY /target/webbapp-consultorio.jar webbapp-consultorio.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/webbapp-consultorio.jar"]