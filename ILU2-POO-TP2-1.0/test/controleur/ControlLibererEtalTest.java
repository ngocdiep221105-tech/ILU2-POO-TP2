package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import villagegaulois.Village;

class ControlLibererEtalTest {
	private Village village;
	private Chef abraracourcix;
	
	@BeforeEach
	public void initialiserSituation() {
		System.out.println("Initialisation...");
		village= new Village("le village des irréductibles",10,5);
		abraracourcix=new Chef("Abraracourcix", 10, village);
		village.setChef(abraracourcix);
	}
	
	@Test
	void testControlLibererEtal() {
		ControlTrouverEtalVendeur controlTrouverEtalVendeur=new ControlTrouverEtalVendeur(village);
		ControlLibererEtal controlLibererEtal=new ControlLibererEtal(controlTrouverEtalVendeur);
		assertNotNull(controlLibererEtal,"Constructeur ne renvoie pas null");
	}

	@Test
	void testIsVendeur() {
		ControlTrouverEtalVendeur controlTrouverEtalVendeur=new ControlTrouverEtalVendeur(village);
		ControlLibererEtal controlLibererEtal=new ControlLibererEtal(controlTrouverEtalVendeur);
		controlTrouverEtalVendeur.trouverEtalVendeur("Bonemine");
		assertFalse(controlLibererEtal.isVendeur("Bonemine"));
		
		
	}

	@Test
	void testLibererEtal() {
		ControlTrouverEtalVendeur controlTrouverEtalVendeur=new ControlTrouverEtalVendeur(village);
		ControlLibererEtal controlLibererEtal=new ControlLibererEtal(controlTrouverEtalVendeur);
		controlLibererEtal.libererEtal("Bonemine");
	}

}
