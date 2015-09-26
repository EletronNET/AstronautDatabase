package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;


public class ConnectionFactory {

	public static Connection getConnection() {

		try {
			// TENTA CONEXÃO COM BANCO DE DADOS REMOTO
			Connection RemoteConnection = DriverManager.getConnection("jdbc:mysql://xmysql.astronautdatabase.com:3306/astronautdatabase", "astronautdataba", "Juliana11@");
			return RemoteConnection;
			
		} catch (Exception e) {
			try {
				// TENTA CONEXÃO COM BANCO DE DADOS LOCAL
				Connection LocalConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/astronautdatabase", "root", "");
				return LocalConnection;
				
			} catch (SQLException e1) {
				//  MOSTRA MENSAGEM DE ERRO EM CASO DE FALHA DE CONEXÃO COM BANCOS DE DADOS
				JOptionPane.showMessageDialog(null, 
    					"Não foi possível estabelecer conexão...", 
    					"Erro", JOptionPane.ERROR_MESSAGE, new ImageIcon("./imagens/vetor/scary.png") );
						throw new RuntimeException(e);
			}
		}
	}
	
}
