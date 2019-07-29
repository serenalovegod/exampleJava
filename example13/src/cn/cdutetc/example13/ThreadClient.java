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
		String serverIP="127.0.0.1"; //��������ַ
		int port=5500;//�������˿�	
		try
		{  
			socket=new Socket(serverIP,port);//���ӷ�����
			in=new DataInputStream(socket.getInputStream());//����������
			out=new DataOutputStream(socket.getOutputStream());//���������
			System.out.println("chat begin:");	
			while(scanner.hasNext())
			{
				input=scanner.nextLine();//�Ӽ��������������˵�Ļ�
				out.writeUTF(input);//��������˷�����������
				String answer=in.readUTF();//�ȴ������˵Ļش�
				System.out.println("robot say��"+answer);
			}
		}catch(Exception e)
		{
			System.out.println("������������ж�");
		}
		finally
		{
			try//�ر���������
			{
				in.close();
				out.close();
				socket.close();
				System.out.println("���ӽ���");
			}
			catch(Exception e){}
		}
	}
}