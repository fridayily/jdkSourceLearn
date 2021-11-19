package cn.my.test;

import java.io.*;

public class SerializeTester implements Serializable {
    public static void main(String... strings) throws Exception {
        File file = new File("out.ser");

        ObjectOutputStream oos = new ObjectOutputStream(
                new FileOutputStream(file));
        Person person = new Person("张三",20);
        SessionDTO dto = new SessionDTO(12134,person);

        System.out.println(
                "data : " + dto.getData()
                + "\n person : " + dto.getPerson()
                + "\n person : " + dto.getPerson().getName()
                + "\n activation time : " + dto.getActivationTime()
                + "\n serialVersionUID : " + dto.getserialVersionUID()
        );
        System.out.println("---------------进行序列化--------------");
        oos.writeObject(dto);

        // 由于java序利化算法不会重复序列化同一个对象，只会记录已序列化对象的编号。
        // 如果序列化一个可变对象（对象内的内容可更改）后，更改了对象内容，再次序列化，
        // 并不会再次将此对象转换为字节序列，而只是保存序列化编号
        System.out.println("---------------序列化后重新设置值--------------");
        dto.getPerson().setName("李四");

        System.out.println(
                "data : " + dto.getData()
                        + "\n person : " + dto.getPerson()
                        + "\n person : " + dto.getPerson().getName()
                        + "\n activation time : " + dto.getActivationTime()
                        + "\n serialVersionUID : " + dto.getserialVersionUID()
        );

        oos.writeObject(dto);
        oos.close();
        ObjectInputStream ois = new ObjectInputStream(
                new FileInputStream(file));
        SessionDTO dtr = (SessionDTO) ois.readObject();

        System.out.println("---------------更改了对象内容，再次序列化,并不会再次将此对象转换为字节序列，而只是保存序列化编号 -------------");

        System.out.println("data : " + dtr.getData()
                + "\n person : " + dtr.getPerson()
                + "\n person : " + dtr.getPerson().getName()
                + "\n activation time : " + dtr.getActivationTime());


        SessionDTO dtr1 = (SessionDTO) ois.readObject();

        System.out.println("data : " + dtr1.getData()
                + "\n person : " + dtr1.getPerson()
                + "\n person : " + dtr1.getPerson().getName()
                + " activation time : " + dtr1.getActivationTime());
        ois.close();
    }
}

//class SessionDTO implements Serializable {
//    private static final long serialVersionUID = 1L;
//    private int data; // Stores session data
//
//    // Session activation time (creation, deserialization)
//    private long activationTime;
//
//    public SessionDTO(int data) {
//        this.data = data;
//        this.activationTime = System.currentTimeMillis();
//    }
//
//    public int getData() {
//        return data;
//    }
//
//    public long getActivationTime() {
//        return activationTime;
//    }
//}


class SessionDTO implements Serializable {
    // JAVA序列化的机制是通过判断类的serialVersionUID来验证的版本一致的
    //在进行反序列化时，JVM会把传来的字节流中的serialVersionUID于本地相应实体类的serialVersionUID进行比较。
    // 如果相同说明是一致的，可以进行反序列化，否则会出现反序列化版本一致的异常，即是InvalidCastException。
    private static final long serialVersionUID = 1L;
    private transient int data; // Stores session data
    // 将不需要序列化的属性前添加关键字transient，序列化对象的时候，这个属性就不会被序列化
    //Session activation time (creation, deserialization)
    private transient long activationTime;

    private transient Person person;

//    Person person = new Person("路飞",20);

    // 构造函数
    public SessionDTO(int data,Person person) {
        this.person = person;
        this.data = data;
        this.activationTime = System.currentTimeMillis();
    }

    // 自定义序列化
    // 通过重写writeObject与readObject方法，可以自己选择哪些属性需要序列化， 哪些属性不需要。
    // 如果writeObject使用某种规则序列化，则相应的readObject需要相反的规则反序列化，以便能正确反序列化出对象
    private void writeObject(ObjectOutputStream oos) throws IOException {
        //  defaultWriteObject 方法会执行默认的序列化机制，此时会忽略 data 字段
        oos.defaultWriteObject();
        // 对data 进行序列化 调用writeInt()方法显示地将 data 字段写入到ObjectOutputStream
        oos.writeInt(data);
        oos.writeObject(person);
        System.out.println("session serialized");
    }

    private void readObject(ObjectInputStream ois) throws IOException,
            ClassNotFoundException {
        ois.defaultReadObject();
        data = ois.readInt();
        person = (Person) ois.readObject();
        activationTime = System.currentTimeMillis();
        System.out.println("session deserialized");
    }

    public int getData() {
        return data;
    }

    public Person getPerson(){
        return person;
    }

    public long getActivationTime() {
        return activationTime;
    }

    public long getserialVersionUID(){
        return serialVersionUID;
    }
//
    public void writeReplace() throws ObjectStreamException {
        System.out.println("writeReplace happen");
//        return  new Person("路飞",20);
    }

//    public Object readResolve() throws  ObjectStreamException{
//        System.out.println("readResolve happen");
//        return  new Person("路飞",20);
//    }
}


//  这里必须序列化，因为
// 如果一个可序列化的类的成员不是基本类型，也不是String类型，那这个引用类型也必须是可序列化的；否则，会导致此类不能序列化。
class Person implements Serializable {
    private String name;
    private int age;
    public Person(String name,int age){
        this.name = name;
        this.age = age;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return this.name;
    }

}