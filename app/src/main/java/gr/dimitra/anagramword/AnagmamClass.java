package gr.dimitra.anagramword;

import java.util.Random;

public class AnagmamClass {

    public static final Random RANDOM = new Random();
    public static final String[] WORDSGREECE = {"SANTORINI", "MYKONOS","MILOS",
            "PAROS", "ATHENS", "THESSALONIKI", "CRETA", "PARTHENON",
            "OLYMPUS", "RHODES"};
    public static final String[] WORDSITALIY = {"VENICE", "FLORENCE","NAPLES",
            "ROME", "CAPRI", "COLOSSEUM", "VATICAN", "SICILY", "MILAN", "BOLOGNA"};

    public static final String[] WORDSBRAZIL = {"AMAZON RIVER", "RIO DE JANEIRO","FAVELAS",
            "SALVADOR", "SAO PAOLO", "BRAZIL", "FLORIANOPOLIS", "GRAMANO", "LAGO NEGRO", "TEATRO AMAZONA"};

    public static final String[] WORDSFRANCE = {"PARIS", "LYON", "NICE",
            "MARSEILLE", "EIFFEL", "MONACO", "TOULOUSE", "BORDEAUX", "CANNES", "VERSAILLES"};

    public static final String[] WORDSEGYPT = {"CAIRO", "ALEXANDRIA","SUEZ",
            "PHARAOH", "LUXOR", "GIZA", "NILE", "SINAI", "SAHARA", "DESERT"};

    public static final String[] WORDSAUSTRALIA = {"PERTH", "SYDNEY","MELBOURNE",
            "GEELONG", "ADELAIDE", "QUEENSLAND", "TASMANIA", "SWAN RIVER", "REDWOOD", "HOBART"};

    public static final String[] WORDSUK = {"LONDON", "BRISTOL","LIVERPOOL",
            "EDINBURGH", "GLASGOW", "YORK", "BRIGHTON", "CARDIFF", "BERMINGHAM", "BUCKINGHAM"};


    public static String randomWordGreece() {
        return WORDSGREECE[RANDOM.nextInt(WORDSGREECE.length)];
    }

    public static String randomWordItaly() {
        return WORDSITALIY[RANDOM.nextInt(WORDSITALIY.length)];
    }

    public static String randomWordEgypt() {
        return WORDSEGYPT[RANDOM.nextInt(WORDSEGYPT.length)];
    }

    public static String randomWordUk() {
        return WORDSUK[RANDOM.nextInt(WORDSUK.length)];
    }

    public static String randomWordFrance() {
        return WORDSFRANCE[RANDOM.nextInt(WORDSFRANCE.length)];
    }

    public static String randomWordAustralia() {
        return WORDSAUSTRALIA[RANDOM.nextInt(WORDSAUSTRALIA.length)];
    }

    public static String randomWordBrazil() {
        return WORDSBRAZIL[RANDOM.nextInt(WORDSBRAZIL.length)];
    }

    public static String shuffleWord(String word) {
        if (word != null  &&  !"".equals(word)) {
            char a[] = word.toCharArray();

            for (int i = 0; i < a.length; i++) {
                int j = RANDOM.nextInt(a.length);
                char tmp = a[i];
                a[i] = a[j];
                a[j] = tmp;
            }

            return new String(a);
        }

        return word;
    }
}
