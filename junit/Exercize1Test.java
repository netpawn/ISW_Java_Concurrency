package it.unipr.informatica.exam.giugno21.junit;

import org.junit.jupiter.api.Test;
//import static org.junit.Assert.*;  unsupported  

public class Exercize1Test {
	
	@SuppressWarnings("unused")
	@Test //(expected=IllegalArgumentException.class) unsupported
	public void sIsNull() {
		Exercize1 e1 = new Exercize1(""); 
		
	}
	@SuppressWarnings("unused")
	@Test
	public void sIsNull2() {
		Exercize1 e2 = new Exercize1(null);
	}
	
	@Test
	public void lIsNull() {
		Exercize1 e = new Exercize1("test");
		e.search(null); 
	}

}
