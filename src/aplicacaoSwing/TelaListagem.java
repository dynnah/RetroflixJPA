/**********************************

 * IFPB - Curso Superior de Tec. em Sist. para Internet
 * Persistencia de Objetos
 * Equipe - George Lucas
 * 		  - Dynnah Hanna
 **********************************/

package aplicacaoSwing;

import java.awt.EventQueue;

import javax.swing.JFrame;

public class TelaListagem {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaListagem window = new TelaListagem();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TelaListagem() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
