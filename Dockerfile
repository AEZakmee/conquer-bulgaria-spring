FROM openjdk:19

ADD src/main/resources/firebase_config.json /

EXPOSE 8080
ADD target/conquer-bulgaria-deploy.jar conquer-bulgaria-deploy.jar
ENTRYPOINT ["java","-jar","/conquer-bulgaria-deploy.jar"]