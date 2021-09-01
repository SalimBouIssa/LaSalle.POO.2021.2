public class BikeTester {
    public static void main (String[] args) {
        Bike bike = new Bike();
        bike.andar();
        bike.marca = "Aro";
        bike.cor = "Preto";
        bike.qtdMarchas = 5;
        bike.frear();
        System.out.println("Marca da bicicleta: " + bike.marca + ";\nCor: " + bike.cor + ";\nQuantidade de Marchas: " + bike.qtdMarchas);
    }
}
