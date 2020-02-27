package layz;

/**
 * @program: design_model
 * @description: 懒汉
 * @author: wuweidong
 * @create: 2020-02-26 20:47
 *
 **/

public class LayzSimpleSingleton {
    private static LayzSimpleSingleton layzSimpleSingleton;

    private LayzSimpleSingleton() {
    }

    // * 优点：节省了不必要的内存消耗
    // * 缺点：线程不安全
//    public static LayzSimpleSingleton getInstance() {
//        if (layzSimpleSingleton == null) {
//            layzSimpleSingleton = new LayzSimpleSingleton();
//        }
//        return layzSimpleSingleton;
//    }
    // * 优点：节省内存，线程安全
    // * 缺点：性能低
    public synchronized static LayzSimpleSingleton getInstance() {
        if (layzSimpleSingleton == null) {
            layzSimpleSingleton = new LayzSimpleSingleton();
        }
        return layzSimpleSingleton;
    }

}
