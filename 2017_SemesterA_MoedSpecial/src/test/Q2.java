package test;

import java.util.*;

public class Q2 {

    public static interface StringReader {
        String readString();
    }

    public static class MyWordFilter implements StringReader {
        StringReader reader;

        public MyWordFilter(StringReader s) {
            this.reader = s;
        } // Decorator

        @Override
        public String readString() {
            HashSet<String> map = new HashSet<>();
            String sp[] = reader.readString().split(" ");

            for (String s : sp) {
                map.add(s);
            }

            StringBuilder sb = new StringBuilder();

            for (String str : sp) {
                if (map.contains(str)) {
                    sb.append(str + ";");
                    map.remove(str);
                }
            }

            return sb.toString();
        }
    }

    public static interface IntArrayReader {
        int[] readIntArray();
    }

    public static class MyIntArrayToStringReader implements StringReader {

        IntArrayReader arrayReader;

        public MyIntArrayToStringReader(IntArrayReader arrayReader) {
            this.arrayReader = arrayReader;

        }

        @Override
        public String readString() {
            StringBuilder sb = new StringBuilder();
            int[] array = arrayReader.readIntArray();

            for (int i : array)
                sb.append(i + " ");
            return sb.toString();
        }

    } // Object Adapter


// ---------------------- test API ------------------------------

    public static class MyStringReader implements StringReader {
        @Override
        public String readString() {
            return "Hello Hello World World Q2";
        }
    }

    public static class MyIntArrayReader implements Q2.IntArrayReader {
        @Override
        public int[] readIntArray() {
            int[] r = {100, 100, 50, 50, 13, 14};
            return r;
        }

    }

    public static void testAPI() {
        StringReader reader = new MyWordFilter(new MyStringReader());
        System.out.println(reader.readString()); // Hello;World;Q2;

        reader = new Q2.MyWordFilter(new Q2.MyIntArrayToStringReader(new MyIntArrayReader()));
        System.out.println(reader.readString()); // 100;50;13;14;
    }
}
