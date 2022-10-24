package it.unipr.informatica.exam.luglio5.resourceManager;

public class Resource {
	
	private int id; 
	boolean busy = false;  
	
	public Resource(int id) {
		this.id = id; 
	}
	
	public void setId(int id) {
		this.id = id; 
	}
	public int getId() {
		return id;
	}
	
	public void setBusy() {
		busy = true; 
	}
	public void setFree() {
		busy = false; 
	}


}
