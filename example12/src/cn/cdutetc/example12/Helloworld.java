package cn.cdutetc.example12;
import cn.cdutetc.example12.ThreadTest;
public class Helloworld {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	   Thread tt=new Thread(new ThreadTest());
	   tt.start();
       while(true)
       {
    	   System.out.println("Hello,World");
       }
	}

}
class ThreadTest implements Runnable
{
       public void run()
       {
    	   while(true)
    	   {
    		   System.out.println("ThreadTest类的run()方法在运行");
    	   }
       }
}