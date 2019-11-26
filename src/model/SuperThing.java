package model;

import java.util.Random;

public abstract class SuperThing extends Person{
	
	private int healthPoints;
	
	public SuperThing() {
		Random random = new Random();
		this.healthPoints = random.nextInt(100) + 1;
	}
	
	public void setHealthPoints(int healthPoints) {
		this.healthPoints = healthPoints;
	}
	
	public int getHealthPoints() {
		return this.healthPoints;
	}
	
	public void receiveDamage(int damagePoints) {
		setHealthPoints(healthPoints - damagePoints);
	}

}
