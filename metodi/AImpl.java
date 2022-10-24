package it.unipr.informatica.exam.giugno7.metodi;

public class AImpl implements A{
	B b; 
	BImpl bimpl; 
	
	/*
	 * Il metodo inizia creando 3 oggetti di classe BImpl implementando B,
	 * e chiamando mb1() su ognuno dei 3 oggetti.
	 * Il metodo prosegue mettendosi in attesa che tutte e tre le chiamate ai 
	 * metodi mb2() terminino usando i rispettivi valori di ritorno. 
	 * Il metodo termina 
	 */
	@Override
	public void ma() throws InterruptedException {
		B b1 = new BImpl(); 
		B b2 = new BImpl(); 
		B b3 = new BImpl(); 
		
		Object o1 = b1.mb1(); 
		Object o2 = b2.mb1(); 
		Object o3 = b3.mb1(); 
		
		
		synchronized(o1){
			System.out.println("Mando la wait su o1"); 
			o1.wait(); 
			System.out.println("o1 ha terminato "); 
		}
		synchronized(o2){
			System.out.println("Mando la wait su o2"); 
			o2.wait(); 
			System.out.println("o2 ha terminato "); 
		}
		synchronized(o3){
			System.out.println("Mando la wait su o3"); 
			o3.wait(); 
			System.out.println("o3 ha terminato "); 
		}
		
		
	}
	
	public void go() {
		try {
			ma();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} 
	}
	
	public static void main(String[] args) {
		new AImpl().go(); 
	}
	

}
