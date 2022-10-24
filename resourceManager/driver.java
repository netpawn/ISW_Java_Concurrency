package it.unipr.informatica.exam.luglio5.resourceManager;

import java.util.Random;

public class driver {
	public static void main(String[] args) {
		new driver().go(); 
	}
	
	public void go() {
		int N=50; 
		ResourceManagerImpl manager = new ResourceManagerImpl(N); //creiamo un manager 
		manager.printFrees(); 
		
		for(int i=0; i<N; i++) {
			new InnerThread(manager, N).start(); //e creiamo tanti thread quante sono le risorse disponibili 
		}
	}
	
	private static class InnerThread extends Thread{ //creiamo un inner thread che usa il manager per fare le richieste 
	
		private ResourceManager manager; 
		private int N; 
		
		
		public InnerThread(ResourceManager manager, int N) {
			this.manager = manager; 
			this.N = N; 
		}
		
		@Override 
		public void run() { //Un thread acquisisce una risorsa se disponibile per 200ms, poi la libera 
			for(int i=0; i<10; i++) {
				int val = new Random().nextInt(N); 
				
				System.out.println("Thread no." + currentThread().getId() + " will use resource no." + val + " and " + ((val+1)%N));
				manager.acquireResource(val); 
				
				try {
					Thread.sleep(200);
				}catch(InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("Thread no." + currentThread().getId() + " is done. Releasing respirce no." + val + " and " + ((val+1)%N));
				manager.freeResource(val);
			}
		}
	}
}
