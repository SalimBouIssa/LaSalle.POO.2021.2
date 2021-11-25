package controller;

import java.util.ArrayList;
import java.util.List;

import dao.AlunoDAO;
import model.Aluno;

public class AlunoController {

    public void create(Aluno aluno) {
        try {
            AlunoDAO dao = new AlunoDAO();
            dao.create(aluno);
        } catch (Exception e) {
            System.out.println("[AlunoController] Erro ao adicionar aluno");
        }
        
    }

    public List<Aluno> readAll() {
        List<Aluno> alunos = new ArrayList<Aluno>();
        try {
            AlunoDAO dao = new AlunoDAO();
            alunos = dao.readAll();
        } catch (Exception e) {
            System.out.println("[AlunoController] Erro ao ler aluno");
        }
        return alunos;
    }

    public void update(Aluno aluno) {
        try {
            AlunoDAO dao = new AlunoDAO();
            dao.update(aluno);
        } catch (Exception e) {
            System.out.println("[AlunoController] Erro ao atualizar aluno");
        }
        
    }

    public void delete(Aluno aluno) {
        try {
            AlunoDAO dao = new AlunoDAO();
            dao.delete(aluno);
        } catch (Exception e) {
            System.out.println("[AlunoController] Erro ao excluir aluno");
        }
    }

    public List<Aluno> select(Aluno aluno) {
        List<Aluno> alunos = new ArrayList<Aluno>();
        try {
            AlunoDAO dao = new AlunoDAO();
            alunos = dao.select(aluno);
        } catch (Exception e) {
            System.out.println("[AlunoController] Erro ao selecionar aluno");
        }
        return alunos;
    }
}
