package com.example.decorator;

//标配
public class Decorator extends Car{
    protected Car car;

    public int unitPrice() {
      return car.unitPrice();
    }

    public Decorator(Car car){
        this.car = car;
    }
}
