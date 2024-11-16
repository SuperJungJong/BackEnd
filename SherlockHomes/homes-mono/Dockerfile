FROM openjdk:21-jdk

ARG JAR_FILE=./build/libs/homes-mono-0.0.1.jar

COPY ${JAR_FILE} app.jar

EXPOSE 8080

ENTRYPOINT ["java","-jar","/app.jar"]
