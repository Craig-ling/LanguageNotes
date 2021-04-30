package com.teromenat.languagenotes.languages

abstract class Language {
    abstract val numbers: HashMap<Int, String>
    abstract val imageWordPairs: HashMap<String, String>
}

data class German (
        override val numbers: HashMap<Int, String> = hashMapOf(0 to "null",
                1 to "eins", 2 to "zwei", 3 to "drei", 4 to "vier", 5 to "fünf", 6 to "sechs",
                7 to "sieben", 8 to "acht", 9 to "neun", 10 to "zehn", 11 to "elf", 12 to "zwölf",
                13 to "dreizehn", 14 to "vierzehn", 15 to "fünfzehn", 16 to "sechszehn", 17 to "seibzehn",
                18 to "achtzehn", 19 to "neunzehn", 20 to "zwanzig", 21 to "Einundzwanzig",
                22 to "Zweiundzwanzig", 23 to "dreiundzwanzig", 24 to "vierundzwanzig", 25 to "fünfundzwanzig", 26 to "Sechsundzwanzig",
                27 to "Siebenundzwanzig", 28 to "Achtundzwanzig", 29 to "Neunundzwanzig", 30 to "Dreiβig",
                31 to "Einunddreiβig", 32 to "Zweiunddreiβig", 33 to "Dreiunddreiβig", 34 to "Vierunddreiβig",
                35 to "Fünfunddreiβig", 36 to "Sechsunddreiβig", 37 to "Siebenunddreiβig", 38 to "Achtunddreiβig",
                39 to "Neununddreiβig", 40 to "Vierzig", 41 to "Einundvierzig", 42 to "Zweiundvierzig",
                43 to "Dreiundvierzig", 44 to "Vierundvierzig", 45 to "Fünfundvierzig", 46 to "Sechsundvierzig",
                47 to "Siebenundvierzig", 48 to "Achtundvierzig", 49 to "Neunundvierzig", 50 to "Fünfzig",
                51 to "Einundfünfzig", 52 to "Zweiundfünfzig", 53 to "Dreiundfünfzig", 54 to "Vierundfünfzig",
                55 to "Fünfundfünfzig", 56 to "Sechsundfünfzig", 57 to "Siebenundfünfzig", 58 to "Achtundfünfzig",
                59 to "Neunundfünfzig", 60 to "Sechzig", 61 to "Einundsechzig", 62 to "Zweiundsechzig",
                63 to "Dreiundsechzig", 64 to "Vierundsechzig", 65 to "Fünfundsechzig", 66 to "Sechsundsechzig",
                67 to "Siebenundsechzig", 68 to "Achtundsechzig", 69 to "Neunundsechzig", 70 to "Siebzig",
                71 to "Einundsiebzig", 72 to "Zweiundsiebzig", 73 to "Dreiundsiebzig", 74 to "Vierundsiebzig",
                75 to "Fünfundsiebzig", 76 to "Sechsundsiebzig", 77 to "Siebenundsiebzig", 78 to "Achtundsiebzig",
                79 to "Neunundsiebzig", 80 to "Achtzig", 81 to "Einundachtzig", 82 to "Zweiundachtzig",
                83 to "Dreiundachtzig", 84 to "Vierundachtzig", 85 to "Fünfundachtzig", 86 to "Sechsundachtzig",
                87 to "Siebenundachtzig", 88 to "Achtundachtzig", 89 to "Neunundachtzig", 90 to "Neunzig",
                91 to "Einundneunzig", 92 to "Zweiundneunzig", 93 to "Dreiundneunzig", 94 to "Vierundneunzig",
                95 to "Fünfundneunzig", 96 to "Sechsundneunzig", 97 to "Siebenundneunzig", 98 to "Achtundneunzig",
                99 to "Neunundneunzig"),
        override val imageWordPairs: HashMap<String, String> = hashMapOf("Book" to "das Buch",
                "Cat" to "die Katze", "Chair" to "der Stuhl", "Dog" to "der Hund", "Fire" to "das Feuer",
        "Phone" to "das Handy", "Sun" to "die Sonne", "Ticket" to "die Fahrkarte", "Waiter" to "der Kellner",
        "Water" to "das Wasser")) : Language()

