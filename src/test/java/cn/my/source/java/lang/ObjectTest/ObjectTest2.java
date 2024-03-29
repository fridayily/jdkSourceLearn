package cn.my.source.java.lang.ObjectTest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Objects;

class ObjectTest2 {

    @BeforeEach
    void setUp() {
        Person sam = new Person("sam", 18);
    }

    @Test
    void toStringTtest() {
        Person sam = new Person("sam", 18);
        String samString = sam.toString();
        System.out.println(samString);
    }

    @Test
    public void testClass() {
        Parent parent = new Parent();
//        person.setPage();
        parent.setName("A");

        Parent p = new Son();

        System.out.println("p.getName " + p.getName());
        //class 是一个类的属性，能获取该类编译时的类对象，
        // 而 getClass() 是一个类的方法，它是获取该类运行时的类对象。
        System.out.println(p.getClass());
        System.out.println(Parent.class);


    }
}


class Person {
    private String pname;
    private int page;

    public Person() {
    }

    public Person(String pname, int page) {
        this.pname = pname;
        this.page = page;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }
//    @Override
//    public boolean equals(Object obj) {
//        if(this == obj){//引用相等那么两个对象当然相等
//            return true;
//        }
//        if(obj == null || !(obj instanceof  Person)){//对象为空或者不是Person类的实例
//            return false;
//        }
//        Person otherPerson = (Person)obj;
//        if(otherPerson.getPname().equals(this.getPname()) && otherPerson.getPage()==this.getPage()){
//            return true;
//        }
//        return false;
//    }


    @Override
    public boolean equals(Object otherObject) {
        //1、判断比较的两个对象引用是否相等，如果引用相等那么表示是同一个对象，那么当然相等
        if (this == otherObject) {
            return true;
        }
        //2、如果 otherObject 为 null，直接返回false，表示不相等
        if (otherObject == null) {//对象为空或者不是Person类的实例
            return false;
        }
        //3、比较 this 和 otherObject 是否是同一个类（注意下面两个只能使用一种）
        //3.1：如果 equals 的语义在每个子类中所有改变，就使用 getClass 检测
        if (this.getClass() != otherObject.getClass()) {
            return false;
        }
        //3.2：如果所有的子类都有统一的定义，那么使用 instanceof 检测
        if (!(otherObject instanceof Person)) {
            return false;
        }

        //4、将 otherObject 转换成对应的类类型变量
        Person other = (Person) otherObject;

        //5、最后对对象的属性进行比较。使用 == 比较基本类型，使用 equals 比较对象。如果都相等则返回true，否则返回false
        //   使用 Objects 工具类的 equals 方法防止比较的两个对象有一个为 null而报错，因为 null.equals() 是会抛异常的
        return Objects.equals(this.pname, other.pname) && this.page == other.page;

        //6、注意如果是在子类中定义equals，则要包含 super.equals(other)
        //return super.equals(other) && Objects.equals(this.pname,other.pname) && this.page == other.page;

    }

    public static void main(String[] args) {
        Person p1 = new Person("Tom", 21);
        Person p2 = new Person("Marry", 20);
        System.out.println(p1 == p2);//false
        System.out.println(p1.equals(p2));//false

        Person p3 = new Person("Tom", 21);
        System.out.println(p1.equals(p3));//true
    }

}