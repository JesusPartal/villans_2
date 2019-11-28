package model;

import model.interfaces.StrengthInterface;

public class BadStrongMan extends SuperVillain implements StrengthInterface {

	private static final long serialVersionUID = 1L;

	public BadStrongMan() {
		super();
//		evilLaugh();
//		strength();
//		createChaos();
	}
	
	public void strength() {
		System.out.println("BadStrongMan is using this super strength...");
	}
	
	public void evilLaugh() {
		System.out.println("Muahahahaha!!!");
	}
	
	public void createChaos() {
		System.out.println("BadStrongMan is creating chaos...");
	}
	
	@Override
	public String getStats() {
		return "BADSTRONGMAN -> Health Poinst: " + this.getHealthPoints() +
				" - Badnesspower Points: " + this.getBadnessPower();
	}
}
