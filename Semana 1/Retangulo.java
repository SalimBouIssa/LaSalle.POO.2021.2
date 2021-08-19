/*
Exercício: Imprimir um retângulo com as medidas recebidas por uma entrada
*/

import java.util.Scanner;

public class Retangulo {
    public static void main (String[] args) {
        Scanner num = new Scanner(System.in);
        System.out.print("Insira o comprimento: ");
        int comp = num.nextInt();
        System.out.print("Insira a altura: ");
        int alt = num.nextInt();
        num.close();
        for (int i = 0; i < alt; i++) {
            for (int j = 0; j < comp; j++) {
                System.out.print(".");
            }
            System.out.print("\n");
        }
    }
}
