/*
Primeira interação com o método equals: Comparar duas strings
*/

import java.util.Scanner;

public class CompString {
    public static void main (String[] args) {
        Scanner entrada = new Scanner(System.in);
        System.out.print("Insira a primeira string: ");
        String ent1 = entrada.nextLine();
        System.out.print("Insira a segunda string: ");
        String ent2 = entrada.nextLine();
        entrada.close();
        if (ent1.equals(ent2)) {
            System.out.print("As strings são iguais");
        } else {
            System.out.print("As strings são diferentes");
        }
    }
}
