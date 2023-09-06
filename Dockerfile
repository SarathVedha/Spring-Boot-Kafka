FROM eclipse-temurin:17
LABEL authors="sarath"

WORKDIR /app
COPY target/SpringBootKafka-0.0.1-SNAPSHOT.jar /app/SpringBootKafka.jar

ENTRYPOINT ["java", "-jar", "SpringBootKafka.jar"]