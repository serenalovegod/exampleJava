package cn.cdutetc.example5;

public class Dog extends Animal implements AnimalAction{
	public Dog()
	{
		
	}
	public Dog(String name,String color,int age,char sex)
	{
		super(name,color,age,sex);
	}

	@Override
	public void shout() {
		// TODO Auto-generated method stub
		System.out.println("dog is shouting");
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("dog is running");
	}

	@Override
	public void sleep() {
		// TODO Auto-generated method stub
		System.out.println("dog is sleeping");
		
	}

	@Override
	public void eat() {
		// TODO Auto-generated method stub
		System.out.println("dog is eating");
		
	}

	@Override
	public String toString() {
		return this.color+this.sex+this.name+"very cute";
	}
	
}
