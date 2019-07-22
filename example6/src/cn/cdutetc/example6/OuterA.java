package cn.cdutetc.example6;
public class OuterA{
	public void print() {
		System.out.println("这是外部类");
	}
	public class InnerA {
		public void print() {
			System.out.println("这是内部类");
		}
	}
	public void test()
	{
		InnerA in=new InnerA();
		in.print();
	}
} 

