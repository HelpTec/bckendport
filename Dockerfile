FROM amazoncorretto:11-alpine-jdk
MAINTAINER SIA
COPY  target/proyectofinalbcknd-0.0.1-SNAPSHOT.jar  bckendport.jar
ENTRYPOINT ["java", "-jar", "/bckendport.jar"]
