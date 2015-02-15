# language: no
Egenskap: Høre rop

  Regler:
  - Maks lengde: 42 tegn
  - Mottak krever ikke registrering
  - Mottaker må kunne identifisere avsender
  - Melding må leveres innen 1s
  - Mottaker må være innenfor 1000m fra avsender

  Spørsmål:
  - Får man levert gamle meldinger?
  - Hvordan håndtere spam?
  - Må vi verifisere brukeres autentisitet?
  - Hva skjer når noen sender en melding som er for lang?
  - Må systeme varsle noen når ytelsen går ned?
  - Skal man høre sine egne meldinger?

  Antagelser:
  - Slottet-Munch muséet er 1,6km

  Bakgrunn:
    Gitt at Slottet ligger på 59,917043, 10,727377
    Gitt at Munchmuseet ligger på 59,916951, 10,77498
    Gitt at Egertorget ligger på 59,9128017, 10,7418443

  Scenario: Harald er for langt borte fra Sonja
    Gitt at Sonja er på Slottet
    Men at Harald er på Munchmuseet
    Når Sonja roper "teen er klar"
    Så hører ikke Harald meldingen "teen er klar"

  Scenario: Harald er mindre enn 1 km fra Sonja
    Gitt at Sonja er på Slottet
    Men at Harald er på Egertorget
    Når Sonja roper "teen er klar"
    Så hører Harald meldingen "teen er klar"















