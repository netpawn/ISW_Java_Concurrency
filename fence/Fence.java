package it.unipr.informatica.exam.giugno21.fence;

public interface Fence {
	public void await() throws InterruptedException; 
	public void add(Object o); 
}
