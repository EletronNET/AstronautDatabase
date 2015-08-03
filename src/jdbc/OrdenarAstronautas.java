package jdbc;

import java.util.Collections;
import java.util.Comparator;

import modelo.Astronauta;

public enum OrdenarAstronautas implements Comparator<Astronauta> {
		 
		  PorDtNasc() {
		        public int compare(Astronauta one, Astronauta other) {
		           return one.getDtNasc().compareTo(other.getDtNasc());
		        }
		     },
		      
		     PorSobrenome() {
		         public int compare(Astronauta one, Astronauta other) {
		            return one.getSobrenome().compareTo(other.getSobrenome());
		         }
		      };
		 
		     
		     public abstract int compare(Astronauta one, Astronauta other);
		 
		     public Comparator<Astronauta> asc() {
		        return this;
		     }
		 
		     public Comparator<Astronauta> desc() {
		        return Collections.reverseOrder(this);
		     }
		}

