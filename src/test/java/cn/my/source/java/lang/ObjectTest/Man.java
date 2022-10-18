package cn.my.source.java.lang.ObjectTest;

public class Man extends Person{
    private String sex;

    public Man(String pname,int page,String sex){
        super(pname,page);
        this.sex = sex;
    }
//    @Override
    public boolean equals_false(Object obj) {
        if(!super.equals(obj)){
            return false;
        }
        if(obj == null || !(obj instanceof  Man)){//对象为空或者不是Person类的实例
            return false;
        }
        Man man = (Man) obj;
        return sex.equals(man.sex);
    }

//    @Override
//    public boolean equals(Object obj) {
//        if(this == obj){//引用相等那么两个对象当然相等
//            return true;
//        }
//        if(obj == null || (getClass() != obj.getClass())){//对象为空或者不是Person类的实例
//            return false;
//        }
//        Person otherPerson = (Person)obj;
//        if(otherPerson.getPname().equals(this.getPname()) && otherPerson.getPage()==this.getPage()){
//            return true;
//        }
//        return false;
//    }



    public static void main(String[] args) {
        Person p = new Person("Tom",22);
        Man m = new Man("Tom",22,"男");

        System.out.println(p.equals(m));//true
        System.out.println(m.equals(p));//false
    }
}
