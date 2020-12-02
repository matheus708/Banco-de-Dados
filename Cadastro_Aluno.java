import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JScrollPane;

public class Cadastro_Aluno extends JFrame {

	private JPanel contentPane;
	private static JTextField TxtNome;
	private static JTextField TxtMatricula;
	private static JTextField TxtCPF;
	private static JTextField TxtEndereco;
	private static JTextField TxtEmail;
	private static JTextField TxtTelefone;
	private static JTextField TxtNascimento;
	private JLabel Nascimento;
	private static JTable table_Aluno;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Cadastro_Aluno frame = new Cadastro_Aluno();
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
	public Cadastro_Aluno() {
		setTitle("Cadastrar Aluno");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 642, 601);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel Nome = new JLabel("Nome");
		Nome.setBounds(10, 54, 46, 14);
		contentPane.add(Nome);
		
		JLabel Matricula = new JLabel("Matricula");
		Matricula.setBounds(10, 11, 46, 14);
		contentPane.add(Matricula);
		
		JLabel CPF = new JLabel("CPF");
		CPF.setBounds(10, 97, 46, 14);
		contentPane.add(CPF);
		
		TxtNome = new JTextField();
		TxtNome.setBounds(76, 54, 210, 20);
		contentPane.add(TxtNome);
		TxtNome.setColumns(10);
		
		TxtMatricula = new JTextField();
		TxtMatricula.setBounds(76, 8, 208, 20);
		contentPane.add(TxtMatricula);
		TxtMatricula.setColumns(10);
		
		TxtCPF = new JTextField();
		TxtCPF.setBounds(74, 94, 210, 20);
		contentPane.add(TxtCPF);
		TxtCPF.setColumns(10);
		
		JLabel Endereco = new JLabel("Endereco");
		Endereco.setBounds(316, 11, 54, 14);
		contentPane.add(Endereco);
		
		JLabel Email = new JLabel("E-mail");
		Email.setBounds(316, 54, 46, 14);
		contentPane.add(Email);
		
		JLabel Telefone = new JLabel("Telefone");
		Telefone.setBounds(316, 97, 46, 14);
		contentPane.add(Telefone);
		
		TxtEndereco = new JTextField();
		TxtEndereco.setBounds(374, 8, 240, 20);
		contentPane.add(TxtEndereco);
		TxtEndereco.setColumns(10);
		
		TxtEmail = new JTextField();
		TxtEmail.setBounds(373, 51, 241, 20);
		contentPane.add(TxtEmail);
		TxtEmail.setColumns(10);
		
		TxtTelefone = new JTextField();
		TxtTelefone.setBounds(375, 94, 239, 20);
		contentPane.add(TxtTelefone);
		TxtTelefone.setColumns(10);
		
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
			            
			            if (TxtMatricula.getText().equals(" ") || TxtNome.getText().equals(" ") || TxtCPF.getText().equals(" ") || TxtNascimento.getText().equals(" ") || TxtEndereco.getText().equals(" ") || TxtEmail.getText().equals(" ") || TxtTelefone.getText().equals(" ")) {
			            JOptionPane.showMessageDialog(contentPane, "Favor preencher todos os campos.");
			            }
			            	
