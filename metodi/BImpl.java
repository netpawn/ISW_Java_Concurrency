package it.unipr.informatica.exam.giugno7.metodi;

public class BImpl implements B {
	
	private Object o; 
	
	public BImpl() {
		this.o = new Object(); 
	}

	/*
	 * Il metodo mb1: 
	 * inizia creando un thread in cui viene eseguito mb2()
	 * Termina immediatamente ritornando un oggetto che può essere usato per mettersi 
	 * in attesa della terminazione della chiamata al metodo mb2() appena fatta. 
	 */
	@Override
	public Object mb1() {
		synchronized(o){
			Thread t1 = new Thread(()->{
				mb2(); 
			});
			t1.start(); 
			System.out.println("Thread t1 started"); 
		}
		return o; 
	}

	/*
	 * Il metodo mb2:
	 * si mette in attesa per 5 secondi 
	 * termina segnalando la terminazione mediante l'oggetto che è stato ritornato 
	 * da mb1() che ha fatto la chiamata a mb2(); 
	 */
	@Override
	public void mb2() {
		try {
			Thread.sleep(5000);
			synchronized(o){
				System.out.println("Sleep done"); 
				o.notifyAll(); 
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		} 

	}
	
}
