package cn.cdutetc.example12;

/**
 * ��Ʊ����ͨ��ʵ�� Runnable�ӿڵķ�ʽ���������߳�
 */
public class SaleTickets_R {
	public static void main(String[] args) {
		TicketWindow_R task = new TicketWindow_R();//�����̵߳����������
		new Thread(task, "����1").start();//�����̲߳�����Ϊ����1�� �����߳�
		new Thread(task, "����2").start();//�����̲߳�����Ϊ����2�� �����߳�
		new Thread(task, "����3").start();//�����̲߳�����Ϊ����3�� �����߳�
	}
}

//�̵߳�������
class TicketWindow_R implements Runnable {
	private int tickets = 10;
	Object lock=new Object();
	@Override
	public void run() {
		
		while(true){
			synchronized(lock)
			{
			  if (tickets > 0) {
				Thread th = Thread.currentThread();//��ȡ��ǰ����run�������߳�
				String th_name = th.getName();//�õ��̵߳�����
					  try { Thread.sleep(10); } 
					  catch (InterruptedException e)
					  {  e.printStackTrace(); }
					 
				System.out.println(th_name + "���ڷ��۵�" + tickets-- + "��Ʊ");
			}
			  else
			  {
				  break;
			  }
		  }
		}
	}
}