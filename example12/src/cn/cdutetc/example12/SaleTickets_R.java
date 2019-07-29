package cn.cdutetc.example12;

/**
 * 售票程序，通过实现 Runnable接口的方式来创建多线程
 */
public class SaleTickets_R {
	public static void main(String[] args) {
		TicketWindow_R task = new TicketWindow_R();//创建线程的任务类对象
		new Thread(task, "窗口1").start();//创建线程并起名为窗口1， 开启线程
		new Thread(task, "窗口2").start();//创建线程并起名为窗口2， 开启线程
		new Thread(task, "窗口3").start();//创建线程并起名为窗口3， 开启线程
	}
}

//线程的任务类
class TicketWindow_R implements Runnable {
	private int tickets = 10;
	Object lock=new Object();
	@Override
	public void run() {
		
		while(true){
			synchronized(lock)
			{
			  if (tickets > 0) {
				Thread th = Thread.currentThread();//获取当前运行run方法的线程
				String th_name = th.getName();//得到线程的名称
					  try { Thread.sleep(10); } 
					  catch (InterruptedException e)
					  {  e.printStackTrace(); }
					 
				System.out.println(th_name + "正在发售第" + tickets-- + "张票");
			}
			  else
			  {
				  break;
			  }
		  }
		}
	}
}