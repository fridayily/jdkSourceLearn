package cn.my.test.authority.package1;

public class B {
    A ca = new A();
    void test() {
        System.out.println(ca.a); // 可以访问默认的
        System.out.println(ca.b); // 可以访问public
        System.out.println(ca.c); // 可以访问protected
        // System.out.print(ca.d);不可访问private
    }

}
