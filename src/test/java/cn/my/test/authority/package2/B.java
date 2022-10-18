package cn.my.test.authority.package2;

import cn.my.test.authority.package1.A;
import org.junit.jupiter.api.Test;

public class B {
    A ca = new A();
    @Test
    void test() {
        // System.out.print(ca.a); // 不可以访问默认的
        System.out.println(ca.b); // 可以访问public
        //System.out.print(ca.c); // 不可以访问protected
        // System.out.print(ca.d); // 不可访问private
    }

}
