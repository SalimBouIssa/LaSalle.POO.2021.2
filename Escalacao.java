import java.util.Scanner;

public class Escalacao {
    // Atributos
    private Jogador jogadores[] = new Jogador[5];
    private Time time = new Time();
    private String data;

    public void setEscalacao () {
        Scanner entrada = new Scanner(System.in);

        System.out.print("Insira o nome do time: ");
        String nomeTime = entrada.nextLine();
        this.time.setNome(nomeTime);

        System.out.print("Insira o escudo do time: ");
        String escudo = entrada.nextLine();
        this.time.setEscudo(escudo);

        System.out.print("Insira a data do jogo (Em xx/xx/xx): ");
        String data = entrada.nextLine();
        this.setData(data);


        for (int i = 0; i < 5; i++) {
            jogadores[i] = new Jogador();
            System.out.printf("Insira o nome do jogador %d: ", i + 1);
            String nome = entrada.nextLine();
            jogadores[i].setNome(nome);

            System.out.printf("Insira o sobrenome do jogador %d: ", i + 1);
            String sobrenome = entrada.nextLine();
            jogadores[i].setSobrenome(sobrenome);

            System.out.printf("Insira a idade do jogador %d: ", i + 1);
            int idade = entrada.nextInt();
            jogadores[i].setIdade(idade);
            entrada.nextLine();

            jogadores[i].setNomeTime(nomeTime);
            jogadores[i].setEscudo(escudo);
        }
        entrada.close();
    }

    private void setData (String data) {
        this.data = data;
    }

    public String getData () {
        return this.data;
    }

    public void imprimir() {
        System.out.print("Time: " + this.time.getNome());
        System.out.println("\n-------------------------");
        for (int i = 0; i < 5; i++) {
            System.out.println(i + "-" + jogadores[i].getNome());
        }
    }

}
