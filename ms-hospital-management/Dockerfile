FROM eclipse-temurin:17-jdk-alpine

VOLUME /tmp

# Définir le répertoire de travail dans le conteneur
WORKDIR /mshm

# Copier le fichier pom.xml pour télécharger les dépendances Maven
COPY pom.xml .

# Copier tous les fichiers source
COPY src ./src

RUN ["mvnw", "package", "-DskipTests"]

EXPOSE 9000

# COPY target/*.jar app.jar
# ENTRYPOINT ["java","-jar","/app.jar"]

CMD ["java", "-jar", "target/mshm.jar"]