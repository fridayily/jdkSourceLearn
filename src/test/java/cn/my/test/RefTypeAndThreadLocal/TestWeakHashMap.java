package cn.my.test.RefTypeAndThreadLocal;

import java.nio.ByteBuffer;
import java.util.WeakHashMap;

public class TestWeakHashMap {
    public static void main(String[] args) {
        WeakHashMap<String,String> map = new WeakHashMap<>();

        ByteBuffer b = ByteBuffer.allocate(1024); // 在堆内分配
        ByteBuffer buffer = ByteBuffer.allocateDirect(1024); // 在堆外分配
    }
}
