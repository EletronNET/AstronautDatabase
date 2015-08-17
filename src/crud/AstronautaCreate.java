package crud;

import java.awt.event.ActionEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import modelo.Astronauta;
import swingHelper.SwingHelper;

/**
 *
 * @author Erasmo
 */
@SuppressWarnings("serial")
public class AstronautaCreate extends javax.swing.JFrame {
	
	public Astronauta getNovoAstronauta() {
		return novoAstronauta;
	}

	public void setNovoAstronauta(Astronauta novoAstronauta) {
		this.novoAstronauta = novoAstronauta;
	}

	Astronauta novoAstronauta;
	String meses[] = new String[] {"Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho", "Julho", "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro"};

    /**
     * Creates new form AstronautaCreate
     */
    public AstronautaCreate() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings({ "unchecked", "rawtypes" })
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        bgSexo = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        lPrimeiro_Nome = new javax.swing.JLabel();
        lNome_do_Meio = new javax.swing.JLabel();
        lSobrenome = new javax.swing.JLabel();
        lData_Nasc = new javax.swing.JLabel();
        lData_Falec = new javax.swing.JLabel();
        lCidade = new javax.swing.JLabel();
        lEstado = new javax.swing.JLabel();
        lPais = new javax.swing.JLabel();
        lBio = new javax.swing.JLabel();
        lBio_eng = new javax.swing.JLabel();
        lMissao1 = new javax.swing.JLabel();
        lMissao2 = new javax.swing.JLabel();
        lMissao3 = new javax.swing.JLabel();
        lMissao4 = new javax.swing.JLabel();
        lMissao5 = new javax.swing.JLabel();
        lMissao6 = new javax.swing.JLabel();
        lMissao7 = new javax.swing.JLabel();
        lMissao8 = new javax.swing.JLabel();
        lFoto = new javax.swing.JLabel();
        tfPrimeiro_Nome = new javax.swing.JTextField();
        tfNome_do_Meio = new javax.swing.JTextField();
        tfSobrenome = new javax.swing.JTextField();
        tfCidade = new javax.swing.JTextField();
        tfEstado = new javax.swing.JTextField();
        tfFoto = new javax.swing.JTextField();
        taBio = new javax.swing.JTextArea();
        taBio_eng = new javax.swing.JTextArea();
        tfMissao1 = new javax.swing.JTextField();
        tfMissao2 = new javax.swing.JTextField();
        tfMissao3 = new javax.swing.JTextField();
        tfMissao4 = new javax.swing.JTextField();
        tfMissao5 = new javax.swing.JTextField();
        tfMissao6 = new javax.swing.JTextField();
        tfMissao7 = new javax.swing.JTextField();
        tfMissao8 = new javax.swing.JTextField();
        lSexo = new javax.swing.JLabel();
        spAno_Nasc = new javax.swing.JSpinner();
        spAno_Falec = new javax.swing.JSpinner();
        cbPais = new javax.swing.JComboBox();
        rbHomem = new javax.swing.JRadioButton();
        rbMulher = new javax.swing.JRadioButton();
        bgSexo.add(rbHomem);bgSexo.add(rbMulher);
        lHomem = new javax.swing.JLabel();
        lMulher = new javax.swing.JLabel();
        bSair = new javax.swing.JButton();
        lTitulo = new javax.swing.JLabel();
        bLimpar = new javax.swing.JButton();
        bSalvar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lPrimeiro_Nome.setText("Primeiro Nome");
        lNome_do_Meio.setText("Nome do Meio");
        lSobrenome.setText("Sobrenome");
        lData_Nasc.setText("Data de Nascimento");
        lData_Falec.setText("Data de Falecimento");
        lCidade.setText("Cidade");
        lEstado.setText("Estado");
        lPais.setText("País");
        lBio.setText("Biografia");
        lBio_eng.setText("Bio Inglês");
        lMissao1.setText("Missão 1");
        lMissao2.setText("Missão 2");
        lMissao3.setText("Missão 3");
        lMissao4.setText("Missão 4");
        lMissao5.setText("Missão 5");
        lMissao6.setText("Missão 6");
        lMissao7.setText("Missão 7");
        lMissao8.setText("Missão 8");
        lFoto.setText("Foto");
        lSexo.setText("Sexo");

