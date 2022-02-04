package cn.my.source.java.util;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.nio.ByteBuffer;
import java.nio.LongBuffer;
import java.util.Arrays;
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
        System.out.println("用long 型数组初始化 bitset");
        long[] l = {7, 7};
        BitSet bitset = BitSet.valueOf(l);
        System.out.println("bitset " + bitset); // {0, 1, 2, 64, 65, 66}  表示第0, 1, 2, 64, 65, 66 为设置为1，其余为0
    }

    @Test
    void testValueOf() {
        ByteBuffer buffer = ByteBuffer.wrap(new byte[]{0,0,0,0,0,0,0,'a'});
        while (buffer.hasRemaining()) {
            System.out.println("第一次" +buffer.position() + "-->" + buffer.get() + ",");
        }

        buffer.rewind();
        LongBuffer longBuffer = buffer.asLongBuffer();
        System.out.println("---LongBuffer----");
        while (longBuffer.hasRemaining()) {
            System.out.println(longBuffer.position() + "-->" + longBuffer.get() + ",");
        }

        System.out.println("longbuffer 测试");
        ByteBuffer buffer1 = ByteBuffer.wrap(new byte[]{0,0,0,0,0,0,1,0});
        LongBuffer longBuffer1 = buffer1.asLongBuffer();
        System.out.println("---LongBuffer----");
        while (longBuffer1.hasRemaining()) {
            System.out.println(longBuffer1.position() + "-->" + longBuffer1.get() + ",");
        }
        longBuffer1.rewind();

        BitSet bitSet = BitSet.valueOf(buffer1);

        System.out.println(bitSet); // 48   word 第48位为1,后面15位都是0

    }

    @Test
    void testValueOf1() {
        System.out.println("用byte初始化");
        BitSet bitSet = BitSet.valueOf(new byte[]{0,0,0,0,0,0,1,0});
        System.out.println(bitSet);


    }

    @Test
    void testValueOf2() {
        System.out.println("用bytebuff初始化");
        ByteBuffer buffer = ByteBuffer.wrap(new byte[]{0,0,0,0,0,0,1,0});
        BitSet bitSet = BitSet.valueOf(buffer);

        System.out.println(bitSet); // 48   word 第48位为1,后面15位都是0
    }

    @Test
    void toByteArray() {
        long[] l = {7, 7};
        BitSet bitset = BitSet.valueOf(l);
        byte[] bytes = bitset.toByteArray();

        System.out.println("Arrays.toString " + Arrays.toString(bytes));

        System.out.println("bytes.toString " + bytes.toString());
    }

    @Test
    void toLongArray() {
        long[] l = {7, 7};
        BitSet bitset = BitSet.valueOf(l);
        long[] la = bitset.toLongArray();

        System.out.println("Arrays.toString " + Arrays.toString(la));

        System.out.println("bytes.toString " + la.toString());
    }

    @Test
    void flip() {
        long[] l = {7, 7};
        BitSet bitset = BitSet.valueOf(l);
        System.out.println(bitset);
        bitset.flip(1); // 将第1位取反
        bitset.flip(3); // 将第2位取反
        System.out.println(bitset);


    }

    @Test
    void testFlip() {
        long[] l = {7, 7};
        BitSet bitset = BitSet.valueOf(l);
        System.out.println(bitset);
        bitset.flip(0,2); // 对0到2-1 位取反
        System.out.println(bitset);
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