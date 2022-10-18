package cn.my.source.java.lang;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class EnumTest {

    public enum Color {
        RED,BLUE,GREEN,BLACK;
    }

    @BeforeEach
    void setUp() {

    }

    @Test
    void name() {

        System.out.println("BLACK " + Color.BLACK);
        System.out.println("RED " + Color.valueOf("RED"));
        System.out.println("name " + Color.BLACK.name());
        System.out.println("getClass " + Color.BLACK.getClass());
    }

    @Test
    void ordinal() {
        System.out.println("ordinal " + Color.BLACK.ordinal() );

    }

    @Test
    void testToString() {

        System.out.println("ordinal " + Color.BLACK.toString() );

    }

    @Test
    void testEquals() {
        System.out.println("Equals " + Color.BLACK.equals(Color.BLUE) );

    }

    @Test
    void testHashCode() {
        System.out.println("Equals " + Color.BLACK.hashCode() );

    }

    @Test
    void testClone() {
//        System.out.println("Equals " + Color.BLACK );

    }

    @Test
    void compareTo() {
        System.out.println("compareTo " + Color.BLACK.compareTo(Color.BLUE) );

    }

    @Test
    void getDeclaringClass() {
        System.out.println("getClass " + Color.BLACK.getDeclaringClass() );

    }
}