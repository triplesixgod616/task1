package com.company;

public class ComplexNumber {
    private double realPart;
    private double i;

    public double getRealPart() {
        return realPart;
    }

    public void setRealPart(double realPart) {
        this.realPart = realPart;
    }

    public double getI() {
        return i;
    }

    public void setI(double i) {
        this.i = i;
    }

    public ComplexNumber(double realPart, double i) {
        this.realPart = realPart;
        this.i = i;
    }
    @Override
    public String toString(){
        return getRealPart() + " + " + getI() + "i";
    }

}
