package cn.my.test.authority.package3;

import cn.my.test.authority.package1.A;
import org.junit.jupiter.api.Test;

public class C extends A {

    @Test
    void test() {
//         System.out.print(a); // 不可以访问默认的
        System.out.println(b); // 可以访问public
        System.out.println(c); // 可以访问protected
//         System.out.print(d);//不可访问private
    }

}
