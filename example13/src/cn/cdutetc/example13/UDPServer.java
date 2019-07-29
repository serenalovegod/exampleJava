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
	        System.out.println("UDP������������������");
	        byte[] b=new byte[1024];
	        while(ds.isClosed()==false)    //�ж�Socket�Ƿ�ر�
	        {
	            dpReceive=new DatagramPacket(b, b.length);
	            try
	            {
	                ds.receive(dpReceive);
	                byte[] Data=dpReceive.getData();
	                int len=Data.length;
	                System.out.println("UDP�ͻ��˷��͵������ǣ�" + new String(Data, 0, len).trim());
	                System.out.println("UDP�ͻ���IP��" + dpReceive.getAddress());
	                System.out.println("UDP�ͻ��˶˿ڣ�" + dpReceive.getPort());
	            }
	            catch(IOException e)
	            {
	                e.printStackTrace();
	            }
	        }
	        }
	        catch(SocketException e1)
	        {
	            // TODO �Զ����ɵ� catch ��
	            e1.printStackTrace();
	        }
	    }
}

