FROM openjdk:17
WORKDIR /app
COPY target/ /app
EXPOSE 8080
ENTRYPOINT ["java","-jar","/app/webapp-0.0.1-SNAPSHOT.jar"]