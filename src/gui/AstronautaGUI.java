package gui;

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
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
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
import crud.AstronautaCreate;
import dao.AstronautaDAO;
import dao.ConnectionFactory;

@SuppressWarnings("serial")
class AstronautaGUI extends JFrame implements ListSelectionListener {

    private Connection 						con;
    private static ArrayList<Astronauta> 	astronautas;
    private static ArrayList<Pais> 			paises;
    private ListaDeAstronautas 				listaDeAstronautas; 						// caixa de lista p/ escolha nome
    private ListaDePaises					listaDePaises;								// caixa de lista p/ escolha pais
    private JTextArea 						taInfo; 									// areas de texto p/ info astronauta
    private JTextArea 						taInfoBio;
    private JTextArea						taInfoConnection;							// propriedades da conexão
    private JLabel                          lbl_foto; 									// lbl_foto que contem a foto do astronauta

    private final File arqFonte = new File ("./fontes/Spaceport.ttf");

    private static final int 	larguraJanela = 140;			// o tamanho da janela da foto
    private static final int 	alturaJanela = larguraJanela * 3/2;

    private static final String[] sArquivo = {
            "Novo","new16.gif","N",
            "Abrir ...","open16new.png","A",
            "Salvar","save16new.png","S",
            "Salvar como ...","saveas16new.png","c",
            null, null, null,
            "Imprimir ...","print16new.png","I",
            null, null, null,
            "Sair","exit16new.png","r"};

    private static final String[] sEditar = {
            "Recortar","cut16.png","R",
            "Copiar","copy16new.png","C",
            "Colar","paste16.gif","o",
            null, null, null,
            "Excluir","delete16.gif","x",
            "Selecionar tudo","blank16.gif","t"};

    private static final String[] sBanco = {
            "Exportar","database-export.png","E",
            "Importar","database-import.png","m",
            "Nuvem","database-cloud.png","v",
            "Rede","database-network.png","R",
            null, null, null,
            "Estatísticas","database-property.png","s",
            null, null, null,
            "Editar registro", "database--pencil.png", "d",
            "Inserir registro","database-insert.png","I",
            "Remover registro", "database-delete.png","e"};

    private static final String[] sPais = {
            "Todos","ALL.png","T",
            "Afeganistão","AFG.png","a",
            "África do Sul","ZAF.png","f",
            "Alemanha","DEU.png","A",
            "Arábia Saudita","SAU.png","t",
            "Áustria","AUT.png","u",
            "Bélgica","BEL.png", "L",
            "Brasil","BRA.png","B",
            "Bulgária","BGR.png","i",
            "Canadá","CAN.png","d",
            "Casaquistão","KAZ.png","z",
            "China","CHN.png","C",
            "Coréia do Sul","KOR.png","K",
            "Cuba","CUB.png","b",
            "Eslováquia","SVK.png","q",
            "Estados Unidos","USA.png","E",
            "França","FRA.png","F",
            "Holanda","NLD.png","l",
            "Hungria","HUN.png","H",
            "Índia","IND.png", "n",
            "Israel","ISR.png","r",
            "Itália","ITA.png","I",
            "Japão","JPN.png","J",
            "Malásia","MYS.png","M",
            "México","MEX.png","x",
            "Mongólia","MNG.png","g",
            "Polônia","POL.png","P",
            "Rep. Checa","CZE.png","h",
            "Reino Unido","GBR.png","U",
            "Romênia","ROU.png","o",
            "Russia","RUS.png","R",
            "Síria","SYR.png","y",
            "Suécia","SWE.png","S",
            "Suiça","CHE.png","ç",
            "Ucrânia","UKR.png","k",
            "Vietnã","VNM.png","V",
    };

    private static final String[] sGrupo = {
            " Todos","globe-green.png","o",
            " Astronautas","hamburger.png","A",
            " Cosmonautas","wall.png", "C",
            " Taikonautas","yin-yang.png","k",
            " Turistas","money-bag-dollar.png","T"
    };

