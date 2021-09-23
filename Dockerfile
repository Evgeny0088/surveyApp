FROM openjdk:16
ARG JAR_FILE=target/surveyApp-0.0.1-SNAPSHOT.jar
RUN useradd -ms /bin/bash evgeny88
RUN mkdir -p /home/evgeny88/app/
WORKDIR /home/evgeny88/app/
RUN chown -R evgeny88:evgeny88 ./
COPY ${JAR_FILE} app.jar  
USER evgeny88
EXPOSE 5000
ENTRYPOINT ["java","-jar","app.jar"] 
