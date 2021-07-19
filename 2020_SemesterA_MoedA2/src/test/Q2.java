package test;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Q2 {

    public static int[] getCount(List<String> words, String fileName) {
        int[] count = new int[words.size()];
        try {
            HashMap<String, Integer> map = new HashMap<>();
            Scanner s = new Scanner(new BufferedReader(new FileReader(fileName)));

            while (s.hasNext()) {
                String w = s.next();
                if (!map.containsKey(w))
                    map.put(w, 1);
                else
                    map.put(w, map.get(w) + 1);
            }
            s.close();

            int iterator = 0;
            for (String word : words) {
                count[iterator] = map.get(word);
                iterator++;
            }


        } catch (IOException e) {
        }

        return count;
    }
}
