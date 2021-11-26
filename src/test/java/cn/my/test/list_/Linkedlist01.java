package cn.my.test.list_;

@SuppressWarnings({"all"})
public class Linkedlist01 {
    public static void main(String[] args) {

        Node jack = new Node("jack");
        Node tom = new Node("tom");
        Node lucy = new Node("lucy");

        // 连接三个节点形成双向链表


        jack.next = tom;
        tom.next = lucy;

        lucy.pre = tom;
        tom.pre = jack;

        Node first = jack; // 让first引用指向jack 就是双向链表的头
        Node last = lucy;// 让last引用指向lucy 就是双向链表的尾节点

        // 演示
        System.out.println("=====演示====");
        while (true) {
            if (first == null) {
                break;
            }
            System.out.println(first);
            first = first.next;
        }


        // 在tom -- lucy 加一个对象 smith

        // 1.先创建一个 Node 对象
        System.out.println("=====添加演示====");

        Node smith = new Node("smith");
        // 把smith加入到双向链表
        smith.next = lucy;
        smith.pre = tom;
        lucy.pre = smith;
        tom.next= smith;

        first = jack;

        System.out.println("----------------------");
        while (true) {
            if (first == null) {
                break;
            }
            System.out.println(first);
            first = first.next;
        }


    }


}


// 定义一个Mode类，Node 对象表示双向链表的一个节点

class Node {
    public Object item;  // 真正存放数据
    public Node next; // 指向下一个节点
    public Node pre; // 指向前一个节点

    public Node(Object name) {
        this.item = name;
    }

    @Override
    public String toString() {
        return "Node{" +
                "item=" + item +
                '}';
    }
}