data class French(
        override val numbers: HashMap<Int, String> = hashMapOf(0 to "zero",
        1 to "un", 2 to "deux", 3 to "trois", 4 to "quatre", 5 to "cinq", 6 to "six", 7 to "sept",
        8 to "huit", 9 to "neuf", 10 to "dix", 11 to "onze", 12 to "douze", 13 to "treize",
        14 to "quatorze", 15 to "quinze", 16 to "seize", 17 to "dix-sept ", 18 to "dix-huit",
        19 to "dix-neuf", 20 to "vingt", 21 to "vingt-et-un ", 22 to "vingt-deux",
        23 to "vingt-trois", 24 to "vingt quatre", 25 to "vingt cinq", 26 to "vingt-six",
        27 to "vingt sept", 28 to "vingt-huit", 29 to "vingt-neuf", 30 to "trente",
        31 to "trente et un", 32 to "trente-deux", 33 to "trente-trois", 34 to "trente-quatre",
        35 to "trente-cinq", 36 to "trente-six", 37 to "trente-sept", 38 to "trente-huit",
        39 to "trente-neuf", 40 to "quarante", 41 to "quarante-et-un", 42 to "quarante-deux",
        43 to "quarante-trois", 44 to "quarante-quatre", 45 to "quarante-cinq", 46 to "quarante-six",
        47 to "quarante-sept", 48 to "quarante huit", 49 to "quarante-neuf", 50 to "cinquante",
        51 to "cinquante et un", 52 to "cinquante deux", 53 to "cinquante-trois", 54 to "cinquante-quatre",
        55 to "cinquante cinq", 56 to "cinquante six", 57 to "cinquante sept", 58 to "cinquante-huit",
        59 to "cinquante neuf", 60 to "soixante", 61 to "soixante-et-un", 62 to "soixante deux",
        63 to "soixante trois", 64 to "soixante quatre", 65 to "soixante-cinq", 66 to "soixante six",
        67 to "soixante sept", 68 to "soixante huit", 69 to "soixante neuf", 70 to "soixante-dix",
        71 to "soixante-onze", 72 to "soixante-douze", 73 to "soixante-treize", 74 to "soixante-quatorze",
        75 to "soixante-quinze", 76 to "soixante-seize", 77 to "soixante-dix-sept", 78 to "soixante-dix-huit",
        79 to "soixante-dix-neuf", 80 to "quatre-vingt", 81 to "quatre vingt un", 82 to "quatre vingt deux",
        83 to "quatre vingt trois", 84 to "quatre vingt quatre", 85 to "quatre vingt cinq", 86 to "quatre vingt six",
        87 to "quatre vingt sept", 88 to "quatre vingt huit", 89 to "quatre vingt neuf", 90 to "quatre vingt dix",
        91 to "quatre vingt onze", 92 to "quatre vingt douze", 93 to "quatre vingt treize",
        94 to "quatre vingt quatorze", 95 to "quatre vingt quinze", 96 to "quatre vingt seize",
        97 to "quatre-vingt-dix-sept", 98 to "quatre-vingt-dix-huit", 99 to "quatre-vingt-dix-neuf"),
        override val imageWordPairs: HashMap<String, String> = hashMapOf("Book" to "Le Livre", "Cat" to "Le Chat",
        "Chair" to "La Chaise", "Dog" to "Le Chien", "Fire" to "Le Feu", "Phone" to "Le Téléphone",
        "Sun" to "Le Soleil", "Ticket" to "Le Billet", "Waiter" to "Le Serveur",
         "Water" to "l'Eau")) : Language()