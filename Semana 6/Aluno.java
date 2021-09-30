public class Aluno extends Pessoa {
    private String matricula, curso;

    public void CancelarMatricula() {
        System.out.println("Matrícula cancelada");
    }

    public Aluno(String nome, String sexo, Integer idade, String matricula, String curso) {
        super(nome, sexo, idade);
        this.setMatricula(matricula);
        this.setCurso(curso);
    }

    public String getMatricula() {
        return matricula;
    }

    public String getCurso() {
        return curso;
    }


    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    
}
