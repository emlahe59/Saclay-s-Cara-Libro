package vue;

import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import controleur.Controleur_Utilisateur;

public class Vue_Utilisateur extends JFrame {

	private static final long serialVersionUID = 1L;

	// composants de l'interface graphique
	JButton boutonDeconnection;
		
	public Vue_Utilisateur() {
		boutonDeconnection = new JButton("Se D�connecter");
		this.add(boutonDeconnection);
		boutonDeconnection.setActionCommand(Controleur_Utilisateur.ACTION_DECONNECTION);
			
		// affichage de la fen�tre
		this.setTitle("Profil");
		this.pack();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
		
	public void setListener(ActionListener controleur) {
		boutonDeconnection.addActionListener(controleur);
	}
	
}