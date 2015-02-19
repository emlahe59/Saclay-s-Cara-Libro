package controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import modele.Modele_Utilisateur;
import vue.Vue_Accueil;
import vue.Vue_Admin;
import vue.Vue_Utilisateur;

public class Controleur_Utilisateur implements ActionListener {

	// constantes pour les actionCommand
	public static final String ACTION_CONNECTION = "CONNECTION";
	public static final String ACTION_CREER_COMPTE = "CREER COMPTE";
	public static final String ACTION_DECONNECTION = "DECONNECTION";
	public static final String ACTION_MODIFIER_PROFIL = "MODIFIER PROFIL";
	public static final String ACTION_REACTIVER_COMPTE = "REACTIVER COMPTE";

	private Modele_Utilisateur modeleUtilisateur;
	private JFrame vue;
	
	public Controleur_Utilisateur() {
		modeleUtilisateur = new Modele_Utilisateur();
		vue = new Vue_Accueil(this);
	}

	public void actionPerformed(ActionEvent e) {
		switch(e.getActionCommand()) {
		case ACTION_CONNECTION:
			connection();
			break;
		case ACTION_CREER_COMPTE:
			creerCompte();
			break;
		case ACTION_DECONNECTION:
			deconnection();
			break;
		case ACTION_MODIFIER_PROFIL:
			modifierProfil();
			break;
		case ACTION_REACTIVER_COMPTE:
			reactiverCompte();
			break;
		}
	}

	private void connection() {
		String login = ((Vue_Accueil) vue).getLogin();
		String motDePasse =  ((Vue_Accueil) vue).getMotDePasse();
		
		switch(modeleUtilisateur.connection(login, motDePasse)) {
		case "UTILISATEUR":
			vue.setVisible(false);
			vue.dispose();
			vue = new Vue_Utilisateur(this);
			break;
		case "ADMIN":
			vue.setVisible(false);
			vue.dispose();
			vue = new Vue_Admin(this);
			break;
		case "ERREUR_LOGIN":
			JOptionPane.showMessageDialog(new JDialog(),"Le compte n'existe pas !", "Erreur", JOptionPane.ERROR_MESSAGE);
			break;
		case "ERREUR_MDP":
			JOptionPane.showMessageDialog(new JDialog(),"Mot de passe incorrect !", "Erreur", JOptionPane.ERROR_MESSAGE);
			break;
		}
	}

	private void creerCompte() {
		String login = ((Vue_Accueil) vue).getLogin();
		String motDePasse =  ((Vue_Accueil) vue).getMotDePasse();
		
		switch(modeleUtilisateur.creerCompte(login, motDePasse)) {
		case "SUCCES":
			JOptionPane.showMessageDialog(new JDialog(),"Le compte a bien été créé. Vous pouvez dès à présent vous connecter avec ce compte.", "Création de compte réussie", JOptionPane.INFORMATION_MESSAGE);
			break;
		case "ERREUR_LOGIN_EXISTE":
			JOptionPane.showMessageDialog(new JDialog(),"Ce login existe déjà !", "Erreur", JOptionPane.ERROR_MESSAGE);
			break;
		case "ERREUR_LOGIN":
			JOptionPane.showMessageDialog(new JDialog(),"Login incorrect !", "Erreur", JOptionPane.ERROR_MESSAGE);
			break;
		case "ERREUR_MDP":
			JOptionPane.showMessageDialog(new JDialog(),"Mot de passe incorrect !", "Erreur", JOptionPane.ERROR_MESSAGE);
			break;
		}
	}
	
	private void deconnection() {
		vue.setVisible(false);
		vue.dispose();
		vue = new Vue_Accueil(this);
	}
	
	private void modifierProfil() {
		
	}
	
	private void reactiverCompte() {
		String login = ((Vue_Accueil) vue).getLogin();
		String motDePasse =  ((Vue_Accueil) vue).getMotDePasse();
		
		switch(modeleUtilisateur.reactiverCompte(login, motDePasse)) {
		case "SUCCES":
			JOptionPane.showMessageDialog(new JDialog(),"Le compte a bien été réactivé. Vous pouvez dès à présent vous connecter avec ce compte.", "Réactivation de compte réussie", JOptionPane.INFORMATION_MESSAGE);
			break;
		case "ERREUR_LOGIN":
			JOptionPane.showMessageDialog(new JDialog(),"Ce compte n'existe pas !", "Erreur", JOptionPane.ERROR_MESSAGE);
			break;
		case "ERREUR_MDP":
			JOptionPane.showMessageDialog(new JDialog(),"Mot de passe incorrect !", "Erreur", JOptionPane.ERROR_MESSAGE);
			break;
		}
	}
	
}
