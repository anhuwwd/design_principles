package singleton;

import layz.LayzSimpleSingleton;

/**
 * @program: design_model
 * @description:
 * @author: wuweidong
 * @create: 2020-02-26 20:54
 **/
public class ExectorThread extends Thread {
    @Override
    public void run() {
        LayzSimpleSingleton simpleSingleton = LayzSimpleSingleton.getInstance();
        System.out.println(Thread.currentThread().getName() + "LayzSimpleSingleton" + simpleSingleton);
    }
}
