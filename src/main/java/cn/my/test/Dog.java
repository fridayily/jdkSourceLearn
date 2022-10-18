package cn.my.test;

public class Dog {

    private String name = "招财猫";

    public int age = 10;

    public Dog() {}

    public Dog(String name){
        this.name = name;
    }

    public void hi() {
//        System.out.println("hi " + name);

    }

    public void cry() {
        System.out.println(name + "喵喵叫");
    }
}
