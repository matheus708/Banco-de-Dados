import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class Materia extends JFrame {

	private JPanel contentPane;
	private JTextField TxtMateria;
	private JTextField TxtResp;
	private JTable table_Materia;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Materia frame = new Materia();
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
	public Materia() {
		setTitle("Mat\u00E9ria");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 541, 535);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel Matéria = new JLabel("Mat\u00E9ria");
		Matéria.setBounds(118, 36, 53, 14);
		contentPane.add(Matéria);
		
		JLabel Responsavel = new JLabel("Respons\u00E1vel");
		Responsavel.setBounds(118, 85, 73, 14);
		contentPane.add(Responsavel);
		
		TxtMateria = new JTextField();
		TxtMateria.setBounds(195, 33, 202, 20);
		contentPane.add(TxtMateria);
		TxtMateria.setColumns(10);
		
		TxtResp = new JTextField();
		TxtResp.setBounds(195, 82, 202, 20);
		contentPane.add(TxtResp);
		TxtResp.setColumns(10);
		
		JButton BtnCadastrar = new JButton("Cadastrar");
		BtnCadastrar.addActionListener(new ActionListener() {
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
			         // Criar Statement

			            Statement stmt = con.createStatement();
			            
			         // Nao aceitar dados vazios
			            
			            if (TxtMateria.getText().equals(" ") || TxtResp.getText().equals(" ")) {
			            JOptionPane.showMessageDialog(contentPane, "Favor preencher todos os campos.");
			            }
			            	
			            else {
			            //inserir dados
			            stmt.executeUpdate("insert into MATERIAS(MATERIA, PROF_RESPONSAVEL) values('"+(TxtMateria.getText())+"','"+(TxtResp.getText())+"')");
			            JOptionPane.showMessageDialog(contentPane, "Cadastro Realizado.");
			            
			            TxtMateria.setText(null);
			            TxtResp.setText(null);
			  
			    }
			    }
				
			    	
			    
			    catch (SQLException ex) {
			    	JOptionPane.showMessageDialog(contentPane, ex.getMessage());
			    	ex.printStackTrace();
			}
			}
		});
		BtnCadastrar.setBounds(10, 139, 101, 38);
		contentPane.add(BtnCadastrar);
		
		JButton BtnLimpar = new JButton("Limpar");
		BtnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				TxtMateria.setText(null);
	            TxtResp.setText(null);
			}
		});
		BtnLimpar.setBounds(121, 139, 88, 38);
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
				            
				       if (TxtMateria.getText().equals(" ") || TxtResp.getText().equals(" ")) {
				          JOptionPane.showMessageDialog(contentPane, "Favor preencher todos os campos.");
				            }
				            	
				       else {
				  //alterar dados
				           stmt.executeUpdate("update MATERIAS set MATERIA =  '"+(TxtMateria.getText())+"' where PROF_RESPONSAVEL = '"+(TxtResp.getText())+"' ");
				           JOptionPane.showMessageDialog(contentPane, "Dados atualizados com sucesso !");
				            
				            TxtMateria.setText(null);
				            TxtResp.setText(null);
				            
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
		BtnEditar.setBounds(219, 139, 90, 38);
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
			            
			       if (TxtMateria.getText().equals(" ") || TxtResp.getText().equals(" ")) {
			          JOptionPane.showMessageDialog(contentPane, "Favor preencher todos os campos.");
			            }
			            	
			       else {
			  //deletar dados
			           stmt.executeUpdate("delete from MATERIAS where PROF_RESPONSAVEL = '"+(TxtResp.getText())+"' ");
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
		BtnExcluir.setBounds(319, 139, 90, 38);
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
			            
			           ResultSet rs = stmt.executeQuery("select * from MATERIAS ");
			           DefaultTableModel dtm = (DefaultTableModel) table_Materia.getModel();
			           dtm.setNumRows(0);
			           
			    while(rs.next()) {
			    	dtm.addRow(new Object[]{
			    		rs.getString("MATERIA"),
			    		rs.getInt("PROF_RESPONSAVEL"),
			    		
			    		
			    	});
			    	
			    	
			    }
			    
			    table_Materia.setModel(dtm);
			    
			    stmt.close();
			    con.close();
			    
			    }
			    catch (SQLException ex) {
			    	JOptionPane.showMessageDialog(contentPane, ex.getMessage());
			    	ex.printStackTrace();
			}
			}
		});
		BtnCarregar.setBounds(414, 139, 101, 38);
		contentPane.add(BtnCarregar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 188, 505, 297);
		contentPane.add(scrollPane);
		
		table_Materia = new JTable();
		table_Materia.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"MATERIA", "PROF_RESPONSAVEL"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, Integer.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		scrollPane.setViewportView(table_Materia);
	}

}
