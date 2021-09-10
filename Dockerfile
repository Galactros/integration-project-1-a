FROM openjdk:16-jdk

ARG JAR_FILE=target/*.jar

ADD ${JAR_FILE} /app/app.jar

EXPOSE 80

ENTRYPOINT ["java","-jar","/app/app.jar"]