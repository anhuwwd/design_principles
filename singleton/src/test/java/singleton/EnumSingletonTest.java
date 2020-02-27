package singleton;

import register.EnumSingleton;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @program: design_model
 * @description: 枚举单例测试
 * @author: wuweidong
 * @create: 2020-02-26 21:53
 **/
public class EnumSingletonTest {
    public static void main(String[] args) {
        EnumSingleton instance = EnumSingleton.getInstance();
        instance.setObj(new Object());
        //测试反射
        try {
            Class clz = EnumSingleton.class;
            Constructor constructor = clz.getDeclaredConstructor(String.class,int.class);
            constructor.setAccessible(true);
            //底层限制了 Cannot reflectively create enum objects
            Object o = constructor.newInstance();
            System.out.println(o);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
