package com.complexnumbers;

public class ComplexNumber {
    private double realPart;
    private double imaginaryPart;

    public double getRealPart() {
        return realPart;
    }


    public double getImaginaryPart() {
        return imaginaryPart;
    }


    public ComplexNumber(double realPart, double imaginaryPart) {
        this.realPart = realPart;
        this.imaginaryPart = imaginaryPart;
    }

    @Override
    public String toString() {
        return getRealPart() + " + " + getImaginaryPart() + "i";
    }

    public ComplexNumber add(ComplexNumber n2) {
        return new ComplexNumber(realPart + n2.getRealPart(), imaginaryPart + n2.getImaginaryPart());
    }

    public ComplexNumber subtract(ComplexNumber n2) {
        return new ComplexNumber(realPart - n2.getRealPart(), imaginaryPart - n2.getImaginaryPart());
    }

    public ComplexNumber multiply(ComplexNumber n2) {
        return new ComplexNumber(
                realPart * n2.getRealPart() - imaginaryPart * n2.getImaginaryPart(),
                realPart * n2.getImaginaryPart() + imaginaryPart * n2.getRealPart());
    }

    public ComplexNumber divide(ComplexNumber n2) {
        double c = n2.getRealPart();
        double d = n2.getImaginaryPart();

        double zreal2 = 0.0;
        if (c != 0.0) {
            zreal2 = StrictMath.pow(c, 2.);
        }

        double zimag2 = 0.0;
        if (d != 0.0) {
            zimag2 = StrictMath.pow(d, 2.);
        }

        double ac = realPart * c;
        double bd = imaginaryPart * d;
        double bc = imaginaryPart * c;
        double ad = realPart * d;

        return new ComplexNumber((ac + bd) / (zreal2 + zimag2), (bc - ad) / (zreal2 + zimag2));
    }

    public boolean equals(ComplexNumber n2) {
        if (n2 == null) return false;
        if (this == n2) return true;
        return realPart == n2.realPart && imaginaryPart == n2.imaginaryPart;
    }

    public static int hashCode(double realPart, double imaginaryPart) {
        return (Double) realPart.hashCode() + (Double) imaginaryPart.hashCode() / (Double) realPart.hashCode();
    }
}
