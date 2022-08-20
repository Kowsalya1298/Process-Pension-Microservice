FROM amazoncorretto:8
EXPOSE 9084
ADD target/*.jar process-pension-microservice-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["sh","-c","java -jar /process-pension-microservice-0.0.1-SNAPSHOT.jar"]
