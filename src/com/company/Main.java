package com.company;

import java.util.Arrays;

public class Main {

    private static int pos = 0;

    public static void main(String[] args) {
        String input = "2*2+4*4*4*4+1+1+1+1";
        String[] arr = input.split("(?<=\\D)(?=\\d)|(?<=\\d)(?=\\D)");
        System.out.println("input: " + Arrays.toString(arr));
        System.out.println("result: " + exp(arr));
    }

    private static double exp(String[] arr) {
        double result = term(arr, pos);
        while (pos < arr.length && isPlusMinus(arr[pos])) {
            String operator = arr[pos];
            pos++;
            if (operator.equals("+")) {
                result += term(arr, pos);
            }
            if (operator.equals("-")) {
                result -= term(arr, pos);
            }
        }
        if (pos < arr.length) {
            System.out.println("error in pos :" + pos);
        }
        return result;
    }

    private static double term(String[] arr, int position) {
        double result = number(arr[pos]);
        while (pos < arr.length && isMulDiv(arr[pos])) {
            String operator = arr[pos];
            pos++;
            if (operator.equals("*")) {
                result *= number(arr[pos]);
            }
            if (operator.equals("/")) {
                result /= number(arr[pos]);
            }
        }
        return result;
    }

    private static boolean isPlusMinus(String s) {
        return s.equals("+") || s.equals("-");
    }

    private static boolean isMulDiv(String s) {
        return s.equals("*") || s.equals("/");
    }

    private static double number(String s) {
        pos++;
        return Double.parseDouble(s);
    }

}
