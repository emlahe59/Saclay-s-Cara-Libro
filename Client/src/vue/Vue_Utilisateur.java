package vue;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controleur.Controleur_Utilisateur;

public class Vue_Utilisateur extends JFrame {

	private static final long serialVersionUID = 1L;
	
	// composants de l'interface graphique
	JPanel panneauProfil;
	JPanel vueMur;
	JLabel labelPrenom;
	JLabel labelNom;
	JButton boutonModifier;
	JButton boutonDeconnection;
		
	public Vue_Utilisateur(Controleur_Utilisateur controleurUtilisateur) {
		// création du panneau profil
		panneauProfil = new JPanel();
		panneauProfil.setLayout(new GridLayout(1, 4));
		labelPrenom = new JLabel("Prénom");
		panneauProfil.add(labelPrenom);
		labelNom = new JLabel("Nom");
		panneauProfil.add(labelNom);
		boutonModifier = new JButton("Modifier le profil");
		panneauProfil.add(boutonModifier);
		boutonModifier.setActionCommand(Controleur_Utilisateur.ACTION_MODIFIER_PROFIL);
		boutonModifier.addActionListener(controleurUtilisateur);
		boutonDeconnection = new JButton("Se déconnecter");
		panneauProfil.add(boutonDeconnection);
		boutonDeconnection.setActionCommand(Controleur_Utilisateur.ACTION_DECONNECTION);
		boutonDeconnection.addActionListener(controleurUtilisateur);
			
		// création du panneau mur
		
		
		// affichage de la fenêtre
		this.setTitle("Profil");
		this.setLayout(new GridLayout(2, 1));
		this.add(panneauProfil);
		//this.add(vueMur);
		this.pack();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
}