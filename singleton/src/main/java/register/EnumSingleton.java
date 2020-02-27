package register;

/**
 * @program: design_model
 * @description: 注册式 枚举是单例
 * @author: wuweidong
 * @create: 2020-02-26 21:52
 **/
// 优点 ：不存在线程安全问题，不会被反射破坏，性能高
//缺点：某些情况存在 内存浪费
public enum EnumSingleton {
    INSTANCE;

    private Object obj;

    public static EnumSingleton getInstance(){
        return INSTANCE;
    }

    public Object getObj() {
        return obj;
    }

    public void setObj(Object obj) {
        this.obj = obj;
    }
}