    private static final String[] sOrdenar = {
            " Ordem de Viagem","Space-Shuttle-icon.png","V",
            " Sobrenome","address-book.png","n",
            " Data de Nascimento","calendar-day.png","D",
            " Número de Missões","counter.png", "M",
            " Cidade de Nascimento","building-hedge.png","C",
            " Tempo no Espaço","alarm-clock.png","ç",
            null,null,null,
            " Inverter Ordem","arrow-return-090.png","I"
    };

    private static final String[] sAjuda = {
            "Ajuda","help16new.png","A", null, null, null,
            "Sobre ...","about16new.png","S"};

    private String 	strSexo = "ALL",
            strMissao = "ALL",
            strPais = "ALL",
            strDataNasc = "ALL",
            strGrupo = "ALL";

    private String ConProperties;
    private String Ordem = sOrdenar[0];

    private static ArrayList<Astronauta> getAstronautas() {
        return astronautas;
    }

    private static void setAstronautas(ArrayList<Astronauta> astronautas) {
        AstronautaGUI.astronautas = astronautas;
    }

    public Connection getCon() {
        return con;
    }

    private void setCon(Connection con) {
        this.con = con;
    }

    private static ArrayList<Pais> getPaises() {
        return paises;
    }

    private static void setPaises(ArrayList<Pais> paises) {
        AstronautaGUI.paises = paises;
    }

    private ListaDeAstronautas getListaDeAstronautas() {
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

    private String getStrPais() {
        return strPais;
    }

    private void setStrPais(String strPais) {
        this.strPais = strPais;
    }

    private String getStrSexo() {
        return strSexo;
    }

    private void setStrSexo(String strSexo) {
        this.strSexo = strSexo;
    }

    private String getStrGrupo() {
        return strGrupo;
    }

    private void setStrGrupo(String strGrupo) {
        this.strGrupo = strGrupo;
    }

    public String getOrdem() {
        return Ordem;
    }

    private void setOrdem(String ordem) {
        Ordem = ordem;
    }

    /*
     *  Construtor
     */
    private AstronautaGUI() throws SQLException, IOException {
        super("Viajantes Espaciais - The Astronaut & Cosmonaut Database"); // ajusta titulo
        setIconImage(new ImageIcon("./imagens/vetor/astronaut-icon.png").getImage());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // acao fechar
        // setLocationRelativeTo(null);

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

        JMenu menuFiltrar = new JMenu("Filtrar");
        JMenuItem miMissao = new JMenuItem("Missão");
        miMissao.setIcon(new ImageIcon("./imagens/vetor/Space-Shuttle-icon.png"));
        miMissao.addActionListener(mh);
        JMenuItem miDataNasc = new JMenuItem("Data de Nascimento");
        miDataNasc.setIcon(new ImageIcon("./imagens/vetor/calendar-day.png"));
        JMenuItem miNome = new JMenuItem("Parte do Nome");
        miNome.setIcon(new ImageIcon("./imagens/vetor/document-attribute.png"));
        miNome.addActionListener(mh);
        JMenuItem miOrdena = new JMenuItem("Ordena seleção por...");
        miOrdena.setIcon(new ImageIcon("./imagens/vetor/sort-alphabet.png"));
        JMenuItem miAtualiza = new JMenuItem("Atualiza");
        miAtualiza.addActionListener(mh);
        miAtualiza.setIcon(new ImageIcon("./imagens/vetor/arrow-circle.png"));

        JMenu menuSexo = new JMenu("Sexo");
        menuSexo.setIcon(new ImageIcon("./imagens/vetor/gender.png"));
        JRadioButtonMenuItem miAmbos = new JRadioButtonMenuItem("Ambos", true);
        miAmbos.setIcon(new ImageIcon("./imagens/vetor/users.png"));
        JRadioButtonMenuItem miMale = new JRadioButtonMenuItem("Homens", false);
        miMale.setIcon(new ImageIcon("./imagens/vetor/user.png"));
        JRadioButtonMenuItem miFemale = new JRadioButtonMenuItem("Mulheres", false);
        miFemale.setIcon(new ImageIcon("./imagens/vetor/user-female.png"));

        miAmbos.addItemListener(mrh);
        miMale.addItemListener(mrh);
        miFemale.addItemListener(mrh);
        ButtonGroup bg = new ButtonGroup();
        bg.add(miAmbos);bg.add(miMale);bg.add(miFemale);

        menuSexo.add(miAmbos);menuSexo.add(miMale);menuSexo.add(miFemale);

        MenuBuilder.imagePrefix = "./imagens/flags/";
        JMenu menuPais = MenuBuilder.newRadioButtonMenu("Pais", 'P', sPais, mcbh);
        menuPais.setIcon(new ImageIcon(MenuBuilder.imagePrefix + "map.png"));

        MenuBuilder.imagePrefix = "./imagens/vetor/";
        JMenu menuGrupo = MenuBuilder.newRadioButtonMenu("Grupo", 'G', sGrupo, mth);
        menuGrupo.setIcon(new ImageIcon(MenuBuilder.imagePrefix + "block.png"));

        JMenu menuOrdenar = MenuBuilder.newMenu("Ordenar seleção por...", 'O', sOrdenar, mh);
        menuOrdenar.setIcon(new ImageIcon(MenuBuilder.imagePrefix + "sort-alphabet.png"));

        menuFiltrar.add(menuPais);
        menuFiltrar.add(menuSexo);
        menuFiltrar.add(menuGrupo);
        menuFiltrar.add(miMissao);
        menuFiltrar.add(miDataNasc);
        menuFiltrar.add(miNome);
        menuFiltrar.addSeparator();
        menuFiltrar.add(menuOrdenar);
        menuFiltrar.addSeparator();
        menuFiltrar.add(miAtualiza);
        menuFiltrar.setMnemonic('F');
        mb.add(menuFiltrar);

        mb.add(MenuBuilder.newMenu("Ajuda", 'u', sAjuda, mh));
        setJMenuBar(mb); //JMenu menu = mb.getMenu(1);

    }

    /**
     * Cria painéis de divisão
     * @throws SQLException
     */
    private void criaPainel() throws SQLException {
        // painel de divisao
        JSplitPane split1 = new JSplitPane(JSplitPane.VERTICAL_SPLIT,
                new JLabel(new ImageIcon("imagens/vetor/logoAstroDB.png")), // imagem
                new JScrollPane(listaDeAstronautas)); // diretorio

        JSplitPane split2 = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,// painel de divisao interno
                lbl_foto = new JLabel(), // janela com a Foto do astronauta
                new JScrollPane(taInfo = new JTextArea())); // area de texto


        JSplitPane split3 = new JSplitPane(JSplitPane.VERTICAL_SPLIT,
                split2,
                new JScrollPane(taInfoBio = new JTextArea())); // area de texto

        JSplitPane split4 = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,
                split1,
                split3);

