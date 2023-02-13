FROM openjdk:18
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
EXPOSE 9090:9090
ADD target/dog-application.jar dog-application.jar
ENTRYPOINT ["java", "-jar", "/dog-application.jar"]
