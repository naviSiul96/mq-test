FROM openjdk:17-jre-slim

WORKDIR /app

COPY target/app.jar /app/app.jar

EXPOSE 8080

ENTRYPOINT [ "java", "-jar", "/app/app.jar" ]