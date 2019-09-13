# Viikkoraportti 2

**Käytin viikolla yhteensä noin seitsemän tuntia intensiiviseen projektin kehittelyyn:**

* Alkuperäinen peli mahdollistaa nyt ratkaisujen lataamisen ja suorittamisen (näppäimistä - ja +)

* Sovellus ottaa vastaan merkkijonomuotoisia tasokoodisyötteitä

* Sovelluksessa on käytössä BFS-reitinhakualgoritmi, jolla se palauttaa rivin ratkaisukomentoja mahdollisten yksinkertaisten tasojen ratkaisemiseksi!
  * Sovelluksen palauttama merkkijono sisältää rivin peräkkäisiä komentoja, jotka pelin uuteen valikkoon syötettynä mahdollistavat ratkaisun tarkastelun.
  * Algoritmin palauttama reitti on toistaiseksi hieman kiemurteleva...

* Sovelluksen testaus on aloitettu
  * Sovelluksessa on yksikkötestit tämänhetkisille käyttötapauksille (tason ratkaisu, mahdoton taso, virheellinen syöte) tosin tason ratkaisemisen testi palauttaa virheilmoituksen jostain syystä...

---------------------------------------------------------------
  
Olen tyytyväinen projektin kehitykseen, ja yllätyin positiivisesti siitä, että sain jo jossain määrin funktionaalisen reitinhakualgoritmin toteutettua.

Mahdollisia seuraavia tavoitteita:

* Ensiaskeleet ohjelman laajentamiseen ratkaisemaan mutkikkaampia tasoja (avaimet ja lukot?)
* Reitinhakualgoritmin mutkien poisto ja hienosäätö
* Testauksen korjaaminen ja laajentaminen
* Dokumentaation päivittäminen
