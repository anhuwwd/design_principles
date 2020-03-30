package com.example.proxy.jdkproxy;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 中介代理
 */
public class Intermediary implements InvocationHandler {

    private IPerson traget;

    public IPerson getInstance(IPerson object){
        this.traget=object;
        Class<?> tClass =object.getClass();
        return (IPerson) Proxy.newProxyInstance(object.getClass().getClassLoader(),tClass.getInterfaces(),this);
    }


    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        before();
        Object res = method.invoke(this.traget,args);
        after();
        return res;
    }

    private void after() {
        System.out.println("达成交易");
    }

    private void before() {
        System.out.println("搜索房源");
    }
}
