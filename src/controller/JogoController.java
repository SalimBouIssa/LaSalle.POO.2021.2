package controller;

import java.util.ArrayList;
import java.util.List;

import dao.JogoDAO;
import model.Jogo;

public class JogoController {
    public void create (Jogo jogo) {
        try {
            JogoDAO dao = new JogoDAO();
            dao.create(jogo);
        } catch (Exception e) {
            System.out.println("[JogoController] Erro ao adicionar jogo");
        }
        
    }

    public List<Jogo> readAll () {
        List<Jogo> jogos = new ArrayList<Jogo>();
        try {
            JogoDAO dao = new JogoDAO();
            jogos = dao.readAll();
        } catch (Exception e) {
            System.out.println("[JogoController] Erro ao ler jogo");
        }
        return jogos;
    }

    public List<Jogo> readAllNome () {
        List<Jogo> jogos = new ArrayList<Jogo>();
        try {
            JogoDAO dao = new JogoDAO();
            jogos = dao.readAllNome();
        } catch (Exception e) {
            System.out.println("[JogoController] Erro ao ler jogo");
        }
        return jogos;
    }

    public void update (Jogo jogo) {
        try {
            JogoDAO dao = new JogoDAO();
            dao.update(jogo);
        } catch (Exception e) {
            System.out.println("[JogoController] Erro ao atualizar jogo");
        }
        
    }

    public void delete (Jogo jogo) {
        try {
            JogoDAO dao = new JogoDAO();
            dao.delete(jogo);
        } catch (Exception e) {
            System.out.println("[JogoController] Erro ao excluir jogo");
        }
    }

    public List<Jogo> select (Jogo jogo) {
        List<Jogo> jogos = new ArrayList<Jogo>();
        try {
            JogoDAO dao = new JogoDAO();
            jogos = dao.select(jogo);
        } catch (Exception e) {
            System.out.println("[JogoController] Erro ao selecionar jogo");
        }
        return jogos;
    }

    public List<Jogo> selectNome (Jogo jogo) {
        List<Jogo> jogos = new ArrayList<Jogo>();
        try {
            JogoDAO dao = new JogoDAO();
            jogos = dao.selectNome(jogo);
        } catch (Exception e) {
            System.out.println("[JogoController] Erro ao selecionar jogo");
        }
        return jogos;
    }

    public String getDevId (String nome) {
        String dev = "";
        try {
            JogoDAO dao = new JogoDAO();
            dev = dao.getDevId(nome);
        } catch (Exception e) {
            System.out.println("[JogoController] Erro ao buscar desenvolvedora");
        }
        return dev;
    }

    public String getPubliId (String nome) {
        String publi = "";
        try {
            JogoDAO dao = new JogoDAO();
            publi = dao.getPubliId(nome);
        } catch (Exception e) {
            System.out.println("[JogoController] Erro ao buscar publicadora");
        }
        return publi;
    }
}