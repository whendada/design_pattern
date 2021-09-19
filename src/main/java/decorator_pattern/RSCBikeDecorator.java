package decorator_pattern;

/**
 * 防爆胎功能
 */
public class RSCBikeDecorator extends BikeDecorator{

    private String desc = "增加一个防爆胎";

    private Bike bike;

    public RSCBikeDecorator(Bike bike) {
        this.bike = bike;
    }

    @Override
    public String getDesc() {
        return bike.getDesc() + "," + desc;
    }

    /**
     * 100是防爆胎的价格
     */
    @Override
    public Integer getPrice() {
        return bike.getPrice() + 100;
    }
}
