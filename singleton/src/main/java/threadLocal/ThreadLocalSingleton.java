package threadLocal;

/**
 * @program: design_model
 * @description:
 * @author: wuweidong
 * @create: 2020-02-26 22:30
 **/
public class ThreadLocalSingleton {
    private ThreadLocal<ThreadLocalSingleton> threadLocalInstance = new ThreadLocal<ThreadLocalSingleton>(){
        @Override
        protected ThreadLocalSingleton initialValue() {
            return new ThreadLocalSingleton();
        }
    };
    private ThreadLocalSingleton(){}

    public ThreadLocalSingleton getInstance(){
        return threadLocalInstance.get();
    }

}
