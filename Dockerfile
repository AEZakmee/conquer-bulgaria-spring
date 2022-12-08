ADD src/resources/firebase_config.json /firebase_config.json

FROM openjdk:19
EXPOSE 8080
ADD target/conquer-bulgaria-deploy.jar conquer-bulgaria-deploy.jar
ENTRYPOINT ["java","-jar","/conquer-bulgaria-deploy.jar"]