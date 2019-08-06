/**********************************

 * IFPB - Curso Superior de Tec. em Sist. para Internet
 * Persistencia de Objetos
 * Equipe - George Lucas
 * 		  - Dynnah Hanna
 **********************************/

package aplicacaoSwing;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import fachada.Fachada;

public class TelaCadastroCliente {

	private JFrame frmCadastro;
	private JLabel label1;
	private JTextField textField;
	private JTextField textField_1;
	private JButton button1;
	private JButton button2;
	private DefaultListModel<String> model;
	private JLabel label2;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					TelaCadastro window = new TelaCadastro();
//					window.frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the application.
	 */
	public TelaCadastroCliente() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCadastro = new JFrame();
		frmCadastro.setTitle("Cadastro");
		frmCadastro.setBounds(100, 100, 225, 274);
		frmCadastro.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmCadastro.getContentPane().setLayout(null);
		
		label1 = new JLabel("nome:");
		label1.setBounds(25, 34, 46, 14);
		frmCadastro.getContentPane().add(label1);
		
		label2 = new JLabel("");
		label2.setBounds(10, 210, 189, 14);
		frmCadastro.getContentPane().add(label2);
		
		textField = new JTextField();
		textField.setBounds(62, 31, 137, 20);
		frmCadastro.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(62, 64, 137, 20);
		frmCadastro.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblEmail = new JLabel("email:");
		lblEmail.setBounds(25, 67, 46, 14);
		frmCadastro.getContentPane().add(lblEmail);
		
		JLabel lblCpf = new JLabel("cep:");
		lblCpf.setBounds(25, 100, 46, 14);
		frmCadastro.getContentPane().add(lblCpf);
		
		JLabel lblCep = new JLabel("cpf:");
		lblCep.setBounds(25, 133, 46, 14);
		frmCadastro.getContentPane().add(lblCep);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(62, 97, 137, 20);
		frmCadastro.getContentPane().add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(62, 130, 137, 20);
		frmCadastro.getContentPane().add(textField_3);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setBounds(48, 176, 106, 23);
		frmCadastro.getContentPane().add(btnCadastrar);
		
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					String nome = textField.getText();
					String email = textField_1.getText();
					String cep = textField_2.getText();
					String cpf = textField_3.getText();
					Fachada.cadastrarCliente(nome, email, cep, cpf);
//					if(!model.isEmpty()) {
//						for(int i=0; i<model.size(); i++) {
//							String numero = (String) model.get(i);
//							Fachada.adicionarTelefonePessoa(nome,numero );
//						}
//					}
//					model.clear();
					textField.setText("");
					label2.setText("cadastro concluido");
				}
				catch(Exception e) {
					
				}
			}
		});
		
		model = new DefaultListModel<String>() ;
		
		//mostrar a janela
		frmCadastro.setVisible(true);
	}
}
