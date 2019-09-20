# Viikkoraportti 3

**Käytin viikolla noin neljä tuntia aikaa projektin kehittelyyn.** 

Huomasin, ettei pajaa järjestetäkään itselle mukavaan aikaan ja pääsin ohjelmointirutiiniin melko myöhään, mutta projekti kehittyi aika hyvin:

* Sovellus osaa ratkaista labyrintteja, joissa on avaimia ja lukkoja!
  * Reitinhakualgoritmi aloittaa etsinnän uudestaan löydettyään avaimen, ja kykenee tällä kerralla avaamaan lukon
  * Ratkaisu löytyy, vaikka avaimia ja lukkoja olisi runsaasti
  * Algoritmia voi toistaiseksi huijata avaamaan turhia lukkoja jolloin se ei mahdollisesti löydä ratkaisua, vaikka sellainen olisi
  * Tein yksikkötestit testaamaan uudenlaisten tasojen ratkaisemista
  
* Sovelluksen tekstikäyttöliittymä piirtää ratkaisun löydettyään reitin
  * Ratkaisu muistuttaa aiemmin piirrettyä kuvaa tason ruudukosta, mutta pelaajahahmon vierailemissa ruuduissa näkyy merkki "+"
  
--------------------------------------------------------------------------------------------------------
  
Mietin sovelluksen tämänhetkisiä ongelmia (testauksen virheet, mutkitteleva reitinhaku), ja uskoisin ohjauksesta olevan apua näiden ratkaisemiseksi.   

Toiminnallisuus erilaisten kenttien selvittämiseen lähti hyvin käyntiin, mistä olen tyytyväinen.  

Mahdollisia seuraavia tavoitteita:

* Yllämainittujen virheiden korjaaminen
* Jar-tiedosto ja käyttöohje vertaisarviointia varten
* Ohjelman laajentaminen ratkaisemaan uudenlaisia tasoja (minulla on idea, miten jääruutujen käsittelyn voisi toteuttaa)
