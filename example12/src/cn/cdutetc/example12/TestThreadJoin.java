package cn.cdutetc.example12;

public class TestThreadJoin {
	public static void main(String args[]) throws Exception {
		Thread t = new Thread(new MyRunnable1(),"子线程" );
		System.out.println("主线程main 开始执行。");
		t.start();
		System.out.println("主线程main 等待子线程执行……");
		t.join();
		System.out.println("主线程main 结束执行。");
	}
   }

class MyRunnable1 implements Runnable {
	public void run() {
		System.out.println(Thread.currentThread().getName()+ "开始执行。");
		System.out.println(Thread.currentThread().getName()+ "正在执行……");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			System.out.println("interrupted!");
		}
		System.out.println(Thread.currentThread().getName() + "结束执行。");
	}
}