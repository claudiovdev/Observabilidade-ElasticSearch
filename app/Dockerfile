# Build stage
FROM maven:3.6.3-openjdk-17-slim AS build
WORKDIR /home/app
COPY src ./src
COPY pom.xml .
RUN mvn clean package -Dmaven.test.skip=true

# Download and add Elastic APM agent
ADD https://repo1.maven.org/maven2/co/elastic/apm/elastic-apm-agent/1.29.0/elastic-apm-agent-1.29.0.jar /elastic-apm-agent.jar

# Package stage
FROM openjdk:17-jdk-alpine
EXPOSE 8080


COPY --from=build /elastic-apm-agent.jar /elastic-apm-agent.jar
COPY --from=build /home/app/target/*.jar /app.jar

ENTRYPOINT ["java", "-javaagent:/elastic-apm-agent.jar", \
            "-Delastic.apm.service_name=my-java-application", \
            "-Delastic.apm.server_urls=http://host.docker.internal:8200", \
            "-jar", "/app.jar"]
