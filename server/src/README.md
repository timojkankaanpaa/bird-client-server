This project demonstrates React client and Java SPring boot server

## Available scripts

## mvn install

(Projektin juurikansiossa [missä pom.xml on])
Asentaa palvelimen tarvitsemat kirjastot uuteen target-kansioon (Web, JPA, MariaDB). Mikäli ei onnistu, vaihda tietokanta-asetukset
application.properties -tiedostoon ja varmista, että VPN päällä koulun tietokantan

## mvn package

(Projektin juurikansiossa [missä pom.xml on])
Tekee suoritettavan jar-tiedoston (microservicen), josta ohjelman voi käynnistää

## java -jar target/bird-0.0.1-SNAPSHOT.jar

(Projektin juurikansiossa [missä pom.xml on])
Käynnistää web-palvelimen porttiin 8080

## npm install

(Ajetaan kansiossa client [missä package.json on])
Asentaa clientin tarvitsemat modulit node_modules -kansioon

## npm start

Käynnistää clientin
