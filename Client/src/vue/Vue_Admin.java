package vue;

import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import controleur.Controleur_Admin;

public class Vue_Admin extends JFrame {

	private static final long serialVersionUID = 1L;

	// composants de l'interface graphique
	JButton boutonDeconnection;
	
	public Vue_Admin() {
		boutonDeconnection = new JButton("Se D�connecter");
		this.add(boutonDeconnection);
		boutonDeconnection.setActionCommand(Controleur_Admin.ACTION_DECONNECTION);
		
		// affichage de la fen�tre
		this.setTitle("Panneau d'administration");
		this.pack();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
	public void setListener(ActionListener controleur) {
		boutonDeconnection.addActionListener(controleur);
	}
	
}