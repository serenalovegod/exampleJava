package cn.cdutetc.example6;

public class TestInner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       OuterC out=new OuterC();
       InterfaceA in=out.getIn();
       in.print();
	}

}
