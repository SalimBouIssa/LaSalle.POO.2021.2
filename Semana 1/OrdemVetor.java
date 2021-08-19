/*
Receber um vetor de tamanho 10 e ordená-lo sem usar sort
*/

import java.util.Scanner;

public class OrdemVetor {
    public static void main (String[] arg) {
        Scanner entrada = new Scanner(System.in);
        int[] vet = new int[10];
        for (int i = 0; i < 10; i++) {
            System.out.print("Insira o valor de v[" + i + "]: ");
            vet[i] = entrada.nextInt();
        }
        entrada.close();
        System.out.println("Vetor antes da ordenação: ");
        for (int i = 0; i < 10; i++) {
            System.out.print("[" + vet[i] + "]");
        }
        for (int i = 0; i < 10; i++) {  
            for (int j = i + 1; j < 10; j++) {   
                if (vet[j] < vet[i]) {  
                    int tmp = vet[i];  
                    vet[i] = vet[j];  
                    vet[j] = tmp;  
                }
            }  
        } 
        System.out.println("\nVetor depois da ordenação: ");
        for (int i = 0; i < 10; i++) {
            System.out.print("[" + vet[i] + "]");
        }
    }
}
