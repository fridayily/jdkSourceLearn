package cn.my.test;

import static org.junit.jupiter.api.Assertions.*;

class A {
  static int a; // 类变量
  static int b; // 类变量
  String name;
  int id;
  int m;
  // 静态代码块
  static {
    a = 10;
    System.out.println("这是父类的静态代码块" + a);
  }

  static {
    b = 20;
    System.out.println("这是父类的静态代码块" + b);
  }

  // 构造代码块
  {
    m = 12;
    System.out.println("这是父类的构造代码块id:" + m);
  }
  // 构造代码块
  {
    id = 11;
    System.out.println("这是父类的构造代码块id:" + id);
  }



  A() {
    System.out.println("这是父类的无参构造函数");
  }

  A(String name) {
    System.out.println("是父类的有参构造函数" + name);
  }

  void f(){
    System.out.println("普通函数代码块");
  }
}

class B extends A {
  String name;
  static int b;
  int x;

  static {
    b = 12;
    System.out.println("这是子类B的静态代码块" + b);
  }

  {
    x = 18;
    System.out.println("这是子类B类的构造代码块 x:" + x);
  }

  B(String name) {
    super();
    System.out.println("B.super 结束");
    this.name = name;
    System.out.println("这是子类B的name:" + name);
  }
}

class C extends A {
  String name;
  static int c;
  int n;

  static {
    c = 13;
    System.out.println("这是子类C的静态代码块" + c);
  }

  {
    n = 18;
    System.out.println("这是子类C的构造代码块n:" + n);
  }

  C(String name) {
    super(name);
    System.out.println("C.super结束");
    this.name = name;
    System.out.println("这是子类C的name:" + name);
  }
}

public class EtcTest {
  public static void main(String[] args) {
    System.out.println("主函数");
    B bb = new B("BB");
    System.out.println("bb.name " + bb.name);
    System.out.println("-----------------------------");
    System.out.println("-----------------------------");
    C cc = new C("CC");
    System.out.println("cc.name " + cc.name);
  }
}
