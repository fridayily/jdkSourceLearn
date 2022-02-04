package cn.my.source.java.lang;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class StringTest {
    String st;

    @BeforeEach
    void setUp() {
        this.st = "abc12345AAb1";




    }

    @Test
    void init()
    {
        // public String():空构造
        String s1 = new String();
        System.out.println("s1:" + s1);
        System.out.println("s1.length():" + s1.length());
        System.out.println("--------------------------");

        // public String(byte[] bytes):把字节数组转成字符串
        byte[] bys = { 97, 98, 99, 100, 101 };
        String s2 = new String(bys);
        System.out.println("s2:" + s2);
        System.out.println("s2.length():" + s2.length());
        System.out.println("--------------------------");

        // public String(byte[] bytes,int index,int length):把字节数组的一部分转成字符串
        // 我想得到字符串"bcd"
        String s3 = new String(bys, 1, 3);
        System.out.println("s3:" + s3);
        System.out.println("s3.length():" + s3.length());
        System.out.println("--------------------------");

        // public String(char[] value):把字符数组转成字符串
        char[] chs = { 'a', 'b', 'c', 'd', 'e', '爱', '林', '亲' };
        String s4 = new String(chs);
        System.out.println("s4:" + s4);
        System.out.println("s4.length():" + s4.length());
        System.out.println("--------------------------");

        // public String(char[] value,int index,int count):把字符数组的一部分转成字符串
        String s5 = new String(chs, 2, 4);
        System.out.println("s5:" + s5);
        System.out.println("s5.length():" + s5.length());
        System.out.println("--------------------------");

        //public String(String original):把字符串常量值转成字符串
        String s6 = new String("abcde");
        System.out.println("s6:" + s6);
        System.out.println("s6.length():" + s6.length());
        System.out.println("--------------------------");

        //字符串字面值"abc"也可以看成是一个字符串对象。
        String s7 = "abcde";
        System.out.println("s7:"+s7);
        System.out.println("s7.length():"+s7.length());
    }



    @Test
    void changliang(){
        String s1 = "Hello";
        String s2 = "Hello";
        String s3 = "Hel" + "lo"; // 首先会在常量内存区创建 hel 和 lo 字符串两个对象，然后在开辟一个空间存放连接后的值 （在编译期间进行优化）
        String s4 = "Hel" + new String("lo"); // 两个对象进行相加，不会优化，生成新的对象


        String s5 = new String("Hello"); //

        //在调用s5.intern()方法的时候会返回”Hello”，但是这个方法会首先检查字符串常量池中是否有”Hello”这个字符串，
        // 如果存在则返回这个字符串的引用，否则就将这个字符串添加到字符串常量池中，然会返回这个字符串的引用。(重要)

        String s6 = s5.intern();
        String s7 = "H";
        String s8 = "ello";
        String s9 = s7 + s8; // 创建新的对象  这里两个都是静态字符串会把结果放入常量池  但s7 s8 字符串的引用

        System.out.println(s1 == s2);  // true
        System.out.println(s1 == s3);  // true
        System.out.println(s1 == s4);  // false
        System.out.println(s1 == s9);  // false
        System.out.println(s4 == s5);  // false
        System.out.println(s1 == s6);  // true

    }

    @Test
    void length() {
    }

    @Test
    void isEmpty() {
        boolean b = this.st.isEmpty();
        System.out.println("isEmpty " + b);

    }

    @Test
    void charAt() {
        char c = this.st.charAt(2);
        System.out.println("charAt " + c);

    }

    @Test
    void codePointAt() {
        int c = "AAA".codePointAt(2);
        System.out.println("codePointAt " + c); //65
        System.out.println("codePointAt hex " + Integer.toHexString(c)); //65
        int d = "AAB".codePointAt(2);
        System.out.println("codePointAt " + d); //65
    }

    @Test
    void codePointBefore() {
        int c = this.st.codePointBefore(2);
        System.out.println("codePointBefore " + c);
    }

    @Test
    void codePointCount() {
        int c = this.st.codePointCount(0, 4);
        System.out.println("codePointCount " + c);
        System.out.println("codePointCount hex " + Integer.toHexString(c));
    }

    @Test
    void offsetByCodePoints() {
        int c = this.st.offsetByCodePoints(2, 4);
        System.out.println("codePointCount " + c);
    }


    @Test
    void testEquals() {
        boolean e = this.st.equals(this.st);
        System.out.println("testEquals e " + e);

    }

    @Test
    void contentEquals() {

//      最大的差别就是String的equals方法只有在另一个对象是String的情况下才可能返回true
//      而contentEquals只要求另一个对象是CharSequence或其子类的对象

        StringBuffer b = new StringBuffer("abc");
        CharSequence c = (CharSequence) b;
        System.out.println("CharSequence" + c);

        boolean e = this.st.contentEquals(b);
        System.out.println("contentEquals " + e);

    }

    @Test
    void testContentEquals() {
    }

    @Test
    void equalsIgnoreCase() {
        String b = "abC12345";
        boolean e = this.st.equalsIgnoreCase(b);
        System.out.println("equalsIgnoreCase " + e);

    }

    @Test
    void compareTo() {
        String b = "abC12345";
        int e = this.st.compareTo(b);
        System.out.println("compareTo " + e);
    }

    @Test
    void compareToIgnoreCase() {
        String b = "abC12345";
        int e = this.st.compareToIgnoreCase(b);
        System.out.println("compareToIgnoreCase " + e);
    }

    @Test
    void regionMatches() {
        String b = "abC12345";
        boolean e = this.st.regionMatches(0, b, 0, 2);
        System.out.println("regionMatches " + e);
    }

    @Test
    void testRegionMatches() {

        String b = "abC12345";
        boolean e = this.st.regionMatches(true, 0, b, 0, 2);
        System.out.println("regionMatches " + e);
    }

    @Test
    void startsWith() {


        String b = "abC12345";
        boolean e = this.st.startsWith("ab", 2);
        System.out.println("startsWith " + e);


        boolean e1 = this.st.startsWith("ab", 0);
        System.out.println("startsWith " + e1);


    }

    @Test
    void testStartsWith() {
        boolean e1 = this.st.startsWith("ab");
        System.out.println("startsWith " + e1);
    }

    @Test
    void endsWith() {
        boolean e1 = this.st.endsWith("ab");
        System.out.println("endsWith " + e1);
    }

    @Test
    void testHashCode() {
        int h = this.st.hashCode();
        System.out.println("testHashCode " + h);


    }

    @Test
    void indexOf() {
        int i = this.st.indexOf("c");
        System.out.println("indexOf " + i);

    }

    @Test
    void testIndexOf() {
        int i = this.st.indexOf("c", 1);
        System.out.println("indexOf " + i);
    }

    @Test
    void lastIndexOf() {

        String b = "abC12ab5";
        int i = this.st.lastIndexOf("ab", 2);
        System.out.println("lastIndexOf " + i);

    }

    @Test
    void testLastIndexOf() {
        int i = this.st.lastIndexOf("13");
        int j = this.st.lastIndexOf("12");
        System.out.println("lastIndexOf i " + i);
        System.out.println("lastIndexOf j " + i);


    }

    @Test
    void testIndexOf1() {
        int j = this.st.lastIndexOf("12", 5);
        System.out.println("lastIndexOf j " + j);
    }


    @Test
    void testIndexOf2() {
    }

    @Test
    void testIndexOf3() {
    }

    @Test
    void testIndexOf4() {
    }

    @Test
    void testLastIndexOf1() {
    }

    @Test
    void testLastIndexOf2() {
    }

    @Test
    void testLastIndexOf3() {
    }

    @Test
    void testLastIndexOf4() {
    }

    @Test
    void substring() {

        String j = this.st.substring(1, 5);
        System.out.println("substring j " + j);

    }

    @Test
    void testSubstring() {

    }

    @Test
    void subSequence() {
        CharSequence j = this.st.subSequence(1, 5);
        System.out.println("subSequence j " + j);
    }

    @Test
    void concat() {
        String j = this.st.concat("qwe");
        System.out.println("concat j " + j);

    }

    @Test
    void replace() {
        String j = this.st.replace("a", "A");
        System.out.println("replace j " + j);
    }

    @Test
    void matches() {
        Boolean j = this.st.matches("^[a]");
        System.out.println("matches j " + j);
    }

    @Test
    void contains() {
        Boolean j = this.st.contains("b");
        System.out.println("matches j " + j);
    }

    @Test
    void replaceFirst() {
        String j = this.st.replaceFirst("b", "d");
        System.out.println("replaceFirst j " + j);


    }

    @Test
    void replaceAll() {
        String j = this.st.replaceAll("b", "d");
        System.out.println("replaceAll j " + j);
    }

    @Test
    void testReplace() {
        String j = this.st.replace("abc", "ABC");
        System.out.println("replace j " + j);

    }

    @Test
    void split() {
        String s = "boo:and:foo";
        String[] s0 = s.split(":");
        System.out.println("split " + Arrays.toString(s0));
        String[] s1 = s.split(":", 1);
        System.out.println("split " + Arrays.toString(s1));
        String[] s2 = s.split(":", 2);
        System.out.println("split " + Arrays.toString(s2));
        String[] s3 = s.split(":", 3);
        System.out.println("split " + Arrays.toString(s3));

//        for(String a:ss) {
//            System.out.println("split " + Arrays.toString(ss));
//
//        }

    }

    @Test
    void testSplit() {
    }

    @Test
    void join() {
        CharSequence delimiter = "_";
        CharSequence ele1 = "a";
        CharSequence ele2 = "b";
        String s = String.join(delimiter, ele1, ele2);
        System.out.println("join s " + s);


    }

    @Test
    void testJoin() {
    }

    @Test
    void toLowerCase() {
        String lowst = this.st.toLowerCase();
        System.out.println("toLowerCase " + lowst);
    }

    @Test
    void testToLowerCase() {
    }

    @Test
    void toUpperCase() {
        String upst = this.st.toUpperCase();
        System.out.println("toUpperCase " + upst);
    }

    @Test
    void testToUpperCase() {
    }

    @Test
    void trim() {
        String s = " a b c ";
        String trim_s = s.trim();
        System.out.println("trim " + trim_s);
    }

    @Test
    void testToString() {

    }

    @Test
    void toCharArray() {
        String s = "abc";
        char[] new_s = s.toCharArray();

        for (char a : new_s) {
            System.out.println("toCharArray " + a);

        }
    }

    @Test
    void format() {
    }

    @Test
    void testFormat() {
    }

    @Test
    void valueOf() {
       Integer  i = 10;
       String str = String.valueOf(i);
        System.out.println("valueOf " + str);
    }

    @Test
    void testValueOf() {
    }

    @Test
    void testValueOf1() {
    }

    @Test
    void copyValueOf() {
        char[] test = new char[]{'a','b','c'};
        String a = String.valueOf(test);
        String b = String.copyValueOf(test);
        System.out.println("valueOf " + a);
        System.out.println("copyValueOf " + b);
        // valueOf  copyValueOf 实现代码一样



    }

    @Test
    void testCopyValueOf() {
    }

    @Test
    void testValueOf2() {
        boolean b = true;
        String str = String.valueOf(b);
        System.out.println("testValueOf2 "+ str);
    }

    @Test
    void testValueOf3() {

        char b = 'z';
        String str = String.valueOf(b);
        System.out.println("testValueOf3 "+ str);
    }

    @Test
    void testValueOf4() {
        int b =  8;
        String str = String.valueOf(b);
        System.out.println("testValueOf4 "+ str);
    }

    @Test
    void testValueOf5() {
        long b =  801111L;
        String str = String.valueOf(b);
        System.out.println("testValueOf5 "+ str);
    }

    @Test
    void testValueOf6() {
        float b =  801111F;
        String str = String.valueOf(b);
        System.out.println("testValueOf6 "+ str);

    }

    @Test
    void testValueOf7() {
        double b =  801111.01;
        String str = String.valueOf(b);
        System.out.println("testValueOf7 "+ str);
    }

    @Test
    void intern() {
        // 返回字符串对象的规范表示形式,可以用来处理在Java中字符串的重复问题
        String s0= "kvill";
        String s1=new String("kvill");
        String s2=new String("kvill");
        System.out.println( s0==s1 ); // false
        System.out.println( "**********");
        s1.intern();
        s2=s2.intern(); //把常量池中“kvill”的引用赋给s2
        System.out.println( s0==s1); //  false 虽然执行了s1.intern(),但它的返回值没有赋给s1
        System.out.println( s1==s2); // false 不是同一对象
        System.out.println( s0==s1.intern() ); // true 说明s1.intern()返回的是常量池中”kvill”的引用
        System.out.println( s0==s2 ); // true
    }


    @Test
    void test() {
        char[] arr = new char[] {'h', 'e', 'l', 'l', 'o', ' ', 'w', 'o', 'r', 'l', 'd'};
        String s = new String(arr,0, arr.length); // "hello world"
        arr[0] = 'a'; // replace the first character with 'a'

        System.out.println("s " + s); // hello world
        System.out.println(arr); // aello world
    }
}