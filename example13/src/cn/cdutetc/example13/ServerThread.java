package cn.cdutetc.example13;


import java.io.*;
import java.net.Socket;

public class ServerThread extends Thread {

	Socket socket=null;
	DataInputStream in=null;
	DataOutputStream out=null;
	String str;
	String response;
	String ip;
	int port;
	public ServerThread(Socket socket)
	{
		this.socket=socket;
		start();
	}
	public void run()
	{
		try
		{
			in=new DataInputStream(socket.getInputStream());//����������
			out=new DataOutputStream(socket.getOutputStream());//���������
			ip=socket.getInetAddress().getHostAddress();//�ͻ���IP��ַ
			port=socket.getPort();//�ͻ��˵Ķ˿ں�
			while (true)
			{
				str=in.readUTF();//��ȡ�ͻ��˵���Ϣ
				System.out.println("client's address"+ip+":"+port+"���͵��������ݣ�");
				System.out.println(str);
				out.writeUTF("i'm robot");
			}
		}
		catch(Exception e)
		{
			System.out.println("���ӽ���");
		}
		finally
		{
			try
			{
				in.close();
				out.close();
				socket.close();
			}
			catch(Exception e){}
		}
	}
}