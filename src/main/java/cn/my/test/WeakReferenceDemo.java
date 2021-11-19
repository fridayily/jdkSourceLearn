package cn.my.test;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

// 引用
// 首先要把引用和对象区别开来，比如Car car = new Car();
// 这条语句新建了一个对象new Car(),同时把car这个引用指向了这个new Car()对象。java在gc的时候，
// 如果发现没有任何引用指向某对象, 该对象就会被回收。比如:Car car = null;。
// 当GC时，如果一个对象只有弱引用指向他时候，那个对象就会被回收。
// WeakReference常用作为cache，适合一些耗内存且更迭快速的对象
public class WeakReferenceDemo {
    public static void main(String[] args) {

        // demo0
        WeakReference<Car> weakReference = new WeakReference<>(new Car());
        Car car = new Car();
        System.out.println("weakReference " +weakReference);
        System.out.println("weakReference.get() " +weakReference.get());
        System.out.println("car " +car);
        System.gc();
        System.out.println("weakReference.get() " +weakReference.get()); // gc 后有被回收
        System.out.println("car " +car); // gc 后没有被回收


        // demo1

        // 这个ReferenceQueue的主要作用是存放那些已经被gc的reference
        ReferenceQueue<Car> referenceQueue = new ReferenceQueue<>();
        WeakReference<Car> weakReference1 = new WeakReference<>(new Car(),referenceQueue);
        System.out.println("weakReference " +weakReference);
        System.out.println("weakReference.get() " +weakReference1.get());
        System.gc();
        // 执行gc后 weakReference1 被放入referenceQueue中
        System.out.println("weakReference.get() " +weakReference1.get()); // gc 后有被回收


    }
}

 class Car {
    String name;
    int age;
    public Car(){
        System.out.println("this is Car");
        this.name = "this is Car";
    }
     public Car(String name,int age){
         this.name = name;
         this.age = age;
     }
}
