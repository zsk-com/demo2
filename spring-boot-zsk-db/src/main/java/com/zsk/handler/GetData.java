package com.zsk.handler;

import com.google.gson.Gson;
import com.zsk.bean.Date;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GetData {
    //缓存数据
    private static HashMap<String,Object> handlerMap=new HashMap<>();
    //请求的url
    private static String url="https://view.inews.qq.com/g2/getOnsInfo?name=disease_h5";

    public static List<Date> getDate() {
        //缓存
        List<Date> dateList = (List<Date>) handlerMap.get("date");
        if (dateList!=null){
            return dateList;
        }
        //文件只读一次
        FileReader reader= null;
        try {
//            reader = new FileReader("tem.txt");
//            //读取文件数据
//            char[] a=new char[1024];
//            int code=reader.read(a);
//            StringBuilder builder=new StringBuilder();
//            while (code!=-1){
//                builder.append(new String(a,0,code));
//                code=reader.read(a);
//            }
            String resp = HttpURLConnectionutil.doGet(url);

            //讲json对象转化成java对象
            Gson gson=new Gson();
            //  System.out.println(builder.toString());
            Map map = gson.fromJson(resp, Map.class);
            //获取data
            String  data = (String) map.get("data");
            //转化成json对象
            Map dataMap = gson.fromJson(data, Map.class);
            // System.out.println(map);
            //获取数据
            ArrayList areaTree = (ArrayList) dataMap.get("areaTree");
            Map map1 = (Map) areaTree.get(0);
            ArrayList children = (ArrayList) map1.get("children");
            //存储最终数据
            ArrayList<Date> reuslt=new ArrayList<>();
            for (int i=0;i<children.size();i++){
                Map listMap= (Map) children.get(i);
                String name = (String) listMap.get("name");
                Map totalMap = (Map) listMap.get("total");
                //System.out.println(totalMap);
                double newConfirm = (double) totalMap.get("nowConfirm");
                double confirm = (double) totalMap.get("confirm");
                double heal = (double) totalMap.get("heal");
                double dead = (double) totalMap.get("dead");
                Date date = new Date(name, (int)newConfirm, (int)confirm, (int) heal, (int) dead);
                reuslt.add(date);
            }
            handlerMap.put("date",reuslt);
            return reuslt;
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if (reader!=null){
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }
}

