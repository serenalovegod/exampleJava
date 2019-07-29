package cn.cdutetc.example12;

public class TestThreadPriority {
	public static void main(String[] args) {
		//创建两个线程
		Thread minPriority = new Thread(new MyRunnable3(), "优先级较低的线程 ");
		Thread maxPriority = new Thread(new MyRunnable3(), "优先级较高的线程 ");
		minPriority.setPriority(Thread.MIN_PRIORITY); //设置线程的优先级为1  
		maxPriority.setPriority(Thread.MAX_PRIORITY); //设置线程的优先级为10
		//开启两个线程
		minPriority.start();
		maxPriority.start();
	}

}
class MyRunnable3 implements Runnable {
	@Override
	public void run() {
		for (int i = 0; i < 5; i++) {
			System.out.println(Thread.currentThread().getName() + "正在输出" + i);
		}
	}
}
