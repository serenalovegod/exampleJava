package cn.cdutetc.example13;

import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class MultiCastReceiver {
	public static void main(String[] arstring) {
		try {
			//创建组播套接字并绑定到发送端口
			MulticastSocket multicastSocket = new MulticastSocket(5555);
			InetAddress inetAddress = InetAddress.getByName("230.0.0.1");
			//组播套接字加入组播组
			multicastSocket.joinGroup(inetAddress);
			while (true) {
				byte[] data = new byte[1024];
				//创建一个用于接收数据的数据包
				DatagramPacket datagramPacket = new DatagramPacket(data,data.length);
				//接收数据包
				multicastSocket.receive(datagramPacket);
				System.out.println(new String(data));
			}
		} catch (Exception exception) {
			exception.printStackTrace();
		}

	}

}

