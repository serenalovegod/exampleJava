package cn.cdutetc.example12;

public class TestThreadYield {
	public static void main(String[] args) {
		Thread t2 = new Thread(new MyRunnable(),"�߳�1");
		Thread t1 =new Thread(new MyRunnable(),"�߳�2");
		t2.start();
		t1.start();
	}

}

class MyRunnable implements Runnable {
	public void run() {
		for (int i = 1; i <= 5; i++) {
			System.out.println(Thread.currentThread().getName() + "��"+i + "��ִ�У�");
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
