# MyLibrary Application

## General info
The Java application - Library - simply CRUD application allows to create, read, update, delete our books and creating new rentals.

## Technologies
- Java 8
- Spring boot
- Angular 6+
- Mysql
- Flyway
- Gradle

## Instalation
To run this project you need to install:
-  [Angular CLI](https://cli.angular.io/)
- [Node.js](https://nodejs.org/en/)
- [MySQL database](https://www.mysql.com/)
- [gradle](https://docs.gradle.org/current/userguide/getting_started.html) or use gradle-wrapper from project dir (gradlew)

1. Create database schema named "library"
2. Go to project directory and run command line:
./gradlew clean build

3. Go to build/libs and run command line: java- jar 'nameOfTheJar.jar'
4. Go to frontend/myLibrary and run command line: npm install and npm start.
5. Go to your web browser and run http://localhost:4200/
