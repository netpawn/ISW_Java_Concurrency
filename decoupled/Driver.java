package it.unipr.informatica.exam.giugno7.decoupled;

public class Driver {
	
	private void go() {
		 
		Student student = new StudentData("John", "Johnson", 18);
		student = DecoupledAspect2.attach(student); 
		
		System.out.println("Age: " + student.getAge());
		System.out.println("Name: " + student.getName());
		System.out.println("Surname: " + student.getSurname());
		
		student.create(); 
		student.study();
		student.rest(); 
		
		
		
	

		System.out.println();
		
	}
	
	public static void main(String[] args) {
		new Driver().go(); 
	}
	


}
