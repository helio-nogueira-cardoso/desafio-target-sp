package br.com.helio.target;

public class QuestionNumber1 {
    public static void main(String[] args) {
        int indice = 13;
        int soma = 0;
        int k = 0;

        while (k < indice) {
            k = k + 1;
            soma = soma + k;
        }

        // R.: 91
        System.out.println(soma);
    }
}
