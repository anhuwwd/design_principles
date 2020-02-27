package hungeySingleton;

/**
 * @program: design_model
 * @description: 饿汉模式
 * @author: wuweidong
 * @create: 2020-02-26 20:41
 *
 * 优点：执行效率高 ，性能高，没有任何锁
 * 缺点：由于创建类的时候就会创建对象，某些情况下会造成内存浪费
 **/
public class HungrySingleton {
    private static final HungrySingleton hungrySingleton = new HungrySingleton();

    private HungrySingleton() {
    }

    public static HungrySingleton getInstance() {
        return hungrySingleton;
    }
}
