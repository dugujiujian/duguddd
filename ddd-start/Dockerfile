FROM openjdk:8
VOLUME /tmp
ADD target/ddd-start-1.0.0-SNAPSHOT.jar duguddd.jar
##RUN sh -c 'touch /duguddd.jar'
ENV JAVA_OPTS=""
ENV TZ 'Asia/Shanghai'
ENV LANG="C.UTF-8"
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom -Dagentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=9088" ,"-jar","/duguddd.jar" ]
EXPOSE 8081