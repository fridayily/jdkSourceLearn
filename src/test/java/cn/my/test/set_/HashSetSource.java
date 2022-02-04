package cn.my.test.set_;

import java.util.HashSet;

public class HashSetSource {
    public static void main(String[] args) {
        HashSet hashSet = new HashSet();
        hashSet.add("java");
        hashSet.add("php");
        hashSet.add("java");

        System.out.println("set=" + hashSet);

        /*
        *
        * 1。执行HashSet()
        *     public HashSet() {
        map = new HashMap<>();
    }
        * */
    }
}
