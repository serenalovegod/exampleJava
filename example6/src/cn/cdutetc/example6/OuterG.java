package cn.cdutetc.example6;
public class OuterG{
	private int a = 100;
	static int b = 5;

	public static class Inner {
		int b = 3;
		public void test() {
			System.out.println("�ⲿ���b:" + OuterG.b);
			System.out.println("�ڲ����b:" + b);
			System.out.println("�ⲿ��ķǾ�̬����a:" + new OuterG().a);
		}
	}

	public static void main(String[] args) {
		Inner inner = new Inner();
		inner.test();
	}
}
