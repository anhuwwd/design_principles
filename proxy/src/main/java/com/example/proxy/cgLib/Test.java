package com.example.proxy.cgLib;

public class Test {
    public static void main(String[] args) throws Exception {
        Intermediary intermediary = new Intermediary();
        ZhangSan zhangSan= (ZhangSan) intermediary.getInstance(ZhangSan.class);
        zhangSan.payForHouse();
    }
}
