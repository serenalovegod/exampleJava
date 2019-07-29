package cn.cdutetc.example12;

//wait 和 notify
public class ProductAndCustomer {
  public static void main(String[] args) {
      Resource resource = new Resource();
      //生产者线程
      ProducerThread p1 = new ProducerThread(resource);
      ProducerThread p2 = new ProducerThread(resource);
      ProducerThread p3 = new ProducerThread(resource);
      //消费者线程
      ConsumerThread c1 = new ConsumerThread(resource);
      p1.start();
      p2.start();
      p3.start();
      c1.start();
  }
}
/**
* 仓库类
* @author 
*
*/
class Resource{
  //当前产品数量
  private int num = 0;
  //仓库中允许存放的产品数目
  private int size = 10;

  /**
   * 从仓库中取走产品,
   */
  public synchronized void remove(){
      if(num > 0){
          num--;
          System.out.println("消费者" + Thread.currentThread().getName() +
                  "消耗一件产品，" + "当前仓库有" + num + "个");
          notifyAll();//通知生产者生产产品
      }else{
          try {
              //如果没有产品，则消费者进入等待状态
              wait();
              System.out.println("消费者" + Thread.currentThread().getName() + "线程进入等待状态");
          } catch (InterruptedException e) {
              e.printStackTrace();
          }
      }
  }
  /**
   * 向仓库中添加产品
   */
  public synchronized void add(){
      if(num < size){
          num++;
          System.out.println(Thread.currentThread().getName() + "生产一件产品，当前仓库有" 
          + num + "个");
          //通知等待的消费者
          notifyAll();
      }else{
          //如果当前产品池中有10件产品
          try{
              wait();//生产者进入等待状态，并释放锁
              System.out.println(Thread.currentThread().getName()+"线程进入等待");
          }catch(InterruptedException e){
              e.printStackTrace();
          }
      }
  }
}
/**
* 消费者线程
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
* 生产者线程
*/
class ProducerThread extends Thread{
  private Resource resource;
  public ProducerThread(Resource resource){
      this.resource = resource;
  }
  @Override
  public void run() {
      //不断地生产产品
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