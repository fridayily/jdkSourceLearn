package cn.my.test.buffer_;

import org.junit.jupiter.api.Test;

import java.nio.ByteBuffer;

public class ByteBufferTest {
    @Test
    public void testBuffer() {
        // 初始化一个大小为6的ByteBuffer
        ByteBuffer buffer = ByteBuffer.allocate(9);
        print(buffer);  // 初始状态：position: 0, limit: 6, capacity: 6

        // 往buffer中写入3个字节的数据
        buffer.put((byte) 1);
        buffer.put((byte) 2);
        buffer.put((byte) 3);
        print(buffer);  // 写入之后的状态：position: 3, limit: 6, capacity: 6

        System.out.println("************** after flip **************");
        buffer.flip();
        print(buffer);  // 切换为读取模式之后的状态：position: 0, limit: 3, capacity: 6

        buffer.get();
        buffer.get();
        print(buffer);  // 读取两个数据之后的状态：position: 2, limit: 3, capacity: 6
    }

    @Test
    public void testMark() {
        ByteBuffer buffer = ByteBuffer.allocate(9);
        // position: 0, limit: 6, capacity: 6

        buffer.put((byte) 1);
        buffer.put((byte) 2);
        buffer.put((byte) 3);
        print(buffer);
        // position: 3, limit: 6, capacity: 6

        buffer.mark();  // 写入三个字节数据后进行标记
        print(buffer);
        // position: 3, limit: 6, capacity: 6

        buffer.put((byte) 4); // 再次写入一个字节数据
        print(buffer);
        // position: 4, limit: 6, capacity: 6

        buffer.reset(); // 对buffer进行重置，此时将恢复到Mark时的状态
        print(buffer);
        // position: 3, limit: 6, capacity: 6

        buffer.flip();  // 切换为读取模式，此时有三个数据可供读取
        print(buffer);
        // position: 0, limit: 3, capacity: 6

        buffer.get(); // 读取一个字节数据之后进行标记
        buffer.mark();
        print(buffer);
        // position: 1, limit: 3, capacity: 6

        buffer.get(); // 继续读取一个字节数据
        print(buffer);
        // position: 2, limit: 3, capacity: 6

        buffer.reset(); // 进行重置之后，将会恢复到mark的状态
        print(buffer);
        // position: 1, limit: 3, capacity: 6
    }

    @Test
    public void testRewind() {
        ByteBuffer buffer = ByteBuffer.allocate(9);
        // position: 0, limit: 6, capacity: 6

        buffer.put((byte) 1);
        buffer.put((byte) 2);
        buffer.put((byte) 3);
        // position: 3, limit: 6, capacity: 6

        buffer.rewind();  // 调用rewind()方法之后，buffer状态将会重置
        // position: 0, limit: 6, capacity: 6
    }

    @Test
    public void testCompact() {
        ByteBuffer buffer = ByteBuffer.allocate(6);
        buffer.put((byte) 1);
        buffer.put((byte) 2);
        buffer.put((byte) 3);
        buffer.put((byte) 4);
        buffer.put((byte) 5);
        buffer.put((byte) 6); // 初始化一个写满的buffer

        print(buffer);

        System.out.println("flip");
        buffer.flip();
        print(buffer);
        // position: 0, limit: 6, capacity: 6  -- 切换为读取模式

        System.out.println(buffer.get());
        System.out.println(buffer.get());
        print(buffer);
//        buffer.get();
        // position: 2, limit: 6, capacity: 6  -- 读取两个字节后，还剩余四个字节

        System.out.println("compact");
        //比如在一个长度为6的ByteBuffer中写满了数据，然后在读取模式下读取了2个数据之后,
        // 我们想继续往buffer中写入数据，此时由于只有前2个字节是可用的，而后4个字节是有效的数据，
        // 此时如果写入的话是会把后面4个有效字节给覆盖掉的。因而需要将后面4个有效字节往前移动,
        // 以空出2个字节，并且将position指向下一个可供写入的位置，而不是迁移之后的索引0处

        buffer.compact();
        print(buffer);
        // position: 4, limit: 6, capacity: 6  -- 进行压缩之后将从第五个字节开始

        buffer.put((byte) 7);
        print(buffer);
        // position: 5, limit: 6, capacity: 6  -- 写入一个字节数据的状态
    }

    @Test
    public void testFreeMemory(){
        System.out.println("----------Test allocate--------");
        System.out.println("before alocate:" + Runtime.getRuntime().freeMemory());

        // 如果分配的内存过小，调用Runtime.getRuntime().freeMemory()大小不会变化？
        // 要超过多少内存大小JVM才能感觉到？
        ByteBuffer buffer = ByteBuffer.allocate(102400);
        System.out.println("buffer = " + buffer);

        System.out.println("after alocate:" + Runtime.getRuntime().freeMemory());

        // 这部分直接用的系统内存，所以对JVM的内存没有影响
        ByteBuffer directBuffer = ByteBuffer.allocateDirect(102400);
        System.out.println("directBuffer = " + directBuffer);
        System.out.println("after direct alocate:" + Runtime.getRuntime().freeMemory());

        System.out.println("----------Test wrap--------");
        byte[] bytes = new byte[32];
        buffer = ByteBuffer.wrap(bytes);
        System.out.println(buffer);

        buffer = ByteBuffer.wrap(bytes, 10, 10);
        System.out.println(buffer);
    }

    private void print(ByteBuffer buffer) {
        System.out.printf("position: %d, limit: %d, capacity: %d\n",
                buffer.position(), buffer.limit(), buffer.capacity());
    }
}
