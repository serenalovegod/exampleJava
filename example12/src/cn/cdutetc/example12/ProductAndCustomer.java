package cn.cdutetc.example12;

//wait �� notify
public class ProductAndCustomer {
  public static void main(String[] args) {
      Resource resource = new Resource();
      //�������߳�
      ProducerThread p1 = new ProducerThread(resource);
      ProducerThread p2 = new ProducerThread(resource);
      ProducerThread p3 = new ProducerThread(resource);
      //�������߳�
      ConsumerThread c1 = new ConsumerThread(resource);
      p1.start();
      p2.start();
      p3.start();
      c1.start();
  }
}
/**
* �ֿ���
* @author 
*
*/
class Resource{
  //��ǰ��Ʒ����
  private int num = 0;
  //�ֿ��������ŵĲ�Ʒ��Ŀ
  private int size = 10;

  /**
   * �Ӳֿ���ȡ�߲�Ʒ,
   */
  public synchronized void remove(){
      if(num > 0){
          num--;
          System.out.println("������" + Thread.currentThread().getName() +
                  "����һ����Ʒ��" + "��ǰ�ֿ���" + num + "��");
          notifyAll();//֪ͨ������������Ʒ
      }else{
          try {
              //���û�в�Ʒ���������߽���ȴ�״̬
              wait();
              System.out.println("������" + Thread.currentThread().getName() + "�߳̽���ȴ�״̬");
          } catch (InterruptedException e) {
              e.printStackTrace();
          }
      }
  }
  /**
   * ��ֿ�����Ӳ�Ʒ
   */
  public synchronized void add(){
      if(num < size){
          num++;
          System.out.println(Thread.currentThread().getName() + "����һ����Ʒ����ǰ�ֿ���" 
          + num + "��");
          //֪ͨ�ȴ���������
          notifyAll();
      }else{
          //�����ǰ��Ʒ������10����Ʒ
          try{
              wait();//�����߽���ȴ�״̬�����ͷ���
              System.out.println(Thread.currentThread().getName()+"�߳̽���ȴ�");
          }catch(InterruptedException e){
              e.printStackTrace();
          }
      }
  }
}
/**
* �������߳�
*/
class ConsumerThread extends Thread{
  private Resource resource;
  public ConsumerThread(Resource resource){
      this.resource = resource;
  }
  @Override
  public void run() {
      while(true){
          try {
              Thread.sleep(1000);
          } catch (InterruptedException e) {
              e.printStackTrace();
          }
          resource.remove();
      }
  }
}
/**
* �������߳�
*/
class ProducerThread extends Thread{
  private Resource resource;
  public ProducerThread(Resource resource){
      this.resource = resource;
  }
  @Override
  public void run() {
      //���ϵ�������Ʒ
      while(true){
          try {
              Thread.sleep(1000);
          } catch (InterruptedException e) {
              e.printStackTrace();
          }
          resource.add();
      }
  }
  
}