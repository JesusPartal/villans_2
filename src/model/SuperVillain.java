package model;

import java.util.Random;

public class SuperVillain extends SuperThing {

	private int badnessPower;
	
	public SuperVillain() {
		super();
		Random random = new Random();
		badnessPower = random.nextInt(100) + 1;
	}
	
	public int getBadnessPower() {
		return badnessPower;
	}
	
	@Override
	public String getStats() {
		return "Health Poinst: " + this.getHealthPoints() +
				" - Badnesspower Points:" + this.getBadnessPower();
	}
}
