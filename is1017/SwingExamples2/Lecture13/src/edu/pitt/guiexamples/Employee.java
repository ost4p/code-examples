package edu.pitt.guiexamples;

public class Employee extends Person{
	double salary;

	public Employee(String name){
		super(name);
		salary = 1000.0;
	}
	
	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}
	@Override
	public String introduceMyself(){
		return "Hello, my name is "+getName()+" and I am an employee";
	}
	
	@Override
	public String toString(){
		return getName() + " (employee)";
	}
}
