package cn.cdutetc.example6;
public class TestOuter {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		OuterA out=new OuterA();
		out.print();
		OuterA.InnerA in=new OuterA().new InnerA();
		in.print();		
	}
}
