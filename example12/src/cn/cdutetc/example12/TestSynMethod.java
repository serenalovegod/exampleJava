package cn.cdutetc.example12;
public class TestSynMethod {
	public static void main(String[] args) {
		TicketWindow_N task = new  TicketWindow_N();//�����̵߳����������
		new Thread(task, "����1").start();//�����̲߳�����Ϊ����1�� �����߳�
		new Thread(task, "����2").start();//�����̲߳�����Ϊ����2�� �����߳�
		new Thread(task, "����3").start();//�����̲߳�����Ϊ����3�� �����߳�
	}
}
//�̵߳�������
class TicketWindow_N implements Runnable {
	boolean isFlag=true;
	private int tickets = 10;
	@Override
	public void run() {
		while(isFlag)
		{
			SaleTickets();
		}
		
	}
	synchronized void SaleTickets()
	{
			  if (tickets > 0) {
				Thread th = Thread.currentThread();//��ȡ��ǰ����run�������߳�
				String th_name = th.getName();//�õ��̵߳�����
			      try { Thread.sleep(10); 
			      }catch (InterruptedException e)
					  {
			    	  e.printStackTrace(); 
			    	  }
					 
				System.out.println(th_name + "���ڷ��۵�" + tickets-- + "��Ʊ");
			}
			  else
			  {
				  isFlag=false;
			  }
		}
	}