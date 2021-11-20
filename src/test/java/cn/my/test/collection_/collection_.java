package cn.my.test.collection_;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class collection_ {
    public static void main(String[] args) {
//        Collection
        //Map
        //集合主要是两组（单列集合，双列集合）
        //Collection 接口有两个重要的子接口 List set  他们的实现子类都是单利集合
        //map 接口的实现子类 是双列集合 ，存放K-v
        //
        ArrayList arrayList = new ArrayList();
        arrayList.add("jack");
        arrayList.add("tom");

        HashMap hashMap = new HashMap();
        hashMap.put("NO1","北京");
        hashMap.put("NO2","上海");
    }
}
