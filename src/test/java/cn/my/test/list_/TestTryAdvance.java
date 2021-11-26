package cn.my.test.list_;

import java.util.ArrayList;
import java.util.function.Consumer;

public class TestTryAdvance {
    public static void main(String[] args) {
        test_forEachRemaining();
        System.out.println("---------------------");
        test_tryAdvance();
    }

    public static void test_tryAdvance() {
        ArrayList<Integer> al = new ArrayList<>();
        for (int i = 0; i <= 10; i++) al.add(i);
        ArrayListSpliterator als_1 = new ArrayListSpliterator(al, 0, -1);
        als_1.tryAdvance(new Consumer<Integer>(){
            @Override
            public void accept(Integer t) {
                System.out.print("tryAdvance " + t + " ");
            }
        });
        System.out.println("\nals_1:" + als_1);
        System.out.println("left size:" + als_1.estimateSize());
    }

    public static void test_forEachRemaining() {
        ArrayList<Integer> al = new ArrayList<>();
        for (int i = 0; i <= 10; i++) al.add(i);
        ArrayListSpliterator als_1 = new ArrayListSpliterator(al, 0, -1);
        als_1.forEachRemaining(new Consumer<Integer>(){
            @Override
            public void accept(Integer t) {
                System.out.print("forEachRemaining " + t + " ");
            }
        });
        System.out.println("\nals_1:" + als_1);
        System.out.println("left size:" + als_1.estimateSize());
    }
}
