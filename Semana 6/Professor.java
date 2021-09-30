public class Professor extends Pessoa {
    private Float salario;
    private String especialidade;
    
    public Professor(String nome, String sexo, Integer idade, Float salario, String especialidade) {
        super(nome, sexo, idade);
        this.setSalario(salario);
        this.setEspecialidade(especialidade);
    }

    public void AumentarSalario(Integer aumento) {
        this.salario *= (1+aumento/100f);
    }

    public Float getSalario() {
        return salario;
    }

    public String getEspecialidade() {
        return especialidade;
    }


    public void setSalario(Float salario) {
        this.salario = salario;
    }
    
    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

}
