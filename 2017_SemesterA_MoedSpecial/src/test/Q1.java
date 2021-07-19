package test;

import java.util.HashMap;
import java.util.LinkedList;

public class Q1 {

    public static class MyStack<T> {
        LinkedList<T> list; // you must use this list to store the items of the stack

        public MyStack() {
            list = new LinkedList<>();
        }

        public void push(T t) {
            list.push(t);
        }

        public T pop() {
            return list.removeFirst();
        }

        public T peek() {
            return list.getFirst();
        }

        public boolean contains(T t) {
            return list.contains(t);

        }

        public int size() {
            return list.size();
        }
    }

    public static void testAPI() {
        MyStack<Integer> stack = new MyStack<>();
        stack.push(15);
        stack.push(14);
        stack.push(13);
        stack.push(12);
        System.out.println(stack.peek()); // 12
        Integer i = stack.pop();
        System.out.println(i); // 12
        System.out.println(stack.contains(12)); // false
        System.out.println(stack.contains(13)); // true
        stack.push(13); // 13 appears twice now
        stack.push(13); // 13 appears 3 times now
        stack.pop();
        System.out.println(stack.contains(13)); // true
        stack.pop();
        System.out.println(stack.contains(13)); // true
        stack.pop();
        System.out.println(stack.contains(13)); // false

    }

}
