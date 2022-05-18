package com.pilipenko.calculator.service;

import org.springframework.stereotype.Service;

@Service
public class CalculatorService {
    public String summarize(double number1, double number2) {
        return String.valueOf(number1 + number2);
    }

    public String subtract(double number1, double number2) {
        return String.valueOf(number1 - number2);
    }

    public String multiply(double number1, double number2) {
        return String.valueOf(number1 * number2);
    }

    public String divide(double number1, double number2) {
        try {
            return String.valueOf(number1 / number2);
        } catch (ArithmeticException e) {
            return e.getMessage();
        }
    }
}