        JSplitPane split5 = new JSplitPane(JSplitPane.VERTICAL_SPLIT,
                split4,
                new JScrollPane(taInfoConnection = new JTextArea())); // area de info sobre conexão

        getContentPane().add(split5, "Center"); // adiciona a janela

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
        taInfo.setAutoscrolls(true);
        taInfoBio.setAutoscrolls(true);
        taInfoBio.setEditable(false);
        taInfo.setSelectionStart(0);
        taInfoBio.setSelectionStart(0);
        taInfo.setLineWrap(true);
        taInfo.setWrapStyleWord(true);
        taInfo.setFont(new Font("Segoe UI", Font.BOLD, 14));
        taInfoBio.setLineWrap(true);
        taInfoBio.setWrapStyleWord(true);
        taInfoBio.setFont(new Font("Segoe UI", Font.PLAIN, 10));

        setSize(1200, 720); // dimensiona janela

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
    private void consultaSQL() throws HeadlessException, SQLException {
        try (Connection con = ConnectionFactory.getConnection()){
            setCon(con);
            ConProperties = this.con.getMetaData().getURL();
            importaBD(con);
        }	catch (SQLException e){
            throw new RuntimeException(e);

        }
    }


    /**
     *
     * @method importaBD
     * @param connection connection
     *
     * Cria os ArrayLists:
     *
     * 1) astronautas 	- coleção de todos os astronautas recuperada do banco de dados MySql
     * 2) paises 		- coleção de todos os paises recuperada do banco de dados MySql
     *
     */
    private void importaBD(Connection connection)
            throws SQLException {

        AstronautaDAO dao 	= new AstronautaDAO(connection);

        setAstronautas	(dao.pegaAstronautas());
        setPaises		(dao.pegaPaises());
    }


