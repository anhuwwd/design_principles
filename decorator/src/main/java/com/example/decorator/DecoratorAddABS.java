package com.example.decorator;

public class DecoratorAddABS extends Decorator{
    public DecoratorAddABS(Car car) {
        super(car);
    }

    @Override
    public int unitPrice() {
        return super.unitPrice()+5;
    }
}
