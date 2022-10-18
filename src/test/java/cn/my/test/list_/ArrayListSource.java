package cn.my.test.list_;

import java.util.ArrayList;

@SuppressWarnings("ALl")
public class ArrayListSource {
    public static void main(String[] args) {

        // 使用无参构造器创建 Arraylist 对象
//        ArrayList list = new ArrayList();
        ArrayList list = new ArrayList(8);

        // 使用for 给list集合添加1-10 数据
        for(int i=1;i<=10;i++){
            list.add(i);
        }

        // 使用for 给list集合添加11-15 数据
        for(int i=11;i<15;i++){
            list.add(i);
        }
        list.add(100);
        list.add(200);
        list.add(null);
    }
}
