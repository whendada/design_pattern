package decorator_pattern;

public class BigBike implements Bike {

    private String desc ="大号自行车";

    @Override
    public String getDesc() {
        return this.desc;

    }

    @Override
    public Integer getPrice() {
        return 300;
    }
}
