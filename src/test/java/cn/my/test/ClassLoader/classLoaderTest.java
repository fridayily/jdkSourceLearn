package cn.my.test.ClassLoader;

public class classLoaderTest {
    public static void main(String[] args) {
        System.out.println(System.getProperty("sun.boot.class.path"));

        System.out.println("------------------");
        System.out.println(System.getProperty("java.ext.dirs"));


        System.out.println("------------------");
        System.out.println(System.getProperty("java.class.path"));

        ClassLoader myTestClassLoader = myTest.class.getClassLoader();

        System.out.println("myTestClassLoader is : "+ myTestClassLoader.toString());
        System.out.println("myTestClassLoader Parent is : "+ myTestClassLoader.getParent().toString());
        try {
            System.out.println("myTestClassLoader Parent's Parent is : " + myTestClassLoader.getParent().getParent().toString());
        } catch (NullPointerException e ){
            System.out.println("ExtClassLoader");
            System.out.println(e);
        }

        System.out.println("-------------------");

        ClassLoader intClassLoader = int.class.getClassLoader();

        try {
            System.out.println("intClassLoader is:" + intClassLoader.toString());
        } catch ( NullPointerException e){
            System.out.println("");
            System.out.println(e);

        }


    }
}
