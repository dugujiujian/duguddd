FROM openjdk:8

EXPOSE 8081

VOLUME /tmp

ADD target/ddd-start-1.0.0-SNAPSHOT.jar duguddd.jar

ENTRYPOINT ["java","-jar","/duguddd.jar"]