        limpaCampos();
   
        spAno_Nasc = SwingHelper.addDateSpinner("Data de Nascimento");
        spAno_Falec = SwingHelper.addDateSpinner("Data de Falecimento");
            
        cbPais.setModel(new javax.swing.DefaultComboBoxModel(new String[] {
				"Afeganistão",
				"África do Sul",
				"Alemanha",
				"Arábia Saudita",
				"Áustria",
				"Bélgica",
				"Brasil",
				"Bulgária",
				"Canadá",
				"Casaquistão",
				"China",
				"Coréia do Sul",
				"Cuba",
				"Eslováquia",
				"Estados Unidos",
				"França",
				"Holanda",
				"Hungria",
				"Índia",
				"Israel",
				"Itália",
				"Japão",	
				"Malásia",
				"México",
				"Mongólia",
				"Polônia",
				"Rep. Checa",
				"Reino Unido",
				"Romênia",
				"Russia",		   								
				"Síria",	   									   								
				"Suécia",
				"Suiça",		   								
				"Ucrânia",
				"Vietnã"		 }));
        cbPais.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbPaisActionPerformed(evt);
            }
        });

        rbHomem.setText("");

        rbMulher.setText("");

        lHomem.setText("Masculino");

        lMulher.setText("Feminino");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(lBio)
                .addGap(392, 392, 392))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(lData_Nasc)
                                .addComponent(lData_Falec))
                            .addComponent(lCidade)
                            .addComponent(lEstado)
                            .addComponent(lPais)
                            .addComponent(lFoto)
                            .addComponent(lSexo, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(lPrimeiro_Nome, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfPrimeiro_Nome, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfCidade, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbPais, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                            //.addGroup(jPanel1Layout.createSequentialGroup()
                              //  .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                   // .addComponent(spDia_Falec, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                                   // .addComponent(spDia_Nasc))
                                .addGap(5, 5, 5)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                   // .addComponent(spMes_Falec, javax.swing.GroupLayout.DEFAULT_SIZE, 72, Short.MAX_VALUE)
                                   // .addComponent(spMes_Nasc))
                                //.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(spAno_Nasc, javax.swing.GroupLayout.DEFAULT_SIZE, 62, Short.MAX_VALUE)
                                    .addComponent(spAno_Falec)))
                            .addComponent(tfFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(rbHomem, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lHomem)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lNome_do_Meio)
                                .addGap(18, 18, 18)
                                .addComponent(tfNome_do_Meio, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(43, 43, 43)
                                .addComponent(lSobrenome)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(tfSobrenome, javax.swing.GroupLayout.DEFAULT_SIZE, 317, Short.MAX_VALUE))
                            .addComponent(taBio, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(taBio_eng, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGap(332, 332, 332)
                                .addComponent(lBio_eng))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(lMissao5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tfMissao5, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lMissao6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(tfMissao6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lMissao7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(tfMissao7, javax.swing.GroupLayout.DEFAULT_SIZE, 81, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lMissao8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(tfMissao8, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(lMissao1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tfMissao1, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lMissao2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(tfMissao2, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lMissao3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(tfMissao3, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lMissao4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(tfMissao4, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(21, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(rbMulher, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lMulher)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {tfMissao1, tfMissao2, tfMissao3, tfMissao4, tfMissao5, tfMissao6, tfMissao7, tfMissao8});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(tfNome_do_Meio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lSobrenome)
                        .addComponent(tfSobrenome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lPrimeiro_Nome)
                        .addComponent(tfPrimeiro_Nome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lNome_do_Meio)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                .addComponent(lBio)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(taBio)
                        .addGap(18, 18, 18)
                        .addComponent(lBio_eng)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(taBio_eng, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lMissao1)
                            .addComponent(tfMissao1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lMissao2)
                            .addComponent(tfMissao2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lMissao3)
                            .addComponent(tfMissao3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lMissao4)
                            .addComponent(tfMissao4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lMissao5)
                            .addComponent(tfMissao5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lMissao6)
                            .addComponent(tfMissao6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lMissao7)
                            .addComponent(tfMissao7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lMissao8)
                            .addComponent(tfMissao8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lData_Nasc)
                            //.addComponent(spDia_Nasc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            //.addComponent(spMes_Nasc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(spAno_Nasc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lData_Falec)
                            //.addComponent(spDia_Falec, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            //.addComponent(spMes_Falec, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(spAno_Falec, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lCidade)
                            .addComponent(tfCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lEstado)
                            .addComponent(tfEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lPais)
                            .addComponent(cbPais, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lFoto)
                            .addComponent(tfFoto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lSexo)
                            .addComponent(rbHomem)
                            .addComponent(lHomem))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbMulher)
                    .addComponent(lMulher))
                .addGap(28, 28, 28))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {taBio, taBio_eng});

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {cbPais, tfCidade, tfEstado, tfFoto});

        bSair.setText("Sair");
        bSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bSairActionPerformed(evt);
            }
        });

        lTitulo.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lTitulo.setText("Cadastro de Astronauta");

        bLimpar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        bLimpar.setText("Limpar");
        bLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bLimparActionPerformed(evt);
            }

			private void bLimparActionPerformed(ActionEvent evt) {
				limpaCampos();
				
			}
        });

        bSalvar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        bSalvar.setText("Salvar");
        bSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
					bSalvarActionPerformed(evt);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }

			@SuppressWarnings("null")
			private void bSalvarActionPerformed(ActionEvent evt) throws ParseException {
				String primeiro_nome = tfPrimeiro_Nome.getText();
	    		String nome_do_meio = tfNome_do_Meio.getText();
	    		String sobrenome = tfSobrenome.getText();
	    		String pais = cbPais.getSelectedItem().toString();
	    		String estado = tfEstado.getText();
	    		String cidade = tfCidade.getText();
	    		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
	    	    java.util.Date dataN = format.parse(spAno_Nasc.getValue().toString());
	    	    java.sql.Date data_nasc =  new java.sql.Date(dataN.getTime()); 
	    	    java.util.Date dataF = format.parse(spAno_Falec.getValue().toString());
	    		java.sql.Date data_falec = new java.sql.Date(dataF.getTime());
	    		String foto = tfFoto.getText();
	    		String sexo = (rbHomem.isSelected()? "M" : "F");
	    		String bio = taBio.getText();
	    		String bio_eng = taBio_eng.getText();
	    		String m1 = tfMissao1.getText();
	    		String m2 = tfMissao2.getText();
	    		String m3 = tfMissao3.getText();
	    		String m4 = tfMissao4.getText();
	    		String m5 = tfMissao5.getText();
	    		String m6 = tfMissao6.getText();
	    		String m7 = tfMissao7.getText();
	    		String m8 = tfMissao8.getText();
	    		
	    		List<String> missao = null;
	    		missao.add(m1);
	    		missao.add(m2);
	    		missao.add(m3);
	    		missao.add(m4);
	    		missao.add(m5);
	    		missao.add(m6);
	    		missao.add(m7);
	    		missao.add(m8);
	    		
	    		int n_missoes = missao.size();
	    		
	    		Astronauta novoAstronauta = new Astronauta(
	    				primeiro_nome,
	    				nome_do_meio,
	    				sobrenome, 
	    				pais,
	    				estado,
	    				cidade,
	    				foto,
	    				sexo,
	    				bio,
	    				bio_eng,
	    				data_nasc,
	    				data_falec,
	    				missao,
	    				n_missoes,
	    				null
	    			);
	    		
	    		setNovoAstronauta(novoAstronauta);	
	    	}
				
			});

        

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(lTitulo)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(bLimpar)
                .addGap(155, 155, 155)
                .addComponent(bSalvar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(bSair)
                .addGap(57, 57, 57))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(lTitulo)
                .addGap(4, 4, 4)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(2, 2, 2)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bLimpar)
                    .addComponent(bSalvar)
                    .addComponent(bSair))
                .addGap(32, 32, 32))
        );

        pack();
    }// </editor-fold>   
    
    
	private void limpaCampos() {
		
		tfPrimeiro_Nome.setText("");

        tfNome_do_Meio.setText("");

        tfSobrenome.setText("");

        tfCidade.setText("");

        tfEstado.setText("");

        tfFoto.setText("");

        taBio.setText("");
        taBio.setLineWrap(true);
        taBio.setWrapStyleWord(true);
        //taBio.setMaximumSize(getSize());
        taBio.setAutoscrolls(true);

        taBio_eng.setText("");
        taBio_eng.setLineWrap(true);
        taBio_eng.setWrapStyleWord(true);
        //taBio_eng.setMaximumSize(getSize());
        taBio_eng.setAutoscrolls(true);

        tfMissao1.setText("");

        tfMissao2.setText("");

        tfMissao3.setText("");

        tfMissao4.setText("");

        tfMissao5.setText("");

        tfMissao6.setText("");

        tfMissao7.setText("");

        tfMissao8.setText("");

	}

    private void bSairActionPerformed(java.awt.event.ActionEvent evt) {                                         
        System.exit(0);
    }                                        

    private void cbPaisActionPerformed(java.awt.event.ActionEvent evt) { 
    	String pais= cbPais.getSelectedItem().toString();
    }                                          

    private void tfPrimeiro_NomeActionPerformed(java.awt.event.ActionEvent evt) {                                                
        // TODO add your handling code here:
    }                                               

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AstronautaCreate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AstronautaCreate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AstronautaCreate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AstronautaCreate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        
    		

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AstronautaCreate().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.ButtonGroup bgSexo;
    private javax.swing.JButton bLimpar;
    private javax.swing.JButton bSalvar;
    private javax.swing.JButton bSair;
    @SuppressWarnings("rawtypes")
	private javax.swing.JComboBox cbPais;
    private javax.swing.JLabel lTitulo;
    private javax.swing.JLabel lBio;
    private javax.swing.JLabel lBio_eng;
    private javax.swing.JLabel lMissao1;
    private javax.swing.JLabel lMissao2;
    private javax.swing.JLabel lMissao3;
    private javax.swing.JLabel lMissao4;
    private javax.swing.JLabel lMissao5;
    private javax.swing.JLabel lMissao6;
    private javax.swing.JLabel lMissao7;
    private javax.swing.JLabel lMissao8;
    private javax.swing.JLabel lPrimeiro_Nome;
    private javax.swing.JLabel lFoto;
    private javax.swing.JLabel lHomem;
    private javax.swing.JLabel lSexo;
    private javax.swing.JLabel lMulher;
    private javax.swing.JLabel lNome_do_Meio;
    private javax.swing.JLabel lSobrenome;
    private javax.swing.JLabel lData_Nasc;
    private javax.swing.JLabel lData_Falec;
    private javax.swing.JLabel lCidade;
    private javax.swing.JLabel lEstado;
    private javax.swing.JLabel lPais;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButton rbHomem;
    private javax.swing.JRadioButton rbMulher;
    private javax.swing.JSpinner spAno_Nasc;
    private javax.swing.JSpinner spAno_Falec;
    private javax.swing.JTextArea taBio;
    private javax.swing.JTextArea taBio_eng;
    private javax.swing.JTextField tfMissao1;
    private javax.swing.JTextField tfMissao2;
    private javax.swing.JTextField tfMissao3;
    private javax.swing.JTextField tfMissao4;
    private javax.swing.JTextField tfMissao5;
    private javax.swing.JTextField tfMissao6;
    private javax.swing.JTextField tfMissao7;
    private javax.swing.JTextField tfMissao8;
    private javax.swing.JTextField tfCidade;
    private javax.swing.JTextField tfEstado;
    private javax.swing.JTextField tfFoto;
    private javax.swing.JTextField tfNome_do_Meio;
    private javax.swing.JTextField tfPrimeiro_Nome;
    private javax.swing.JTextField tfSobrenome;
    // End of variables declaration                   
}
