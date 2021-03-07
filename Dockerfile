FROM maven:3.6.3-jdk-11-slim AS build
RUN mkdir -p /workspace
WORKDIR /workspace
COPY pom.xml /workspace
COPY src /workspace/src
RUN mvn -B -f pom.xml clean package -DskipTests -Dspring-boot.run.profiles=prod

FROM openjdk:11
COPY --from=build /workspace/target/*.jar app/app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/app/app.jar"]