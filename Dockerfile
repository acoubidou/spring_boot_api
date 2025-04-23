FROM openjdk:21

EXPOSE 9000

WORKDIR /app

COPY api-0.0.1-SNAPSHOT.jar /app/api-0.0.1-SNAPSHOT.jar

CMD ["java", "jar", "api-0.0.1-SNAPSHOT.jar"]