package seriable;

import hungeySingleton.HungrySingleton;

import java.io.Serializable;

/**
 * @program: design_model
 * @description: 序列化单例
 * @author: wuweidong
 * @create: 2020-02-26 22:18
 **/
public class SeriableSingleton implements Serializable {
    private static final SeriableSingleton instance = new SeriableSingleton();

    private SeriableSingleton() {
    }

    public static SeriableSingleton getInstance() {
        return instance;
    }

    private Object readResolve() {
        return instance;
    }
}