    /**
     *
     * Cria listas de astronautas e países
     */
    private void criaListas() {
        // CRIA LISTA DE ASTRONAUTAS E CARREGA NO JLIST

        listaDeAstronautas = new ListaDeAstronautas(getAstronautas());

        // System.out.println("Registros: " + getListaDeAstronautas().getModelAstro().getSize());

        // CRIA LISTA DE PAISES E CARREGA NO JLIST


        listaDePaises = new ListaDePaises(getPaises());

    }

    /**
     * @method mostraStatusListaAstro
     * Mostra o estado atual da lista de astronautas
     */
    private void mostraStatusListaAstro() {
        System.out.println("LISTA ASTRONAUTAS");
        System.out.println("Pais = " + getStrPais());
        System.out.println("Sexo = " + getStrSexo());
        System.out.println(listaDeAstronautas);
    }

    // classe implementa listener
    @Override
    public void valueChanged(ListSelectionEvent e) {

        // SimpleDateFormat sdf = new SimpleDateFormat("dd MMMMM yyyy");

        /* formatador de data */
        DateTimeFormatter dateTimeFormatter3 = DateTimeFormatter.ofPattern("dd/MMM/YYYY");

        Astronauta selecionado;

        int i = getListaDeAstronautas().getSelectedIndex();
        if (i == -1) {
            selecionado = AstronautaDAO.NENHUM;
        } else {
            selecionado = getListaDeAstronautas().getSelectedValue();
        }

        /*****************************************************************************************
            ÁREA DE TEXTO COM INFO DO ASTRONAUTA
            Exibe informacoes do astronauta: ID, nome, pa�s de origem, data de nascimento, sexo.
        ******************************************************************************************/

        StringBuilder sb = new StringBuilder("REGISTRO: \t" + selecionado.getIdAstronauta() + "\n");
        String nome = selecionado.getPrimeiro_Nome() + " "
                + selecionado.getNome_do_Meio() + " "
                + selecionado.getSobrenome() + "\n";
        String pais = listaDePaises.mostraNome(selecionado.getPais_Nasc(), paises) + "\n";
        String estado = selecionado.getEstado_Nasc() + "\n";
        String cidade = selecionado.getCidade_Nasc() + "\n";
        LocalDate dataNasc = selecionado.getDtNasc();
        String textDataNasc = dataNasc.format(dateTimeFormatter3);
        LocalDate dataFalec = selecionado.getDtFalec();
        String textDataFalec = dataFalec.format(dateTimeFormatter3);

        sb.append("NOME: \t").append(nome);
        sb.append("PAIS: \t").append(pais);
        sb.append("ESTADO: \t").append(estado);
        sb.append("CIDADE: \t").append(cidade);
        sb.append("NASCEU: \t").append(textDataNasc).append("\n");

        if (dataFalec.isBefore(LocalDate.now())) {
            // caso a data de falecimento recuperada esteja no futuro
            // indica que o astronauta não faleceu --> não imprime
            // data de falecimento.
            sb.append("FALECEU: \t").append(textDataFalec).append("\n");
        }

        sb.append("SEXO: \t").append(selecionado.getSexo().charAt(0) == 'M' ? "masculino" : "feminino").append("\n\n");

        StringBuilder sb2 = new StringBuilder("BIOGRAFIA: " + "\n\n" + selecionado.getInfo() + "\n\n");
        sb2.append("MISSOES: " + "\n\n");
        for (String s : selecionado.getMissao()){
            sb2.append(s).append("\n");
        }

        String sb3 = "SERVIDOR: \t" + ConProperties + "\n" + "REGISTROS: \t" + getListaDeAstronautas().getModel().getSize() + " registros encontrados." + "\n" +
                "FILTROS: \t" + "[pais = " + listaDePaises.mostraNome(getStrPais(), paises) + "] [sexo = " + getStrSexo() + "] [grupo = " + getStrGrupo() + "]" + "\n" +
                "ORDEM: \t" + Ordem.substring(1);

        taInfo.setText(sb.toString());
        taInfoBio.setText(sb2.toString());
        taInfoConnection.setText(sb3);

        BufferedImage img = null;
        try {
            img = ImageIO.read(new File("./imagens/people/" + selecionado.getFoto()));

        } catch (IOException ignored){}

        BufferedImage imagem = formataImagem(img);

        lbl_foto.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        lbl_foto.setSize(larguraJanela, alturaJanela);
        lbl_foto.setIcon(new ImageIcon(imagem));
    }

