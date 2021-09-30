public class Pessoa {
    
    private String nome, sexo;
    private Integer idade;

    public Pessoa () {

    }

    public Pessoa(String nome, String sexo, Integer idade) {
        this.setNome(nome);
        this.setSexo(sexo);
        this.setIdade(idade);
    }

    public void fazerAniversario() {
        if (sexo.equalsIgnoreCase("f")) {
            System.out.printf("Eu sou a %s e hoje é o meu aniversário\n", this.nome);
        } else {
            System.out.printf("Eu sou o %s e hoje é o meu aniversário\n", this.nome);
        }
        
    }

    public String getNome() {
        return nome;
    }

    public String getSexo() {
        return sexo;
    }

    public Integer getIdade() {
        return idade;
    }


    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    
}
