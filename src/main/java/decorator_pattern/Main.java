package decorator_pattern;

public class Main {

    public static void main(String[] args) {
        // 1、实例化，选择一个自行车
        Bike bike = new BigBike();

        // 2、搭配防爆胎
        bike = new RSCBikeDecorator(bike);
        bike = new RSCBikeDecorator(bike);

        // 3、搭配唢呐
        bike = new SuonaBikeDecorator(bike);
        bike = new SuonaBikeDecorator(bike);

        System.out.println(bike.getDesc() + " 的价格是" + bike.getPrice());
    }
}
