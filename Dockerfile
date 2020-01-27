FROM openjdk:8
ADD target/shoppingTimeline-0.0.1-SNAPSHOT.jar shoppingtimeline-api.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "shoppingtimeline-api.jar"]
