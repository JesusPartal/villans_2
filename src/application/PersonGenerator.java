package application;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Random;

import model.Person;
import model.SuperVillain;
import model.VillainFactory;
import model.enums.VillainType;
import storage.FileStorageController;

public class PersonGenerator {
	private boolean isVillain;
	FileStorageController fSC;
	private ObjectOutputStream toServer;
	
	public Person getPerson() {
		fSC = new FileStorageController();
		isVillain = getRandomBoolean();
		if (isVillain) {
			boolean isStrong = getRandomBoolean();
			SuperVillain superVillain = (isStrong) 
					? VillainFactory.buildVillain(VillainType.BADSTRONGMAN) 
							: VillainFactory.buildVillain(VillainType.BADFLYPERSON);
			fSC.saveVillain(superVillain);
			try {
				toServer = new ObjectOutputStream(Client.socket.getOutputStream());
				toServer.writeObject(superVillain);
			} catch (IOException e) {
				e.printStackTrace();
			}
			return superVillain;
		}
		return new Person();
	}
	
	private boolean getRandomBoolean() {
		Random random = new Random();
		return random.nextBoolean();
	}
	
}
