import java.util.Random;

public class newBikeTester {
    public static void main (String[] args) {
        newBike bike = new newBike("Aro", "Azul", 6);
        Random random = new Random();
        bike.andar();
        for (int i = 0; i < 30; i++) {
            int acao = random.nextInt(20);
            try {
                Thread.sleep(500);
            } catch(InterruptedException e) {
            }
            if (acao <= 7) {
                bike.aumentarMarcha();
            } else if (acao <= 15) {
                bike.reduzirMarcha();
            } else if (acao <= 17) {
                bike.andar();
            } else {
                bike.frear();
            }
        }
        
        System.out.println("Marca da bicicleta: " + bike.getMarca(bike) + ";\nCor: " + bike.getCor(bike) + ";\nQuantidade de Marchas: " + bike.getqtdMarchas(bike));
    }
}
