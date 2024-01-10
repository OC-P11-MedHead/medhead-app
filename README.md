# Medhead apps

MedHead met en place un système de réservation d'urgence de lit d'hôpitaux. `EMERGENCY EXPERT SYSTEMS`

## Introduction

Ce dépot contient les différents fichiers permettant de lancer facilement la totalité de l'application MedheadERS : 
 
 - L'application web
 - Les microservices backend (Java / Spring)

Ce projet répond au document d'exigence pour le POC du nouveau système Medhead disponible à l'adresse suivante : [Exigences pour le POC](https://github.com/OC-P11-MedHead/medhead-archi/blob/main/Exigences_pour_le_de%CC%81veloppement_de_la_POC.pdf)

## Requirement

* Docker (service démaré)
* JDK 17 installé

## Technologies utilisées

* HTML5/CSS3
* [Angular](https://angular.io/docs)
* [TypeScript](https://www.typescriptlang.org/)
* [Java 17](https://www.java.com/fr/)
* [Spring Boot](https://spring.io/projects/spring-boot)
* [JMeter](https://jmeter.apache.org/)

## Contribution

Yoann VALERO

## Auteurs

Yoann VALERO

## Pipeline CI/CD

La pipeline CI/CD mise en place est documentée ici : [CI/CD Documentation](https://github.com/OC-P11-MedHead/medhead-archi#CI/CD)

## Lancement du projet

Le lancement est extrêmement simple : 
 - Copier le fichier `.env.example`, le renommer en `.env` et personnaliser son contenu (voir doc fourni avec)
 - Copier le fichier `docker-compose.yml` au même endroit et lancer la commande :
   
 ```shell
   docker compose up -d
   ```

