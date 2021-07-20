package test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.function.Function;

public class Encoder {
    HashMap<Character, Character> ekey;
    HashMap<Character, Character> dkey;

    public Encoder(HashMap<Character, Character> key) {
        ekey = key;
        dkey = new HashMap<>();
        key.forEach((k, v) -> dkey.put(v, k));
    }

    public Encoder(Function<Character, Character> func) {
        ekey = new HashMap<>();
        dkey = new HashMap<>();
        for (char e = 0; e < 256; e++) {
            char d = func.apply(e);
            ekey.put(e, d);
            dkey.put(d, e);
        }
    }

    public String encode(String text) {
        String word = "";
        char[] chars = text.toCharArray();
        for (char c : chars) {
            word = word + ekey.get(c);
        }

        return word;
    }


    public String decode(String text) {
        String word = "";
        char[] chars = text.toCharArray();
        for (char c : chars) {
            word = word + dkey.get(c);
        }

        return word;
    }

}
