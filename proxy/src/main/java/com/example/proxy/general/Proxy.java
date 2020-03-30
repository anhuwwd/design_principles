package com.example.proxy.general;

import com.example.proxy.myproxy.proxy.MyClassLoader;
import com.example.proxy.myproxy.proxy.MyInvocationHandler;
import com.example.proxy.myproxy.proxy.MyProxy;

import java.lang.reflect.Method;

/**
 * 静态代理模式
 */
public class Proxy implements IPerson {

    private IPerson person;

    public Proxy (IPerson person){
        this.person = person;
    }

    private void after() {
        System.out.println("达成交易");
    }

    private void before() {
        System.out.println("搜索房源");
    }

    public void payForHouse() {
        before();
        person.payForHouse();
        after();
    }
}
