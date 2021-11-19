package cn.my.test;

import java.util.HashMap;
import java.util.Set;

public class HashMapTest {

    public static void main(String[] args) {
        HashMap<String, String> hashMap = new HashMap<>();

        hashMap.put("1", "2");
        String oldvalue = hashMap.put("1", "3");
        System.out.println(oldvalue);



    }

}
