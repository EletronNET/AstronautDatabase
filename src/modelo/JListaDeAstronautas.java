package modelo;

import java.util.Collection;
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

	public ListaDeAstronautas(Collection<Astronauta> astronautas) {
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
		//for (Astronauta a : astronautas)
		sbLista.append("] \n");
		return sbLista.toString();
	}
	
	public void inicializa(Collection<Astronauta> astronautas){
		modelAstro 	= new DefaultListModel<>();
		for (Astronauta a : astronautas){
			modelAstro.addElement(a);
		}
		
		setModel(modelAstro);
		setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		setSelectedIndex(0);
		ensureIndexIsVisible(0);
		
	}

	public void filtra(Collection<Astronauta> astros, String sexo, String pais, String grupo){
	
		DefaultListModel<Astronauta> modelAstroConsulta = new DefaultListModel<Astronauta>();
		/*
		Set<Astronauta> sexoSet = new LinkedHashSet<Astronauta>();sexoSet.addAll(astros);
		Set<Astronauta> paisSet = new LinkedHashSet<Astronauta>();paisSet.addAll(astros);
		Set<Astronauta> grupoSet = new LinkedHashSet<Astronauta>();grupoSet.addAll(astros);
			
		if (sexo != "ALL") {
			for (Astronauta astronauta : sexoSet) {
					 
				if (!astronauta.getSexo().equals(sexo)){
					sexoSet.remove(astronauta);
				}
			}
			
			if (pais != "ALL") {
				for (Astronauta astronauta2 : paisSet) {
					
				if (!astronauta2.getPais_Nasc().equals(pais)){
					paisSet.remove(astronauta2);
					}
				}
			}
			
			if (grupo != "ALL") {
				if (!astronauta.getGrupo().equals(grupo)){
					grupoSet.remove(astronauta);
				}
			}
		}
		*/
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

	public void ordena(Collection<Astronauta> listaDeAstronautas, Comparator<Astronauta> c){
		
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
