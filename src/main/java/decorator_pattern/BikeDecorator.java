package decorator_pattern;

public class BikeDecorator implements Bike{

    private String desc = "我是装饰器，啥都不表示，子类帮我做";

    @Override
    public String getDesc() {
        return desc;
    }

    @Override
    public Integer getPrice() {
        return null;
    }
}
