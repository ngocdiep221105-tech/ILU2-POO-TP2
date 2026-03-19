package frontiere;

import controleur.ControlEmmenager;


public class BoundaryEmmenager {
	private ControlEmmenager controlEmmenager;

	public BoundaryEmmenager(ControlEmmenager controlEmmenager) {
		this.controlEmmenager = controlEmmenager;
	}

	public void emmenager(String nomVisiteur) {
		if (controlEmmenager.isHabitant(nomVisiteur)) {
			System.out.println(
					"Mais vous êtes déjà un habitant du village !");
		} else {
			StringBuilder question = new StringBuilder();
			question.append("Êtes-vous :\n");
			question.append("1 - un druide.\n");
			question.append("2 - un gaulois.\n");
			int choixUtilisateur = -1;
			do {
				choixUtilisateur = Clavier.entrerEntier(question.toString());
				switch (choixUtilisateur) {
				case 1:
					emmenagerDruide(nomVisiteur);
					break;

				case 2:
					System.out.println("Bienvenue villageois" + nomVisiteur);
					System.out.println("Quelles est votre force?");
					int force= Clavier.entrerEntier(question.toString());
					controlEmmenager.ajouterGaulois(nomVisiteur,force);
					
					break;

				default:
					System.out
							.println("Vous devez choisir le chiffre 1 ou 2 !");
					break;
				}
			} while (choixUtilisateur != 1 && choixUtilisateur != 2);
		}
	}

	private void emmenagerDruide(String nomVisiteur) {
		System.out.println("Bienvenue druide" + nomVisiteur);
		System.out.println("Quelles est votre force?");
		StringBuilder question = new StringBuilder();
		int forceDruide= Clavier.entrerEntier(question.toString());
		
		System.out.println("Quelles est la force de potion la plus faible que vous produiser?");
		int effetPotionMin= Clavier.entrerEntier(question.toString());
		System.out.println("Quelles est la force de potion la plus forte que vous produiser?");
		int effetPotionMax= Clavier.entrerEntier(question.toString());
		
		if (effetPotionMax<effetPotionMin) {
			System.out.println("Quelles est la force de potion la plus faible que vous produiser?");
			effetPotionMin= Clavier.entrerEntier(question.toString());
			System.out.println("Quelles est la force de potion la plus forte que vous produiser?");
			effetPotionMax= Clavier.entrerEntier(question.toString());
			
			if (effetPotionMax<effetPotionMin) {
				System.out.println("Attention Druide, vous vous être trompé entre la minimum et le maximum ");
			}
		}
		
		controlEmmenager.ajouterDruide(nomVisiteur, forceDruide, effetPotionMin, effetPotionMax);
	}
	
 
}
