package jdbc;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics2D;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Collection;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import modelo.Astronauta;
import modelo.ListaDeAstronautas;
import modelo.ListaDePaises;
import modelo.Pais;
import dao.AstronautaDAO;

@SuppressWarnings("serial")
public class AstronautaGUI extends JFrame implements ListSelectionListener {

	private static Collection<Astronauta> 	astronautas;
	private static Collection<Pais> 		paises;	
	private ListaDeAstronautas 				listaDeAstronautas; 						// caixa de lista p/ escolha nome
	private ListaDePaises					listaDePaises;								// caixa de lista p/ escolha pais	
	private JTextArea 						taInfo; 									// areas de texto p/ info astronauta
	private JTextArea 						taInfoBio;
	private JLabel 							label; 										// label que contem a foto do astronauta
	
	private File arqFonte = new File ("./fontes/Spaceport.ttf"); 
	
	private static int 	larguraJanela = 140;			// o tamanho da janela da foto
	private static int 	alturaJanela = larguraJanela * 3/2;

	private static String sArquivo[] = {
	      "Novo","new16.gif","N", 
	      "Abrir ...","open16.gif","A",
	      "Salvar","save16.gif","S", 
	      "Salvar como ...","saveas16.gif","c",
	      null, null, null, 
	      "Imprimir ...","print16.gif","I", 
	      null, null, null, 
	      "Sair","blank16.gif","r"};
	
	private static String sEditar[] = {
	      "Recortar","cut16.gif","R", 
	      "Copiar","copy16.gif","C",
	      "Colar","paste16.gif","o", 
	      null, null, null,
	      "Excluir","delete16.gif","x", 
	      "Selecionar tudo","blank16.gif","t"};
	
	private static String sBanco[] = {
	      "Exportar","database-export.png","E", 
	      "Importar","database-import.png","m",
	      "Nuvem","database-cloud.png","u", 
	      "Rede","database-network.png","R",
	      null, null, null, 
	      "Estatísticas","database-property.png","s", 
	      null, null, null, 
	      "Editar registro", "database--pencil.png", "d",
	      "Inserir registro","database-insert.png","I", 
	      "Remover registro", "database-delete.png","e"};
	
	private static String sPais[] = {
										"Todos","ALL.png","T",
		   								"Estados Unidos","USA.png","E",
		   								"Russia","RUS.png","R",
		   								"China","CHN.png","C",
		   								"Japão","JPN.png","J",
		   								"Alemanha","DEU.png","A",
		   								"França","FRA.png","F",
		   								"Canadá","CAN.png","d",
		   								"Itália", "ITA.png","I",
		   								"Brasil","BRA.png","B",
		   								"Hungria","HUN.png","H",
		   								"Romênia","ROU.png","o",
		   								"Polônia","POL.png","P",
		   								"Bélgica", "BEL.png", "L",
		   								"Cuba","CUB.png","b",
		   								"Áustria", "AUT.png","u",
		   								"Índia", "IND.png", "n",
		   								"Rep. Checa","CZE.png","h"
		   								}; 
	
	private static String sGrupo[] = {
										" Todos","globe-green.png","o",
										" Astronautas","hamburger.png","A",
										" Cosmonautas","wall.png", "C",
										" Taikonautas","yin-yang.png","k",
										" Turistas Espaciais","money-bag-dollar.png","T"
									};
	   
	private static String sAjuda[] = {
	      "Ajuda","help16.gif","A", null, null, null,
	      "Sobre ...","about16.gif","S"};
	
	private String 	strSexo = "ALL", 
					strMissao = "ALL", 
					strPais = "ALL",
					strDataNasc = "ALL";
	
	public static Collection<Astronauta> getAstronautas() {
		return astronautas;
	}

	public static void setAstronautas(Collection<Astronauta> astronautas) {
		AstronautaGUI.astronautas = astronautas;
	}
	