    // recebe uma imagem e retorna essa imagem no padrão LARGURA = larguraJanela, ALTURA = alturaJanela
    private BufferedImage formataImagem(BufferedImage bi) throws HeadlessException {

        BufferedImage aux = new BufferedImage(AstronautaGUI.larguraJanela, AstronautaGUI.alturaJanela, bi.getType());
        Graphics2D gg = aux.createGraphics();
        AffineTransform at = AffineTransform.getScaleInstance((double) AstronautaGUI.larguraJanela /bi.getWidth(), (double) AstronautaGUI.alturaJanela /bi.getHeight());
        gg.drawRenderedImage(bi, at);
        return aux;
    }

    /*****************
    @class MenuHandler
     *****************/
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

            // Banco de Dados - Exportar
            if (acao.equals(sBanco[0*3])){
                //TODO: implementar
                mostraMsgOperNaoImplementada();
            }

            // Banco de Dados - Importar
            if (acao.equals(sBanco[1*3])){
                //TODO: implementar
                mostraMsgOperNaoImplementada();
            }

            // Banco de Dados - Nuvem
            if (acao.equals(sBanco[2*3])){
                //TODO: implementar
                mostraMsgOperNaoImplementada();
            }

            // Banco de Dados - Rede
            if (acao.equals(sBanco[3*3])){
                //TODO: implementar
                mostraMsgOperNaoImplementada();
            }

            // Banco de Dados - Estatísticas
            if (acao.equals(sBanco[5*3])){
                //TODO: implementar
                mostraMsgOperNaoImplementada();
            }

            // Banco de Dados - Editar registro
            if (acao.equals(sBanco[7*3])){
                //TODO: implementar
                mostraMsgOperNaoImplementada();
            }

            // Banco de Dados - Inserir registro
            if (acao.equals(sBanco[8*3])){
                Astronauta astronauta = null;
                try {
                    astronauta = new AstronautaCreate().getNovoAstronauta();
                } catch (HeadlessException | SQLException e2) {
                    // TODO Auto-generated catch block
                    e2.printStackTrace();
                }
                try (Connection con = ConnectionFactory.getConnection()){
                    AstronautaDAO dao = new AstronautaDAO(con);
                    dao.salva(astronauta);
                }	catch (SQLException evt){
                    JOptionPane.showMessageDialog(null,
                            "Não foi possível estabelecer conexão remota...",
                            "Erro", JOptionPane.ERROR_MESSAGE, new ImageIcon("./imagens/vetor/scary.png") );
                }

                //mostraMsgOperNaoImplementada();
            }

            // Banco de Dados - Remover registro
            if (acao.equals(sBanco[9*3])){
                //TODO: implementar
                mostraMsgOperNaoImplementada();
            }

            /*******************************************************************
             * FILTROS
             ******************************************************************/
            // Filtro = missão
            if (acao.equals("Missão")) {
                String mission = ((String) JOptionPane.showInputDialog(
                        AstronautaGUI.this,
                        "Digite o nome da missão:",
                        "Filtrar Resultados",
                        JFrame.EXIT_ON_CLOSE,
                        new ImageIcon("./imagens/vetor/space-rocket48.png"),
                        null,
                        null)).toLowerCase();

                DefaultListModel<Astronauta> modelAstroConsulta = new DefaultListModel<>();
                for (Astronauta astronauta : astronautas) {
                    List<String> missoes = astronauta.getMissao();
                    for (String missao : missoes) {

                        if (missao.toLowerCase().contains(mission)) {
                            modelAstroConsulta.addElement(astronauta);
                            break;
                        }

                    }
                }

                listaDeAstronautas.setModel(modelAstroConsulta);
                listaDeAstronautas.setSelectedIndex(0);
                listaDeAstronautas.ensureIndexIsVisible(0);


            }

