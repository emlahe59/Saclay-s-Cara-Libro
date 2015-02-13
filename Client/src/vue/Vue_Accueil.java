package vue;

import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;

import controleur.Controleur_Accueil;

public class Vue_Accueil extends JFrame {

	private static final long serialVersionUID = 1L;
	
	// composants de l'interface graphique
	private JPanel panneauInfos;
	private JPanel panneauBoutons;
	private JButton boutonConnection;
	private JButton boutonCreerCompte;
	private JLabel labelIdentifiant;
	private JLabel labelMotDePasse;
	private JTextArea texteIdentifiant;
	private JPasswordField champMotDePasse;
	
	public Vue_Accueil() {		
		// cr�ation du panneau pour les informations de login
		panneauInfos = new JPanel();
		panneauInfos.setLayout(new GridLayout(2, 2));
		labelIdentifiant = new JLabel("Identifiant :");
		panneauInfos.add(labelIdentifiant);
		texteIdentifiant = new JTextArea("");
		panneauInfos.add(texteIdentifiant);
		labelMotDePasse = new JLabel("Mot de passe :");
		panneauInfos.add(labelMotDePasse);
		champMotDePasse = new JPasswordField("");
		champMotDePasse.setEchoChar('*');
		panneauInfos.add(champMotDePasse);
		
		// cr�ation du panneau pour les boutons
		panneauBoutons = new JPanel();
		panneauBoutons.setLayout(new GridLayout(1, 2));
		boutonConnection = new JButton("Connection");
		panneauBoutons.add(boutonConnection);
		boutonConnection.setActionCommand(Controleur_Accueil.ACTION_CONNECTION);
		boutonCreerCompte = new JButton("Cr�er un compte");
		panneauBoutons.add(boutonCreerCompte);
		boutonCreerCompte.setActionCommand(Controleur_Accueil.ACTION_CREER_COMPTE);
		
		// affichage de la fen�tre
		this.setTitle("Accueil");
		this.setLayout(new GridLayout(2, 1));
		this.add(panneauInfos);
		this.add(panneauBoutons);
		this.pack();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}

	public void setListener(ActionListener controleur) {
		boutonConnection.addActionListener(controleur);
		boutonCreerCompte.addActionListener(controleur);
	}
	
	public void redessiner() {
		texteIdentifiant.setText("");
		champMotDePasse.setText("");
	}
	
	public String getIdentifiant() {
		return texteIdentifiant.getText();
	}
	
	public String getMotDePasse() {
		return champMotDePasse.getPassword().toString();
	}
	
}
