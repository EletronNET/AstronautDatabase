package modelo;

import java.util.Comparator;

public class MissoesComparator implements Comparator<Astronauta> {
    public int compare(Astronauta astronauta, Astronauta outroAstronauta) {
    	int comp = (astronauta.getMissao().size() > outroAstronauta.getMissao().size()) ? 1 : 0;
    	if(comp == 0){
    	    comp = (astronauta.getMissao().size() == outroAstronauta.getMissao().size()) ? 0 : -1;
    	}
    	return comp;
    }
}