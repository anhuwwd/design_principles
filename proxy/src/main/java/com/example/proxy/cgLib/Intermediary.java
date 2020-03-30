package com.example.proxy.cgLib;


import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
import net.sf.cglib.proxy.Enhancer;

import java.lang.reflect.Method;

/**
 * 中介代理
 * cgLib 被代理不用实现任何接口
 */
public class Intermediary implements MethodInterceptor {


    public Object getInstance(Class<?> clazz) throws Exception {
        //相当于Proxy，代理的工具类
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(clazz);
        enhancer.setCallback(this);
        return enhancer.create();
    }


    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        before();
        Object res = methodProxy.invokeSuper(o, objects);
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
