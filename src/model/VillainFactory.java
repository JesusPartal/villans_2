package model;

import model.enums.VillainType;

public class VillainFactory {
	
	public static SuperVillain buildVillain(VillainType type) {
	
		SuperVillain superVillain = null;
		
		switch(type) {
		case BADSTRONGMAN:
			superVillain = new BadStrongMan();
			break;
		case BADFLYPERSON:
			superVillain = new BadFlyPerson();
			break;
		default:
			break;
		}
		
		return superVillain;
	}
}
