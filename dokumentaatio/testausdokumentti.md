# Sovelluksen testaus
---------------------------------
## Yksikkötestit

Sovelluksessa on käytössä JUnit, joka mahdollistaa projektin testaamisen yksikkötesteillä.

[Yksikkötestit](http://htmlpreview.github.io/?https://github.com/Craetion5/maze-pathfinder/blob/master/dokumentaatio/tests/test/index.html
)

[Testausrivikattavuus](http://htmlpreview.github.io/?https://github.com/Craetion5/maze-pathfinder/blob/master/dokumentaatio/jacoco/test/html/index.html
)

### Tietorakenteiden testaus

Tietorakenteille on testit luokissa PointTest ja SimpleQueueTest. Tietorakenteiden yksinkertaisuuden vuoksi niiden testitkin ovat yksinkertaisia ja testaavat tietorakenteiden toimintaa.

### Reitinhaun testaus

Testiluokka PathfinderTest sisältää testejä sovelluslogiikalle.

Nämä yksikkötestit testaavat sovelluksen käyttötapauksia joissa ensin muutetaan tasokoodimerkkijono taulukkomuotoon ja sitten annetaan taso ratkaistavaksi reitinhakualgoritmille. Testesissä esiintyvät tasokoodit ovat monipuolisia. Ne sisältävät monipuolisesti eri pelissä esiintyviä ruutuja, ja puolet tasoista ovat mahdottomia.

Testit on helppo toistaa JUnitin avulla tai kopioimalla testeissä käytetyt tasokoodit ja syöttämällä ne ohjelmalle.

-------------------------------------------
## Suorituskykytestaus

Sovelluksessa on käytössä reitihnhakualgoritmin suorituskykytestaus jonka voi käynnistää antamalla komennon 'test' sovelluksen käyttöliittymälle.

Aihevalinnan takia sovellusta ei voi oikein verrata muihin algoritmeihin ja varsinaisia "suuria syötteitä" ei ole. Alla on testeissä käytettyjen mahdollisten tasokoodien ratkaisuajat:

Testi |Keskimääräinen aika|
-----|----------|
testSolveLevel | 232447ns |
testSolveKeyLevel | 54795ns |
testSolveIceLevel | 233842ns |
testCantFoolThePlayer | 193137ns |
testSolveLavaLevel | 159516ns |

Ja suoritusaika testien mahdottomilla tasoilla:

Testi |Keskimääräinen aika|
-----|----------|
testCantSolveLevel | 30591ns |
testCantSolveKeyLevel | 41079ns |
testCantSolveIceLevel | 90177ns |
testCantSolveLavaLevel | 24431ns |
