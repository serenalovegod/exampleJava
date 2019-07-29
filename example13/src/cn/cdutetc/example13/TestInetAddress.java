package cn.cdutetc.example13;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * InetAddress��������IP��ַ һ��InetAddress�������һ��IP��ַ
 */
public class TestInetAddress {

    public static void main(String[] args) throws UnknownHostException {
    //��δ���һ��InetAddress����
    InetAddress inet = InetAddress.getByName("www.baidu.com");
    System.out.println(inet);
    System.out.println(inet.getHostName());
    System.out.println(inet.getHostAddress());
    //��ȡ������Ϣ
    inet = InetAddress.getLocalHost();
    System.out.println(inet);
    System.out.println(inet.getHostName());
    System.out.println(inet.getHostAddress());
    }

}