package cn.cdutetc.example13;

import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class MultiCastReceiver {
	public static void main(String[] arstring) {
		try {
			//�����鲥�׽��ֲ��󶨵����Ͷ˿�
			MulticastSocket multicastSocket = new MulticastSocket(5555);
			InetAddress inetAddress = InetAddress.getByName("230.0.0.1");
			//�鲥�׽��ּ����鲥��
			multicastSocket.joinGroup(inetAddress);
			while (true) {
				byte[] data = new byte[1024];
				//����һ�����ڽ������ݵ����ݰ�
				DatagramPacket datagramPacket = new DatagramPacket(data,data.length);
				//�������ݰ�
				multicastSocket.receive(datagramPacket);
				System.out.println(new String(data));
			}
		} catch (Exception exception) {
			exception.printStackTrace();
		}

	}

}

