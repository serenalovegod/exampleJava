package cn.cdutetc.example5;

public class TestAnimal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Dog dog=new Dog();
        Cat cat=new Cat();
        whoIsDoingSomthing(dog);
        whoIsDoingSomthing(cat);
	}
	
	public static void whoIsDoingSomthing(AnimalAction ac)
	{
		ac.eat();
		ac.shout();
		ac.run();
		ac.sleep();
	}
}
