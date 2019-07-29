package cn.cdutetc.example12;

public class TestThreadPriority {
	public static void main(String[] args) {
		//���������߳�
		Thread minPriority = new Thread(new MyRunnable3(), "���ȼ��ϵ͵��߳� ");
		Thread maxPriority = new Thread(new MyRunnable3(), "���ȼ��ϸߵ��߳� ");
		minPriority.setPriority(Thread.MIN_PRIORITY); //�����̵߳����ȼ�Ϊ1  
		maxPriority.setPriority(Thread.MAX_PRIORITY); //�����̵߳����ȼ�Ϊ10
		//���������߳�
		minPriority.start();
		maxPriority.start();
	}

}
class MyRunnable3 implements Runnable {
	@Override
	public void run() {
		for (int i = 0; i < 5; i++) {
			System.out.println(Thread.currentThread().getName() + "�������" + i);
		}
	}
}
