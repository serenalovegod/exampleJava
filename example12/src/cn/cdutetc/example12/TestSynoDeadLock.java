package cn.cdutetc.example12;
class SynoDeadLock implements Runnable{ 
    private Object obj1;
    private Object obj2;
    public SynoDeadLock(Object o1, Object o2){
        this.obj1=o1;
        this.obj2=o2;
    } 
    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        synchronized (obj1) {
            System.out.println(name + "请求获得锁 "+obj1);
            work();
            synchronized (obj2) {
                System.out.println("After, "+name + "请求获得锁 "+obj2);
                work();
            }
            System.out.println(name + "释放锁 "+obj2);
        }
        System.out.println(name + " 释放锁 "+obj1);
        System.out.println(name + " 结束执行.");
    }
    
    private void work() {
        try {
        	System.out.println("Hello,world");
            Thread.sleep(3000);  
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
public class TestSynoDeadLock {

    public static void main(String[] args) throws InterruptedException {
        Object obj1 = new Object();
        Object obj2 = new Object();
        Object obj3 = new Object();
        Thread t1 = new Thread(new SynoDeadLock(obj1, obj2), "t1");
        Thread t2 = new Thread(new SynoDeadLock(obj2, obj3), "t2");
        Thread t3 = new Thread(new SynoDeadLock(obj3, obj1), "t3");
        t1.start();
        Thread.sleep(1000);
        t2.start();
        Thread.sleep(1000);
        t3.start();
 
    }
}

