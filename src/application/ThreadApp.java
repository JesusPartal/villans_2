package application;

import java.io.IOException;
import java.net.UnknownHostException;
import java.util.List;

import threads.ThreadVillainsGenerator1;

public class ThreadApp implements SubAppInterface{
	
	private List<Integer> spawns;
	private int cadency;
	
	public ThreadApp(int cadency, List<Integer> spawns) throws UnknownHostException, IOException {
		System.out.println("Launching Sub Application 1");
		this.cadency = cadency;
		this.spawns = spawns;
	}

	
	@Override
	public void runSubApp() throws InterruptedException {
		System.out.println("Launching Thread-0 and Thread-1");
		ThreadVillainsGenerator1 t1 = new ThreadVillainsGenerator1(cadency, spawns.get(0));
		ThreadVillainsGenerator1 t2 = new ThreadVillainsGenerator1(cadency, spawns.get(1));
		
		t1.setPriority(1);
		t2.setPriority(10);
		
		t1.join();
		t2.join();
		
		t1.start();
		t2.start();
	}

}

;