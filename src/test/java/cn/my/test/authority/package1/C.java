package cn.my.test.authority.package1;

public class C extends A {
    void test() {
        System.out.println(a); // 可以访问默认的
        System.out.println(b); // 可以访问public
        System.out.println(c); // 可以访问protected
        // System.out.print(d);不可访问private
    }

}
