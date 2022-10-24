package it.unipr.informatica.exam.luglio5.resourceManager;

import java.util.ArrayList;

public class ResourceManagerImpl implements ResourceManager{
	private Object mutex;  //omg un mutex 
	private boolean[] frees; //array per risorse libere 
	int N; //numero risorse 
	ArrayList<Resource> list; //lista contenente le risorse
	
	public ResourceManagerImpl(int N) {
		this.N = N; 
		this.frees = new boolean[N]; 
		this.list = new ArrayList<Resource>();
		this.mutex = new Object(); 
		
		for(int i=0; i<N; i++) {
			list.add(new Resource(i)); 
			frees[i] = true; 
		}
	}

	@Override
	public void acquireResource(int i) {
		synchronized(mutex) {
			while(!(frees[i] && frees[(i+1)%N])) { //Vediamo se le risorse sono libere 
				System.out.println("Resources " + i + " and/or " + (i+1)%N + " are busy. Queueing request."); 
				try {
					mutex.wait(); //andiamo in coda se no 
				}catch(InterruptedException e) {
					e.printStackTrace();
				}
			}
			frees[i] = false; //settiamo la risorsa busy se la acquisiamo 
			frees[(i+1)%N] = false; 
			System.out.println("Reources " + i + " and " + (i+1)%N + " acquired"); //acquisiamo in caso contrario 
		}
		
	}

	@Override
	public void freeResource(int i) {
		synchronized(mutex) {
			frees[i] = true; //bool set libero 
			frees[(i+1)%N] = true; 
			
			System.out.println("Resources " + i + " and " + (i+1)%N + " freed."); //e liberiamo di nuovo 
			mutex.notifyAll(); 
		}
		
	}
	
	public void printFrees() { //funzione di controllo 
		for(int i=0; i<N; i++) {
			if(list.get(i).busy == true) {
				System.out.println(i + " is BUSY"); 
			}
			else System.out.println(i + " is FREE");
		}
	}

}
