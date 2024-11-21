FROM openjdk:21-jdk

ARG JAR_FILE=./build/libs/homes-ai-0.0.1.jar

COPY ${JAR_FILE} app.jar

EXPOSE 8086

ENTRYPOINT ["java","-jar","/app.jar"]
