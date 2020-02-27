package singleton;

import layz.LayzStaticInnerClassSingleton;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @program: design_model
 * @description:
 * @author: wuweidong
 * @create: 2020-02-26 21:41
 **/
//反射破坏单例
public class ReflectTest {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
//        LayzStaticInnerClassSingleton instance = LayzStaticInnerClassSingleton.getInstance();


        Class<?> clazz = LayzStaticInnerClassSingleton.class;
        Constructor constructor = clazz.getDeclaredConstructor(null);
        constructor.setAccessible(true);
        LayzStaticInnerClassSingleton instance0= (LayzStaticInnerClassSingleton) constructor.newInstance();
        LayzStaticInnerClassSingleton instance1= (LayzStaticInnerClassSingleton) constructor.newInstance();

        System.out.println(instance0);
        System.out.println(instance1);
    }
}
