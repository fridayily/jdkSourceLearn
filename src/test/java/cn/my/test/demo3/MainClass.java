package cn.my.test.demo3;

public class MainClass {
    public static void main(String[] args) {
        // 创建抽奖器对象，指定数据类型
        ProductGetter<String> stringProductGetter = new ProductGetter<>();
        String[] strProducts = {"苹果手机","华为手机","扫地机器人","咖啡机"};
        // 抽奖器填充奖品
        for (int i = 0; i < strProducts.length; i++) {
            stringProductGetter.addProduct(strProducts[i]);
        }

        // 抽奖
        String product = stringProductGetter.getProduct();
        System.out.println("抽中： " + product);
        System.out.println("---------------------------");

        ProductGetter<Integer> integerProductGetter = new ProductGetter<>();
        int[] intProducts = {1000,5000,3000,500,30000};
        for (int i = 0; i < strProducts.length; i++) {
            integerProductGetter.addProduct(intProducts[i]);
        }

        // 抽奖
        Integer intProduct = integerProductGetter.getProduct();
        System.out.println("抽中： " + intProduct);
        System.out.println("---------------------------");

    }
}
