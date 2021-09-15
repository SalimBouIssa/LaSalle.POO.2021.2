public class Jogador {

    // Atributos
    private String nome;
    private String sobrenome;
    private Integer idade;
    private Time time;

    // Construtor
    public Jogador(){
        time = new Time();
    }

    
    // Métodos
    // Set
    public void setNome (String nome) {
        this.nome = nome;
    }

    public void setSobrenome (String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public void setIdade (int idade) {
        this.idade = idade;
    }

    public void setNomeTime (String nomeTime) {
        this.time.setNome(nomeTime);
    }

    public void setEscudo (String escudo) {
        this.time.setEscudo(escudo);;
    }



    // Get
    public String getNomeCompleto () {
        return this.nome + " " + this.sobrenome;
    }

    public String getNome () {
        return this.nome;
    }

    public String getSobrenome () {
        return this.sobrenome;
    }

    public int getIdade () {
        return this.idade;
    }

    public String getNomeTime () {
        return this.time.getNome();
    }

    public String getEscudoTime () {
        return this.time.getEscudo();
    }
}