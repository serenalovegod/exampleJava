package cn.cdutetc.example13;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ThreadServer {
	public static void main(String args[]) 
	{
		ServerSocket server_socket=null;
		Socket socket=null;
		DataInputStream in=null;
		DataOutputStream out=null;
		int port=5500;
		try
		{
			server_socket=new ServerSocket(port);//�����󶨶˿ڵķ�������socket
			System.out.println("robot run��");
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		while(true) 
		{
			try
			{  
				socket=server_socket.accept();
				
			} 
			catch (IOException e) 
			{
				System.out.println("���ڵȴ��ͻ�");
			}
			
			if(socket!=null) 
			{ 
				new ServerThread(socket); //Ϊÿ���ͻ�����һ��ר�ŵ��߳�  
			}
		} 
	}
	}
