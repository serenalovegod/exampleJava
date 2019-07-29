package cn.cdutetc.example13;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	public static void main(String[] args)
	{
		ServerSocket server_socket=null;
		Socket socket=null;
		DataInputStream in=null;
		DataOutputStream out=null;
		int port=5050;
		try
		{
			server_socket=new ServerSocket(port);//�����󶨶˿ڵķ�������socket
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		
		try
		{
			System.out.println("������������");
			socket=server_socket.accept();//���������ܵ����׽��ֵ����ӡ��˷��������Ӵ���֮ǰ��������״̬
			in=new DataInputStream(socket.getInputStream());//����������
			out=new DataOutputStream(socket.getOutputStream());//���������
			String str=in.readUTF();//����������ȡ�ַ�������ȡ����֮ǰ��������״̬
			System.out.println("�ͻ������͹�������Ϣ�ǣ� "+str);
			out.writeUTF("��ã����Ƿ�����A");//�������д���ַ���
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		finally
		{
			try//�ر���������
			{
				out.close();
				in.close();
				socket.close();
				server_socket.close();
			}
			catch(Exception e){}
		}
	}
}
