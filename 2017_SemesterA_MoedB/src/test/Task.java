package test;

import java.text.Collator;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

public class Task implements Comparable<Task> {

    int frequency;
    int duration;
    String name;

    public Task(int frequency, int duration, String name) {
        this.frequency = frequency;
        this.duration = duration;
        this.name = name;
    }


    public int compareTo(Task b) {
        if (this.frequency == b.frequency) {
            if (this.duration == b.duration) {
                return this.name.compareTo(b.name);
            } else
                return duration - b.duration;
        } else
            return b.frequency - frequency;
    }
}
