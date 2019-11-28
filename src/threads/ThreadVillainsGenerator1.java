package threads;

import application.PersonGenerator;
import model.Person;
import storage.FileStorageController;

public class ThreadVillainsGenerator1 extends Thread{
	private PersonGenerator personGenerator;
	private int cadency, spawns;
	
	public ThreadVillainsGenerator1(int cadency, int spawns) {
		this.cadency = cadency;
		this.spawns = spawns;
		personGenerator = new PersonGenerator();
	}
	
	public void run () {
		System.out.println("Starting " + this.getName());
		for (int i = 0; i < this.spawns; i++) {
			try {
				Person person = personGenerator.getPerson();
				System.out.println(this.getName() + " - " +person.getStats());
				Thread.sleep(cadency);
				Thread.yield();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
		System.out.println("Ending " + this.getName());
	}
	
	public static void savePerson(Person person) {
		
	}
}
