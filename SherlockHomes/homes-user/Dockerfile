FROM openjdk:21-jdk

ARG JAR_FILE=./build/libs/homes-user-0.0.1.jar

COPY ${JAR_FILE} app.jar

EXPOSE 8083

ENTRYPOINT ["java","-jar","/app.jar"]
