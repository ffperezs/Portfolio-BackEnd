FROM openjdk:17
MAINTAINER ffperezs
COPY target/ffperezs-0.0.1-SNAPSHOT.jar  ffperezs-app.jar
ENTRYPOINT ["java","-jar","/ffperezs-app.jar"]
