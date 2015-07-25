package modelo;

import java.util.ArrayList;
import java.util.Comparator;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.ListSelectionModel;

@SuppressWarnings("serial")
public class ListaDeAstronautas extends JList<Astronauta>{
	private DefaultListModel<Astronauta> modelAstro;
	
	public ListaDeAstronautas(DefaultListModel<Astronauta> modelAstro) {
		super();
		this.modelAstro = modelAstro;
	}

	public ListaDeAstronautas(ArrayList<Astronauta> astronautas) {
		inicializa(astronautas);
	}

	public DefaultListModel<Astronauta> getModelAstro() {
		return modelAstro;
	}

	public void setModelAstro(DefaultListModel<Astronauta> modelAstro) {
		this.modelAstro = modelAstro;
	}
	
	@Override
	public String toString() {
		StringBuilder sbLista = new StringBuilder("[");
		
		return sbLista.toString();
	}
	
	public void inicializa(ArrayList<Astronauta> astros){
		modelAstro 	= new DefaultListModel<>();
		for (Astronauta a : astros){
			modelAstro.addElement(a);
		}
		
		setModel(modelAstro);
		setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
	}

	public void atualiza(ArrayList<Astronauta> astros, String sexo, String pais){
	
		DefaultListModel<Astronauta> modelAstroConsulta = new DefaultListModel<Astronauta>();
		
		switch(pais){
							case "ALL":	switch(sexo){
															case "ALL": {
																for (Astronauta a : astros) {
																	modelAstroConsulta.addElement(a);
																	};
																break;
																}
															
															default: {
																for (Astronauta a : astros) {
															
																if (a.getSexo().equals(sexo)){
																	modelAstroConsulta.addElement(a);
																	}
																}
																break;
															}
															
															
										}
							
										break;
							
							default:	switch(sexo){
															case "ALL": {
																for (Astronauta a : astros) {
																	if (a.getPais_Nasc().equals(pais)){
																		modelAstroConsulta.addElement(a);
																	}
																}
																break;
															}
															
															default: {
																for (Astronauta a : astros){
																	if (a.getPais_Nasc().equals(pais) && (a.getSexo().equals(sexo))){
																		modelAstroConsulta.addElement(a);
																	}
																}
																break;
															}
										}
										break;
		}
		
		setModel(modelAstroConsulta);
		setSelectedIndex(0);
		ensureIndexIsVisible(0);
	
	}

	public void ordena(ArrayList<Astronauta> listaDeAstronautas, Comparator<Astronauta> c){
		
		DefaultListModel<Astronauta> modelAstroOrdena = new DefaultListModel<>();
		
		// TODO		
		
		for (Astronauta a : listaDeAstronautas) {
			modelAstroOrdena.addElement(a);
			};
		
		setModel(modelAstroOrdena);
		setSelectedIndex(0);
		ensureIndexIsVisible(0);
	
	}

}
