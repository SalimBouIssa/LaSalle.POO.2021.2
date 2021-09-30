public class HerancaTester {
    
    public static void main (String[] args) {
        Pessoa pessoa = new Pessoa("Salim", "M", 22);
        pessoa.fazerAniversario();

        Aluno aluno = new Aluno("Sofia", "F", 21, "023", "Arquitetura");
        aluno.fazerAniversario();
        System.out.println("Aluna " + aluno.getMatricula() + " do curso de " + aluno.getCurso());

        Professor professor = new Professor("Marcos", "M", 43, (float)7500 ,"Urbanismo");
        professor.fazerAniversario();
        System.out.println("Recebe " + professor.getSalario() + " e especializa em " + professor.getEspecialidade());
        professor.AumentarSalario(10);
        System.out.println("Recebe " + professor.getSalario() + " e especializa em " + professor.getEspecialidade());

        Funcionario funcionario = new Funcionario("Thais", "F", 39, "Administração", "Sim");
        funcionario.fazerAniversario();
        System.out.println("No setor de " + funcionario.getSetor() + ". Está trabalhando? " + funcionario.getTrabalhando());
        funcionario.mudarTrabalho("Pedagogia");
        System.out.println("No setor de " + funcionario.getSetor() + ". Está trabalhando? " + funcionario.getTrabalhando());

    }

}
