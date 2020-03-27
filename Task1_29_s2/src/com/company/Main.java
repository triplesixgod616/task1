package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter first number's real part: ");
        double realPart = scanner.nextDouble();
        System.out.println("Enter first number's imaginary part: ");
        ComplexNumber n1 = new ComplexNumber(realPart,scanner.nextDouble());

        System.out.println("Enter second number's real part: ");
        realPart = scanner.nextDouble();
        System.out.println("Enter second number's imaginary part: ");
        ComplexNumber n2 = new ComplexNumber(realPart,scanner.nextDouble());

        System.out.println("Choose operation + - * /");
        scanner.nextLine();
        String operand = scanner.nextLine();
        ComplexNumber result = null;
        switch (operand){
            case "+": result = ComplexMath.sum(n1,n2); break;
            case "-": result = ComplexMath.minus(n1,n2); break;
            case "*": result = ComplexMath.multiply(n1,n2); break;
            case "/": result = ComplexMath.divide(n1,n2); break;
            default:
                System.out.println("No such operand");
        }
        if (result != null){
            System.out.println("Result :" + result.toString());
        }
    }
}
