package cn.cdutetc.example4;

public class Dog extends Animal{
	
	Dog()
	{
		super("���","��ɫ",6,'M');
	}
	public void shout()
	{
		
		System.out.println("dog is shoutting");
	}
	public void shout(String name)
	{
		System.out.println(name+" is shoutting");
	}
	public void shout(int age)
	{
		//return "hello";
	}
	public void shout(String name,String color)
	{
		System.out.println(color+name+" is shoutting");
	}
	public void print()
	{
		if(sex=='M')
		System.out.println(color+"��"+name+age+"��");
		else
			System.out.println(color+"Ů"+name+age+"��");	
	}
}
