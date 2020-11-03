FROM openjdk:14
ADD target/ControlService.jar ControlService.jar
EXPOSE 8087
ENTRYPOINT ["java", "-jar", "ControlService.jar"]