import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class Cadastro_Professor extends JFrame {

	private JPanel contentPane;
	private JTextField TxtMatricula;
	private JTextField TxtNome;
	private JTextField TxtNascimento;
	private JTextField TxtEmail;
	private JTextField TxtTelefone;
	private JTextField TxtValor;
	private JTable table_Professor;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Cadastro_Professor frame = new Cadastro_Professor();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Cadastro_Professor() {
		setTitle("Cadastro Professor");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 644, 524);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel Nome = new JLabel("Nome");
		Nome.setBounds(22, 62, 46, 14);
		contentPane.add(Nome);
		
		JLabel Matricula = new JLabel("Matricula");
		Matricula.setBounds(22, 23, 46, 14);
		contentPane.add(Matricula);
		
		JLabel Nascimento = new JLabel("Nascimento");
		Nascimento.setBounds(22, 102, 61, 14);
		contentPane.add(Nascimento);
		
		JLabel Email = new JLabel("E-mail");
		Email.setBounds(310, 23, 46, 14);
		contentPane.add(Email);
		
		JLabel Telefone = new JLabel("Telefone");
		Telefone.setBounds(310, 62, 46, 14);
		contentPane.add(Telefone);
		
		JLabel Valor = new JLabel("Valor HR");
		Valor.setBounds(310, 102, 46, 14);
		contentPane.add(Valor);
		
		TxtMatricula = new JTextField();
		TxtMatricula.setBounds(87, 20, 213, 20);
		contentPane.add(TxtMatricula);
		TxtMatricula.setColumns(10);
		
		TxtNome = new JTextField();
		TxtNome.setBounds(87, 59, 213, 20);
		contentPane.add(TxtNome);
		TxtNome.setColumns(10);
		
		TxtNascimento = new JTextField();
		TxtNascimento.setBounds(87, 99, 213, 20);
		contentPane.add(TxtNascimento);
		TxtNascimento.setColumns(10);
		
		TxtEmail = new JTextField();
		TxtEmail.setBounds(366, 20, 252, 20);
		contentPane.add(TxtEmail);
		TxtEmail.setColumns(10);
		
		TxtTelefone = new JTextField();
		TxtTelefone.setBounds(366, 59, 252, 20);
		contentPane.add(TxtTelefone);
		TxtTelefone.setColumns(10);
		
		TxtValor = new JTextField();
		TxtValor.setBounds(366, 99, 252, 20);
		contentPane.add(TxtValor);
		TxtValor.setColumns(10);
		
		JButton BtnCadastrar = new JButton("Cadastrar");
		BtnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String server = "LAPTOP-6RTEV8HD\\SQLEXPRESS01";
			    int port = 52202 ;
			    String user = "sa";
			    String pass = "496758123q";
			    String database = "Escola";
			    String jdbcurl = "jdbc:sqlserver://"+server+":"+port+";user="+user+";password="+pass+";databasename="+database+"";
			    Connection con = null; 
			    
			   		

			    try {
			        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			    } catch (ClassNotFoundException e1) {
			        e1.printStackTrace();
			    }   
			        
			    try {
			            con = DriverManager.getConnection(jdbcurl);
			         // Criar Statement

			            Statement stmt = con.createStatement();
			            
			         // Nao aceitar dados vazios
			            
			            if (TxtMatricula.getText().equals(" ") || TxtNome.getText().equals(" ") || TxtNascimento.getText().equals(" ") || TxtEmail.getText().equals(" ") || TxtTelefone.getText().equals(" ") || TxtValor.getText().equals(" ")) {
			            JOptionPane.showMessageDialog(contentPane, "Favor preencher todos os campos.");
			            }
			            	
			            else {
			            //inserir dados
			            stmt.executeUpdate("insert into CADASTRO_PROFESSOR(MATRICULA_PROFESSOR, NOME_PROFESSOR, NASC_PROFESSOR, EMAIL_PROFESSOR, TEL_PROFESSOR,VALORHR_PROFESSOR) values('"+(TxtMatricula.getText())+"','"+(TxtNome.getText())+"','"+(TxtNascimento.getText())+"','"+(TxtEmail.getText())+"','"+(TxtTelefone.getText())+"','"+(TxtValor.getText())+"')");
			            JOptionPane.showMessageDialog(contentPane, "Cadastro Realizado.");
			            
			            TxtMatricula.setText(null);
			            TxtNome.setText(null);
			            TxtNascimento.setText(null);
			            TxtEmail.setText(null);
			            TxtTelefone.setText(null);
			            TxtValor.setText(null);
			    }
			    }
				
			    	
			    
			    catch (SQLException ex) {
			    	JOptionPane.showMessageDialog(contentPane, ex.getMessage());
			    	ex.printStackTrace();
			}
			}
		});
		BtnCadastrar.setBounds(22, 158, 103, 37);
		contentPane.add(BtnCadastrar);
		
		JButton BtnLimpar = new JButton("Limpar");
		BtnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				TxtMatricula.setText(null);
	            TxtNome.setText(null);
	            TxtNascimento.setText(null);
	            TxtEmail.setText(null);
	            TxtTelefone.setText(null);
	            TxtValor.setText(null);
			}
		});
		BtnLimpar.setBounds(135, 158, 103, 37);
		contentPane.add(BtnLimpar);
		
		JButton BtnEditar = new JButton("Editar");
		BtnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String server = "LAPTOP-6RTEV8HD\\SQLEXPRESS01";
			    int port = 52202 ;
			    String user = "sa";
			    String pass = "496758123q";
			    String database = "Escola";
			    String jdbcurl = "jdbc:sqlserver://"+server+":"+port+";user="+user+";password="+pass+";databasename="+database+"";
			    Connection con = null; 
			    
			   		

			    try {
			        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			    } catch (ClassNotFoundException e1) {
			        e1.printStackTrace();
			    }   
			        
			    try {
			            con = DriverManager.getConnection(jdbcurl);
			            Statement stmt = con.createStatement();
			            
			            
				  // Nao aceitar dados vazios
				            
				       if (TxtMatricula.getText().equals(" ") || TxtNome.getText().equals(" ") || TxtNascimento.getText().equals(" ") || TxtEmail.getText().equals(" ") || TxtTelefone.getText().equals(" ") || TxtValor.getText().equals(" ")) {
				          JOptionPane.showMessageDialog(contentPane, "Favor preencher todos os campos.");
				            }
				            	
				       else {
				  //alterar dados
				           stmt.executeUpdate("update CADASTRO_PROFESSOR set NOME_PROFESSOR =  '"+(TxtNome.getText())+"' where MATRICULA_PROFESSOR = '"+(TxtMatricula.getText())+"' ");
				           stmt.executeUpdate("update CADASTRO_PROFESSOR set NASC_PROFESSOR =  '"+(TxtNascimento.getText())+"' where MATRICULA_PROFESSOR = '"+(TxtMatricula.getText())+"' ");
				           stmt.executeUpdate("update CADASTRO_PROFESSOR set EMAIL_PROFESSOR =  '"+(TxtEmail.getText())+"' where MATRICULA_PROFESSOR = '"+(TxtMatricula.getText())+"' ");
				           stmt.executeUpdate("update CADASTRO_PROFESSOR set TEL_PROFESSOR =  '"+(TxtTelefone.getText())+"' where MATRICULA_PROFESSOR = '"+(TxtMatricula.getText())+"' ");
				           stmt.executeUpdate("update CADASTRO_PROFESSOR set VALORHR_PROFESSOR =  '"+(TxtValor.getText())+"' where MATRICULA_PROFESSOR = '"+(TxtMatricula.getText())+"' ");
				           JOptionPane.showMessageDialog(contentPane, "Dados atualizados com sucesso !");
				            
				            TxtMatricula.setText(null);
				            TxtNome.setText(null);
				            TxtNascimento.setText(null);
				            TxtEmail.setText(null);
				            TxtTelefone.setText(null);
				            TxtValor.setText(null);
			    }
				       
				       	stmt.close();
					    con.close();
					    
			    }
				
			    
			    
			    catch (SQLException ex) {
			    		JOptionPane.showMessageDialog(contentPane, ex.getMessage());
			    		ex.printStackTrace();
				
			}
			}
		});
		BtnEditar.setBounds(248, 158, 112, 37);
		contentPane.add(BtnEditar);
		
		JButton BtnExcluir = new JButton("Excluir");
		BtnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String server = "LAPTOP-6RTEV8HD\\SQLEXPRESS01";
			    int port = 52202 ;
			    String user = "sa";
			    String pass = "496758123q";
			    String database = "Escola";
			    String jdbcurl = "jdbc:sqlserver://"+server+":"+port+";user="+user+";password="+pass+";databasename="+database+"";
			    Connection con = null; 
			    
			   		

			    try {
			        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			    } catch (ClassNotFoundException e1) {
			        e1.printStackTrace();
			    } 
			    try {
		            con = DriverManager.getConnection(jdbcurl);
		            Statement stmt = con.createStatement();
		            
		            
			  // Nao aceitar dados vazios
			            
			       if (TxtMatricula.getText().equals(" ") || TxtNome.getText().equals(" ") || TxtNascimento.getText().equals(" ") || TxtEmail.getText().equals(" ") || TxtTelefone.getText().equals(" ") || TxtValor.getText().equals(" ")) {
			          JOptionPane.showMessageDialog(contentPane, "Favor preencher todos os campos.");
			            }
			            	
			       else {
			  //deletar dados
			           stmt.executeUpdate("delete from CADASTRO_PROFESSOR where MATRICULA_PROFESSOR = '"+(TxtMatricula.getText())+"' ");
			           JOptionPane.showMessageDialog(contentPane, "Dados excluidos com sucesso !");
			    
			}
			       	stmt.close();
				    con.close();
				    
				    }
				    catch (SQLException ex) {
				    	JOptionPane.showMessageDialog(contentPane, ex.getMessage());
				    	ex.printStackTrace();
				}
			}
		});
		BtnExcluir.setBounds(370, 158, 115, 37);
		contentPane.add(BtnExcluir);
		
		JButton BtnCarregar = new JButton("Carregar");
		BtnCarregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String server = "LAPTOP-6RTEV8HD\\SQLEXPRESS01";
			    int port = 52202 ;
			    String user = "sa";
			    String pass = "496758123q";
			    String database = "Escola";
			    String jdbcurl = "jdbc:sqlserver://"+server+":"+port+";user="+user+";password="+pass+";databasename="+database+"";
			    Connection con = null; 
			    
			   		

			    try {
			        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			    } catch (ClassNotFoundException e1) {
			        e1.printStackTrace();
			    }   
			        
			    try {
			            con = DriverManager.getConnection(jdbcurl);
			            Statement stmt = con.createStatement();
			            
			           ResultSet rs = stmt.executeQuery("select * from CADASTRO_PROFESSOR ");
			           DefaultTableModel dtm = (DefaultTableModel) table_Professor.getModel();
			           dtm.setNumRows(0);
			           
			    while(rs.next()) {
			    	dtm.addRow(new Object[]{
			    		rs.getInt("MATRICULA_PROFESSOR"),
			    		rs.getString("NOME_PROFESSOR"),
			    		rs.getInt("NASC_PROFESSOR"),
			    		rs.getString("EMAIL_PROFESSOR"),
			    		rs.getString("TEL_PROFESSOR"),
			    		rs.getInt("VALORHR_PROFESSOR"),
			    		
			    		
			    	});
			    	
			    	
			    }
			    
			    table_Professor.setModel(dtm);
			    
			    stmt.close();
			    con.close();
			    
			    }
			    catch (SQLException ex) {
			    	JOptionPane.showMessageDialog(contentPane, ex.getMessage());
			    	ex.printStackTrace();
			}
			}
		});
		BtnCarregar.setBounds(495, 158, 123, 37);
		contentPane.add(BtnCarregar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(22, 206, 596, 268);
		contentPane.add(scrollPane);
		
		table_Professor = new JTable();
		scrollPane.setViewportView(table_Professor);
		table_Professor.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"MATRICULA_PROFESSOR", "NOME_PROFESSOR", "NASC_PROFESSOR", "EMAIL_PROFESSOR", "TEL_PROFESSOR", "VALOHR_PROFESSOR"
			}
		) {
			Class[] columnTypes = new Class[] {
				Integer.class, String.class, Integer.class, String.class, Integer.class, Integer.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
	}

}
