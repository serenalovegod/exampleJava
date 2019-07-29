package cn.cdutetc.example12;

import java.io.IOException;

public class TestThreadInterrupt {
	 public static void main(String[] args)  {
	       
	        Thread t = new Thread(new MyRunnable2(),"子线程");
	        t.start();
	       t.interrupt();
	    }  

}
class MyRunnable2 implements Runnable{
    @Override
    public void run() {
        try {
            System.out.println("进入睡眠状态");
            Thread.currentThread();
			Thread.sleep(10000);
            System.out.println("睡眠完毕");
        } catch (InterruptedException e) {
            System.out.println("得到中断异常");
        }
        System.out.println("run方法执行完毕");
    }
}

