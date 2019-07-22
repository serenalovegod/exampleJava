package cn.cdutetc.example6;

public class OuterD {
	private String name="¹ó±ö";
	   private class InnerTest {
	   public InnerTest() {	
		   System.out.println(name);
	       }
}
public void test() {
		   new InnerTest();
	   }	 
public static void main(String args[]) {
	     OuterD out=new OuterD();
	     out.test();
}
}