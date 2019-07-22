package cn.cdutetc.example4;

public class Animal
{
    String color;
    int age;
    char sex;
    String name;
    public Animal()
{
}
    public Animal(String name,String color,int age,char sex)
{
    this.name=name;
    this.color=color;
    this.age=age;
    this.sex=sex;
}
    public void shout()
{
     System.out.println("it¡¯s shouting!");
}
public void jump()
{
     System.out.println("it¡¯s jumping!");
}
    public void run()
{
     System.out.println("it¡¯s running!");
}
  public void sleep()
{
     System.out.println("it¡¯s sleep!");
}
}

