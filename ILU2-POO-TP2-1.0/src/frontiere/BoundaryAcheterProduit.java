package frontiere;

import java.util.Iterator;

import controleur.ControlAcheterProduit;

public class BoundaryAcheterProduit {
	private ControlAcheterProduit controlAcheterProduit;

	public BoundaryAcheterProduit(ControlAcheterProduit controlAcheterProduit) {
		this.controlAcheterProduit = controlAcheterProduit;
	}

	public void acheterProduit(String nomAcheteur) {
		boolean acheteurConnu=controlAcheterProduit.verifierIdentite(nomAcheteur);
		if (!acheteurConnu) {
			System.out.println("Je suis désolée Bonemine mais il faut être un habitant de notre village pour commercer ici.");	
		}
		else {
			System.out.println("Quel produit voulez-vous acheter ?");
			StringBuilder question = new StringBuilder();
			String produit = Clavier.entrerChaine(question.toString());
			String[] vendeurs=controlAcheterProduit.donnerVendeur(produit);
			if (vendeurs==null) {
				System.out.println("Désolé, personne ne vend ce produit au marché.");
			}
			else {
				System.out.println("Chez quel commerçant voulez-vous acheter des fleurs ?");
				for(int i=0; i<vendeurs.length;i++) {
					System.out.println((i+1)+" - "+vendeurs[i]);
				}
				int idVendeur = Clavier.entrerEntier(question.toString());
				String vendeurChoisi=vendeurs[idVendeur-1];
				System.out.println("Combien de " + produit + " voulez-vous acheter ?");
				int nbProduitVoulu = Clavier.entrerEntier(question.toString());
				int nbProduitRest=controlAcheterProduit.acheterProduit(vendeurChoisi, nbProduitVoulu);
				if (nbProduitRest==0) {
					System.out.println(nomAcheteur+" veut acheter "+nbProduitVoulu+" "+produit+", malheureusement il n’y en a plus !");
				}
				if (nbProduitRest<nbProduitVoulu) {
					System.out.println(nomAcheteur+" veut acheter "+nbProduitVoulu+" "+produit+", malheureusement "+vendeurChoisi+" n’en plus que"+nbProduitRest+". "+nomAcheteur+" achète tout le stock de "+vendeurChoisi+".");
				}
				if (nbProduitRest>=nbProduitVoulu) {
					System.out.println(nomAcheteur+" achète "+nbProduitVoulu+" "+produit+"à"+vendeurChoisi);
				}
			}
		}
	}
}
