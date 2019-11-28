package application;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Client {
	private static int cadency, spawns;
	private static SubAppInterface subApp;
	private static int port = 8000;
	private static String host = "127.0.0.1";
	DataInputStream in;
	DataOutputStream out;
	public static Socket socket;
	
	public static void main(String[] args) throws InterruptedException, UnknownHostException, IOException {
		
		Scanner scanChoice = new Scanner(System.in);
		int choiceInput = -1;
		socket = new Socket(host, port);
		System.out.println("Connecting to: " + host + ":" + port);

		System.out.println("Welcome to Villain Generator 2.0\n");
		System.out.println("Please select the app functionality you want to try:");
		System.out.println("----------------------------------------------------");
		System.out.println("\t1. Using Threads with yield(), join(), priority()");
		System.out.println("\t2. Using Threads; extending the Thread class and using the Runnable interface");
		System.out.println("\t3. Using Java Thread Pools (Executor); FixedThreadPool and CachedThreadPool");
		System.out.println("\t4. Using synchronization; synchronization keyword and using locks");
		System.out.println("\t5. Using await(), singal(), and singalall()");
		System.out.println("\n\t0. Exit application");
		System.out.println("----------------------------------------------------\n");

		choiceInput = integerValidatorWithMessage(scanChoice, 0, 5, "Please select your choice (0-5)> ");
		
		switch(choiceInput){
			case 0:
				System.out.println("Bye!");
				scanChoice.close();
				System.exit(0);
				break;
	        case 1:
	            System.out.println("Case " + choiceInput);
	            getSpawnAndCadency(scanChoice);
	            subApp = (SubAppInterface) new ThreadApp(cadency, integerDividedByTwo(spawns));
	            subApp.runSubApp();
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

		scanChoice.close();
	}

	
	public void createSocket() {
		try {
			socket = new Socket(host, port);
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void getSpawnAndCadency(Scanner scanChoice) {
		cadency = integerValidatorWithMessage(scanChoice, 1, 30, "Please select the cadency (time in seconds between spawns (1-30)>") * 1000;
		spawns = integerValidatorWithMessage(scanChoice, 1, 100, "Please select number of spawns (1-100)> ");
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
	
	public static List<Integer> integerDividedByTwo(int a) {
		if (a % 2 == 0)
			return Arrays.asList(a/2, a/2);
		return Arrays.asList(a/2 + 1, a/2);
	}
}
