package cn.my.test;

// https://blog.csdn.net/qq_42282074/article/details/104847312
public class PlateTest {

    static class Food {
        @Override
        public String toString() {
            return "food";
        }
    }

    static class Fruit extends Food {
        @Override
        public String toString() {
            return "fruit";
        }
    }

    static class Apple extends Fruit {
        @Override
        public String toString() {
            return "apple";
        }
    }

    static class Plate<T>{
        private T item;

        public Plate(T t){
            item=t;
        }

        public void setItem(T t) {
            this.item = t;
        }

        public T getItem() {
            return item;
        }
    }

  public static void main(String[] args) {
      Plate<? extends Fruit> p= new Plate<Apple>(new Apple());
//      p.setItem(new Fruit());

      //读取出来的东西只能存放在Fruit或它的基类里。
      Fruit item = p.getItem();
      Object ob = p.getItem();
//      Apple apple = p.getItem();


      Plate<? super Fruit> p1= new Plate<>(new Food());
//      p.setItem(new Fruit());

      p1.setItem(new Fruit());
      p1.setItem(new Apple());

      Food food = (Food) p1.getItem();
      Object ob1 = p1.getItem();
      Apple apple2 = (Apple) p1.getItem();
  }
}
