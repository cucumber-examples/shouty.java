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

  Antagelser:
  - Slottet-Munch museet er 1,6km

  Scenario: Harald er for langt borte fra Sonja
    Gitt at Sonja er på Slottet
    Men Harald er på Munch-muséet
    Når Sonja roper "teen er klar"
    Så hører ikke Harald meldingen















