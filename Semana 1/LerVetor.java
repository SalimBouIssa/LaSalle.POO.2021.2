import java.util.Scanner;

public class LerVetor {
    public static void main (String[] args) {
        Scanner input = new Scanner(System.in);

        int[] num = new int[5];
        
        for (int i = 0; i < 5; i++) {
            System.out.println("Entre com o aluno " + (i + 1));
            num[i] = input.nextInt();
        }
        input.close();

        // Calcular o maior número lido
        int maior = num[0];
        for (int i = 0; i < 5; i++) {
            if (num[i] > maior) {
                maior = num[i];
            }
        }

        System.out.println("Maior numero = " + maior);

    }
}