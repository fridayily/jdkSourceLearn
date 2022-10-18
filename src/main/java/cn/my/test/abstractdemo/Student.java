package cn.my.test.abstractdemo;

public class Student extends Person {

    private String name;

    @Override
    public void setName(String name) {
        this.name = name;

    }
    @Override
    public String getName() {
        return this.name;
    }

}
