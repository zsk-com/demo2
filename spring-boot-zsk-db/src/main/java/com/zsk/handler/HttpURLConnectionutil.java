package com.zsk.handler;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * 模仿发送请求
 */
public class HttpURLConnectionutil {
    public static String doGet(String url){
        InputStream is=null;
        BufferedReader br=null;
        StringBuilder builder=new StringBuilder();
        InputStreamReader isr=null;
        try {
            URL urls=new URL(url);
            //传创建连接
            HttpURLConnection conn = (HttpURLConnection) urls.openConnection();
            //设置请求方式
            conn.setRequestMethod("GET");
            //设置连接时间 与资源建立连接，受地区距离和网速影响
            conn.setConnectTimeout(15000);
            //设置读取时间 连接成功后，读取的时间，受数据量和服务器处理速度影响
            conn.setReadTimeout(60000);
            // 设定请求头参数的方式：如指定接收json数据   服务端的key值为content-type
            conn.setRequestProperty("Accept", "application/json");
            //发送连接
            conn.connect();
            if (conn.getResponseCode()!=200){
                return "error";
            }
            //读取信息
            is=conn.getInputStream();
            //讲字节流转化为字符流
            isr=new InputStreamReader(is,"UTF-8");
            br=new BufferedReader(isr);
            String code = br.readLine();
            while (code!=null){
                builder.append(code);
                code=br.readLine();
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if (is != null) is.close();
                if (br != null) br.close();
                if (isr!= null) isr.close();
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        return builder.toString();
    }
}
