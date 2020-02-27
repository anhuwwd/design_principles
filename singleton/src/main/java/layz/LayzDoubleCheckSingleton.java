package layz;

/**
 * 优点： 性能提高了，线程安全
 * 缺点：可读性差，不够优雅简洁
 */
public class LayzDoubleCheckSingleton {
    private volatile static LayzDoubleCheckSingleton instance;

    private LayzDoubleCheckSingleton() {
    }

    public static LayzDoubleCheckSingleton getInstance() {
        //第一次检查是否要阻塞
        if (instance == null) {
            synchronized (LayzDoubleCheckSingleton.class) {
                //第二次检查是否要创建实例
                if (instance == null) {
                    instance = new LayzDoubleCheckSingleton();
                    //指令重排序的问题
                }
            }
        }
        return instance;
    }
}
