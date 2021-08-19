/*
Exercício :Criar um código para ler usuario e senha. Se a senha for igual a “Semana2” enviar mensagem dizendo acesso liberado senão, emitir mensagem acesso negado.
Adicionalmente, eu inseri o requisito do usuário correto "admin"
*/

import java.util.Scanner;

public class Senha {
    public static void main (String[] args) {
        Scanner entrada = new Scanner(System.in);
        String usuario = "", user = "admin";
        while (usuario.equals(user) == false) {
            if (usuario.equals("") == false) {
                System.out.println("Usuário incoreto");
            }
            System.out.print("Insira o usuário: ");
            usuario = entrada.nextLine();
        }
        System.out.print("Insira a senha: ");
        String senha = entrada.nextLine();
        entrada.close();
        if (senha.equals("Semana2")) {
            System.out.print("Acesso liberado");
        } else {
            System.out.print("Acesso negado");
        }
    }
}
