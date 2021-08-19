/*
Exercício: Ler um nome e emitir uma saudação
*/

import java.util.Scanner;

public class Saudacao {
    public static void main (String[] args) {
        Scanner nome = new Scanner(System.in);
        System.out.print("Insira o seu nome: ");
        String nom = nome.nextLine();
        nome.close();
        System.out.print("Boa noite, " + nom + "!!!");
    }
}
