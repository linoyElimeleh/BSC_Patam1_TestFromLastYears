package test;


import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

public class Smurf { // you may edit class signiture

    private boolean working;
    ArrayList<Smurf> affectSmurfs;

    public Smurf() {
        working = false;
        affectSmurfs = new ArrayList<>();
    }

    public boolean isWorking() {
        return working;
    }

    public void worksWhen(Smurf... s) {
        for (int i = 0; i < s.length; i++) {
            s[i].affectSmurfs.add(this);
        }

    }

    public void work() {
        if (working == false) {
            working = true;
            for (int i = 0; i < affectSmurfs.size(); i++) {
                Smurf sNew = affectSmurfs.get(i);
                sNew.work();

            }
        }
    }


    // implement worksWhen method

    // add additional methods as needed

}
