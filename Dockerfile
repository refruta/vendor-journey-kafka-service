FROM openjdk:8
ADD build/libs/vendor-journey-kafka-service-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8081
ENTRYPOINT ["java","-jar","app.jar"]