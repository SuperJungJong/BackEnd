FROM openjdk:21-jdk

ARG JAR_FILE=./build/libs/homes-apt-0.0.1.jar.jar

COPY ${JAR_FILE} app.jar

EXPOSE 8085

ENTRYPOINT ["java","-jar","/app.jar"]
