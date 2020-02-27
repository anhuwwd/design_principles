package singleton;

/**
 * @program: design_model
 * @description:
 * @author: wuweidong
 * @create: 2020-02-26 20:53
 **/
public class LayzSingletonTest {
    //*运行结果
    //打印同一实例
    //    线程1覆盖线程0
    //    正常执行
    //打印不同示例
    //
    public static void main(String[] args) {
        Thread thread = new ExectorThread();
        Thread thread1 = new ExectorThread();
        thread.start();
        thread1.start();
        System.out.println("end");
    }
}
