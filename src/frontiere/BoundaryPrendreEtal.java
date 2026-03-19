package frontiere;

import controleur.ControlPrendreEtal;

public class BoundaryPrendreEtal {
	private ControlPrendreEtal controlPrendreEtal;

	public BoundaryPrendreEtal(ControlPrendreEtal controlChercherEtal) {
		this.controlPrendreEtal = controlChercherEtal;
	}

	public void prendreEtal(String nomVendeur) {
		if(controlPrendreEtal.verifierIdentite(nomVendeur)==false){
			System.out.println("Je suis désolée "+nomVendeur+" mais il faut être un habitant de notre village pour commercer ici." );
		}
		else {
			System.out.println("Bonjour "+nomVendeur+" , je vais regarder si je peut vous trouver un étal.");
			if(controlPrendreEtal.resteEtals()==false) {
				System.out.println("Désolée " + nomVendeur + " j'ai n'ai pas plus d'étal qui ne soit dèja occupé.");
			}
			else {
				installerVendeur(nomVendeur);
			}
		}
	}

	private void installerVendeur(String nomVendeur) {
		//TODO a completer
	}
}
