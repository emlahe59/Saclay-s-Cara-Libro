package controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import modele.Modele_Utilisateur;
import vue.Vue_Accueil;
import vue.Vue_Utilisateur;

public class Controleur_Utilisateur implements ActionListener {

	// constantes pour les actionCommand
	public static final String ACTION_DECONNECTION = "DECONNECTION";

	private Modele_Utilisateur modeleUtilisateur;
	private Vue_Utilisateur vueUtilisateur;
	private Vue_Accueil vueAccueil;
	
	public Controleur_Utilisateur(Modele_Utilisateur modeleUtilisateur, Vue_Utilisateur vueUtilisateur, Vue_Accueil vueAccueil) {
		this.modeleUtilisateur = modeleUtilisateur;
		this.vueUtilisateur = vueUtilisateur;
		this.vueAccueil = vueAccueil;
		vueUtilisateur.setListener(this);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand() == ACTION_DECONNECTION) {
			vueUtilisateur.setVisible(false);
			vueUtilisateur.dispose();
			vueUtilisateur = null;
			vueAccueil.setVisible(true);
			modeleUtilisateur = null;
		}
	}

}