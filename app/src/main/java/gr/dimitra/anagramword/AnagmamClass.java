package gr.dimitra.anagramword;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
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
        Random rand = new Random();
        String word = null;

        for (int i = 0; i < WORDSGREECE.length; i++) {
            int randomIndexToSwap = rand.nextInt(WORDSGREECE.length);
            String temp = WORDSGREECE[randomIndexToSwap];
            WORDSGREECE[randomIndexToSwap] = WORDSGREECE[i];
            WORDSGREECE[i] = temp;
            word = WORDSGREECE[i];
        }

        return word;

        //return WORDSGREECE[RANDOM.nextInt(WORDSGREECE.length)];
    }

    public static String randomWordItaly() {
        Random rand = new Random();
        String word = null;

        for (int i = 0; i < WORDSITALIY.length; i++) {
            int randomIndexToSwap = rand.nextInt(WORDSITALIY.length);
            String temp = WORDSITALIY[randomIndexToSwap];
            WORDSITALIY[randomIndexToSwap] = WORDSITALIY[i];
            WORDSITALIY[i] = temp;
            word = WORDSITALIY[i];
        }

        return word;
        //return WORDSITALIY[RANDOM.nextInt(WORDSITALIY.length)];
    }

    public static String randomWordEgypt() {
        Random rand = new Random();
        String word = null;

        for (int i = 0; i < WORDSEGYPT.length; i++) {
            int randomIndexToSwap = rand.nextInt(WORDSEGYPT.length);
            String temp = WORDSEGYPT[randomIndexToSwap];
            WORDSEGYPT[randomIndexToSwap] = WORDSEGYPT[i];
            WORDSEGYPT[i] = temp;
            word = WORDSEGYPT[i];
        }

        return word;
        //return WORDSEGYPT[RANDOM.nextInt(WORDSEGYPT.length)];
    }

    public static String randomWordUk() {
        Random rand = new Random();
        String word = null;

        for (int i = 0; i < WORDSUK.length; i++) {
            int randomIndexToSwap = rand.nextInt(WORDSUK.length);
            String temp = WORDSUK[randomIndexToSwap];
            WORDSUK[randomIndexToSwap] = WORDSUK[i];
            WORDSUK[i] = temp;
            word = WORDSUK[i];
        }

        return word;
        //return WORDSUK[RANDOM.nextInt(WORDSUK.length)];
    }

    public static String randomWordFrance() {
        Random rand = new Random();
        String word = null;

        for (int i = 0; i < WORDSFRANCE.length; i++) {
            int randomIndexToSwap = rand.nextInt(WORDSFRANCE.length);
            String temp = WORDSFRANCE[randomIndexToSwap];
            WORDSFRANCE[randomIndexToSwap] = WORDSFRANCE[i];
            WORDSFRANCE[i] = temp;
            word = WORDSFRANCE[i];
        }

        return word;
        //return WORDSFRANCE[RANDOM.nextInt(WORDSFRANCE.length)];
    }

    public static String randomWordAustralia() {
        Random rand = new Random();
        String word = null;

        for (int i = 0; i < WORDSAUSTRALIA.length; i++) {
            int randomIndexToSwap = rand.nextInt(WORDSAUSTRALIA.length);
            String temp = WORDSAUSTRALIA[randomIndexToSwap];
            WORDSAUSTRALIA[randomIndexToSwap] = WORDSAUSTRALIA[i];
            WORDSAUSTRALIA[i] = temp;
            word = WORDSAUSTRALIA[i];
        }

        return word;
        //return WORDSAUSTRALIA[RANDOM.nextInt(WORDSAUSTRALIA.length)];
    }

    public static String randomWordBrazil() {
        Random rand = new Random();
        String word = null;

        for (int i = 0; i < WORDSBRAZIL.length; i++) {
            int randomIndexToSwap = rand.nextInt(WORDSBRAZIL.length);
            String temp = WORDSBRAZIL[randomIndexToSwap];
            WORDSBRAZIL[randomIndexToSwap] = WORDSBRAZIL[i];
            WORDSBRAZIL[i] = temp;
            word = WORDSBRAZIL[i];
        }

        return word;
        //return WORDSBRAZIL[RANDOM.nextInt(WORDSBRAZIL.length)];
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
