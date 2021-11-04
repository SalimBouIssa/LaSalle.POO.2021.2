import java.util.ArrayList;

public class NuvemTester {
    public static void main (String[] args) {
        Nuvem nuvem = new Nuvem("Teste.csv");

        ArrayList<String> palavras = nuvem.ler();

        Nuvem.ordenar(palavras);

        for (int i = 0; i < 10; i++) {
            System.out.println(palavras.get(i));
        }
    }
}
