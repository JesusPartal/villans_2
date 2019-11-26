package application;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		Scanner scanChoice = new Scanner(System.in);
		int choiceInput = -1;
		int cadency = -1;
		int spawns = -1;
		
		System.out.println("Welcome to Villain Generator 2.0\n");
		System.out.println("Please select the app functionality you want to try:");
		System.out.println("----------------------------------------------------");
		System.out.println("\t1. Using Threads with yield(), join(), priority()");
		System.out.println("\t2. Using Threads; extending the Thread class and using the Runnable interface");
		System.out.println("\t3. Using Java Thread Pools (Executor); FixedThreadPool and CachedThreadPool");
		System.out.println("\t4. Using synchronization; synchronization keyword and using locks");
		System.out.println("\t5. Using await(), singal(), and singalall()");
		System.out.println("\n\t0. Exit application");
		
		choiceInput = integerValidatorWithMessage(scanChoice, 0, 5, "Please select your choice (0-5)> ");
		
		switch(choiceInput){
			case 0:
				System.out.println("Bye!");
				System.exit(0);
				break;
	        case 1:
	            System.out.println("Case " + choiceInput);
	            break;
	        case 2:
	        	System.out.println("Case " + choiceInput);
	            break;
	        case 3:
	        	System.out.println("Case " + choiceInput);
	            break;
	        case 4:
	        	System.out.println("Case " + choiceInput);
	            break;
	        case 5:
	        	System.out.println("Case " + choiceInput);
	            break;
		}
		
		cadency = integerValidatorWithMessage(scanChoice, 1, 30, "Please select the cadency (time in seconds between spawns (1-30): ");
		spawns = integerValidatorWithMessage(scanChoice, 1, 100, "Please select number of spawns (1-100):");
           
		scanChoice.close();
	}
	
	/**
	 * 
	 * @param scanner
	 * @param min
	 * @param max
	 * @param message
	 * @return
	 */
	public static int integerValidatorWithMessage(Scanner scanner, int min, int max, String message) {
		boolean validated = false;
		int intValidated = -1;
		do {
			System.out.print(message);
			try {
				intValidated = scanner.nextInt();
				if (intValidated >= min && intValidated <= max) {
					validated = true;
				} else {
					System.out.println("Invalid selection; must be between" + min + " and " + max);
					scanner.nextLine();
				}
			} catch (Exception exception) {
				System.out.println("Invalid selection; not a number");
					scanner.nextLine();
			}			
		} while (!validated);
		return intValidated;
	}
}
