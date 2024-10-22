package br.com.helio.target;

import java.util.InputMismatchException;
import java.util.Scanner;

public class QuestionNumber2 {
    public static void main(String[] args) {
        Scanner userInputStream = new Scanner(System.in);
        boolean waitingRightInput = true;

        while (waitingRightInput) {
            try {
                System.out.println("Digite um número para testar se é primo:");
                long n = userInputStream.nextLong();
                waitingRightInput = false;

                if (QuestionNumber2.isFibonacci(n)) {
                    System.out.println(n + " é um número de Fibonacci!");
                } else {
                    System.out.println(n + " não é um número de Fibonacci!");
                }
            } catch (InputMismatchException e) {
                System.out.println("Digite um número inteiro!");
                userInputStream.nextLine();
            }
        }

        userInputStream.close();
    }

    public static boolean isFibonacci(long n) {
        if (n == 0) {
            return true;
        }

        long previousFibonacci = 0;
        long currentFibonacci = 1;

        while (currentFibonacci <= n) {
            if (currentFibonacci == n) {
                return true;
            }

            long newFibonacci = previousFibonacci + currentFibonacci;
            previousFibonacci = currentFibonacci;
            currentFibonacci = newFibonacci;
        }

        return false;
    }
}
