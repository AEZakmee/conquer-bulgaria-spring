FROM openjdk:19
EXPOSE 8080

RUN --mount=type=secret,id=DB_URL \
  --mount=type=secret,id=DB_USERNAME \
  --mount=type=secret,id=DB_PASSWORD \
  --mount=type=secret,id=FIREBASE_ID \
   export API_ENDPOINT=$(cat /run/secrets/DB_URL) && \
   export API_PASSWORD=$(cat /run/secrets/DB_USERNAME) && \
   export API_PASSWORD=$(cat /run/secrets/DB_PASSWORD) && \
   export API_PASSWORD=$(cat /run/secrets/FIREBASE_ID) && \
   yarn gen

ADD src/main/resources/firebase_config.json firebase_config.json
ADD target/conquer-bulgaria-deploy.jar conquer-bulgaria-deploy.jar

ENTRYPOINT ["java","-jar","/conquer-bulgaria-deploy.jar"]