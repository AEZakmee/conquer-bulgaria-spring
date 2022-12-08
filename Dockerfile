FROM openjdk:19
EXPOSE 8080

ADD src/main/resources/firebase_config.json firebase_config.json
ADD target/conquer-bulgaria-deploy.jar conquer-bulgaria-deploy.jar

ENTRYPOINT ["java","-jar","/conquer-bulgaria-deploy.jar"]