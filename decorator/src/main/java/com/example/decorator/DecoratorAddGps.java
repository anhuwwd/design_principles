package com.example.decorator;

public class DecoratorAddGps extends Decorator{

    public DecoratorAddGps(Car car) {
        super(car);
    }

    @Override
    public int unitPrice() {
        //+GPs
        return car.unitPrice()+10;
    }
}
