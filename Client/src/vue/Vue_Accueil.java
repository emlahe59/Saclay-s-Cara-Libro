package vue;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;

import controleur.Controleur_Utilisateur;

public class Vue_Accueil extends JFrame {
	
	private static final long serialVersionUID = 1L;
	
	// composants de l'interface graphique
	private JPanel panneauInfos;
	private JPanel panneauBoutons;
	private JButton boutonConnection;
	private JButton boutonCreerCompte;
	private JButton boutonReactiver;
	private JLabel labelLogin;
	private JLabel labelMotDePasse;
	private JTextArea texteLogin;
	private JPasswordField champMotDePasse;
	
	public Vue_Accueil(Controleur_Utilisateur controleurUtilisateur) {		
		// création du panneau pour les informations de login
		panneauInfos = new JPanel();
		panneauInfos.setLayout(new GridLayout(2, 2));
		labelLogin = new JLabel("Login :");
		panneauInfos.add(labelLogin);
		texteLogin = new JTextArea("");
		panneauInfos.add(texteLogin);
		labelMotDePasse = new JLabel("Mot de passe :");
		panneauInfos.add(labelMotDePasse);
		champMotDePasse = new JPasswordField("");
		champMotDePasse.setEchoChar('*');
		panneauInfos.add(champMotDePasse);
		
		// création du panneau pour les boutons
		panneauBoutons = new JPanel();
		panneauBoutons.setLayout(new GridLayout(1, 3));
		boutonConnection = new JButton("Connection");
		panneauBoutons.add(boutonConnection);
		boutonConnection.setActionCommand(Controleur_Utilisateur.ACTION_CONNECTION);
		boutonConnection.addActionListener(controleurUtilisateur);
		boutonCreerCompte = new JButton("Créer un compte");
		panneauBoutons.add(boutonCreerCompte);
		boutonCreerCompte.setActionCommand(Controleur_Utilisateur.ACTION_CREER_COMPTE);
		boutonCreerCompte.addActionListener(controleurUtilisateur);
		boutonReactiver = new JButton("Réactiver un compte");
		panneauBoutons.add(boutonReactiver);
		boutonReactiver.setActionCommand(Controleur_Utilisateur.ACTION_REACTIVER_COMPTE);
		boutonReactiver.addActionListener(controleurUtilisateur);
		
		// affichage de la fenêtre
		this.setTitle("Accueil");
		this.setLayout(new GridLayout(2, 1));
		this.add(panneauInfos);
		this.add(panneauBoutons);
		this.pack();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
	public String getLogin() {
		return texteLogin.getText();
	}
	
	public String getMotDePasse() {
		return champMotDePasse.getPassword().toString();
	}

}
