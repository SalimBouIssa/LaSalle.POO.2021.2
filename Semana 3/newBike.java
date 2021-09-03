public class newBike {
    private String marca, cor;
    private Integer qtdMarchas, marchaAtual = 1;
    private boolean movimento = false;

    public newBike(String marca, String cor, int qtdMarchas) {
        setMarca(marca);
        setCor(cor);
        setqtdMarchas(qtdMarchas);
    }

    // Inserir valores aos atributos
    public void setMarca (String marca) {
        this.marca = marca;
    }
    public void setCor (String cor) {
        this.cor = cor;
    }
    public void setqtdMarchas (int qtdMarchas) {
        this.qtdMarchas = qtdMarchas;
    }



    // Ler valores dos atributos
    public String getMarca (newBike bike) {
        return this.marca;
    }
    public String getCor (newBike bike) {
        return this.cor;
    }
    public Integer getqtdMarchas (newBike bike) {
        return this.qtdMarchas;
    }

    // Métodos para alterar marcha
    public void aumentarMarcha() {
        if (this.marchaAtual < this.qtdMarchas) {
            this.marchaAtual++;
            System.out.println("Aumentando a marcha: Marcha após mudança: " + this.marchaAtual);
        } else {
            System.out.println("A marcha já está no máximo, impossível aumentar");
        }
    }

    public void reduzirMarcha() {
        if (this.marchaAtual > 1) {
            this.marchaAtual--;
            System.out.println("Reduzindo a marcha: Marcha após mudança: " + this.marchaAtual);
        } else {
            System.out.println("A marcha já está no mínimo, impossível reduzir");
        }
    }


    // Métodos para movimento
    public void andar() {
        if (movimento == false) {
            System.out.println("Começando a pedalar na " + this.marchaAtual + "ª marcha");
            this.movimento = true;
        } else {
            System.out.println("Andando na " + this.marchaAtual + "ª marcha");
        } 
    }

    public void frear() {
        if (movimento == false) {
            System.out.println("A bicicleta já está parada na " + this.marchaAtual + "ª marcha");
        } else {
            System.out.println("Parando a bicicleta na " + this.marchaAtual + "ª marcha");
            this.movimento = false;
        } 
    }

}
