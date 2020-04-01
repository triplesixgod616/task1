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
    public String toString(){
        return getRealPart() + " + " + getImaginaryPart() + "i";
    }

    public void add(ComplexNumber n2){
        realPart += n2.getRealPart();
        imaginaryPart += n2.getImaginaryPart();
    }
    public void substract(ComplexNumber n2){
        realPart -= n2.getRealPart();
        imaginaryPart -= n2.getImaginaryPart();
    }
    public void multiply(ComplexNumber n2){
        //https://www.geeksforgeeks.org/multiplication-two-complex-numbers-given-strings/
        ComplexNumber temp = new ComplexNumber(
                realPart * n2.getRealPart() - imaginaryPart * n2.getImaginaryPart(),
                realPart * n2.getImaginaryPart() + imaginaryPart * n2.getRealPart());
        realPart = temp.realPart;
        imaginaryPart = temp.imaginaryPart;
    }
    public void divide(ComplexNumber n2){
        //https://gist.github.com/cab1729/1349284/07c307f565568593c616b869da75dbff606ad44b
        double c = n2.getRealPart();
        double d = n2.getImaginaryPart();

        double zreal2 = 0.0;
        if (c != 0.0)
        {
            zreal2 = StrictMath.pow(c, 2.);
        }

        double zimag2 = 0.0;
        if (d != 0.0)
        {
            zimag2 = StrictMath.pow(d, 2.);
        }

        double ac = realPart*c;
        double bd = imaginaryPart*d;
        double bc = imaginaryPart*c;
        double ad = realPart*d;

        ComplexNumber temp = new ComplexNumber((ac+bd)/(zreal2+zimag2),(bc-ad)/(zreal2+zimag2));
        realPart = temp.realPart;
        imaginaryPart = temp.imaginaryPart;
    }
    public void pow(ComplexNumber y)
    {
        double c = y.realPart;
        double d = y.imaginaryPart;
        ComplexNumber z = new ComplexNumber(realPart,imaginaryPart);
        // get polar of base
        double r = ComplexMath.abs(z);
        double theta = ComplexMath.arg(z);

        ComplexNumber f1 = new ComplexNumber(
                (StrictMath.pow(r, c)*StrictMath.pow(StrictMath.E, -d*theta)),0);
        ComplexNumber f2 =
                new ComplexNumber(
                        StrictMath.cos(d*StrictMath.log(r)+c*theta),
                        StrictMath.sin(d*StrictMath.log(r)+c*theta));

        f1.multiply(f2);
        realPart = f1.realPart;
        imaginaryPart = f1.imaginaryPart;

    }
    boolean equals(ComplexNumber n2){
        return realPart == n2.realPart && imaginaryPart == n2.imaginaryPart;
    }
}
