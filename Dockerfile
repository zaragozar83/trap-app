FROM openjdk:8-jdk-alpine
VOLUME /tmp
COPY target/trapapp-0.0.1-SNAPSHOT.jar .
EXPOSE 8080
ENTRYPOINT java $JAVA_OPTS -jar trapapp-0.0.1-SNAPSHOT.jar