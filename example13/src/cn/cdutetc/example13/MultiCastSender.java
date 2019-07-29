package cn.cdutetc.example13;


import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class MultiCastSender {
	public static void main(String[] args) {

		try {
            String testStr="hello,world";
			byte[] msg =testStr.getBytes(); 
			//根据主机名返回主机的IP地址
			InetAddress inetAddress = InetAddress.getByName("230.0.0.1");
			//数据包包含消息内容，消息长度，组播IP和端口
			DatagramPacket datagramPacket = new DatagramPacket(msg, msg.length,inetAddress,5555);
			MulticastSocket multicastSocket = new MulticastSocket();
			multicastSocket.send(datagramPacket);//发送数据包
		} catch (Exception exception) {
			exception.printStackTrace();
		}
	}
}
