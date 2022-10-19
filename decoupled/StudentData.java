package it.unipr.informatica.exam.giugno7.decoupled;

public class StudentData implements Student{
	
	private String name; 
	private String surname; 
	private int age; 
	
	public StudentData() {
		
	}
	
	public StudentData(String name, String surname, int age) {
		this.name = name; 
		this.surname = surname; 
		this.age = age;
	}

	@Override
	public Object study() {
		Object subject = new Object(); 
		subject = "math"; 
		System.out.println("Student " + name + " is now studying... " + subject);
		return subject; 
		
	}

	@Override
	public Object rest() {
		Object bed = new Object(); 
		bed = "bed"; 
		System.out.println("Student " + name + " is now resting on " + bed);
		return bed; 
		
	}
	
	@Override
	public Object create() {
		Object c = new Object(); 
		c = 1; 
		System.out.println("Creo oggetto");
		return c.toString(); 
	}
	
	public void setName(String name) {
		this.name = name; 
	}
	public void setSurname(String surname) {
		this.surname = surname; 
	}
	public void setAge(int age) {
		this.age = age; 
	}
	@Override
	public String getName() {
		return name; 
	}
	@Override
	public String getSurname() {
		return surname; 
	}
	@Override
	public int getAge() {
		return age; 
	}


}
