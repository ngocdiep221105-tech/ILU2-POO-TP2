package frontiere;

import controleur.ControlPrendreEtal;

public class BoundaryPrendreEtal {
	private ControlPrendreEtal controlPrendreEtal;

	public BoundaryPrendreEtal(ControlPrendreEtal controlChercherEtal) {
		this.controlPrendreEtal = controlChercherEtal;
	}

	public void prendreEtal(String nomVendeur) {
		boolean nomVendeurConnu=controlPrendreEtal.verifierIdentite(nomVendeur);
		if(!nomVendeurConnu){
			System.out.println("Je suis désolée "+nomVendeur+" mais il faut être un habitant de notre village pour commercer ici." );
		}
		else {
			System.out.println("Bonjour "+nomVendeur+" , je vais regarder si je peut vous trouver un étal.");
			boolean etalDisponible=controlPrendreEtal.resteEtals();
			if(!etalDisponible) {
				System.out.println("Désolée " + nomVendeur + " j'ai n'ai pas plus d'étal qui ne soit dèja occupé.");
			}
			else {
				installerVendeur(nomVendeur);
			}
		}
	}

	private void installerVendeur(String nomVendeur) {
		System.out.println("C'est parfait, il me reste un étal pour vous!");
		System.out.println("Il me faudrait quelquels renseignement:");
		System.out.println("Qule produit souhaitez-vous vendre?");
		StringBuilder question = new StringBuilder();
		String produit = Clavier.entrerChaine(question.toString());
		System.out.println("Combien souhaitez-vous vendre?");
		int nbProduit= Clavier.entrerEntier(question.toString());
		int numeroEtal = controlPrendreEtal.prendreEtal(nomVendeur, produit, nbProduit);
		if(numeroEtal!=1){
			System.out.println("Le vendeur "+nomVendeur+" s'est installé à n° "+numeroEtal);
		}
	}
}
