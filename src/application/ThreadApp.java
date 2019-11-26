package application;

import java.util.Random;
import model.Person;
import model.SuperVillain;
import model.VillainFactory;
import model.enums.VillainType;

public class ThreadApp extends Thread {
	
	private int cadency, spawns;
	
	public ThreadApp(int cadency, int spawns) {
		this.cadency = cadency;
		this.spawns = spawns;
	}
	
	@Override
	public void run() {
		boolean isVillain;
		
		for (int i = 0; i <= spawns; i++) {
			try {
				isVillain = getRandomBoolean();
				Person newPerson = generatePerson(isVillain);
				System.out.println(newPerson.getClass().getName() 
						+ " --- "
						+ newPerson.getStats());
				Thread.sleep(cadency);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public Person generatePerson(boolean isVillain) {
		if (isVillain) {
			boolean isStrong = getRandomBoolean();
			SuperVillain superVillain = (isStrong) 
					? VillainFactory.buildVillain(VillainType.BADSTRONGMAN) 
							: VillainFactory.buildVillain(VillainType.BADFLYPERSON);
			// TODO save to file
			return superVillain;
		} else {
			return new Person();
		}
	}
	
	public boolean getRandomBoolean() {
		Random random = new Random();
		return random.nextBoolean();
	}
}

