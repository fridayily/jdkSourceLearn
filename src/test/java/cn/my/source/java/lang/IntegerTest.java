package cn.my.source.java.lang;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IntegerTest {
    Integer integer;

    @BeforeEach
    void setUp() {
        this.integer=22876;
    }

    @Test
    void testToString() {
        String st = Integer.toString(12,16);
        System.out.println("testToString " + st);
    }

    @Test
    void toUnsignedString() {
        String st = Integer.toUnsignedString(this.integer);
        System.out.println("toUnsignedString " + st);
    }

    @Test
    void toHexString() {
        String st = Integer.toHexString(30);
        System.out.println("toHexString " + st);
    }

    @Test
    void toOctalString() {
        String st = Integer.toOctalString(30);
        System.out.println("toOctalString " + st);
    }

    @Test
    void toBinaryString() {
        String st = Integer.toBinaryString(30);
        System.out.println("toBinaryString " + st);
    }

    @Test
    void formatUnsignedInt() {
        //static

    }

    @Test
    void testToString1() {
        String st = Integer.toString(30);
        System.out.println("toString " + st);
    }

    @Test
    void testToUnsignedString() {
    }

    @Test
    void getChars() {
//        char[] buf= {'a'};
//        this.integer.g

    }

    @Test
    void stringSize() {
        //static
    }

    @Test
    void parseInt() {
        //int 范围 -2147483648——2147483647
        System.out.println("16进制转10进制 最大数 "+Integer.parseInt("7fffffff",16)); // 2147483647
        System.out.println("16进制转10进制 最小数 "+Integer.parseInt("-80000000",16)); // -2147483648
//        System.out.println("16进制转10进制 最小数 "+Integer.parseInt("80000000",16)); // -2147483648

        String s = "ABC";
        int a = Integer.parseInt(s,16);

        System.out.println("a " +a);
    }

    @Test
    void testParseInt() {
    }

    @Test
    void parseUnsignedInt() {
        Integer i =  Integer.parseUnsignedInt("2147483648");
        System.out.println("2147483647 parseUnsignedInt 16进制转10进制 "+i);

        Integer j =  Integer.parseUnsignedInt("80000000",16);
        System.out.println("parseInt 16进制转10进制 "+j);
        System.out.println(Integer.parseUnsignedInt("11",10));
        System.out.println("2进制转10进制 "+Integer.parseUnsignedInt("11",2));
    }

    @Test
    void testParseUnsignedInt() {
    }

    @Test
    void valueOf() {
    }

    @Test
    void testValueOf() {
    }

    @Test
    void testValueOf1() {
    }

    @Test
    void byteValue() {
    }

    @Test
    void shortValue() {
    }

    @Test
    void intValue() {
    }

    @Test
    void longValue() {
    }

    @Test
    void floatValue() {
    }

    @Test
    void doubleValue() {
    }

    @Test
    void testToString2() {
    }

    @Test
    void testHashCode() {
    }

    @Test
    void testHashCode1() {
    }

    @Test
    void testEquals() {
    }

    @Test
    void getInteger() {
    }

    @Test
    void testGetInteger() {
    }

    @Test
    void testGetInteger1() {
    }

    @Test
    void decode() {
//        Integer i = new Integer(100);
        System.out.println("decode 100 "+ Integer.decode("0100")) ;
        System.out.println("decode 100 "+ Integer.decode("1100")) ;



    }

    @Test
    void compareTo() {
    }

    @Test
    void compare() {
    }

    @Test
    void compareUnsigned() {
    }

    @Test
    void toUnsignedLong() {
    }

    @Test
    void divideUnsigned() {
    }

    @Test
    void remainderUnsigned() {
    }

    @Test
    void highestOneBit() {
    }

    @Test
    void lowestOneBit() {
    }

    @Test
    void numberOfLeadingZeros() {
        Integer i = new Integer(123);
        String k = Integer.toBinaryString(i);
        System.out.printf("二进制数为%s  长度%d \n" , k,k.length());

        int n =  Integer.numberOfLeadingZeros(i);
        System.out.println("numberOfLeadingZeros "+ n);
    }

    @Test
    void numberOfTrailingZeros() {
        Integer i = new Integer(120);
        String k = Integer.toBinaryString(i);
        System.out.printf("二进制数为%s  长度%d \n" , k,k.length());

        int n =  Integer.numberOfTrailingZeros(i);
        System.out.println("numberOfLeadingZeros "+ n);
    }

    @Test
    void bitCount() {
        Integer i = new Integer(10);
        String k = Integer.toBinaryString(i);
        System.out.printf("二进制数为%s  长度%d \n" , k,k.length());

        int n =  Integer.bitCount(i);
        System.out.println("bitCount "+ n);

    }

    @Test
    void rotateLeft() {
        Integer i = new Integer(10);
        String k = Integer.toBinaryString(i);
        System.out.printf("二进制数为%s  长度%d \n" , k,k.length());

        int n =  Integer.rotateLeft(i,1);
        System.out.println("rotateLeft "+ n);


        int n2 =  Integer.rotateLeft(i,2);
        System.out.println("rotateLeft "+ n2);
    }

    @Test
    void rotateRight() {
        Integer i = new Integer(10);
        String k = Integer.toBinaryString(i);
        System.out.printf("二进制数为%s  长度%d \n" , k,k.length());

        int n =  Integer.rotateRight(i,1);
        String n_l = Integer.toBinaryString(n);

        System.out.printf("二进制数为%s  长度%d \n" , n_l,n_l.length());

        System.out.println("rotateRight "+ n);


        int n2 =  Integer.rotateRight(i,2);
        String n2_l = Integer.toBinaryString(n2);

        System.out.printf("二进制数为%s  长度%d \n" , n2_l,n2_l.length());

        System.out.println("rotateRight "+ n2);
    }

    @Test
    void reverse() {
        Integer i = new Integer(10);
        String k = Integer.toBinaryString(i);
        System.out.printf("二进制数为%s  长度%d \n" , k,k.length());

        int n =  Integer.reverse(i);
        String n_l = Integer.toBinaryString(n);
        System.out.printf("二进制数为%s  长度%d \n" , n_l,n_l.length());

        System.out.println("reverse "+ n);

    }

    @Test
    void signum() {
        Integer i = new Integer(10);
        String k = Integer.toBinaryString(i);
        System.out.printf("二进制数为%s  长度%d \n" , k,k.length());

        int n =  Integer.signum(i);
        String n_l = Integer.toBinaryString(n);
        System.out.printf("二进制数为%s  长度%d \n" , n_l,n_l.length());

        System.out.println("reverse "+ n);
    }

    @Test
    void reverseBytes() {
        Integer i = new Integer(1296);
        String k = Integer.toBinaryString(i);
        System.out.printf("二进制数为%s  长度%d \n" , k,k.length());

        int n =  Integer.reverseBytes(i);
        String n_l = Integer.toBinaryString(n);
        System.out.printf("二进制数为%s  长度%d \n" , n_l,n_l.length());

        System.out.println("reverse "+ n);
    }

    @Test
    void sum() {
    }

    @Test
    void max() {
    }

    @Test
    void min() {
    }
}