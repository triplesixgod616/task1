package com.complexnumbers;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        ComplexNumber testComplex1 = new ComplexNumber(1, 3);
        ComplexNumber testComplex2 = new ComplexNumber(3, 5);

        testComplex1.add(testComplex2);
        System.out.println("add: " + testComplex1);
        testComplex1.substract(testComplex2);
        System.out.println("substract: " + testComplex1);

        testComplex1.multiply(testComplex2);
        System.out.println("multiply: " + testComplex1);
        testComplex1.divide(testComplex2);
        System.out.println("divide: " + testComplex1);

        testComplex1.pow(testComplex2);
        System.out.println("pow: " + testComplex2);


        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter first number's real part: ");
        double realPart = scanner.nextDouble();
        System.out.println("Enter first number's imaginary part: ");
        ComplexNumber n1 = new ComplexNumber(realPart, scanner.nextDouble());

        System.out.println("Enter second number's real part: ");
        realPart = scanner.nextDouble();
        System.out.println("Enter second number's imaginary part: ");
        ComplexNumber n2 = new ComplexNumber(realPart, scanner.nextDouble());

        System.out.println("Choose operation + - * / ^ ==");
        scanner.nextLine();
        String operand = scanner.nextLine();
        ComplexNumber result = null;
        switch (operand) {
            case "+":
                result = ComplexMath.sum(n1, n2);
                break;
            case "-":
                result = ComplexMath.difference(n1, n2);
                break;
            case "*":
                result = ComplexMath.multiply(n1, n2);
                break;
            case "/":
                result = ComplexMath.divide(n1, n2);
                break;
            case "^":
                result = ComplexMath.pow(n1, n2);
                break;
            case "==":
                System.out.println(n1.equals(n2));
                break;
            default:
                System.out.println("No such operand");
        }
        if (result != null) {
            System.out.println("Result :" + result.toString());
        }
    }
}
