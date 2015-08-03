package modelo;

import java.util.Comparator;

public class DataNascComparator implements Comparator<Astronauta> {
    public int compare(Astronauta astronauta, Astronauta outroAstronauta) {
        return astronauta.getDtNasc().
                compareTo(outroAstronauta.getDtNasc());
    }
}


