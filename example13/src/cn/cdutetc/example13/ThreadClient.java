package cn.cdutetc.example13;
import java.io.*;
import java.net.*;
import java.util.Scanner;

public class ThreadClient {

	public static void main(String args[])
	{
		Scanner scanner = new Scanner(System.in);
		String input=null;
		Socket socket=null;
		DataInputStream in=null;
		DataOutputStream out=null;
		String serverIP="127.0.0.1"; //服务器地址
		int port=5500;//服务器端口	
		try
		{  
			socket=new Socket(serverIP,port);//连接服务器
			in=new DataInputStream(socket.getInputStream());//创建输入流
			out=new DataOutputStream(socket.getOutputStream());//创建输出流
			System.out.println("chat begin:");	
			while(scanner.hasNext())
			{
				input=scanner.nextLine();//从键盘输入向机器人说的话
				out.writeUTF(input);//向服务器端发送运算请求
				String answer=in.readUTF();//等待机器人的回答
				System.out.println("robot say："+answer);
			}
		}catch(Exception e)
		{
			System.out.println("与服务器连接中断");
		}
		finally
		{
			try//关闭网络连接
			{
				in.close();
				out.close();
				socket.close();
				System.out.println("连接结束");
			}
			catch(Exception e){}
		}
	}
}