FROM openjdk:16-jdk

COPY /target/app.jar /

CMD ["java", "-Dspring.profiles.active=prod" , "-jar" , "/app.jar"]
