package test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.UnaryOperator;

public class Buffer<T> {
    ArrayList<T> buff;

    public Buffer() {
        buff = new ArrayList<>();
    }

    public Buffer(T... ts) {
        buff = new ArrayList<>();
        for (T t : ts)
            buff.add(t);
    }

    public List<T> toList() {
        return buff;
    }

    // Start from here:
    //-----------------

    // implement append

    public Buffer<T> append(T object) {
        buff.add(object);
        return this;
    }


    public Buffer<T> reverese() {
        ArrayList<T> t = buff;
        buff = new ArrayList<>();
        for (int i = t.size() - 1; i >= 0; i--)
            buff.add(t.get(i));
        return this;
    }


    public Buffer<T> apply(UnaryOperator<T> uop) {
        ArrayList<T> t = buff;
        buff = new ArrayList<>();
        for (int i = 0; i < t.size(); i++)
            buff.add(uop.apply(t.get(i)));
        return this;
    }
}
