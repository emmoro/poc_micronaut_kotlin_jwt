## Project Micronaut with kotlin and JWT
Project to do call in Rest and using authentication token JWT
</br>

## Tools used in project
* Language: Java 11
* Database: MySql
* Micronaut - 2.5.5

## Requirements
You will need to following tools in order to work with this project and code:

* Java 11
* Gradle
* IDE was used Intellij.

## Getting Started
To run this project locally, perform the following steps:

* Use this command to download the project to your machine: git clone https://github.com/emmoro/poc_micronaut_kotlin_jwt.git
* To install all of its dependencies and start each app, follow the instructions below:
* To run the server. Application address: http://localhost:80
  80/SMT
  Start: gradlew run

## How to use the system

* Necessary create database, you can use the script that is folder "resource/bd/scriptDatabase"
* You can use the collection json that is in system in folder "\support" the file 'poc-micronaut-kotlin-jwt.json'.
* Necessary to do "POST http://localhost:8080/login" to get the Token.
* After to get the token is necessary to use in Authorization: Bearer {{token}}
* You can use collection to "create", "Read", "Read-by-id", "update" and "delete"
