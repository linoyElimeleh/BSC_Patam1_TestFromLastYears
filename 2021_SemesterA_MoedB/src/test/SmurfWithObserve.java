package test;

import java.util.Observable;
import java.util.Observer;

public class SmurfWithObserve extends Observable implements Observer {

    private boolean working;

    public SmurfWithObserve() {
        working = false;
    }

    public boolean isWorking() {
        return working;
    }

    public void worksWhen(SmurfWithObserve... smurfs) {
        for (SmurfWithObserve s : smurfs) {
            s.addObserver(this);
        }
    }

    public void work() {
        if (!working) {
            working = true;
            setChanged();
            notifyObservers();
        }
    }

    @Override
    public void update(Observable o, Object arg) {
        work();
    }

}
