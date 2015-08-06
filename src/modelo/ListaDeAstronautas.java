package modelo;

import java.util.Collection;
import java.util.Comparator;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.ListSelectionModel;

@SuppressWarnings("serial")
public class ListaDeAstronautas extends JList<Astronauta>{
	
	private String sPais[] = {
			"AFG",
			"ZAF",
			"DEU",
			"SAU",
			"AUT",
			"BEL",
			"BRA",
			"BGR",
			"CAN",
			"KAZ",
			"CHN",
			"KOR",
			"CUB",
			"SVK",
			"USA",
			"FRA",
			"NLD",
			"HUN",
			"IND",
			"ISR",
			"ITA",
			"JPN",	
			"MYS",
			"MEX",
			"MNG",
			"POL",
			"CZE",
			"GBR",
			"ROU",
			"RUS",		   								
			"SYR",	   									   								
			"SWE",
			"CHE",		   								
			"UKR",
			"VNM",		   								
	}; 
	
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
		HashSet<String> sexoSet = new LinkedHashSet<String>();
		HashSet<String> paisSet = new LinkedHashSet<String>();
		HashSet<String> grupoSet = new LinkedHashSet<String>();
			
		ArrayList<String> grupos = new ArrayList<String>();
		grupos.add("Astronautas");
		grupos.add("Cosmonautas");
		grupos.add("Taikonautas");
		grupos.add("Turistas");
		
		if (sexo == "ALL") 							{sexoSet.add("M");sexoSet.add("F");} else {sexoSet.add(sexo);}
		
		if (grupo == "ALL") 						{grupoSet.addAll(grupos);} else {grupoSet.add(grupo);}
		
		if (pais == "ALL") 	    			{for (int i=0; i<sPais.length; i++)
														{System.out.println(sPais[i]);
														paisSet.add(sPais[i]);}
													} else {paisSet.add(pais);}
				
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
		/*
		for (Astronauta a : astros){
			if (
						sexoSet.contains(a.getSexo()) 
					&& 	paisSet.contains(a.getPais_Nasc()) 
					&& grupoSet.contains(a.getGrupo())
					)
			{
				modelAstroConsulta.addElement(a);
			}
		}
		*/
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
