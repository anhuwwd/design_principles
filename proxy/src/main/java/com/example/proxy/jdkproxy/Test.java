package com.example.proxy.jdkproxy;

public class Test {
    public static void main(String[] args) {
        Intermediary intermediary = new Intermediary();
        IPerson zhangSan= intermediary.getInstance(new ZhangSan());
        zhangSan.payForHouse();
    }
}
