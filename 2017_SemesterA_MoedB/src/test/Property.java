package test;


import java.util.Observable;
import java.util.Observer;

public class Property<V> extends Observable implements Observer {
    private V value;

    public Property() {
    }

    public void setValue(V i) {
        this.value = i;
        setChanged();
        notifyObservers();
    }

    public void bind(Property<V> k) {
        addObserver(k);
    }

    public V getValue() {
        return this.value;
    }

    @Override
    public void update(Observable o, Object arg) {
        Property<V> p = (Property<V>) o;
        setValue(p.getValue());
    }
}
