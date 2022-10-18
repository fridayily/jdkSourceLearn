package cn.my.test.authority.package1;

import org.junit.jupiter.api.Test;

public class A {
    int a; // 默认访问权限
    public int b; // 公共的public
    protected int c; // 受保护的protected
    private int d;  // 私有的private

    @Test
    void test() {
        System.out.println(a); // 可以访问默认的
        System.out.println(b); // 可以访问public
        System.out.println(c); // 可以访问protected
        System.out.println(d); // 可以访问private
    }
}
