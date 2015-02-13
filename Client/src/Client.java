import controleur.Controleur_Accueil;
import vue.Vue_Accueil;
import modele.Modele_Accueil;

public class Client {

	public static void main(String[] args) {
		new Controleur_Accueil(new Modele_Accueil(), new Vue_Accueil());
	}

}
