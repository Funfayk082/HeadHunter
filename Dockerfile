FROM openjdk:17
WORKDIR /app
COPY target/ /app
RUN mvn -f /app/pom.xml clean package
EXPOSE 8080
ENTRYPOINT ["java","-jar","/app/webapp-0.0.1-SNAPSHOT.jar"]