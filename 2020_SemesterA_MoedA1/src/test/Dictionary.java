package test;

import java.util.*;

public class Dictionary {

    // you can add code here
    HashMap<Character, List<String>> dic;

    public Dictionary(String text) {
        // you can add code here
        HashMap<Character, Set<String>> map = new HashMap<>();

        Scanner s = new Scanner(text);
        while (s.hasNext()) {
            String word = s.next();
            char w = word.charAt(0);
            if (!map.containsKey(w))
                map.put(w, new HashSet<>());
            map.get(w).add(word);
        }

        s.close();
        dic = new HashMap<>();
        for (char c : map.keySet()) {
            List<String> l = new ArrayList<>();
            l.addAll(map.get(c));
            Collections.sort(l);
            dic.put(c, l);
        }
    }

    public List<String> getList(char c) {
        // implement in O(1)
        if (dic.containsKey(c)) {
            return dic.get(c);

        }
        return new ArrayList<>();
    }
}
