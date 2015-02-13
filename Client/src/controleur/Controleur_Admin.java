package controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import modele.Modele_Admin;
import vue.Vue_Accueil;
import vue.Vue_Admin;

public class Controleur_Admin implements ActionListener {

	// constantes pour les actionCommand
	public static final String ACTION_DECONNECTION = "DECONNECTION";
	
	private Modele_Admin modeleAdmin;
	private Vue_Admin vueAdmin;
	private Vue_Accueil vueAccueil;
	
	public Controleur_Admin(Modele_Admin modeleAdmin, Vue_Admin vueAdmin, Vue_Accueil vueAccueil) {
		this.modeleAdmin = modeleAdmin;
		this.vueAdmin = vueAdmin;
		this.vueAccueil = vueAccueil;
		vueAdmin.setListener(this);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand() == ACTION_DECONNECTION) {
			vueAdmin.setVisible(false);
			vueAdmin.dispose();
			vueAdmin = null;
			vueAccueil.setVisible(true);
			modeleAdmin = null;
		}
	}

}
