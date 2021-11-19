package cn.my.source.java.lang;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ObjectTest {

    @BeforeEach
    void setUp() {
        Person sam = new Person("sam",18);
    }

    @Test
    void toStringTtest(){
        Person sam = new Person("sam",18);
        String samString = sam.toString();
        System.out.println(samString);
    }
}


class Person {
    private String pname;
    private int page;

    public Person(){}

    public Person(String pname,int page){
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
    @Override
    public boolean equals(Object obj) {
        if(this == obj){//引用相等那么两个对象当然相等
            return true;
        }
        if(obj == null || !(obj instanceof  Person)){//对象为空或者不是Person类的实例
            return false;
        }
        Person otherPerson = (Person)obj;
        if(otherPerson.getPname().equals(this.getPname()) && otherPerson.getPage()==this.getPage()){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Person p1 = new Person("Tom",21);
        Person p2 = new Person("Marry",20);
        System.out.println(p1==p2);//false
        System.out.println(p1.equals(p2));//false

        Person p3 = new Person("Tom",21);
        System.out.println(p1.equals(p3));//true
    }

}