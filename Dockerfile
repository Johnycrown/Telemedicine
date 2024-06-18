FROM openjdk:17
VOLUME /tmp
EXPOSE 8083
ADD target/spring-boot-docker.jar app.jar

ENTRYPOINT ["java","-jar","app.jar"]