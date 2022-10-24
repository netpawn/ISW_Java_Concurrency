package it.unipr.informatica.exam.giugno21.fence;
import java.util.LinkedList;

public class Driver {
	
	public void go() {
		Object mutex = new Object(); 
		LinkedList<Object> collection = new LinkedList<Object>();
		FenceImpl fence = new FenceImpl(collection, mutex); 
		
		
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				
				Object o1 = new Object(); 
				Object o2 = new Object(); 
				Object o3 = new Object(); 
				Object o4 = new Object(); 
				o1=1; o2=2; o3=3; o4=4; 
				
				fence.add(o1);
				fence.add(o2);
				fence.printcoll(); 
				try {
					fence.await();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				fence.add(o3);
				fence.add(o3);
				fence.add(o4);
				fence.printcoll();
				
			} 
		});
		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					Thread.sleep(5000);
					fence.notifycoll(); 
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
			} 
		});
		t1.start(); 
		t2.start();
	}
	
	public static void main(String[] args) {
		new Driver().go(); 
	}

}
