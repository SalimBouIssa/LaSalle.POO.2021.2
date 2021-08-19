import java.util.Scanner;

public class Exercicios1 {
    public static void main (String[] args) {
        System.out.println("Exercício 1.1: Exibir todos os números pares entre 1 e 100");
        for (int i = 1; i <= 100; i++) {
            if (i % 2 == 0) {
                System.out.println(i);
            }
        }

        System.out.println("Exercício 1.2: Utilizar entrada para o valor final da sequência");
        Scanner entrada = new Scanner(System.in);
        System.out.print("Insira o número final da sequência: ");
        int ult = entrada.nextInt();
        for (int i = 1; i <= ult; i++) {
            if (i % 2 == 0) {
                System.out.println(i);
            }
        }

        System.out.println("Exercício 1.3: Ler um nome e dar uma saudação de bom carnaval");
        entrada.nextLine();
        System.out.print("Insira o seu nome: ");
        String nome = entrada.nextLine();
        entrada.close();
        System.out.print(nome + ", bom carnaval!!!");
    }
}
