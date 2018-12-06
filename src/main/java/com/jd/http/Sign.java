package com.jd.http;

public class Sign {
    static long timestamp =System.currentTimeMillis();

    static String secretKey = "c92d4ebd0d21a198af18bc53d7524eda";
    public static void main(String [] args ){
       String sign = MD5.md5Password(secretKey+timestamp);
        String a=new String(secretKey+timestamp);
       System.out.println(secretKey+timestamp);
    }
}