	public static Collection<Pais> getPaises() {
		return paises;
	}

	public static void setPaises(Collection<Pais> paises) {
		AstronautaGUI.paises = paises;
	}

	public ListaDeAstronautas getListaDeAstronautas() {
		return listaDeAstronautas;
	}

	public void setListaDeAstronautas(ListaDeAstronautas listaDeAstronautas) {
		this.listaDeAstronautas = listaDeAstronautas;
	}

	public ListaDePaises getListaDePaises() {
		return listaDePaises;
	}
	
	public void setListaDePaises(ListaDePaises listaDePaises) {
		this.listaDePaises = listaDePaises;
	}
	
	public String getStrDataNasc() {
		return strDataNasc;
	}

	public void setStrDataNasc(String strDataNasc) {
		this.strDataNasc = strDataNasc;
	}

	public String getStrMissao() {
		return strMissao;
	}

	public void setStrMissao(String strMissao) {
		this.strMissao = strMissao;
	}

	public String getStrPais() {
		return strPais;
	}

	public void setStrPais(String strPais) {
		this.strPais = strPais;
	}

	public String getStrSexo() {
		return strSexo;
	}

	public void setStrSexo(String strSexo) {
		this.strSexo = strSexo;
	}

	/*
	 *  Construtor
	 */
	public AstronautaGUI() throws SQLException, IOException {
		super("Astronaut Database"); // ajusta titulo
	    setIconImage(new ImageIcon("./imagens/vetor/astronaut-icon.png").getImage());  
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // acao fechar
	    
		inicializa();
	}

	/**
	 * CRIAÇÃO DOS MENUS
	 */
	private void criaMenu() {
		
	      JMenuBar mb = new JMenuBar();
	      MenuHandler mh = new MenuHandler();
	      MenuSexoHandler mrh = new MenuSexoHandler();
	      MenuPaisHandler mcbh = new MenuPaisHandler();
	      MenuGrupoHandler mth = new MenuGrupoHandler();
	      
	      MenuBuilder.imagePrefix = "./imagens/vetor/";
	      mb.add(MenuBuilder.newMenu("Arquivo", 'A', sArquivo, mh));
	      mb.add(MenuBuilder.newMenu("Editar", 'E', sEditar, mh));
	      mb.add(MenuBuilder.newMenu("Banco de Dados", 'B', sBanco, mh));
	      
	      JMenu menuConsulta = new JMenu("Consulta"); 
			      JMenuItem miMissao = new JMenuItem("Missão");
			      miMissao.setIcon(new ImageIcon("./imagens/vetor/Space-Shuttle-icon.png"));
			      JMenuItem miDataNasc = new JMenuItem("Data de Nascimento");
			      miDataNasc.setIcon(new ImageIcon("./imagens/vetor/calendar-day.png"));
			      JMenuItem miOrdena = new JMenuItem("Ordena seleção por...");
			      miOrdena.setIcon(new ImageIcon("./imagens/vetor/sort-alphabet.png"));
			      JMenuItem miAtualiza = new JMenuItem("Atualiza");
			      miAtualiza.addActionListener(mh);
			      miAtualiza.setIcon(new ImageIcon("./imagens/vetor/arrow-circle.png"));
			      
				   JMenu menuSexo = new JMenu("Sexo");
					      menuSexo.setIcon(new ImageIcon("./imagens/vetor/gender.png"));
						      JRadioButtonMenuItem miAmbos = new JRadioButtonMenuItem("Ambos", true);
						      miAmbos.setIcon(new ImageIcon("./imagens/vetor/toilet.png"));
						      JRadioButtonMenuItem miMale = new JRadioButtonMenuItem("Homens", false);
						      miMale.setIcon(new ImageIcon("./imagens/vetor/toilet-male.png"));
						      JRadioButtonMenuItem miFemale = new JRadioButtonMenuItem("Mulheres", false);
						      miFemale.setIcon(new ImageIcon("./imagens/vetor/toilet-female.png"));
						      
						      miAmbos.addItemListener(mrh);
						      miMale.addItemListener(mrh);
						      miFemale.addItemListener(mrh);
						      ButtonGroup bg = new ButtonGroup();
						      bg.add(miMale);bg.add(miFemale);bg.add(miAmbos);
						      
						      menuSexo.add(miMale);menuSexo.add(miFemale);menuSexo.add(miAmbos);
						  
						  MenuBuilder.imagePrefix = "./imagens/flags/";
						  JMenu menuPais = MenuBuilder.newRadioButtonMenu("Pais", 'P', sPais, mcbh);
						  menuPais.setIcon(new ImageIcon(MenuBuilder.imagePrefix + "_united-nations.png"));
						  
						  MenuBuilder.imagePrefix = "./imagens/vetor/";
						  JMenu menuGrupo = MenuBuilder.newRadioButtonMenu("Grupo", 'G', sGrupo, mth);
						  menuGrupo.setIcon(new ImageIcon(MenuBuilder.imagePrefix + "block.png"));
						      
				      menuConsulta.add(menuPais);
				      menuConsulta.add(menuSexo);
				      menuConsulta.add(menuGrupo);
				      menuConsulta.add(miMissao);
				      menuConsulta.add(miDataNasc);
				      menuConsulta.addSeparator();
				      menuConsulta.add(miOrdena);
				      menuConsulta.addSeparator();
				      menuConsulta.add(miAtualiza);
				      menuConsulta.setMnemonic('C');
			      mb.add(menuConsulta);
	      
	      mb.add(MenuBuilder.newMenu("Ajuda", 'j', sAjuda, mh));
	      setJMenuBar(mb); //JMenu menu = mb.getMenu(1);
	
	}

