package source.java.lang.ref;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;


class WeakReferenceTest {

    @BeforeEach
    void setUp() {

    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void weakreference(){
        WeakReference<Car> weakReference = new WeakReference<>(new Car());
        Car car = new Car();
        System.out.println("weakReference " +weakReference);
        System.out.println("weakReference.get() " +weakReference.get());
        System.out.println("car " +car);
        System.gc();
        System.out.println("weakReference.get() " +weakReference.get()); // gc 后有被回收
        System.out.println("car " +car); // gc 后没有被回收

    }


    @Test
    void weakReferenceQueue(){
        // 这个ReferenceQueue的主要作用是存放那些已经被gc的reference
        ReferenceQueue<Car> referenceQueue = new ReferenceQueue<>();
        WeakReference<Car> weakReference1 = new WeakReference<>(new Car(),referenceQueue);
        System.out.println("weakReference " + weakReference1);
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