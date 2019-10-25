# Sovelluksen toteutus
------------------------------------------
## Sovelluksen pakkausrakenne

Ohjelman koodin sisältävät luokat on jaettu kolmeen pakkaukseen:

### datastructures
Pakkaus sisältää sovellusta varten itse toteutetut tietorakenteet:

#### Point
* yksinkertainen (x,y)-koordinaatistopisteen toteutus
* mahdollistaa koordinaatin x- ja y-arvojen asettamisen ja palauttamisen

#### SimpleQueue
* yksinkertainen taulukon avulla toteutettu jono
* jonoon voi lisätä alkioita, jonosta voi poistaa ensimmäisen alkion ja voi tarkistaa onko jono tyhjä

### pathfinder
Pakkaus sisältää keskeisen sovelluslogiikan.

#### PathFinder
* ohjelman suorituksen aloittava luokka
* kysyy käyttäjältä merkkijonomuotoisen tasokoodin
* muodostaa kaksiuloitteisen taulukon tasokoodista ja antaa sen reitinhakualgoritmille
* tulostaa reitinhakualgoritmin antavan ratkaisun

#### BFS
* sovelluksen ydin
* pyrkii löytämään ratkaisun syötteenä annettuun tasoon

#### LevelPrinter
* tulostaa käyttöliittymään havainnollistavan kuvan ratkaistavasta pelikentästä

### performancetest
Pakkaus sisältää suorituskykytestausluokan:

#### PerformanceTester
* luokasta voi luoda instanssin joka suorittaa ohjelman halutulla syötteellä halutun määrän kertoja
* tulostaa käyttöliittymään suorituskykytestauksen tulokset
------------------
## Reitinhakualgoritmin toiminta

Sovelluksen reitinhaku on luokassa BFS ja perustuu peliruudukon leveyssuuntaiseen läpikäyntiin. Algoritmi tallentaa jonoon tutkimattomia peliruutuja joihin pelaajalla on mahdollista liikkua. Näissä ruuduissa vieraillaan vuorotellen ja tallennetaan tieto jo vierailluista ruuduista sekä niiden naapureista kaksiuloitteisiin taulukoihin.

Jos poimitaan avain tai avataan avaimella lukko niin taulukkoon tallennettua pelikenttää päivitetään ja reitinhaku aloitetaan uudelleen. Reitinhaun epäonnistuttua avaimen keräämisen tai lukon avaamisen jälkeen yritetään reitinhakua uudelleen ilman kyseisen tapahtuman toistamista. Algoritmi toimii siis rekursiivisesti tietyissä tapauksissa.

Algoritmi palauttaa merkkijonomuotoisen ratkaisun, jos reitti maaliruudulle löytyy. Muuten se kertoo ratkaisuyrityksen epäonnistuneen.

### Aika- ja tilavaativuuksista

Aika- ja tilavaativuudet eivät ole erityisen oleellisia koska ratkaistavat kentät ovat aina vakiokokoisia.  

Aikavaativuus lienee leveyssuuntaisen läpikäynnin pahimman tapauksen aikavaativuus O(n²). Pahimmillaan lähes jokainen ruutu joudutaan tarkistamaan mahdollisesti useita kertoja koska avainten ja lukkojen käsittelyn yhteydessä reitinhaku aloitetaan alusta.

Tilavaativuus on O(n), reitinhakualgoritmi käyttää lyhyttä jonoa ja muutamaa vakiokokoista taulukkoa.

([Leveyssuuntaisen läpikäynnin aikavaativuus Wikipediassa](https://en.wikipedia.org/wiki/Breadth-first_search#Time_and_space_complexity
))
