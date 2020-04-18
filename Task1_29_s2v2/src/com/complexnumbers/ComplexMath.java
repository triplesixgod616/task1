package com.complexnumbers;


public class ComplexMath {
    public static ComplexNumber sum(ComplexNumber n1, ComplexNumber n2) {
        return new ComplexNumber(n1.getRealPart() + n2.getRealPart(), n1.getImaginaryPart() + n2.getImaginaryPart());
    }

    public static ComplexNumber difference(ComplexNumber n1, ComplexNumber n2) {
        return new ComplexNumber(n1.getRealPart() - n2.getRealPart(), n1.getImaginaryPart() - n2.getImaginaryPart());
    }

    public static ComplexNumber multiply(ComplexNumber n1, ComplexNumber n2) {
        return new ComplexNumber(
                n1.getRealPart() * n2.getRealPart() - n1.getImaginaryPart() * n2.getImaginaryPart(),
                n1.getRealPart() * n2.getImaginaryPart() + n1.getImaginaryPart() * n2.getRealPart());
    }

    public static ComplexNumber divide(ComplexNumber n1, ComplexNumber n2) {
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

        double ac = n1.getRealPart() * c;
        double bd = n1.getImaginaryPart() * d;
        double bc = n1.getImaginaryPart() * c;
        double ad = n1.getRealPart() * d;

        return new ComplexNumber((ac + bd) / (zreal2 + zimag2), (bc - ad) / (zreal2 + zimag2));
    }

    public static ComplexNumber sin(ComplexNumber z) {
        double x = Math.exp(z.getImaginaryPart());
        double x_inv = 1 / x;
        double r = Math.sin(z.getRealPart()) * (x + x_inv) / 2;
        double i = Math.cos(z.getRealPart()) * (x - x_inv) / 2;
        return new ComplexNumber(r, i);
    }

    public static ComplexNumber cos(ComplexNumber z) {
        double x = Math.exp(z.getImaginaryPart());
        double x_inv = 1 / x;
        double r = Math.cos(z.getRealPart()) * (x + x_inv) / 2;
        double i = -Math.sin(z.getRealPart()) * (x - x_inv) / 2;
        return new ComplexNumber(r, i);
    }

    public static ComplexNumber pow(ComplexNumber z, ComplexNumber y) {
        double c = y.getRealPart();
        double d = y.getImaginaryPart();

        // get polar of base
        double r = abs(z);
        double theta = arg(z);

        ComplexNumber f1 = new ComplexNumber(
                (StrictMath.pow(r, c) * StrictMath.pow(StrictMath.E, -d * theta)), 0);
        ComplexNumber f2 =
                new ComplexNumber(
                        StrictMath.cos(d * StrictMath.log(r) + c * theta),
                        StrictMath.sin(d * StrictMath.log(r) + c * theta));

        f1.multiply(f2);

        return new ComplexNumber(f1.getRealPart(), f1.getImaginaryPart());

    }

    public static double abs(ComplexNumber z) {
        return StrictMath.sqrt(StrictMath.pow(z.getRealPart(), 2) + StrictMath.pow(z.getImaginaryPart(), 2));
    }

    public static double arg(ComplexNumber z) {
        double theta = StrictMath.atan2(z.getImaginaryPart(), z.getRealPart());

        return theta;
    }

}
