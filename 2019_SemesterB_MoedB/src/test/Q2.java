package test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;

public class Q2 {


    public static List<String> orderByCount(String text) {


        HashMap<String, Integer> map = new HashMap<>();
        Scanner s = new Scanner(text);

        while (s.hasNext()) {
            String w = s.next();
            if (!map.containsKey(w))
                map.put(w, 1);
            else
                map.put(w, map.get(w) + 1);
        }
        s.close();

        List<String> l = new ArrayList<>();
        l.addAll(map.keySet());

        l.sort((s1, s2) -> {
            int x = map.get(s2) - map.get(s1);
            if (x == 0)
                x = s1.compareTo(s2);
            return x;
        });


        // List<String> words = new ArrayList<>();


        return l;
    }
}