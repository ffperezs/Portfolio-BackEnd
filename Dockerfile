FROM amazoncorretto:17-alpine-jdk
COPY target/ffperezs-0.0.1-SNAPSHOT.jar ffperezs-app.jar
ENTRYPOINT ["java","-jar","/ffperezs-app.jar"]
