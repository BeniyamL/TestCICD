FROM openjdk:25
EXPOSE 9090
ADD target/rest_api_spring_boot.jar rest_api_spring_boot.jar
ENTRYPOINT ["java", "-jar", "/rest_api_spring_boot.jar"]