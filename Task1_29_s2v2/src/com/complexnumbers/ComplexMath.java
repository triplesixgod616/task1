package com.complexnumbers;


public class ComplexMath {

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

    public static ComplexNumber tan(ComplexNumber z) {
        return sin(z).divide(cos(z));
    }

    public static ComplexNumber atan(ComplexNumber z) {
        double x = z.getRealPart();
        double y = z.getImaginaryPart();
        double x1 = Math.atan(2 * x / (1 - x * x - y * y)) / 2;
        double y1 = Math.log((x * x + (y + 1) * (y + 1)) / (x * x + (y * y - 1) * (y * y - 1))) / 4;
        return new ComplexNumber(x1, y1);
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
