package cn.cdutetc.example5;

public class Cat extends Animal implements AnimalAction {
	public Cat()
	{
		
	}

	public Cat(String name, String color, int age, char sex) {
		super(name, color, age, sex);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void shout() {
		// TODO Auto-generated method stub
		System.out.println("Cat is shouting");
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("Cat is running");
		
	}

	@Override
	public void sleep() {
		// TODO Auto-generated method stub
		System.out.println("Cat is sleeping");
		
	}

	@Override
	public void eat() {
		// TODO Auto-generated method stub
		System.out.println("Cat is eating");
		
	}
}
