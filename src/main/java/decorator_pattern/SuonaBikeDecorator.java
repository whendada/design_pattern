package decorator_pattern;

public class SuonaBikeDecorator extends BikeDecorator{

    private String desc = "增加一个唢呐";

    private Bike bike;

    public SuonaBikeDecorator(Bike bike) {
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
        return bike.getPrice() + 50;
    }
}
