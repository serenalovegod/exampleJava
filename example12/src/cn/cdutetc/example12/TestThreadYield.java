package cn.cdutetc.example12;

public class TestThreadYield {
	public static void main(String[] args) {
		Thread t2 = new Thread(new MyRunnable(),"线程1");
		Thread t1 =new Thread(new MyRunnable(),"线程2");
		t2.start();
		t1.start();
	}

}

class MyRunnable implements Runnable {
	public void run() {
		for (int i = 1; i <= 5; i++) {
			System.out.println(Thread.currentThread().getName() + "第"+i + "次执行！");
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
