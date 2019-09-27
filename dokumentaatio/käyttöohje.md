# Sovelluksen käyttäminen

## Lataaminen ja toiminnallisuus lyhyesti

Sovelluksen jar-tiedoston voi ladata releaseista. Sovelluksen käynnistettyä sille syötetään merkkijonomuotoinen tason koodi jolle se yrittää löytää ratkaisun.

## Sovelluksen idea

Sovellus on tarkoitettu aiemmin toteuttamani, vielä kehityksen alla olevan [pelin](https://github.com/Craetion5/otm-harjoitustyo) tasojen ratkaisemiseen.
Pelin tasoeditori mahdollistaa tasojen luomisen ja näiden tasojen tallentamisen merkkijonomuotoiseksi tasokoodiksi. Sovellukselle voi syöttää tällaisen tasokoodin, jolloin se yrittää löytää ratkaisun pelin kyseiseen tasoon.
Sovellus palauttaa reitinhaun onnistuttua rivin komentoja, jota voi käyttää pelissä tason ratkaisemiseksi näppäinten - ja + avulla.
Tällä hetkellä sovellus kykenee käsittelemään tasoja, jotka sisältävät seuraavia ruutuja: lattia, seinä, aloitus, maali, oranssi avain, oranssi lukko, jää.

Sovelluksen toimintaa voi havainnollistaa ilman pelin käyttämistä hyödyntämällä sovelluksen yksikkötesteissä olevia tasokoodeja. 
