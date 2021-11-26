package cn.my.source.java.util;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.BitSet;

class BitSetTest {
    BitSet bSet;
    BitSet cSet;
    BitSet dSet;

    @BeforeEach
    void setUp() {

        bSet = new BitSet();

    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void valueOf() {
    }

    @Test
    void testValueOf() {
        cSet = new BitSet(65);
        System.out.println("cSet "+ cSet);

        System.out.println("测试valueof");
        long data[] = {7,0};
        BitSet vobitset = BitSet.valueOf(data);
        System.out.println("testValueOf "+ vobitset);
    }

    @Test
    void testValueOf1() {
    }

    @Test
    void testValueOf2() {
    }

    @Test
    void toByteArray() {
    }

    @Test
    void toLongArray() {
    }

    @Test
    void flip() {
    }

    @Test
    void testFlip() {
    }

    @Test
    void set() {
    }

    @Test
    void testSet() {
    }

    @Test
    void testSet1() {
    }

    @Test
    void testSet2() {
    }

    @Test
    void clear() {
    }

    @Test
    void testClear() {
    }

    @Test
    void testClear1() {
    }

    @Test
    void get() {
    }
}