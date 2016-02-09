package edu.pitt.guiexamples;
public class Person{
	private String name;
	
	public Person(String name){
		this.name=name;
	}
	
	public void setName(String name){
		this.name = name;
	}
	public String getName(){
		return this.name;
	}
	
	public String introduceMyself(){
		return "Hello, my name is "+getName();
	}
	
	@Override
	public String toString(){
		return name;
	}

}
