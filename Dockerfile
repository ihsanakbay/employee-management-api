#FROM openjdk:19 AS build
#
#COPY pom.xml mvnw ./
#RUN chmod +x mvnw
#COPY .mvn .mvn
#RUN ./mvnw dependency:resolve
#
#COPY src src
#RUN ./mvnw package


FROM openjdk:19
WORKDIR employee-management-api
COPY target/*.jar employee-management-api.jar
ENTRYPOINT ["java", "-jar", "employee-management-api.jar"]