package com.company;


public class ComplexMath {
    public static ComplexNumber sum(ComplexNumber n1, ComplexNumber n2){
        return new ComplexNumber(n1.getRealPart() + n2.getRealPart(),n1.getI() + n2.getI());
    }

    public static ComplexNumber minus(ComplexNumber n1, ComplexNumber n2){
        return new ComplexNumber(n1.getRealPart() - n2.getRealPart(),n1.getI() - n2.getI());
    }

    public static ComplexNumber multiply(ComplexNumber n1, ComplexNumber n2){
        //https://www.geeksforgeeks.org/multiplication-two-complex-numbers-given-strings/
        return new ComplexNumber(
                n1.getRealPart() * n2.getRealPart() - n1.getI() * n2.getI(),
                n1.getRealPart() * n2.getI() + n1.getI() * n2.getRealPart());
    }

    public static ComplexNumber divide(ComplexNumber n1, ComplexNumber n2){
        //https://gist.github.com/cab1729/1349284/07c307f565568593c616b869da75dbff606ad44b
        double c = n2.getRealPart();
        double d = n2.getI();

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

        double ac = n1.getRealPart()*c;
        double bd = n1.getI()*d;
        double bc = n1.getI()*c;
        double ad = n1.getRealPart()*d;

        return new ComplexNumber((ac+bd)/(zreal2+zimag2),(bc-ad)/(zreal2+zimag2));
    }
    public static ComplexNumber sin(ComplexNumber z)
    {
        double x = Math.exp(z.getI());
        double x_inv = 1/x;
        double r = Math.sin(z.getRealPart()) * (x + x_inv)/2;
        double i = Math.cos(z.getRealPart()) * (x - x_inv)/2;
        return new ComplexNumber(r,i);
    }
    public static ComplexNumber cos(ComplexNumber z)
    {
        double x = Math.exp(z.getI());
        double x_inv = 1/x;
        double r = Math.cos(z.getRealPart()) * (x + x_inv)/2;
        double i = -Math.sin(z.getRealPart()) * (x - x_inv)/2;
        return new ComplexNumber(r,i);
    }

}
