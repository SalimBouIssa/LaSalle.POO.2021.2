import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;

public class Nuvem {
    private String nomeArq;

    public Nuvem (String nome) {
        this.nomeArq = nome;
    }
    
    public void imprimir () {
        try (BufferedReader reader = new BufferedReader(new FileReader(this.nomeArq))) {
            String linha = reader.readLine();
            while (linha != null) {
                System.out.println(linha);
            }
        } catch (Exception e) {
            System.out.println("Erro ao tentar ler o arquivo\n" + e.getMessage());
        }
    }

    public ArrayList<String> ler() {

        ArrayList<String> palavras = new ArrayList<String>();

        try (BufferedReader reader = new BufferedReader(new FileReader(this.nomeArq))) {
            String linha = reader.readLine();

            while (linha != null) {
                palavras.add(linha);
                linha = reader.readLine();
            }

        } catch (Exception e) {
            System.out.println(("Erro ao tentar ler arquivo!!" + e.getMessage()));
        }

        return palavras;

    }

    public static void ordenar(ArrayList<String> palavras) {
        Collections.sort(palavras);
        for (int i = 0; i < palavras.size(); i++) {
            for (int j = i + 1; j < palavras.size(); j++) {
                if (palavras.get(i).length() < palavras.get(j).length()) {
                    String temp = palavras.get(i);
                    palavras.set(i, palavras.get(j));
                    palavras.set(j, temp);
                }
            }
        }

    }
}