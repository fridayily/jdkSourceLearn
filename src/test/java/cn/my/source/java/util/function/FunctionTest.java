package cn.my.source.java.util.function;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

import static org.junit.jupiter.api.Assertions.*;

class FunctionTest {

  @Test
  void apply() {
    Function<Integer, Integer> A = i -> i + 1;
    Function<Integer, Integer> B = i -> i * i;

    System.out.println("F0:" + A.apply(1));
    System.out.println("-------------------------");
    System.out.println("F1:" + B.compose(A).apply(5));  // (5+1)*(5+1)
    System.out.println("F1:" + B.apply(A.apply(5)));

    System.out.println("-------------------------");
    System.out.println("F2:" + B.andThen(A).apply(5));
    System.out.println("F2:" + A.apply(B.apply(5))); // 5*5 +1

    System.out.println("-------------------------");
    System.out.println("F3:" + B.compose(A).compose(B).apply(3)); //  ((3*3)+1)* ((3*3)+1)
    System.out.println("F3:" + B.apply(A.apply(B.apply(3))));

    System.out.println("-------------------------");
    System.out.println("F4:" + B.andThen(A).compose(B).apply(3)); //  (3*3)*(3*3)+1
    System.out.println("F4:" + A.apply(B.apply(B.apply(3))));

    System.out.println("-------------------------");
    System.out.println("F5:" + B.andThen(A).compose(B).andThen(A).apply(3)); //  (3*3)*(3*3)+1
    System.out.println("F5:" +   A.apply(3));




    // 返回一个执行了apply()方法之后只会返回输入参数的函数对象
    Object identity = Function.identity().apply("huohuo");
    System.out.println(identity);

    System.out.println("-------------------------");
  }

  @Test
  void compose() {}

  @Test
  void andThen() {}

  @Test
  void identity() {}
}

class FunctionDemo {

  // API which accepts an implementation of

  // Function interface

  static void modifyTheValue(int valueToBeOperated, Function<Integer, Integer> function) {

    int newValue = function.apply(valueToBeOperated);

    /*
     * Do some operations using the new value.
     */

    System.out.println(newValue);
  }
}
