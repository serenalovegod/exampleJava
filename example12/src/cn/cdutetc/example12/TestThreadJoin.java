package cn.cdutetc.example12;

public class TestThreadJoin {
	public static void main(String args[]) throws Exception {
		Thread t = new Thread(new MyRunnable1(),"���߳�" );
		System.out.println("���߳�main ��ʼִ�С�");
		t.start();
		System.out.println("���߳�main �ȴ����߳�ִ�С���");
		t.join();
		System.out.println("���߳�main ����ִ�С�");
	}
   }

class MyRunnable1 implements Runnable {
	public void run() {
		System.out.println(Thread.currentThread().getName()+ "��ʼִ�С�");
		System.out.println(Thread.currentThread().getName()+ "����ִ�С���");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			System.out.println("interrupted!");
		}
		System.out.println(Thread.currentThread().getName() + "����ִ�С�");
	}
}