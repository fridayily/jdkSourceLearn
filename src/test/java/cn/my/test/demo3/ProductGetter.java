package cn.my.test.demo3;

import java.util.ArrayList;
import java.util.Random;

public class ProductGetter<T> {
    Random random = new Random();

    // 奖品
    private T product;

    // 奖品池
    ArrayList<T> list = new ArrayList<>();

    // 添加奖品
    public void addProduct(T t){
        list.add(t);
    }

    // 抽奖
    public T getProduct(){
        product = list.get(random.nextInt(list.size()));
        return  product;

    }

}
