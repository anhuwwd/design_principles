package com.example.proxy.myproxy.client;

import com.example.proxy.myproxy.proxy.MyClassLoader;
import com.example.proxy.myproxy.proxy.MyInvocationHandler;
import com.example.proxy.myproxy.proxy.MyProxy;

import java.lang.reflect.Method;

/**
 * 中介
 */
public class Intermediary implements MyInvocationHandler {
    private IPerson traget;
    private IHouse source;
    public IPerson getInstance(IPerson object){
        this.traget=object;
        Class<?> tClass =object.getClass();
        return (IPerson) MyProxy.newProxyInstance(new MyClassLoader(),tClass.getInterfaces(),this);
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
