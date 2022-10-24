package it.unipr.informatica.exam.giugno21.junit;

import java.util.List;

public class Exercize1 {
	private String s; 
	
	public Exercize1(String s) {
		if(s==null || s.length() == 0)
			throw new IllegalArgumentException("s is null or s is 0"); 
		
		this.s = s; 
	}
	
	public boolean search(List<String> l) {
		if(l==null)
			throw new IllegalArgumentException("l is null"); 
		
		for(String e:l) 
			if(s.equals(e))
				return true; 
			return false; 
	}
}
