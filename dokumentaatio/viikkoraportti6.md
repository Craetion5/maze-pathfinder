# Viikkoraportti 6


**Käytin viikolla reilu viisi tuntia projektin kehittelyyn:**

* Reitinhakua on vaikeampi huijata ansoiksi asetetuilla avaimilla ja lukoilla.
  * Toteutusperiaate: reitinhaku päätyy näihin ansoihin ja aloittaa haun uudestaan mutta toistamatta kyseiseen ansaan päätymiseen aiheuttavaa virhettä.
* Reitinhaku osaa välttää laavaruudut.
  * Välttäminen onnistuu myös jos jääruudut kuljettaisivat niihin.
* Reitinhaun palauttaman ratkaisun tulostus ruudukkomuodossa on poistettu seuraavista syistä:
  * Tämä ratkaisun havainnollistus ei ole kauhean tyylikäs erityisesti monimutkaisissa tasoissa.
  * Ratkaisua voi jo tarkastella tehokkaasti pelin sisällä liittämällä ohjelman palauttaman ratkaisukoodin.
  * Ratkaisun ruudukkotulostuksen toteuttaminen uudenlaisiin tasoihin (jää) aiheuttaisi turhaa päänvaivaa.
* X,Y-pisteen toteutus on toteutettu omaan tietorakenteeseen ja reitin tallentamiseen käytetty HashMap on korvattu taulukolla.
* Ohjelman yksikkötestausta on laajennettu.
  * Yksikkötestit kattavat tasot, joissa on laavaa ja ansoiksi asetettuja avaimia ja lukkoja.
  * Omien tietorakenteiden perustoiminnallisuutta on testattu.
* Reitinhakuluokan muuttujien nimet ovat hieman selkeämpiä.

--------------------------------------------------------------

Projekti alkaa jo tuntua aika valmiilta. Mahdollisen koodin ja dokumentoinnin hienosäädön lisäksi olisi vielä ainakin yksi tietty kehitysidea:

Jäällä liukumisen toteuttava koodi on hieman sotkuista joten sen voisi toteuttaa siistimmin erilliseen metodiin. Tämä mahdollistaisi vielä tiettyjen ruutujen helpon toteutuksen reitinhakuun.
