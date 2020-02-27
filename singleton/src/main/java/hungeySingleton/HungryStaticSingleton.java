package hungeySingleton;

/**
 * @program: design_model
 * @description: 饿汉模式第二种写法
 * @author: wuweidong
 * @create: 2020-02-26 20:44
 **/
public class HungryStaticSingleton {
    private static HungryStaticSingleton hungryStaticSingleton ;
    static {
        hungryStaticSingleton = new HungryStaticSingleton();
    }
    private HungryStaticSingleton(){}

}
