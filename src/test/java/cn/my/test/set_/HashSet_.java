package cn.my.test.set_;

import java.util.HashSet;
import java.util.Set;

public class HashSet_ {
    public static void main(String[] args) {

        /*
        *     public HashSet() {
        map = new HashMap<>();
        }
        * 2.HashSet 可以存放null,但是只能有一个null,即元素不能重复
        * 3.HashSet 数据是无序的(添加和取出顺序不一致)
        * */
        Set hashSet = new HashSet();
        hashSet.add(null);
        hashSet.add(null);

        System.out.println("hashSet=" + hashSet);
    }
}
