package layz;

/**
 * @program: design_model
 * @description: 静态内部类懒汉写法
 * @author: wuweidong
 * @create: 2020-02-26 21:34
 **/


 /*
  * classpath :LayzStaticInnerClassSingleton.class
  *             LayzStaticInnerClassSingleton$lazyHolder.class
  * 内部静态类在类加载的时候不被扫描
  * 优点：写法优雅，利用了java本身的语法特点，性能高。避免了内存浪费
  * 缺点：能够被反射破坏
  *
  */
public class LayzStaticInnerClassSingleton {

//    private LayzStaticInnerClassSingleton() {
//    }


    private LayzStaticInnerClassSingleton() {
        if(LazyHolder.INSTANCE != null){
            throw new RuntimeException("不允许非法访问");
        }
    }

    public static LayzStaticInnerClassSingleton getInstance() {
        return LazyHolder.INSTANCE;
    }

    private static class LazyHolder {
        private static final LayzStaticInnerClassSingleton INSTANCE = new LayzStaticInnerClassSingleton();
    }
}
