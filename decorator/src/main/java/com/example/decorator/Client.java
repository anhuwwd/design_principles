package com.example.decorator;

public class Client {
    public static void main(String[] args) {
        Car car = new StandardCar();
        System.out.println("标配车价格"+car.unitPrice());
        Car addABS = new DecoratorAddABS(car);
        System.out.println("标配车加装ABS价格"+addABS.unitPrice());
        Car addGpS = new DecoratorAddGps(car);
        System.out.println("标配车加装Gps价格"+addGpS.unitPrice());
    }
}
