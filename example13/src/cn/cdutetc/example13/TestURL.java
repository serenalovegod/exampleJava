package cn.cdutetc.example13;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;

class ContentFromInternet {
    public static void download(String urlString, String fileName, String savePath) {
        URL url;
        InputStream is=null;
        OutputStream os=null;
		try {
			url = new URL(urlString);
			  //使用openConnection方法
	        // URLConnection conn = url.openConnection();
	        // is = conn.getInputStream();
			is = url.openStream();
		    byte[] buff = new byte[1024];
		    int len = 0;
		    File file = new File(savePath);
		    if (!file.exists()) {
		            file.mkdirs();
		     } 
		    os = new FileOutputStream(file.getAbsolutePath() + "\\"
		                + fileName);
		    while ((len = is.read(buff)) != -1) {
		            os.write(buff, 0, len);
		   }
		    os.close();
		     is.close();    // 释放资源
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch(IOException e)
		{
			e.printStackTrace();
		}
    }
}
public class TestURL
{
   public static void main(String args[])
   {
	   ContentFromInternet.download("http://www.baidu.com", "test.html","d:\\java");
   }
}