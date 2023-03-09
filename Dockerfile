FROM openjdk:17-alpine
COPY target/duneapi-0.0.1-SNAPSHOT.jar duneapi.jar
EXPOSE 8080
EXPOSE 80
ENTRYPOINT ["java","-jar","/duneapi.jar"]