FROM eclipse-temurin:17-jdk-alpine

VOLUME /tmp

# Définir le répertoire de travail dans le conteneur
WORKDIR /app

# Copier le fichier  pom.xml pour télécharger les dépendances Maven
COPY pom.xml .

# Copier tous les fichiers source
COPY src ./src

# Copie du fichier mvnw
COPY mvnw ./

# Copie du dossier .mvn (contenant les scripts nécessaires)
COPY .mvn ./.mvn

RUN ["./mvnw", "package", "-DskipTests"]

# COPY ./target/ms-emergency-management.jar /app/ms-emergency-management.jar

EXPOSE 9090

# CMD ["java", "-jar", "ms-emergency-management.jar"]

# COPY target/*.jar app.jar
# ENTRYPOINT ["java","-jar","/app.jar"]

CMD ["java", "-jar", "target/msem.jar"]

