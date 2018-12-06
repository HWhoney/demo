package com.jd.http;
import com.google.common.hash.Hashing;
import java.nio.charset.Charset;


class GreatApk extends Thread{
    static String secretKey = "2e148773a0338a8f2200ba90d445f084";
    @Override
    public void run()  {
        long timestamp = System.currentTimeMillis();
        String sign = Hashing.md5().hashString(secretKey + timestamp, Charset.forName("UTF-8")).toString();

    }
}
public class Secret {
    public static void main( String [] args) {
        int i=0;
        while(i<10) {
            GreatApk thread =new GreatApk();
            thread.start();
            try {
                Thread.sleep(6000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            i++;
        }
    }
}