package cn.my.source.java.util.stream;

//import com.sun.tools.javac.util.List;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class StreamTest {

    @Test
    void filter() {
    }

    @Test
    void map() {
        Arrays.stream(new String[]{"A", "B", "C"}).forEach(System.out::println);
        System.out.println("----------------------");
        Arrays.stream(new Integer[]{1, 5, 8}).forEach(System.out::println);


        List<String> names = Arrays.asList("Bob", "Alice", "Tim");
        List<Person> persons = names.stream().map(Person::new).collect(Collectors.toList());
        System.out.println(persons);


        List<String> list = Arrays.asList("test", "hello", "world", "java", "tom", "C", "javascript");
        list.stream().map(String::toUpperCase).forEach(System.out::println);


        Stream<String> stream1 = Arrays.stream(new String[]{"A", "B", "C"});
        Stream<String> stream2 = com.sun.tools.javac.util.List.of("X", "Y", "Z").stream();
        stream1.forEach(System.out::println);
        stream2.forEach(System.out::println);
    }

    /**
     * 获取集合中的最大值或最小值
     */
    @Test
    public void testMaxAndMin() {
        List<Integer> list = Arrays.asList(1, -1, 2, -2);
        Integer max = list.stream().max(Integer::compare).get();
        Integer min = list.stream().min(Integer::compare).get();
        System.out.printf("max=%s, min=%s", max, min); // max=2, min=-2
    }


    @Test
    void Streammini() {
        List<String> names = Arrays.asList("kotlin", "java", "go");
        int maxLength = names.stream().filter(name -> name.length() <= 4).map(String::length)
                .max(Comparator.naturalOrder()).orElse(-1);
        System.out.println(maxLength);
    }

    @Test
    void mapToInt() {
    }

    @Test
    void mapToLong() {
    }

    @Test
    void mapToDouble() {
    }

    @Test
    void flatMap() {
    }

    @Test
    void flatMapToInt() {
    }

    @Test
    void flatMapToLong() {
    }

    @Test
    void flatMapToDouble() {
    }

    @Test
    void distinct() {
    }
}

class Person {
    String name;

    public Person(String name) {
        this.name = name;
    }

    public String toString() {
        return "Person:" + this.name;
    }
}