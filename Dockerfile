FROM openjdk:17-jdk-slim

COPY "./target/Nuevo_Rest_desarrollo-0.0.1-SNAPSHOT.jar" "app.jar"

ENTRYPOINT [ "java" , "-jar" , "app.jar" ]