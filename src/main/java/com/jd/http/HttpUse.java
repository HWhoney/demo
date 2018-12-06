package com.jd.http;


import com.google.common.hash.Hashing;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;


public class HttpUse {

    static String secretKey = "c92d4ebd0d21a198af18bc53d7524eda";
    static long timestamp =0L;
    static String sign=null;
    public static void setSign(){
        timestamp = System.currentTimeMillis();
        sign = Hashing.md5().hashString(secretKey + timestamp, Charset.forName("UTF-8")).toString();
    }
    public static void main(String[] args) throws Exception {

        int i=0;
        while (i<10) {
            setSign();
            URL url = new URL("https://aiapi.jd.com/jdai/URL_pose_estimation?muti_det=2&url=https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1540799431095&di=124e05bf2ff57368db52ec2bbecc9381&imgtype=0&src=http%3A%2F%2Fimgsrc.baidu.com%2Fimgad%2Fpic%2Fitem%2F267f9e2f0708283882959b0bb299a9014c08f111.jpg&appkey=b148a7f7cc27a4f336e75c83a3ada768&timestamp=" + timestamp + "&" + "sign=" + sign);
            //创建http链接
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();

            //设置请求的方法类型
            httpURLConnection.setRequestMethod("POST");

            //设置请求的内容类型
            httpURLConnection.setRequestProperty("Content-type", "application/x-www-form-urlencoded");

            //设置发送数据
            httpURLConnection.setDoOutput(true);
            //设置接受数据
            httpURLConnection.setDoInput(true);

            //发送数据,使用输出流
            OutputStream outputStream = httpURLConnection.getOutputStream();
            //发送的soap协议的数据
            //String requestXmlString = requestXml("北京");

            //String content = "user_id="+ URLEncoder.encode("123", "gbk");

            //发送数据
            //outputStream.write(content.getBytes());

            //接收数据
            InputStream inputStream = httpURLConnection.getInputStream();

            //定义字节数组
            byte[] b = new byte[1024];

            //定义一个输出流存储接收到的数据
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

            //开始接收数据
            int len = 0;
            while (true) {
                len = inputStream.read(b);
                if (len == -1) {
                    //数据读完
                    break;
                }
                byteArrayOutputStream.write(b, 0, len);
            }
            i++;
            //从输出流中获取读取到数据(服务端返回的)
            String response = byteArrayOutputStream.toString();
            System.out.println("timestamp=" + timestamp);
            System.out.println("sign=" + sign);
            System.out.println(response);

        }

    }
}
