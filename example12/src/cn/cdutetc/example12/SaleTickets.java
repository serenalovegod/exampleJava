package cn.cdutetc.example12;
/**
 * ��Ʊ����ͨ���̳�Thread��ķ�ʽ��ʵ�ֶ��̵߳Ĵ���
 */
public class SaleTickets {
	public static void main(String[] args) {
		new TicketWindow("����1").start(); // ������һ���̶߳���TicketWindow������
		new TicketWindow("����2").start(); // �����ڶ����̶߳���TicketWindow������
		new TicketWindow("����3").start(); // �����������̶߳���TicketWindow������
	}
}
class TicketWindow extends Thread {
	private int tickets = 10;
	public TicketWindow(String name) {
		// TODO Auto-generated constructor stub
		super(name);
	}
	public void run() {
	        while(true)// ͨ����ѭ������ӡ���
			if (tickets > 0) {
				Thread th = Thread.currentThread(); // ��ȡ��ǰ�߳�
				String th_name = th.getName(); // ��ȡ��ǰ�̵߳�����
				System.out.println(th_name + " ���ڷ��۵� " + tickets-- + " ��Ʊ ");
			}
		}
	}
