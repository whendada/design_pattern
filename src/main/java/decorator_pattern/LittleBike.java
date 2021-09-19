package decorator_pattern;

public class LittleBike implements Bike {

    private String desc ="小号自行车";

    @Override
    public String getDesc() {
        return this.desc;

    }

    @Override
    public Integer getPrice() {
        return 100;
    }
}
