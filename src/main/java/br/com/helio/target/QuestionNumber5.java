package br.com.helio.target;

import java.util.Scanner;

public class QuestionNumber5 {
    public static void main(String[] args) {
        Scanner userInputStream = new Scanner(System.in);

        System.out.println("Digite uma string para inverter:");
        String str = userInputStream.nextLine();

        System.out.println("String invertida: " + QuestionNumber5.reverseString(str));

        userInputStream.close();
    }

    public static String reverseString(String str) {
        StringBuilder reversed = new StringBuilder();

        for (int i = str.length() - 1; i >= 0; i--) {
            reversed.append(str.charAt(i));
        }

        return reversed.toString();
    }
}