			            else {
			            //inserir dados
			            stmt.executeUpdate("insert into CADASTRO_ALUNO(MATRICULA_ALUNO, NOME_ALUNO, CPF_ALUNO, NASC_ALUNO, ENDERECO_ALUNO, EMAIL_ALUNO, TEL_ALUNO) values('"+(TxtMatricula.getText())+"','"+(TxtNome.getText())+"','"+(TxtCPF.getText())+"','"+(TxtNascimento.getText())+"','"+(TxtEndereco.getText())+"','"+(TxtEmail.getText())+"','"+(TxtTelefone.getText())+"')");
			            JOptionPane.showMessageDialog(contentPane, "Cadastro Realizado.");
			            
			            TxtMatricula.setText(null);
			            TxtNome.setText(null);
			            TxtCPF.setText(null);
			            TxtNascimento.setText(null);
			            TxtEndereco.setText(null);
			            TxtEmail.setText(null);
			            TxtTelefone.setText(null);
			    }
			    }
				
			    	
			    
			    catch (SQLException ex) {
			    	JOptionPane.showMessageDialog(contentPane, ex.getMessage());
			    	ex.printStackTrace();
			}
			}
		});
		BtnCadastrar.setBounds(30, 183, 100, 34);
		contentPane.add(BtnCadastrar);
		
		Nascimento = new JLabel("Nascimento");
		Nascimento.setBounds(10, 141, 65, 14);
		contentPane.add(Nascimento);
		
		TxtNascimento = new JTextField();
		TxtNascimento.setBounds(76, 138, 208, 20);
		contentPane.add(TxtNascimento);
		TxtNascimento.setColumns(10);
		
		JButton BtnLimpar = new JButton("Limpar");
		BtnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				TxtMatricula.setText(null);
	            TxtNome.setText(null);
	            TxtCPF.setText(null);
	            TxtNascimento.setText(null);
	            TxtEndereco.setText(null);
	            TxtEmail.setText(null);
	            TxtTelefone.setText(null);
			}
		});
		BtnLimpar.setBounds(140, 183, 100, 34);
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
				            
				       if (TxtMatricula.getText().equals(" ") || TxtNome.getText().equals(" ") || TxtCPF.getText().equals(" ") || TxtNascimento.getText().equals(" ") || TxtEndereco.getText().equals(" ") || TxtEmail.getText().equals(" ") || TxtTelefone.getText().equals(" ")) {
				          JOptionPane.showMessageDialog(contentPane, "Favor preencher todos os campos.");
				            }
				            	
				       else {
				  //alterar dados
				           stmt.executeUpdate("update CADASTRO_ALUNO set NOME_ALUNO =  '"+(TxtNome.getText())+"' where MATRICULA_ALUNO = '"+(TxtMatricula.getText())+"' ");
				           stmt.executeUpdate("update CADASTRO_ALUNO set CPF_ALUNO =  '"+(TxtCPF.getText())+"' where MATRICULA_ALUNO = '"+(TxtMatricula.getText())+"' ");
				           stmt.executeUpdate("update CADASTRO_ALUNO set NASC_ALUNO =  '"+(TxtNascimento.getText())+"' where MATRICULA_ALUNO = '"+(TxtMatricula.getText())+"' ");
				           stmt.executeUpdate("update CADASTRO_ALUNO set ENDERECO_ALUNO =  '"+(TxtEndereco.getText())+"' where MATRICULA_ALUNO = '"+(TxtMatricula.getText())+"' ");
				           stmt.executeUpdate("update CADASTRO_ALUNO set EMAIL_ALUNO =  '"+(TxtEmail.getText())+"' where MATRICULA_ALUNO = '"+(TxtMatricula.getText())+"' ");
				           stmt.executeUpdate("update CADASTRO_ALUNO set TEL_ALUNO =  '"+(TxtTelefone.getText())+"' where MATRICULA_ALUNO = '"+(TxtMatricula.getText())+"' ");
				           JOptionPane.showMessageDialog(contentPane, "Dados atualizados com sucesso !");
				            
				            TxtMatricula.setText(null);
				            TxtNome.setText(null);
				            TxtCPF.setText(null);
				            TxtNascimento.setText(null);
				            TxtEndereco.setText(null);
				            TxtEmail.setText(null);
				            TxtTelefone.setText(null);
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
		BtnEditar.setBounds(250, 183, 100, 34);
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
			            
			       if (TxtMatricula.getText().equals(" ") || TxtNome.getText().equals(" ") || TxtCPF.getText().equals(" ") || TxtNascimento.getText().equals(" ") || TxtEndereco.getText().equals(" ") || TxtEmail.getText().equals(" ") || TxtTelefone.getText().equals(" ")) {
			          JOptionPane.showMessageDialog(contentPane, "Favor preencher todos os campos.");
			            }
			            	
			       else {
			  //deletar dados
			           stmt.executeUpdate("delete from CADASTRO_ALUNO where MATRICULA_ALUNO =  '"+(TxtMatricula.getText())+"' ");
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
		BtnExcluir.setBounds(360, 183, 100, 34);
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
			            
			           ResultSet rs = stmt.executeQuery("select * from CADASTRO_ALUNO ");
			           DefaultTableModel dtm = (DefaultTableModel) table_Aluno.getModel();
			           dtm.setNumRows(0);
			           
			    while(rs.next()) {
			    	dtm.addRow(new Object[]{
			    		rs.getInt("MATRICULA_ALUNO"),
			    		rs.getString("NOME_ALUNO"),
			    		rs.getInt("CPF_ALUNO"),
			    		rs.getInt("NASC_ALUNO"),
			    		rs.getString("ENDERECO_ALUNO"),
			    		rs.getString("EMAIL_ALUNO"),
			    		rs.getInt("TEL_ALUNO"),
			    		
			    		
			    	});
			    	
			    	
			    }
			    
			    table_Aluno.setModel(dtm);
			    
			    stmt.close();
			    con.close();
			    
			    }
			    catch (SQLException ex) {
			    	JOptionPane.showMessageDialog(contentPane, ex.getMessage());
			    	ex.printStackTrace();
			}
			}
		});
		BtnCarregar.setBounds(470, 183, 126, 34);
		contentPane.add(BtnCarregar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 233, 606, 318);
		contentPane.add(scrollPane);
		
		table_Aluno = new JTable();
		scrollPane.setViewportView(table_Aluno);
		table_Aluno.setBackground(Color.WHITE);
		table_Aluno.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"MATRICULA_ALUNO", "NOME_ALUNO", "CPF_ALUNO", "NASC_ALUNO", "ENDERE\u00C7O_ALUNO", "EMAIL_ALUNO", "TEL_ALUNO"
			}
		) {
			Class[] columnTypes = new Class[] {
				Integer.class, String.class, Integer.class, Integer.class, String.class, String.class, Integer.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
			
		}
	}
