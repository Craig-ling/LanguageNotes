package com.example.languagenotes.languages

abstract class Language {
    abstract val numbers: HashMap<Int, String>
}

data class German (
        override val numbers: HashMap<Int, String> = hashMapOf(0 to "null",
                1 to "eins", 2 to "zwei", 3 to "drei", 4 to "vier", 5 to "fünf", 6 to "sechs",
                7 to "sieben", 8 to "acht", 9 to "neun", 10 to "zehn", 11 to "elf", 12 to "zwölf",
                13 to "dreizehn", 14 to "vierzehn", 15 to "fünfzehn", 16 to "sechszehn", 17 to "seibzehn",
                18 to "achtzehn", 19 to "neunzehn", 20 to "zwanzig", 21 to "Einundzwanzig",
                22 to "Zweiundzwanzig", 23 to "", 24 to "", 25 to "", 26 to "Sechsundzwanzig",
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
                99 to "Neunundneunzig")) : Language()
