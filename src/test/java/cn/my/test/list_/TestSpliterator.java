package cn.my.test.list_;

import java.util.ArrayList;

public class TestSpliterator {
    public static void main(String[] args) {
        test_trySplit();
    }

    public static void test_trySplit() {
        ArrayList<Integer> al = new ArrayList<>();
        for (int i = 0; i <= 10; i++) al.add(i);
        ArrayListSpliterator als_1 = new ArrayListSpliterator(al, 0, -1);
        System.out.println("als_1:" + als_1);    // [0,11]

        System.out.println("---------split-----------");
        ArrayListSpliterator als_2 = als_1.trySplit();
        System.out.println("als_1:" + als_1);    // [5,11]
        System.out.println("als_2:" + als_2);    // [0,5]

        // [0,11](als_1) ---> [0,5](als_2) + [5,11](als_1)

        System.out.println("---------split-----------");
        ArrayListSpliterator als_3 = als_1.trySplit();
//        ArrayListSpliterator als_4 = als_2.trySplit();
        System.out.println("als_1:" + als_1);
        System.out.println("als_2:" + als_2);
        System.out.println("als_3:" + als_3);
//        System.out.println("als_4:" + als_4);

        /**
         * [0,5](als_2)  --> [0,2](als_4)  + [2,5](als_2)
         * [5,11](als_1) --> [8,11](als_1) + [5,8](als_3)
         */

        System.out.println("---------test the address---------");
        System.out.println("(als_1.list == als_2.list) = " + (als_1.list == als_2.list));
        System.out.println("(als_2.list == als_3.list) = " + (als_2.list == als_3.list));
//        System.out.println("(als_3.list == als_4.list) = " + (als_3.list == als_4.list));
    }
}
