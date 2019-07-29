package cn.cdutetc.example13;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * InetAddress用来代表IP地址 一个InetAddress对象代表一个IP地址
 */
public class TestInetAddress {

    public static void main(String[] args) throws UnknownHostException {
    //如何创建一个InetAddress对象
    InetAddress inet = InetAddress.getByName("www.baidu.com");
    System.out.println(inet);
    System.out.println(inet.getHostName());
    System.out.println(inet.getHostAddress());
    //获取本机信息
    inet = InetAddress.getLocalHost();
    System.out.println(inet);
    System.out.println(inet.getHostName());
    System.out.println(inet.getHostAddress());
    }

}