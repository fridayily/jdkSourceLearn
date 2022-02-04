package source.java.io;

import org.junit.jupiter.api.Test;

import java.io.*;

class SerializeTester {
    @Test
    void SessionTest() throws IOException, ClassNotFoundException {
        File file = new File("out.ser");

        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(
                    new FileOutputStream(file));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Person person = new Person("张三", 20);
        SessionDTO dto = new SessionDTO(12134, person);

        System.out.println(
                "data : " + dto.getData()
                        + "\n person : " + dto.getPerson()
                        + "\n person : " + dto.getPerson().getName()
                        + "\n activation time : " + dto.getActivationTime()
                        + "\n serialVersionUID : " + dto.getserialVersionUID()
        );
        oos.writeObject(dto);

        // 由于java序利化算法不会重复序列化同一个对象，只会记录已序列化对象的编号。
        // 如果序列化一个可变对象（对象内的内容可更改）后，更改了对象内容，再次序列化，
        // 并不会再次将此对象转换为字节序列，而只是保存序列化编号
        System.out.println("--------------------- 修改person 名称 ---------------------");
        dto.getPerson().setName("李四");

        System.out.println(
                "data : " + dto.getData()
                        + "\n person : " + dto.getPerson()
                        + "\n person : " + dto.getPerson().getName()
                        + "\n activation time : " + dto.getActivationTime()
                        + "\n serialVersionUID : " + dto.getserialVersionUID()
        );
        System.out.println("--------------------- 将对象序列化写入 ---------------------");

        oos.writeObject(dto); // 这里写入是原来的流
        oos.close();

        ObjectInputStream ois = new ObjectInputStream(
                new FileInputStream(file));

        System.out.println("--------------------- 将对象序列化读入 ---------------------");

        SessionDTO dtr = (SessionDTO) ois.readObject(); // 反序列化对象是JVM生成的

        System.out.println("data : " + dtr.getData()
                + "\n person : " + dtr.getPerson()
                + "\n person : " + dtr.getPerson().getName()
                + "\n activation time : " + dtr.getActivationTime());

        System.out.println("--------------------- 将对象序列化读入 ---------------------");
        SessionDTO dtr1 = (SessionDTO) ois.readObject();

        System.out.println("data : " + dtr1.getData()
                + "\n person : " + dtr1.getPerson()
                + "\n person : " + dtr1.getPerson().getName()
                + "\n activation time : " + dtr1.getActivationTime());
        ois.close();

    }


    @Test
    void SerialProcessTest() throws IOException {
        System.out.println("序列化过程测试");
        File file = new File("person.txt");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream( new FileOutputStream(file));
        Person person = new Person();
        person.setAge(25);
        person.setName("zhangsan");
        objectOutputStream.writeObject(person);
        objectOutputStream.flush();
        objectOutputStream.close();

    }
}

    @Test
    void writeObjectTest() throws FileNotFoundException {
        System.out.println("测试对序列化后的对象重新序列化");


        File file = new File("teacher.txt");
        try (ObjectOutputStream oos1 = new ObjectOutputStream(new FileOutputStream(file))) {
            Person person = new Person("路飞", 20);
            Teacher t1 = new Teacher("雷利", person);
            Teacher t2 = new Teacher("红发香克斯", person);
            //依次将4个对象写入输入流
            oos1.writeObject(t1); // 新的序列化
            oos1.writeObject(t2); // 新的序列化
            oos1.writeObject(person); // 输出编码，因为person 在 他 序列化过
            oos1.writeObject(t2); // 输出编码
        } catch (IOException e) {
            e.printStackTrace();
        }
        /*
         * 1.所有保存到磁盘到对象都有一个序列化编码
         * 2.当程序视图序列化一个对象时，会先检查此对象是否已经序列化过，只有此对象从未被序列化过，才会将此对象序列户为字节序列输出
         * 3。如果此对象已经序列化过，则直接输出编号即可
         *
         * */
    }


    @Test
    void SerialProcessTest() throws IOException {
        System.out.println("序列化过程测试");
        File file = new File("person.txt");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream( new FileOutputStream(file));
        Person person = new Person();
        person.setAge(25);
        person.setName("zhangsan");
        objectOutputStream.writeObject(person);
        objectOutputStream.flush();
        objectOutputStream.close();

    }


    @Test
    void writeObjectTest() throws FileNotFoundException {
        System.out.println("测试对序列化后的对象重新序列化");


        File file = new File("teacher.txt");
        try (ObjectOutputStream oos1 = new ObjectOutputStream(new FileOutputStream(file))) {
            Person person = new Person("路飞", 20);
            Teacher t1 = new Teacher("雷利", person);
            Teacher t2 = new Teacher("红发香克斯", person);
            //依次将4个对象写入输入流
            oos1.writeObject(t1); // 新的序列化
            oos1.writeObject(t2); // 新的序列化
            oos1.writeObject(person); // 输出编码，因为person 在 他 序列化过
            oos1.writeObject(t2); // 输出编码
        } catch (IOException e) {
            e.printStackTrace();
        }
        /*
         * 1.所有保存到磁盘到对象都有一个序列化编码
         * 2.当程序视图序列化一个对象时，会先检查此对象是否已经序列化过，只有此对象从未被序列化过，才会将此对象序列户为字节序列输出
         * 3。如果此对象已经序列化过，则直接输出编号即可
         *
         * */
    }


class SessionDTO implements Serializable {
    // JAVA序列化的机制是通过判断类的serialVersionUID来验证的版本一致的
    // 在进行反序列化时，JVM会把传来的字节流中的serialVersionUID于本地相应实体类的serialVersionUID进行比较。
    // 如果相同说明是一致的，可以进行反序列化，否则会出现反序列化版本一致的异常，即是InvalidCastException。
    private static final long serialVersionUID = 1L;
    private transient int data; // Stores session data
    // 将不需要序列化的属性前添加关键字transient，序列化对象的时候，这个属性就不会被序列化
    //Session activation time (creation, deserialization)
    private transient long activationTime;

    private transient Person person;

//    Person person = new Person("路飞",20);

    // 构造函数
    public SessionDTO(int data, Person person) {
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

    public Person getPerson() {
        return person;
    }

    public long getActivationTime() {
        return activationTime;
    }

    public long getserialVersionUID() {
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

    public Person(){}

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getAge() {
        return this.age;
    }


}


class Teacher implements Serializable {
    private String name;
    private Person person;

    public Teacher(String name, Person person) {
        this.name = name;
        this.person = person;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }


}