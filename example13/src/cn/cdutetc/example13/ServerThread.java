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
			in=new DataInputStream(socket.getInputStream());//创建输入流
			out=new DataOutputStream(socket.getOutputStream());//创建输出流
			ip=socket.getInetAddress().getHostAddress();//客户端IP地址
			port=socket.getPort();//客户端的端口号
			while (true)
			{
				str=in.readUTF();//获取客户端的信息
				System.out.println("client's address"+ip+":"+port+"发送的请求内容：");
				System.out.println(str);
				out.writeUTF("i'm robot");
			}
		}
		catch(Exception e)
		{
			System.out.println("连接结束");
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