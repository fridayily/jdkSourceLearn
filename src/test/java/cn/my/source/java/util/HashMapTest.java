package cn.my.source.java.util;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class HashMapTest {

    HashMap<Integer, String> hashMap = new HashMap(16);

    @BeforeEach
    void setUp() {
//        HashMap<String, String> hashMap = new HashMap<>();
//        hashMap.put("19", "190");
//        hashMap.put("3", "30");
//        hashMap.put("35", "350");
//        hashMap.put("7", "70");
        hashMap.put(7, "");
        hashMap.put(11, "");
        hashMap.put(43, "");
//        hashMap.put(59, "");
//        hashMap.put(19, "");
//        hashMap.put(3, "");
//        hashMap.put(35, "");
//        String oldvalue =  hashMap.put("day1", "2021-07-16");
//        System.out.println("oldvalue "+oldvalue);

    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void hash() {

        // s[0]*31^(n-1) + s[1]*31^(n-2) + ... + s[n-1]
        System.out.println("0".hashCode());
        // ascii(0)*31^0 = 48

        System.out.println("00".hashCode());
        // ascii(0)*31^1 + ascii(0)*31^0 = 48*31 + 48 =48*32 = 1536

        System.out.println("a".hashCode());
    }



//    @Test
//    public void testTraversal() {
//
//
//    }
    @Test
    void comparableClassFor() {
    }

    @Test
    void compareComparables() {
    }

    @Test
    void tableSizeFor() {
    }

    @Test
    void putMapEntries() {
    }

    @Test
    void size() {
    }

    @Test
    void isEmpty() {
    }

    @Test
    void get() {
      String date =   hashMap.get("day1");
      System.out.println("date "+date);
    }

    @Test
    void getNode() {
    }

    @Test
    void containsKey() {
    }

    @Test
    void put() {
        hashMap.put(59, "");
        hashMap.put(19, "");
        hashMap.put(3, "");
        hashMap.put(35, "");
    }

    @Test
    void putVal() {
    }

    @Test
    void resize() {

//        hashMap
    }

    @Test
    void treeifyBin() {
    }

    @Test
    void putAll() {
    }

    @Test
    void remove() {
    }

    @Test
    void removeNode() {
    }

    @Test
    void clear() {
    }

    @Test
    void containsValue() {
    }

    @Test
    void keySet() {
        System.out.println("遍历结果：");

        Set<Integer> keysets = hashMap.keySet();
        for (Integer key : keysets) {
            System.out.print(key + " -> ");
        }
    }

    @Test
    void values() {
    }

    @Test
    void entrySet() {
    }

    @Test
    void getOrDefault() {
    }

    @Test
    void putIfAbsent() {
    }

    @Test
    void testRemove() {
    }

    @Test
    void replace() {
    }

    @Test
    void testReplace() {
    }

    @Test
    void computeIfAbsent() {
    }

    @Test
    void computeIfPresent() {
    }

    @Test
    void compute() {
    }

    @Test
    void merge() {
    }

    @Test
    void forEach() {
    }

    @Test
    void replaceAll() {
    }

    @Test
    void testClone() {
    }

    @Test
    void loadFactor() {
    }

    @Test
    void capacity() {
    }

    @Test
    void newNode() {
    }

    @Test
    void replacementNode() {
    }

    @Test
    void newTreeNode() {
    }

    @Test
    void replacementTreeNode() {
    }

    @Test
    void reinitialize() {
    }

    @Test
    void afterNodeAccess() {
    }

    @Test
    void afterNodeInsertion() {
    }

    @Test
    void afterNodeRemoval() {
    }

    @Test
    void internalWriteEntries() {
    }
}