package cn.cdutetc.example12;

import java.io.IOException;

public class TestThreadInterrupt {
	 public static void main(String[] args)  {
	       
	        Thread t = new Thread(new MyRunnable2(),"���߳�");
	        t.start();
	       t.interrupt();
	    }  

}
class MyRunnable2 implements Runnable{
    @Override
    public void run() {
        try {
            System.out.println("����˯��״̬");
            Thread.currentThread();
			Thread.sleep(10000);
            System.out.println("˯�����");
        } catch (InterruptedException e) {
            System.out.println("�õ��ж��쳣");
        }
        System.out.println("run����ִ�����");
    }
}

