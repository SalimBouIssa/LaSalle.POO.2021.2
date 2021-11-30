package controller;

import java.util.ArrayList;
import java.util.List;

import dao.PublicadoraDAO;
import model.Publicadora;

public class PublicadoraController {
    public void create(Publicadora publi) {
        try {
            PublicadoraDAO dao = new PublicadoraDAO();
            dao.create(publi);
        } catch (Exception e) {
            System.out.println("[PublicadoraController] Erro ao adicionar publicadora");
        }
        
    }

    public List<Publicadora> readAll() {
        List<Publicadora> publis = new ArrayList<Publicadora>();
        try {
            PublicadoraDAO dao = new PublicadoraDAO();
            publis = dao.readAll();
        } catch (Exception e) {
            System.out.println("[PublicadoraController] Erro ao ler publicadora");
        }
        return publis;
    }

    public List<String> readAllNome() {
        List<String> publis = new ArrayList<String>();
        try {
            PublicadoraDAO dao = new PublicadoraDAO();
            publis = dao.readAllNome();
        } catch (Exception e) {
            System.out.println("[DesenvolvedoraController] Erro ao ler desenvolvedora");
        }
        return publis;
    }

    public void update(Publicadora publi) {
        try {
            PublicadoraDAO dao = new PublicadoraDAO();
            dao.update(publi);
        } catch (Exception e) {
            System.out.println("[PublicadoraController] Erro ao atualizar publicadora");
        }
        
    }

    public void delete(Publicadora publi) {
        try {
            PublicadoraDAO dao = new PublicadoraDAO();
            dao.delete(publi);
        } catch (Exception e) {
            System.out.println("[PublicadoraController] Erro ao excluir publicadora");
        }
    }

    public List<Publicadora> select(Publicadora publi) {
        List<Publicadora> publis = new ArrayList<Publicadora>();
        try {
            PublicadoraDAO dao = new PublicadoraDAO();
            publis = dao.select(publi);
        } catch (Exception e) {
            System.out.println("[PublicadoraController] Erro ao selecionar publicadora");
        }
        return publis;
    }  
}