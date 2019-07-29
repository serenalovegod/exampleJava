package cn.cdutetc.example12;
/**
 * 售票程序，通过继承Thread类的方式来实现多线程的创建
 */
public class SaleTickets {
	public static void main(String[] args) {
		new TicketWindow("窗口1").start(); // 创建第一个线程对象TicketWindow并开启
		new TicketWindow("窗口2").start(); // 创建第二个线程对象TicketWindow并开启
		new TicketWindow("窗口3").start(); // 创建第三个线程对象TicketWindow并开启
	}
}
class TicketWindow extends Thread {
	private int tickets = 10;
	public TicketWindow(String name) {
		// TODO Auto-generated constructor stub
		super(name);
	}
	public void run() {
	        while(true)// 通过死循环语句打印语句
			if (tickets > 0) {
				Thread th = Thread.currentThread(); // 获取当前线程
				String th_name = th.getName(); // 获取当前线程的名字
				System.out.println(th_name + " 正在发售第 " + tickets-- + " 张票 ");
			}
		}
	}
