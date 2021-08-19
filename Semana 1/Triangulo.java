/*
Ler a base e a altura de um triângulo para retornar a área do mesmo e transformar o cálculo da área em uma função
*/

import java.util.Scanner;

public class Triangulo {
    public static void main (String[] args) {
        Scanner num = new Scanner(System.in);
        System.out.print("Insira o tamanho da base: ");
        float base = num.nextFloat();
        System.out.print("Insira o tamanho da altura: ");
        float alt = num.nextFloat();
        num.close();
        System.out.print("A área do triângulo é: " + area(base, alt));
    }

    public static float area (float b, float a) {
        return b*a/2;
    }
}