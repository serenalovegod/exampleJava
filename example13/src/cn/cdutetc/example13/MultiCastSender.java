package cn.cdutetc.example13;


import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class MultiCastSender {
	public static void main(String[] args) {

		try {
            String testStr="hello,world";
			byte[] msg =testStr.getBytes(); 
			//��������������������IP��ַ
			InetAddress inetAddress = InetAddress.getByName("230.0.0.1");
			//���ݰ�������Ϣ���ݣ���Ϣ���ȣ��鲥IP�Ͷ˿�
			DatagramPacket datagramPacket = new DatagramPacket(msg, msg.length,inetAddress,5555);
			MulticastSocket multicastSocket = new MulticastSocket();
			multicastSocket.send(datagramPacket);//�������ݰ�
		} catch (Exception exception) {
			exception.printStackTrace();
		}
	}
}
