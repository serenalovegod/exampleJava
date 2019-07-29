package cn.cdutetc.example13;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class UDPClient {
	public static void main(String[] args)
	{
	    DatagramSocket ds=null;
	    DatagramPacket dpSend=null;
	    int port=5501;
	    try {
			InetAddress ia=InetAddress.getByName("127.0.0.1");
			ds=new DatagramSocket();
	        for(int i=0;i<5;i++)
	        {
	            byte[] data=("我是 UDP 客户端"+i).getBytes();
	            dpSend=new DatagramPacket(data,data.length,ia,port);
	            ds.send(dpSend);
	            Thread.sleep(1000);    
		    }
	        ds.close();
	    }catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  catch(IOException | InterruptedException e)
	    {
	        // TODO 自动生成的 catch 块
	        e.printStackTrace();
	    }   
	  
	}
}
