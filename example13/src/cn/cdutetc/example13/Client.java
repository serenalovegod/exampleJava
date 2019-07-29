package cn.cdutetc.example13;
import java.net.*;
import java.io.*;

public class Client {
	public static void main(String[] args) 
	{
		Socket client_socket=null;
		DataInputStream in=null;
		DataOutputStream out=null;
		String ip="127.0.0.1";//������IP
		int port=5050;//�������˿�
		
		try
		{
			client_socket=new Socket(ip,port);//���������������
			in=new DataInputStream(client_socket.getInputStream());//����������
			out=new DataOutputStream(client_socket.getOutputStream());//���������
			out.writeUTF("��ã����ǿͻ���B");//��������˷�����Ϣ
			System.out.println("�ͻ����������������������Ϣ����ã����ǿͻ���B");
			String str=in.readUTF();//�ȴ���ȡ����������Ӧ����Ϣ����������״̬
			System.out.println("�������˵���Ӧ��Ϣ��"+str);
		}
		catch (Exception e)
		{
			System.out.println(e);
		}
		finally
		{
			try//�ر���������
			{
				in.close();
				out.close();
				client_socket.close();
			}
			catch(Exception e){}
		}
	}
}
