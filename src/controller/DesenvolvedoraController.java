package controller;

import java.util.ArrayList;
import java.util.List;

import dao.DesenvolvedoraDAO;
import model.Desenvolvedora;

public class DesenvolvedoraController {
    public void create (Desenvolvedora dev) {
        try {
            DesenvolvedoraDAO dao = new DesenvolvedoraDAO();
            dao.create(dev);
        } catch (Exception e) {
            System.out.println("[DesenvolvedoraController] Erro ao adicionar desenvolvedora");
        }
        
    }

    public List<Desenvolvedora> readAll () {
        List<Desenvolvedora> devs = new ArrayList<Desenvolvedora>();
        try {
            DesenvolvedoraDAO dao = new DesenvolvedoraDAO();
            devs = dao.readAll();
        } catch (Exception e) {
            System.out.println("[DesenvolvedoraController] Erro ao ler desenvolvedora");
        }
        return devs;
    }

    public List<String> readAllNome () {
        List<String> devs = new ArrayList<String>();
        try {
            DesenvolvedoraDAO dao = new DesenvolvedoraDAO();
            devs = dao.readAllNome();
        } catch (Exception e) {
            System.out.println("[DesenvolvedoraController] Erro ao ler desenvolvedora");
        }
        return devs;
    }

    public void update (Desenvolvedora dev) {
        try {
            DesenvolvedoraDAO dao = new DesenvolvedoraDAO();
            dao.update(dev);
        } catch (Exception e) {
            System.out.println("[DesenvolvedoraController] Erro ao atualizar desenvolvedora");
        }
        
    }

    public void delete (Desenvolvedora dev) {
        try {
            DesenvolvedoraDAO dao = new DesenvolvedoraDAO();
            dao.delete(dev);
        } catch (Exception e) {
            System.out.println("[DesenvolvedoraController] Erro ao excluir desenvolvedora");
        }
    }

    public List<Desenvolvedora> select (Desenvolvedora dev) {
        List<Desenvolvedora> devs = new ArrayList<Desenvolvedora>();
        try {
            DesenvolvedoraDAO dao = new DesenvolvedoraDAO();
            devs = dao.select(dev);
        } catch (Exception e) {
            System.out.println("[DesenvolvedoraController] Erro ao selecionar desenvolvedora");
        }
        return devs;
    }
}