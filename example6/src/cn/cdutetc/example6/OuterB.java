package cn.cdutetc.example6;
public class OuterB {
	private int a = 200;
	int b = 35;
	public class InnerB {
		int b = 6;
		public void test() {
			System.out.println("�����ⲿ���е�a:" + a);
			System.out.println("�����ⲿ���е�b:" + OuterB.this.b);
		}
	}
	public static void main(String[] args) {
		OuterB o = new OuterB();
		InnerB i = o.new InnerB();
		i.test();
	}
}