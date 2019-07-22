package cn.cdutetc.example6;
public class OuterB {
	private int a = 200;
	int b = 35;
	public class InnerB {
		int b = 6;
		public void test() {
			System.out.println("访问外部类中的a:" + a);
			System.out.println("访问外部类中的b:" + OuterB.this.b);
		}
	}
	public static void main(String[] args) {
		OuterB o = new OuterB();
		InnerB i = o.new InnerB();
		i.test();
	}
}