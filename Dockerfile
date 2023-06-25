FROM amazoncorretto:17
COPY target/ffperezs-0.0.1-SNAPSHOT.jar ffperezs-app.jar
ENTRYPOINT ["java","-jar","/ffperezs-app.jar"]
EXPOSE 8080
