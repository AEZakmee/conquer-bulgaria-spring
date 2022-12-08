FROM openjdk:19
EXPOSE 8080

ARG DB_URL
ENV DB_URL ${DB_URL}

ARG DB_USERNAME
ENV DB_USERNAME ${DB_USERNAME}

ARG DB_PASSWORD
ENV DB_PASSWORD ${DB_PASSWORD}

ARG FIREBASE_ID
ENV FIREBASE_ID ${FIREBASE_ID}

ADD src/main/resources/firebase_config.json firebase_config.json
ADD target/conquer-bulgaria-deploy.jar conquer-bulgaria-deploy.jar

ENTRYPOINT ["java","-jar","/conquer-bulgaria-deploy.jar"]