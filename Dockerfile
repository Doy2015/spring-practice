FROM openjdk:17-jdk
ARG JAR_FILE=build/libs/practice-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} practice.jar
ENTRYPOINT ["java", "-Djava.net.preferIPv4Stack=true", "-jar", "practice.jar"]