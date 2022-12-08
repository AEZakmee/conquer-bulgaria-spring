FROM openjdk:19
EXPOSE 8080

ARG DB_URL_ARG
ENV DB_URL=$DB_URL_ARG

ARG DB_USERNAME_ARG
ENV DB_USERNAME=$DB_USERNAME_ARG

ARG DB_PASSWORD_ARG
ENV DB_PASSWORD=$DB_PASSWORD_ARG

ARG FIREBASE_ID_ARG
ENV FIREBASE_ID=$FIREBASE_ID_ARG

ADD src/main/resources/firebase_config.json firebase_config.json
ADD target/conquer-bulgaria-deploy.jar conquer-bulgaria-deploy.jar

ENTRYPOINT ["java","-jar","/conquer-bulgaria-deploy.jar"]