FROM registry.access.redhat.com/ubi8/openjdk-17

WORKDIR /app

COPY target/mq-0.0.1.jar /app/app.jar

EXPOSE 8080

ENTRYPOINT [ "java", "-jar", "/app/app.jar" ]