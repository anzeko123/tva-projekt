# Zagon APIja za vnos podatkov
Prvo je potrebno prenesti si .env datoteko ki sem dal na massenger in jo dati v root datoteko v nodeAPI
v terminalu se usmeri v datoteko nodeAPI z ukazom: cd nodeAPI
se namesti vse dependencije z: npm i
zažene API z npm start

# PRVI COMMIT:
git clone https://github.com/anzeko123/tva-projekt.git

git checkout -b main   !!! NUJNO JE POTRBNO NAREDITI TO - mogoče je že avtomatsko nastavljeni na main
git add .  (se dodajo datoteke)
git status (se pogleda kakšni je status kaj je dodano/izbrisano)
git commit -m "Sporočilo" (se napiše sporočilo da se ve kaj se je naredilo)
git push https://github.com/anzeko123/tva-projekt.git

TO SE NAREDI ZA PRVI COMMIT
ZA VSE NADALJNE COMMITE SE UPOŠTEVA SPODNJI PRIMER

---------------------------------------------------------------------------------------------------

ČE SE DOBI TA ERROR SPODAJ:

![GITHUB_PUSH_ERROR](https://github.com/anzeko123/tva-projekt/blob/main/hithub-push-error.png?raw=true)

Pomeni da datoteke v github repositoryu in datoteke v lokalnem repositoryu niso enake, kar pomeni da je nekdo  že pushal v času ko ti pišeš novo kodo.

V tem primeru se mora narediti git pull - primer spodaj
git pull https://github.com/anzeko123/tva-projekt.git (to bo posodobilo obstoječo kodo in dodalo novo kodo - če pride do kakšnih težav napiše kaj je težava in se reši)

----------------------------------------------------------------------------------------------------

# OD PRVEGA COMMITA NAPREJ SE UPORABLJA TOLE:
git pull https://github.com/anzeko123/tva-projekt.git       (tukaj se preveri če je akj novega in se popravi)
git chackout -b ime_brancha
git add .
git status
git commit -m "Sporočilo"
git push https://github.com/anzeko123/tva-projekt.git

ČE PRIDE PONOVNO DO ZGORNJEGA ERRORJA SE NAREDI GIT PULL IN NATO KO SE VSE UREDI ŠE ENKRAT GIT PUSH:
git pull https://github.com/anzeko123/tva-projekt.git (to bo posodobilo obstoječo kodo in dodalo novo kodo - če pride do kakšnih težav napiše kaj je težava in se reši)
git push https://github.com/anzeko123/tva-projekt.git


TO SE POTEM SAMO SKOS PONAVLJA OB IZDELAVI APLIKACIJE DO ZAKLJUČKA

ČE BO PRIŠLO DO ZAPLETOV SE LAHKO NAREDI NOVI BRANCH
