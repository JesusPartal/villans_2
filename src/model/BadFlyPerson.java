package model;

import model.interfaces.FlyInterface;

public class BadFlyPerson extends SuperVillain implements FlyInterface {
	
	public BadFlyPerson() {
		super();
		evilLaugh();
		fly();
		createChaos();
	}
	
	public void fly() {
		System.out.println("BadFlyPerson is using his fly power");
	}
	
	public void evilLaugh() {
		System.out.println("Muahahaha!!!");
	}
	
	public void createChaos() {
		System.out.println("BadFlyPerson is creating chaos...");
	}
}