            // Filtro = parte do nome
            if (acao.equals("Parte do Nome")) {
                try {
                    String parteDoNome = ((String) JOptionPane
                            .showInputDialog(
                                    AstronautaGUI.this,
                                    "Digite parte do nome:",
                                    "Filtrar Resultados",
                                    JFrame.EXIT_ON_CLOSE,
                                    new ImageIcon(
                                            "./imagens/vetor/astronaut-icon.png"),
                                    null, null)).toLowerCase();
                    DefaultListModel<Astronauta> modelAstroConsulta = new DefaultListModel<>();
                    astronautas.stream().filter(astronauta -> astronauta.getPrimeiro_Nome().toLowerCase()
                            .contains(parteDoNome)
                            || (astronauta.getNome_do_Meio()
                            .toLowerCase()
                            .contains(parteDoNome) || (astronauta
                            .getSobrenome().toLowerCase()
                            .contains(parteDoNome)))).forEach(modelAstroConsulta::addElement);
                    listaDeAstronautas.setModel(modelAstroConsulta);
                    listaDeAstronautas.setSelectedIndex(0);
                    listaDeAstronautas.ensureIndexIsVisible(0);
                } catch (Exception e2) {
                    // TODO: handle exception
                }
            }

            if (acao.equals("Sobre ...")){

                mostraMsgSobre();
            }

            if (acao.equals("Atualiza")){
                System.out.println("atualizando ----------------------------------------->");
                listaDeAstronautas.filtra(getAstronautas(), getStrSexo(), getStrPais(), getStrGrupo());
                System.out.println("Operação realizada com sucesso-------> " + getListaDeAstronautas().getModel().getSize() + " registros encontrados.");
                mostraStatusListaAstro();
            }

            // Ordenar por IdAstronauta = ordem de viagem ao espaço
            if (acao.equals(sOrdenar[0*3])) {
                //IdAstronautaComparator comparator = new IdAstronautaComparator();
                setOrdem(acao);
                Collections.sort(astronautas, OrdenarAstronautas.PorIdAstronauta.asc());
                listaDeAstronautas.filtra(getAstronautas(), getStrSexo(), getStrPais(), getStrGrupo());
            }

            // Ordenar por sobrenome
            if (acao.equals(sOrdenar[1*3])) {
                //SobrenomeComparator comparator = new SobrenomeComparator();
                setOrdem(acao);
                Collections.sort(astronautas, OrdenarAstronautas.PorSobrenome.asc());
                listaDeAstronautas.filtra(getAstronautas(), getStrSexo(), getStrPais(), getStrGrupo());
            }

            // Ordenar por data de nascimento
            if (acao.equals(sOrdenar[2*3])) {
                //DataNascComparator comparator = new DataNascComparator();
                setOrdem(acao);
                Collections.sort(astronautas, OrdenarAstronautas.PorDtNasc.asc());
                listaDeAstronautas.filtra(getAstronautas(), getStrSexo(), getStrPais(), getStrGrupo());
            }

            // Ordenar por número de missões
            if (acao.equals(sOrdenar[3*3])) {
                //MissoesComparator comparator = new MissoesComparator();
                setOrdem(acao);
                Collections.sort(astronautas, OrdenarAstronautas.PorNumDeMissoes.desc());
                listaDeAstronautas.filtra(getAstronautas(), getStrSexo(), getStrPais(), getStrGrupo());
            }

            // Ordenar por cidade de nascimento
            if (acao.equals(sOrdenar[4*3])) {
                //CidadeComparator comparator = new CidadeComparator();
                setOrdem(acao);
                Collections.sort(astronautas, OrdenarAstronautas.PorCidade.asc());
                listaDeAstronautas.filtra(getAstronautas(), getStrSexo(), getStrPais(), getStrGrupo());
            }

