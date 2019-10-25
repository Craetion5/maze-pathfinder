# Sovelluksen käyttäminen

## Lataaminen ja toiminnallisuus lyhyesti

Sovelluksen jar-tiedoston voi ladata [releasesta](https://github.com/Craetion5/maze-pathfinder/releases/tag/loppupalautus
). Sovelluksen käynnistettyä sille syötetään merkkijonomuotoinen tasokoodi jolle se yrittää löytää ratkaisun. [Sovelluslogiikan testeistä](https://github.com/Craetion5/maze-pathfinder/blob/master/maze-pathfinder/src/test/java/pathfinder/PathfinderTest.java
) löytyy hyviä tasokoodiesimerkkejä, joilla ohjelman suoritusta voi testata.

## Sovelluksen idea

Sovellus on tarkoitettu aiemmin toteuttamani, vielä kehityksen alla olevan [pelin](https://github.com/Craetion5/otm-harjoitustyo) tasojen ratkaisemiseen.

### Tasokoodien luominen sovellusta varten
Tasokoodeja pystyy luoda pelin tasoeditorityökalun avulla. Tasoeditori mahdollistaa tasojen rakentamisen ja näiden tasojen tallentamisen merkkijonomuotoiseksi tasokoodiksi. Sovellukselle voi syöttää tällaisen tasokoodin, jolloin se yrittää löytää ratkaisun pelin kyseiseen tasoon. Enemmän tietoa [pelin käyttöohjeessa](https://github.com/Craetion5/otm-harjoitustyo/blob/master/dokumentaatio/kayttoohje.md
).  
Reitinhakusovelluksen tukemat ruudut: <img src="https://raw.githubusercontent.com/Craetion5/otm-harjoitustyo/master/dokumentaatio/kuvat/floor.png"><img src="https://raw.githubusercontent.com/Craetion5/otm-harjoitustyo/master/dokumentaatio/kuvat/wall.png"><img src="https://raw.githubusercontent.com/Craetion5/otm-harjoitustyo/master/dokumentaatio/kuvat/goal.png"><img src="https://raw.githubusercontent.com/Craetion5/otm-harjoitustyo/master/dokumentaatio/kuvat/ice.png"><img src="https://raw.githubusercontent.com/Craetion5/otm-harjoitustyo/master/dokumentaatio/kuvat/lava.png"><img src="https://raw.githubusercontent.com/Craetion5/otm-harjoitustyo/master/dokumentaatio/kuvat/key.png"><img src="https://raw.githubusercontent.com/Craetion5/otm-harjoitustyo/master/dokumentaatio/kuvat/lock.png"> ja start-ruutu mistä tasot alkavat.

### Sovelluksen palauttama ratkaisu

Sovellus palauttaa reitinhaun onnistuttua rivin komentoja sisältävän merkkijonon, jota voi käyttää pelissä tason ratkaisemiseksi.

Ratkaisun syöttäminen peliin onnistuu painamalla nappia "-" jolloin peliin avautuu ikkuna, jonne ratkaisukoodin voi syöttää.

Jos pelissä on kyseinen taso pelattavana voi napilla "+" toistaa seuraavan liikkeen syötetyn ratkaisukoodin mukaisella reitillä ja näin tarkastella reitinhaun palauttamaa ratkaisua.
