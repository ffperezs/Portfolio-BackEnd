FROM amazoncorretto:17-alpine-jdk                           //de que imagen partimos
MAINTAINER ffperezs                                         //quien es el dueño
COPY target/ffperezs-0.0.1-SNAPSHOT  ffperezs-app.jar       //va a copiar el empaquetado a GIT
ENTRYPOINT ["java","-jar","/ffperezs-app.jar"]              //es la instrucción que se va a ejecutar primero