	/**
	 * Cria painéis de divisão
	 */
	private void criaPainel() {
		// painel de divisao
		JSplitPane split1 = new JSplitPane(JSplitPane.VERTICAL_SPLIT,
				new JLabel(new ImageIcon("imagens/vetor/logoAstroDB.png")), // imagem
				new JScrollPane(listaDeAstronautas)); // diretorio
		
		JSplitPane split2 = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,// painel de divisao interno 
				label = new JLabel(), // janela com a Foto do astronauta
				new JScrollPane(taInfo = new JTextArea())); // area de texto
			
		
		JSplitPane split3 = new JSplitPane(JSplitPane.VERTICAL_SPLIT, 
				split2, 
				new JScrollPane(taInfoBio = new JTextArea())); // area de texto
		
		JSplitPane split4 = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, 
				split1, 
				split3);
		
		getContentPane().add(split4, "Center"); // adiciona a janela
		
		// outros ajustes
		Font fonte;
		try {
			fonte = Font.createFont(Font.TRUETYPE_FONT, arqFonte);
			fonte = fonte.deriveFont(Font.PLAIN, 14);
			
		} catch (FontFormatException | IOException e1) {
			fonte = new Font("Verdana", Font.BOLD, 14);
			//e1.printStackTrace();
		}
		split1.setDividerLocation(50); 
		split2.setBorder(BorderFactory.createLoweredBevelBorder());
		split2.setDividerLocation(larguraJanela);
		split2.setOneTouchExpandable(true);
		split3.setDividerLocation(alturaJanela);
		taInfo.setEditable(false);
		taInfo.setAutoscrolls(false);
		taInfoBio.setAutoscrolls(false);
		taInfoBio.setEditable(false);
		taInfo.setSelectionStart(0);
		taInfoBio.setSelectionStart(0);
		taInfo.setLineWrap(true);
		taInfo.setWrapStyleWord(true);
		taInfo.setFont(new Font("Segoe UI", Font.BOLD, 14));
		taInfoBio.setLineWrap(true);
		taInfoBio.setWrapStyleWord(true);
		setSize(1200, 700); // dimensiona janela
		listaDeAstronautas.addListSelectionListener(this);
		listaDeAstronautas.setSelectedIndex(0); // elemento inicial da lista
		//pack();
	}
	/**
	 * @throws HeadlessException
	 * @throws SQLException
	 */
	
	/**
	 * Conecta com o BD MySql
	 * 
	 * @throws HeadlessException
	 * @throws SQLException
	 */
	public void consultaSQL() throws HeadlessException, SQLException {
		try (Connection con = AstronautaDB.getRemoteConnection()){	
			importaBD(con);
		}	catch (SQLException e){
			JOptionPane.showMessageDialog(null, 
					"Não foi possível estabelecer conexão remota. Pressione OK para tentar conexão local...", 
					"Erro", JOptionPane.ERROR_MESSAGE, new ImageIcon("./imagens/vetor/scary.png") );
			try (Connection con = AstronautaDB.getLocalConnection()){
				importaBD(con);
			}
		}
		
	}

	/**
	 * @method importaBD
	 * @param Connection connection
	 * 
	 * Cria os ArrayLists:
	 * 
	 * 1) astronautas 	- coleção de todos os astronautas recuperada do banco de dados MySql
	 * 2) paises 		- coleção de todos os paises recuperada do banco de dados MySql
	 * 
	 */
	public void importaBD(Connection connection)
			throws SQLException {
		
		AstronautaDAO dao 	= new AstronautaDAO(connection);
		
		setAstronautas	(dao.pegaAstronautas(connection));
		setPaises		(dao.pegaPaises(connection));
	}
	
	
	/**
	 * 
	 * Cria listas de astronautas e países
	 */
	public void criaListas() {
		// CRIA LISTA DE ASTRONAUTAS E CARREGA NO JLIST
		 
		listaDeAstronautas = new ListaDeAstronautas(getAstronautas());

		System.out.println("Registros: " + getListaDeAstronautas().getModelAstro().getSize());
				
		// CRIA LISTA DE PAISES E CARREGA NO JLIST

		
		listaDePaises = new ListaDePaises(getPaises());
		
	}

	/**
	 * @method mostraStatusListaAstro
	 * Mostra o estado atual da lista de astronautas
	 */
	public void mostraStatusListaAstro() {
		System.out.println("LISTA ASTRONAUTAS");
		System.out.println("Pais = " + getStrPais());
		System.out.println("Sexo = " + getStrSexo());
		System.out.println(listaDeAstronautas);
	}

	// classe implementa listener
	@Override
	public void valueChanged(ListSelectionEvent e) {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd MMMMM yyyy");
		Astronauta selecionado;
		
		int i = getListaDeAstronautas().getSelectedIndex();
		if (i == -1) {
				selecionado = AstronautaDAO.NENHUM;
			} else {
				selecionado = getListaDeAstronautas().getSelectedValue();
			}
		
		// CRIA A ÁREA DE TEXTO COM INFO DO ASTRONAUTA
		// exibe informacoes do astronauta: ID, nome, pa�s de origem, data de nascimento, sexo.
		StringBuilder sb = new StringBuilder("REGISTRO: \t" + selecionado.getIdAstronauta() + "\n");
		String nome = selecionado.getPrimeiro_Nome() + " " 
					+ selecionado.getNome_do_Meio() + " " 
					+ selecionado.getSobrenome() + "\n";
		String pais = mostraNome(selecionado.getPais_Nasc()) + "\n";
		String estado = selecionado.getEstado_Nasc() + "\n";
		String cidade = selecionado.getCidade_Nasc() + "\n";
		String dataNasc = (sdf.format(selecionado.getDtNasc()) + "\n");
		Date dataFalec = selecionado.getDtFalec();
		
		sb.append("NOME: \t" + nome	);
		sb.append("PAIS: \t"  + pais );
		sb.append("ESTADO: \t" + estado );
		sb.append("CIDADE: \t" + cidade );
		sb.append("NASCEU: \t" + dataNasc);

		if (dataFalec != null) {
			sb.append("FALECEU: \t" + (sdf.format(dataFalec) + "\n"));
		}
		
		sb.append("SEXO: \t" + (selecionado.getSexo().charAt(0) == 'M' ? "masculino" : "feminino") + "\n\n");
		
		StringBuilder sb2 = new StringBuilder("BIOGRAFIA: " + "\n\n" + selecionado.getInfo() + "\n\n");
		sb2.append("MISSOES: " + "\n\n");
		for (String s : selecionado.getMissao()){
			sb2.append(s + "\n");
		}
		
		taInfo.setText(sb.toString());
		taInfoBio.setText(sb2.toString());
		
		BufferedImage img = null;
		try {
				img = ImageIO.read(new File("./imagens/people/" + selecionado.getFoto())); 

			} catch (IOException eio){}
		
		BufferedImage imagem = formataImagem(img, larguraJanela, alturaJanela);
		
		label.setBorder(BorderFactory.createLineBorder(Color.BLACK));  
		label.setSize(larguraJanela, alturaJanela);
		label.setIcon(new ImageIcon(imagem));  
	}
	
	// recebe uma imagem e retorna essa imagem no padrão LARGURA = larguraJanela, ALTURA = alturaJanela
	private BufferedImage formataImagem(BufferedImage bi, int largura, int altura) throws HeadlessException {

		BufferedImage aux = new BufferedImage(largura,altura, bi.getType());
		Graphics2D gg = aux.createGraphics();
		AffineTransform at = AffineTransform.getScaleInstance((double) largura/bi.getWidth(), (double) altura/bi.getHeight());
		gg.drawRenderedImage(bi, at);
		return aux;
	}
	
	
	   public class MenuHandler implements ActionListener {
		   
		   	@Override	
		    public void actionPerformed(ActionEvent e) {
		        
		   		String acao = ((JMenuItem)e.getSource()).getText();
		        
		         if (acao.equals(sArquivo[1*3])) {
		            JFileChooser dialogo = new JFileChooser();
		            int resultado = dialogo.showOpenDialog(AstronautaGUI.this);
		            if (resultado == JFileChooser.APPROVE_OPTION) {
		            	// TODO
		               // File arqEscolhido = dialogo.getSelectedFile();
		               // processamento do arquivo escolhido
		               // taEditor.append("Arquivo: "+ arqEscolhido.getName() + "\n");
		            }
		         }
		         
		         if (acao.equals(sArquivo[7*3])) {System.exit(0);}
		         
		         if (acao.equals("Estatísticas")){
		        	 // TODO
		         }
		         
		         if (acao.equals("Sobre ...")){
		        	 
		        	 JOptionPane.showMessageDialog(
		        			 AstronautaGUI.this, 
		        			 "(C) Erasmo Leite Jr 2015 - eleitejr@gmail.com", 
		        			 "Astronaut Database", 
		        			 JOptionPane.INFORMATION_MESSAGE,
		        			 new ImageIcon("./imagens/vetor/mike.png"));
		         }
		         
		         if (acao.equals("Atualiza")){
		         		System.out.println("atualizando ----------------------------------------->");
		         		listaDeAstronautas.atualiza(getAstronautas(), getStrSexo(), getStrPais());
		         		System.out.println("Operação realizada com sucesso-------> " + getListaDeAstronautas().getModel().getSize() + " registros encontrados.");
		         		mostraStatusListaAstro();
		         	}
		      }

	   }
     		 
	   private class MenuPaisHandler implements ItemListener {

			@Override
			public void itemStateChanged(ItemEvent eventoPais) {
				
				if (eventoPais.getStateChange() == ItemEvent.SELECTED) {
				
					String paisSel = ((JMenuItem)eventoPais.getSource()).getIcon().toString();
					
					// A expressão abaixo retorna o código ISO-3 do país, a partir do ícone armazenado no JMenuItem
					setStrPais(paisSel.substring(16,19));
					
						System.out.println("atualizando ----------------------------------------->");
						listaDeAstronautas.atualiza(getAstronautas(), getStrSexo(), getStrPais());
						System.out.println("Filtro [PAIS = " + getStrPais() + "] aplicado com sucesso-------> " 
								+ getListaDeAstronautas().getModel().getSize() + " registros encontrados.");
						//mostraStatusListaAstro();

				  }
				
				}
				
			}

	   
	   private class MenuSexoHandler implements ItemListener {

			@Override
			public void itemStateChanged(ItemEvent eventoSexo) {
				
				if (eventoSexo.getStateChange() == ItemEvent.SELECTED) {
					
					String sexoSel = ((JMenuItem)eventoSexo.getSource()).getText();
					
					switch(sexoSel) {
					
						case "Ambos" : default	:	{setStrSexo("ALL"); 	break;}
						case "Homens" 		:	{setStrSexo("M");	 	break;}
						case "Mulheres" 		:	{setStrSexo("F");	 	break;}
					}	
					
					System.out.println("atualizando ----------------------------------------->");
	         		listaDeAstronautas.atualiza(getAstronautas(), getStrSexo(), getStrPais());
	         		System.out.println("Filtro [SEXO = " + getStrSexo() + "] aplicado com sucesso-------> " 
	         				+ getListaDeAstronautas().getModel().getSize() + " registros encontrados.");
	         		//mostraStatusListaAstro();
	         		
				}
			}
	   }
	   
	   private class MenuGrupoHandler implements ItemListener {

			@Override
			public void itemStateChanged(ItemEvent eventoTipo) {
				
				if (eventoTipo.getStateChange() == ItemEvent.SELECTED) {
					
					String tipoSel = ((JMenuItem)eventoTipo.getSource()).getText().substring(1, 2);
					
					switch(tipoSel) {
					
						case "A" : default	:	
						case "C" 		:	
						case "k" 		:	
						case "T"		:	{break;}
					}	
					/*
					 * TODO: criar método para consulta
					 */
					//System.out.println("atualizando ----------------------------------------->");
	         		//listaDeAstronautas.atualiza(getAstronautas(), getStrSexo(), getStrPais());
	         		//System.out.println("Filtro [SEXO = " + getStrSexo() + "] aplicado com sucesso-------> " 
	         		//		+ getListaDeAstronautas().getModel().getSize() + " registros encontrados.");
	         		//mostraStatusListaAstro();
	         		
				}
			}
	   }
	       
	   /*
	    *           INICIALIZAÇÃO DOS COMPONENTES
	    */
	   private void inicializa() throws HeadlessException, SQLException {
			    /*
			     * INICIALIZA DADOS DAS LISTAS E CRIA O PAINEL PRINCIPAL  
			     */
			
		   	consultaSQL(); 
			criaListas();			
			criaPainel();
			criaMenu();
		}

	public String mostraNome(String paisISO){
		for (Pais p : paises){
			if (p.getId().equalsIgnoreCase(paisISO)){
				return p.getNome();
			} 
		}
		return null;
	}
	
	public String mostraISO(String pais){
		for (Pais p : paises){
			if (p.getNome().equalsIgnoreCase(pais)){
				return p.getId();
			} 
		}
		return null;
	}

	/*
	 * Método MAIN()
	 */
	public static void main(String s[]) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					new AstronautaGUI().setVisible(true);
				} catch (SQLException | IOException e) {
					JOptionPane.showMessageDialog(
							null, 
							"Erro de Conexão!", 
							"Alerta", 
							JOptionPane.ERROR_MESSAGE);
					e.printStackTrace();
				}
			}
		});
	}
}
