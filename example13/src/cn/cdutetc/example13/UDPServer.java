package cn.cdutetc.example13;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class UDPServer {
	public static void main(String[] args)
	{
	    DatagramSocket ds=null;
	    DatagramPacket dpReceive=null;
	    int port=5501;
	    try
	    {
	        ds=new DatagramSocket(port);
	        System.out.println("UDP服务器已启动。。。");
	        byte[] b=new byte[1024];
	        while(ds.isClosed()==false)    //判定Socket是否关闭
	        {
	            dpReceive=new DatagramPacket(b, b.length);
	            try
	            {
	                ds.receive(dpReceive);
	                byte[] Data=dpReceive.getData();
	                int len=Data.length;
	                System.out.println("UDP客户端发送的内容是：" + new String(Data, 0, len).trim());
	                System.out.println("UDP客户端IP：" + dpReceive.getAddress());
	                System.out.println("UDP客户端端口：" + dpReceive.getPort());
	            }
	            catch(IOException e)
	            {
	                e.printStackTrace();
	            }
	        }
	        }
	        catch(SocketException e1)
	        {
	            // TODO 自动生成的 catch 块
	            e1.printStackTrace();
	        }
	    }
}

