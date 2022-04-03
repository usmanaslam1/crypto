FROM openjdk:8-jre-alpine3.9
# copy the packaged jar file into our docker image
COPY ./target/crypto-0.0.1-SNAPSHOT.jar /crypto.jar
# set the startup command to execute the jar
#CMD ["java", "-jar", "/crypto.jar"]
ENTRYPOINT ["java","-jar", "/crypto.jar"]
