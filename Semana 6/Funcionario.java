public class Funcionario extends Pessoa {
    private String setor, trabalhando;
    
    public Funcionario(String nome, String sexo, Integer idade, String setor, String trabalhando) {
        super(nome, sexo, idade);
        this.setSetor(setor);
        this.setTrabalhando(trabalhando);
    }

    public void mudarTrabalho(String setor) {
        this.setSetor(setor);
    }

    public String getSetor() {
        return setor;
    }

    public String getTrabalhando() {
        return trabalhando;
    }


    public void setSetor(String setor) {
        this.setor = setor;
    }
    public void setTrabalhando(String trabalhando) {
        this.trabalhando = trabalhando;
    }

    
}
