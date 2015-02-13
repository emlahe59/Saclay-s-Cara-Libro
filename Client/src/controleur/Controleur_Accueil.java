package controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import modele.Modele_Accueil;
import modele.Modele_Admin;
import modele.Modele_Utilisateur;
import vue.Vue_Accueil;
import vue.Vue_Admin;
import vue.Vue_Utilisateur;

public class Controleur_Accueil implements ActionListener {

	// constantes pour les actionCommand
	public static final String ACTION_CONNECTION = "CONNECTION";
	public static final String ACTION_CREER_COMPTE = "CREER_COMPTE";
	
	private Modele_Accueil modeleAccueil;
	private Vue_Accueil vueAccueil;
	
	public Controleur_Accueil(Modele_Accueil modeleAccueil, Vue_Accueil vueAccueil) {
		this.modeleAccueil = modeleAccueil;
		this.vueAccueil = vueAccueil;
		vueAccueil.setListener(this);
	}
	
	public void actionPerformed(ActionEvent e) {
		modeleAccueil.setIdentifiant(vueAccueil.getIdentifiant());
		modeleAccueil.setMotDePasse(vueAccueil.getMotDePasse());
		
		if (e.getActionCommand() == ACTION_CONNECTION) {
			switch(modeleAccueil.connection()) {
			case "UTILISATEUR":
				vueAccueil.setVisible(false);
				new Controleur_Utilisateur(new Modele_Utilisateur(), new Vue_Utilisateur(), vueAccueil);
				break;
			case "ADMIN":
				vueAccueil.setVisible(false);
				new Controleur_Admin(new Modele_Admin(), new Vue_Admin(), vueAccueil);
				break;
			case "ERREUR":
				vueAccueil.redessiner();
				break;
			}
		}
		else if (e.getActionCommand() == ACTION_CREER_COMPTE) {
			modeleAccueil.creerCompte();
		}
	}

}