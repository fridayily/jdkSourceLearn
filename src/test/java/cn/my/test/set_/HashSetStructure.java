package cn.my.test.set_;

public class HashSetStructure {
    public static void main(String[] args) {
        // 模拟一个HashSet 的底层 (hashMap)

        // 1.创建一个数组，数组的类型是Node[]
        // 2.有些人 直接把Node[] 数组称为表
        Node[] table = new Node[16];
        System.out.println("table=" + table);

        // 3.创建结点
        Node john = new Node("john", null);

        table[2] = john;
        Node jack = new Node("jack", null);
        john.next = jack; // 将jack 结点挂载到john
        Node rose = new Node("Rose", null);
        jack.next = rose;

        Node lucy = new Node("lucy", null);
        table[3] = lucy;

        System.out.println("table=" + table);
    }
}

class Node { // 结点，存储数据，可以指向下一个结点，从而形成链表

    Object item; // 存放数据
    Node next; // 指向下一个Node

    public Node(Object item, Node next) {
        this.item = item;
        this.next = next;
    }
}
