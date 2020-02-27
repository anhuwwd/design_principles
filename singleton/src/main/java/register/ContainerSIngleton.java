package register;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @program: design_model
 * @description: 容器式单例
 * @author: wuweidong
 * @create: 2020-02-26 22:05
 **/
public class ContainerSIngleton {
    private ContainerSIngleton() {
    }

    private static Map<String, Object> ioc = new ConcurrentHashMap();

    public static Object getInstance(String className) {
        if (!ioc.containsKey(className)) {
            Object instance = null;
            try {
                instance = Class.forName(className).newInstance();
                ioc.put(className, instance);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return instance;
        } else {
            return ioc.get(className);
        }
    }
}
