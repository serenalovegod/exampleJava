package cn.cdutetc.example6;
public class OuterA{
	public void print() {
		System.out.println("�����ⲿ��");
	}
	public class InnerA {
		public void print() {
			System.out.println("�����ڲ���");
		}
	}
	public void test()
	{
		InnerA in=new InnerA();
		in.print();
	}
} 

