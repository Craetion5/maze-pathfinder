# Sovelluksen toteutus

Sovellus koostuu viidestä luokasta:
* syötteen vastaanottava luokka, josta ohjelman suoritus alkaa (PathFinder)
* reitinhakutoiminnallisuuden sisältävä luokka (BFS)
* pieni luokka, joka tuottaa havainnollistavia tulostuksia (LevelPrinter)
* yksinkertainen jonon toteutus (SimpleQueue)
* sovelluksen suorituskykyä testaava luokka (PerformanceTester)

PathFinder ottaa vastaan numeroista ja pilkuista koostuvia tasokoodimerkkijonoja, muodostaa niistä kaksiuloitteisen taulukon, ja kutsuu reitinhakuluokkaa BFS.

Reitinhakuluokka BFS sisältää toiminnallisuuden ratkaisupolun etsimiseen sille annettuun tasoon. Luokan toiminnallisuuden muodostaa BFS-reitinhakualgoritmi, joka tallentaa tutkimattomia peliruutuja jonoon, vierailee niissä vuorotellen, ja tallentaa tiedon jo vierailluista ruuduista kaksiuloitteeseen koordinaattipareja sisältävään taulukkoon.
