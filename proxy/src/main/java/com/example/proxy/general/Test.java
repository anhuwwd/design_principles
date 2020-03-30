package com.example.proxy.general;

public class Test {
    public static void main(String[] args) {
       IPerson person = new ZhangSan();
       Proxy intermediary = new Proxy(person);
       intermediary.payForHouse();
    }
}
