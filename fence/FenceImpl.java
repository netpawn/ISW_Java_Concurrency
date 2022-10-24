package it.unipr.informatica.exam.giugno21.fence;
import java.util.LinkedList; 

public class FenceImpl implements Fence{
	
	private LinkedList<Object> collection; 
	private Object mutex; 
	static boolean iswaiting = false; 
	
	public FenceImpl(LinkedList<Object> collection, Object mutex) {
		this.mutex = mutex; 
		this.collection = collection; 
	}

	@Override
	public void await() throws InterruptedException {
		synchronized(mutex){
			try {
				for(Object o:collection)
					System.out.println("wait on " + o); 
					mutex.wait(); 
			} catch (InterruptedException e) {
				e.printStackTrace();
			} 
		}
	}

	@Override
	public void add(Object o) {
		collection.add(o); 		
	}
	
	public void notifycoll() {
		synchronized(mutex){
			for(Object o:collection)
				System.out.println("notify on " + o);
				mutex.notifyAll(); 
		}
	}
	public void printcoll() {
		for(Object o:collection)
			System.out.println(o); 
	}

}
