package storage;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import model.Person;
import model.SuperVillain;

public class FileStorageController implements Serializable {

	private static final long serialVersionUID = 1L;

	private static String DIRECTORY = "../BattleFolder/";
	private static String FILENAME = "battlezone_";
	private static String FILE_EXTENSION = ".txt";
	private  int fileNumber;
	
	public FileStorageController() {
		
		getFileNumber();
	}
	
	public synchronized void getFileNumber() {
		
		int checkNumber = 1;
		
		File file = new File(DIRECTORY
				+ FILENAME
				+ checkNumber
				+ FILE_EXTENSION);
		
		while(file.exists()) {
			checkNumber++;
			file = new File(DIRECTORY
					+ FILENAME
					+ checkNumber
					+ FILE_EXTENSION
					);
		}
		this.fileNumber = checkNumber;
	}
	
	public synchronized void saveVillain(Person villain) {
		
		String savePath = DIRECTORY 
						+ FILENAME
						+ fileNumber
						+ FILE_EXTENSION;
		File savedFile = new File(savePath);
		
		if(!savedFile.getParentFile().exists())
			savedFile.getParentFile().mkdir();
		
		try {
			System.out.println("saving "  + savePath);
			storeObject(villain, savePath);
		} catch (Exception errorWritingToFile){
			System.out.println("Error while writing file...");
		}
		fileNumber++;
	}
	
	public static void storeObject(Object object, String filename) {
		
		try {
			FileOutputStream fileOutput = new FileOutputStream(filename);
			ObjectOutputStream objectOutput = new ObjectOutputStream(fileOutput);
			
			objectOutput.writeObject(object);
			objectOutput.close();
			fileOutput.close();
		} catch (IOException iOException) {
			storeObject(iOException, "IOException.ser");
		}
	}
	
}
