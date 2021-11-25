package model;

public class Aluno {
    private String matricula;
    private String nome;



    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public void setNome(String nome) {
       
        this.nome = nome;
    }
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }


    public String getMatricula() {
        return matricula;
    }
   
    public String getNome() {
        return nome;
    }
    
    public String getTelefone() {
        return telefone;
    }
    
    private String telefone;

    
}
