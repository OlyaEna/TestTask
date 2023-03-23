package com.task.task2;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

public class Factorial {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double n = scanner.nextDouble();
        System.out.println(functionUn(n));
    }

    public static String functionUn(double n) {
        double factor = 0;
        double firstFactor = 0;
        double result = 0;
        String resultMessage;

        for (int i = 1; i <= n; i++) {
            factor += factorial(i);
            if (i == 2) {
                firstFactor = factor;
            }
        }

        double firstResult = (1.0 / factorial(2)) * firstFactor;
        result = (1.0 / factorial(n)) * factor;
        BigDecimal bigDecimalResult = new BigDecimal(Double.toString(result));
        bigDecimalResult = bigDecimalResult.setScale(6, RoundingMode.HALF_UP);
        resultMessage = firstResult > result ? "Функция стремится к нулю u(n) = " + bigDecimalResult
                : "Функция стремится к бесконечности u(n) = " + bigDecimalResult;
        return resultMessage;
    }

    private static double factorial(double n) {
        if (n == 0)
            return 1;
        return n * factorial(n - 1);
    }
}
