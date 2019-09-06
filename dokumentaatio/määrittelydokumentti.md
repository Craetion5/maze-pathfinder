# Määrittelydokumentti

## Käytettävät algoritmit
  
Käytän työssä reitinhakualgoritmia, todennäköisesti algoritmia A*. Käytettäviä tietorakenteita ovat luultavasti keko ja hajautustaulu.

## Ratkaistava ongelma

Toteutettavan ohjelman on tarkoitus löytää ratkaisu [aiemmin toteuttamani pelin](https://github.com/Craetion5/otm-harjoitustyo) tasoihin. Pelissä on 15x15 ruudukko, jossa on tarkoitus liikkua lähtöruudusta maaliruutuun liikkumiseen sallittuja ruutuja pitkin (eikä vinottain). Reitinhakualgoritmi on ilmeinen tapa lähestyä kyseisen ohjelman rakentamista. Pelissä on useita erilaisia ruutuja, ja aion aloittaa yksinkertaisimmista tasoista (pelkkiä tavallisia seiniä), ja yrittää vähitellen saada ohjelman ratkaisemaan hankalampiakin tasoja, jotka sisältävät mm. liikkumiseen pakottavia jääruutuja ja avaimilla avattavia lukittuja seiniä.

## Syötteet

Ohjelma saa syötteeksi numeroita ja pilkkuja sisältävän tasokoodin, jonka se muuttaa sopivaksi aputietorakenteeksi (hajautustaulu?). Reitinhakualgoritmi ratkaisee tason, ja palauttaa tarvittavat liikkeet sisältävän merkkijonon. Jos taso sisältää erilaisia ruutuja, pyrkii ohjelma muuttamaan sen reitinhakualgoritmille ratkaistavaan muotoon.

## Vaativuudet

Tavoitteena on varmaan algoritmin vaativa logaritminen aikavaativuus. Ohjelman syötteet ovat aina pieniä, joten prioriteetti on saada ohjelma ratkaisemaan monimutkaisempia kenttiä.

## Lähteet(?)

[A*-algoritmi englanninkielisessä Wikipediassa](https://en.wikipedia.org/wiki/A*_search_algorithm)
