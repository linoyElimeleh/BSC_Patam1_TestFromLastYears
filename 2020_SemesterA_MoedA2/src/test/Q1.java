package test;

import java.util.*;

public class Q1 {

    public static Map<Character, List<String>> makeDictionary(List<String> words) {
        Map<Character, Set<String>> map = new HashMap<>();
        for (String word : words) {
            char c = word.charAt(0);
            if (!map.containsKey(c)) {
                map.put(c, new HashSet<>());

            }
            map.get(c).add(word);
        }

        Map<Character, List<String>> map2 = new HashMap<>();
        for (Character c : map.keySet()) {
            List<String> l = new ArrayList<>();
            l.addAll(map.get(c));
            map2.put(c, l);
        }
        return map2;
    }
}
