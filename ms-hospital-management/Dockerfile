FROM eclipse-temurin:17-jdk-alpine
VOLUME /tmp
RUN ["./mvnw", "package", "-DskipTests"]
EXPOSE 9000
COPY target/*.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