            // Ordenar por tempo no espaço
            if (acao.equals(sOrdenar[5*3])) {
                //TODO: implementar
                setOrdem(acao);
                mostraMsgOperNaoImplementada();
            }
        }

        /**
         * @throws HeadlessException
         */
        public void mostraMsgSobre() throws HeadlessException {
            JOptionPane.showMessageDialog(
                    AstronautaGUI.this,
                    "(C) Erasmo Leite Jr 2015 - eleitejr@gmail.com\n\nThanks to:\n- Spacefacts - http://www.spacefacts.de\n- ASTROnote - http://astronaut.ru/",
                    "Viajantes Espaciais",
                    JOptionPane.INFORMATION_MESSAGE,
                    new ImageIcon("./imagens/vetor/Astronaut-50.png"));
        }

        /**
         * @throws HeadlessException
         */
        public void mostraMsgOperNaoImplementada() throws HeadlessException {
            JOptionPane.showMessageDialog(
                    AstronautaGUI.this,
                    "Huh... Não entendi... Vou ficar te devendo essa...",
                    "Alerta",
                    JOptionPane.INFORMATION_MESSAGE,
                    new ImageIcon("./imagens/vetor/scary.png"));
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
                listaDeAstronautas.filtra(getAstronautas(), getStrSexo(), getStrPais(), getStrGrupo());
                mostraFiltros();
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
                    case "Homens" 			:	{setStrSexo("M");	 	break;}
                    case "Mulheres" 		:	{setStrSexo("F");	 	break;}
                }

                System.out.println("atualizando ----------------------------------------->");
                listaDeAstronautas.filtra(getAstronautas(), getStrSexo(), getStrPais(), getStrGrupo());
                mostraFiltros();
                //mostraStatusListaAstro();

            }
        }
    }


    private class MenuGrupoHandler implements ItemListener {

        @Override
        public void itemStateChanged(ItemEvent eventoTipo) {

            if (eventoTipo.getStateChange() == ItemEvent.SELECTED) {

                String grupo = ((JMenuItem)eventoTipo.getSource()).getText().substring(1);

                setStrGrupo(grupo.equals("Todos") ? "ALL": grupo);

					/*
					 * TODO: criar método para consulta
					 */
                System.out.println("atualizando ----------------------------------------->");
                listaDeAstronautas.filtra(getAstronautas(), getStrSexo(), getStrPais(), getStrGrupo());
                mostraFiltros();
                //mostraStatusListaAstro();

            }
        }
    }

    /***************************************************
     *           INICIALIZAÇÃO DOS COMPONENTES
     ***************************************************/
    private void inicializa() throws HeadlessException, SQLException {
			    /*
			     * INICIALIZA DADOS DAS LISTAS E CRIA O PAINEL PRINCIPAL
			     */
        try {
            consultaSQL();  // realiza a consulta no banco de dados MySQL
            criaListas();   // cria JLists de astronautas e paises
            criaPainel();   // implementa a interface grafica
            criaMenu();     // cria os menus de Arquivo, Banco de Dados, Filtro.

        } catch (Exception e) {
            JOptionPane.showMessageDialog(
                    AstronautaGUI.this,
                    "Não foi possível inicializar o sistema!",
                    "Alerta",
                    JOptionPane.ERROR_MESSAGE,
                    new ImageIcon("./imagens/vetor/scary.png"));
            e.printStackTrace();
        }

    }

    /****************************************************************
     * Cria uma 'STATUSBAR' com dados da conexao e filtros acionados
     ****************************************************************/
    private void mostraFiltros() {
        System.out.println("Filtro [PAIS = " + getStrPais() + "][SEXO = " + getStrSexo() + "][GRUPO = " + getStrGrupo() + "] -------> "
                + getListaDeAstronautas().getModel().getSize() + " registros encontrados.");
    }

    /****************************************************************************************
     *                                    Método MAIN()
     ****************************************************************************************/
    public static void main(String s[]) {
        SwingUtilities.invokeLater(() -> {
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
        });
    }
}
