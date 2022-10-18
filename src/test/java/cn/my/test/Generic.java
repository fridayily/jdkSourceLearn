package cn.my.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
//此处T可以随便写为任意标识，常见的如T、E、K、V等形式的参数常用于表示泛型
//在实例化泛型类时，必须指定T的具体类型
public class Generic<T>{

//    protected final Logger logger = LoggerFactory.getLogger(getClass());

    //key这个成员变量的类型为T,T的类型由外部指定
    private T key;

    public Generic(T key) { //泛型构造方法形参key的类型也为T，T的类型由外部指定
        this.key = key;
    }

    public T getKey(){ //泛型方法getKey的返回值类型为T，T的类型由外部指定
        return key;
    }

    public static void main(String[] args) {

        final Logger logger = LoggerFactory.getLogger(Generic.class);

//泛型的类型参数只能是类类型（包括自定义类），不能是简单类型
//传入的实参类型需与泛型的类型参数类型相同，即为Integer.
        Generic<Integer> genericInteger = new Generic<Integer>(123456);

//传入的实参类型需与泛型的类型参数类型相同，即为String.
        Generic<String> genericString = new Generic<String>("key_vlaue");
        logger.info("泛型测试 key is " + genericInteger.getKey());
        logger.info("泛型测试 key is " + genericString.getKey());


// 泛型类在创建对象的时候，没有指定类型，按照Object 类型来操作
        Generic generic = new Generic("111111");
        Generic generic1 = new Generic(4444);
        Generic generic2 = new Generic(55.55);
        Generic generic3 = new Generic(false);

        logger.info("泛型测试 key is " + generic.getKey());
        logger.info("泛型测试 key is " + generic1.getKey());
        logger.info("泛型测试 key is " + generic2.getKey());
        logger.info("泛型测试 key is " + generic3.getKey());


        // 泛型类，不支持基本数据类型
//        Generic<int> genericInteger = new Generic<int>(123456);


        // 同一泛型类，根据不同的数据类型创建的对象，本质上是同一类型
        System.out.println(genericInteger.getClass());
        System.out.println(genericString.getClass());
        System.out.println(genericString.getClass() == genericInteger.getClass());
    }
}
