package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import java.sql.ResultSet;

import model.Jogo;
import jdbc.ConnectionFactory;

public class JogoDAO {
    
    public void create(Jogo jogo) {
        Connection conexaoBD = null;
        PreparedStatement stmt = null;
        String sql = "INSERT INTO jogo(id, nome, genero, id_dev, id_publi) VALUES (?, ?, ?, ?, ?)";

        try {
            conexaoBD = ConnectionFactory.getConnection();

            stmt = conexaoBD.prepareStatement(sql);
            stmt.setString(1, jogo.getId());
            stmt.setString(2, jogo.getNome());
            stmt.setString(3, jogo.getGenero());
            stmt.setString(4, jogo.getId_dev());
            stmt.setString(5, jogo.getId_publi());

            // Query
            try {
                stmt.executeUpdate();
                System.out.println("[JogoDAO] Jogo inserido no banco de dados com sucesso.");
            } catch (SQLException e) {
                System.out.println("[JogoDAO] Erro ao inserir jogo. " + e.getMessage());
            }        


        } catch (ClassNotFoundException e) {
            e.printStackTrace();

        } catch (SQLException e) {
            e.printStackTrace();

        } finally {
            ConnectionFactory.closeConnection(conexaoBD, stmt);
        }
    }

    public List<Jogo> readAll() {
        Connection conexaoBD = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        String sql = "SELECT id, nome, genero, id_dev, id_publi FROM jogo";
        List<Jogo> jogos = new ArrayList<Jogo>();

        try {
            conexaoBD = ConnectionFactory.getConnection();
            stmt = conexaoBD.prepareStatement(sql);
            
            rs = stmt.executeQuery();

            while (rs.next()) {
                Jogo jogo = new Jogo();
                jogo.setId(rs.getString("id"));
                jogo.setNome(rs.getString("nome"));
                jogo.setGenero(rs.getString("genero"));
                jogo.setId_dev(rs.getString("id_dev"));
                jogo.setId_publi(rs.getString("id_publi"));

                jogos.add(jogo);
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();

        } catch (SQLException e) {
            e.printStackTrace();

        } finally {
            ConnectionFactory.closeConnection(conexaoBD, stmt);
        }

        return jogos;
    }

    public List<Jogo> readAllNome() {
        Connection conexaoBD = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        String sql = "SELECT j.id, j.nome, j.genero, d.nome id_dev, p.nome id_publi FROM jogo j INNER JOIN desenvolvedora d ON j.id_dev = d.id INNER JOIN publicadora p ON j.id_publi = p.id WHERE j.nome = j.nome AND j.genero = j.genero AND j.id_dev = j.id_dev AND j.id_publi = j.id_publi ORDER BY j.id ASC";
        List<Jogo> jogos = new ArrayList<Jogo>();

        try {
            conexaoBD = ConnectionFactory.getConnection();
            stmt = conexaoBD.prepareStatement(sql);
            
            rs = stmt.executeQuery();

            while (rs.next()) {
                Jogo jogo = new Jogo();
                jogo.setId(rs.getString("id"));
                jogo.setNome(rs.getString("nome"));
                jogo.setGenero(rs.getString("genero"));
                jogo.setId_dev(rs.getString("id_dev"));
                jogo.setId_publi(rs.getString("id_publi"));

                jogos.add(jogo);
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();

        } catch (SQLException e) {
            e.printStackTrace();

        } finally {
            ConnectionFactory.closeConnection(conexaoBD, stmt);
        }

        return jogos;
    }

    public List<Jogo> select(Jogo jogo) {
        Connection conexaoBD = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        // Apenas a matrícula foi imformada
        
        List<Jogo> jogos = new ArrayList<Jogo>();

        try {
            conexaoBD = ConnectionFactory.getConnection();
            // Qualquer situação que id foi informado
            if (jogo.getId() != "") {
                String sql = "SELECT id, nome, genero, id_dev, id_publi FROM jogo WHERE id = ?";
                stmt = conexaoBD.prepareStatement(sql);
                stmt.setString(1, jogo.getId());

                // Nenhum foi informado
            } else if (jogo.getNome() == "" && jogo.getGenero() == "" && jogo.getId_dev() == "" && jogo.getId_publi() == "") {
                String sql = "SELECT id, nome, genero, id_dev, id_publi FROM jogo";
                stmt = conexaoBD.prepareStatement(sql);

                // Apenas o nome foi informado
            } else if (jogo.getGenero() == "" && jogo.getId_dev() == "" && jogo.getId_publi() == "") {
                String sql = "SELECT id, nome, genero, id_dev, id_publi FROM jogo WHERE nome = ?";
                stmt = conexaoBD.prepareStatement(sql);
                stmt.setString(1, jogo.getNome());

                // Apenas o genero foi informado
            } else if (jogo.getNome() == "" && jogo.getId_dev() == "" && jogo.getId_publi() == "") {
                String sql = "SELECT id, nome, genero, id_dev, id_publi FROM jogo WHERE genero = ?";
                stmt = conexaoBD.prepareStatement(sql);
                stmt.setString(1, jogo.getGenero());

                // Apenas o id_dev foi informado
            } else if (jogo.getNome() == "" && jogo.getGenero() == "" && jogo.getId_publi() == "") {
                String sql = "SELECT id, nome, genero, id_dev, id_publi FROM jogo WHERE id_dev = ?";
                stmt = conexaoBD.prepareStatement(sql);
                stmt.setString(1, jogo.getId_dev());

                // Apenas o id_publi foi informado
            } else if (jogo.getNome() == "" && jogo.getGenero() == "" && jogo.getId_dev() == "") {
                String sql = "SELECT id, nome, genero, id_dev, id_publi FROM jogo where id_publi = ?";
                stmt = conexaoBD.prepareStatement(sql);
                stmt.setString(1, jogo.getId_publi());

                // Apenas o nome e o genero foram informados
            } else if (jogo.getId_dev() == "" && jogo.getId_publi() == "") {
                String sql = "SELECT id, nome, genero, id_dev, id_publi FROM jogo WHERE nome = ? AND genero = ?";
                stmt = conexaoBD.prepareStatement(sql);
                stmt.setString(1, jogo.getNome());
                stmt.setString(2, jogo.getGenero());

                // Apenas o nome e o id_dev foram informados
            } else if (jogo.getGenero() == "" && jogo.getId_publi() == "") {;
                String sql = "SELECT id, nome, genero, id_dev, id_publi FROM jogo WHERE nome = ? AND id_dev = ?";
                stmt = conexaoBD.prepareStatement(sql);
                stmt.setString(1, jogo.getNome());
                stmt.setString(2, jogo.getId_dev());
                
                // Apenas o nome e id_publi foram informados
            } else if (jogo.getGenero() == "" && jogo.getId_dev() == "") {
                String sql = "SELECT id, nome, genero, id_dev, id_publi FROM jogo where nome = ? AND id_publi = ?";
                stmt = conexaoBD.prepareStatement(sql);
                stmt.setString(1, jogo.getNome());
                stmt.setString(2, jogo.getId_publi());

                // Apenas o genero e o id_dev foram informados
            } else if (jogo.getNome() == "" && jogo.getId_publi() == "") {
                String sql = "SELECT id, nome, genero, id_dev, id_publi FROM jogo WHERE genero = ? AND id_dev = ?";
                stmt = conexaoBD.prepareStatement(sql);
                stmt.setString(1, jogo.getGenero());
                stmt.setString(2, jogo.getId_dev());

                // Apenas o genero e o id_publi foram informados
            } else if (jogo.getNome() == "" && jogo.getId_dev() == "") {
                String sql = "SELECT id, nome, genero, id_dev, id_publi FROM jogo WHERE genero = ? AND id_publi = ?";
                stmt = conexaoBD.prepareStatement(sql);
                stmt.setString(1, jogo.getGenero());
                stmt.setString(2, jogo.getId_publi());

                // Apenas o id_dev e o id_publi foram informados
            } else if (jogo.getNome() == "" && jogo.getGenero() == "") {;
                String sql = "SELECT id, nome, genero, id_dev, id_publi FROM jogo WHERE id_dev = ? AND id_publi = ?";
                stmt = conexaoBD.prepareStatement(sql);
                stmt.setString(1, jogo.getId_dev());
                stmt.setString(2, jogo.getId_publi());

                // Apenas nome, genero e id_dev foram informados
            } else if (jogo.getId_publi() == "") {
                String sql = "SELECT id, nome, genero, id_dev, id_publi FROM jogo WHERE nome = ? AND genero = ? AND id_dev = ?";
                stmt = conexaoBD.prepareStatement(sql);
                stmt.setString(1, jogo.getNome());
                stmt.setString(2, jogo.getGenero());
                stmt.setString(3, jogo.getId_dev());

                // Apenas nome, genero e id_publi foram informados
            } else  if (jogo.getId_dev() == "") {
                String sql = "SELECT id, nome, genero, id_dev, id_publi FROM jogo WHERE nome = ? AND genero = ? AND id_publi = ?";
                stmt = conexaoBD.prepareStatement(sql);
                stmt.setString(1, jogo.getNome());
                stmt.setString(2, jogo.getGenero());
                stmt.setString(3, jogo.getId_publi());

                // Apenas nome, id_dev e id_publi foram informados
            } else if (jogo.getGenero() == "") {
                String sql = "SELECT id, nome, genero, id_dev, id_publi FROM jogo WHERE nome = ? AND id_dev = ? AND id_publi = ?";
                stmt = conexaoBD.prepareStatement(sql);
                stmt.setString(1, jogo.getNome());
                stmt.setString(2, jogo.getId_dev());
                stmt.setString(3, jogo.getId_publi());

                // Apenas genero, id_dev e id_publi foram informados
            } else if (jogo.getNome() == "") {
                String sql = "SELECT id, nome, genero, id_dev, id_publi FROM jogo WHERE genero = ? AND id_dev = ? AND id_publi = ?";
                stmt = conexaoBD.prepareStatement(sql);
                stmt.setString(1, jogo.getGenero());
                stmt.setString(2, jogo.getId_dev());
                stmt.setString(3, jogo.getId_publi());

                // Tudo exceto id foi informado
            } else {
                String sql = "SELECT id, nome, genero, id_dev, id_publi FROM jogo WHERE nome = ? AND genero = ? AND id_dev = ? AND id_publi = ?";
                stmt = conexaoBD.prepareStatement(sql);
                stmt.setString(1, jogo.getNome());
                stmt.setString(2, jogo.getGenero());
                stmt.setString(3, jogo.getId_dev());
                stmt.setString(4, jogo.getId_publi());
            }

            
            rs = stmt.executeQuery();

            while (rs.next()) {
                Jogo temp = new Jogo();
                temp.setId(rs.getString("id"));
                temp.setNome(rs.getString("nome"));
                temp.setGenero(rs.getString("genero"));
                temp.setId_dev(rs.getString("id_dev"));
                temp.setId_publi(rs.getString("id_publi"));

                jogos.add(temp);
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();

        } catch (SQLException e) {
            e.printStackTrace();

        } finally {
            ConnectionFactory.closeConnection(conexaoBD, stmt);
        }

        return jogos;
    }

    public List<Jogo> selectNome (Jogo jogo) {
        Connection conexaoBD = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        // Apenas a matrícula foi imformada
        
        List<Jogo> jogos = new ArrayList<Jogo>();

        try {
            conexaoBD = ConnectionFactory.getConnection();
            // Qualquer situação que id foi informado
            if (jogo.getId() != "") {
                String sql = "SELECT j.id, j.nome, j.genero, d.nome id_dev, p.nome id_publi FROM jogo j INNER JOIN desenvolvedora d ON j.id_dev = d.id INNER JOIN publicadora p ON j.id_publi = p.id WHERE id = ?";
                stmt = conexaoBD.prepareStatement(sql);
                stmt.setString(1, jogo.getId());

                // Nenhum foi informado
            } else if (jogo.getNome() == "" && jogo.getGenero() == "" && jogo.getId_dev() == "" && jogo.getId_publi() == "") {
                String sql = "SELECT id, nome, genero, id_dev, id_publi FROM jogo";
                stmt = conexaoBD.prepareStatement(sql);

                // Apenas o nome foi informado
            } else if (jogo.getGenero() == "" && jogo.getId_dev() == "" && jogo.getId_publi() == "") {
                String sql = "SELECT j.id, j.nome, j.genero, d.nome id_dev, p.nome id_publi FROM jogo j INNER JOIN desenvolvedora d ON j.id_dev = d.id INNER JOIN publicadora p ON j.id_publi = p.id WHERE j.nome = ?";
                stmt = conexaoBD.prepareStatement(sql);
                stmt.setString(1, jogo.getNome());

                // Apenas o genero foi informado
            } else if (jogo.getNome() == "" && jogo.getId_dev() == "" && jogo.getId_publi() == "") {
                String sql = "SELECT j.id, j.nome, j.genero, d.nome id_dev, p.nome id_publi FROM jogo j INNER JOIN desenvolvedora d ON j.id_dev = d.id INNER JOIN publicadora p ON j.id_publi = p.id WHERE j.genero = ?";
                stmt = conexaoBD.prepareStatement(sql);
                stmt.setString(1, jogo.getGenero());

                // Apenas o id_dev foi informado
            } else if (jogo.getNome() == "" && jogo.getGenero() == "" && jogo.getId_publi() == "") {
                String sql = "SELECT j.id, j.nome, j.genero, d.nome id_dev, p.nome id_publi FROM jogo j INNER JOIN desenvolvedora d ON j.id_dev = d.id INNER JOIN publicadora p ON j.id_publi = p.id WHERE id_dev = ?";
                stmt = conexaoBD.prepareStatement(sql);
                stmt.setString(1, jogo.getId_dev());

                // Apenas o id_publi foi informado
            } else if (jogo.getNome() == "" && jogo.getGenero() == "" && jogo.getId_dev() == "") {
                String sql = "SELECT j.id, j.nome, j.genero, d.nome id_dev, p.nome id_publi FROM jogo j INNER JOIN desenvolvedora d ON j.id_dev = d.id INNER JOIN publicadora p ON j.id_publi = p.id WHERE id_publi = ?";
                stmt = conexaoBD.prepareStatement(sql);
                stmt.setString(1, jogo.getId_publi());

                // Apenas o nome e o genero foram informados
            } else if (jogo.getId_dev() == "" && jogo.getId_publi() == "") {
                String sql = "SELECT j.id, j.nome, j.genero, d.nome id_dev, p.nome id_publi FROM jogo j INNER JOIN desenvolvedora d ON j.id_dev = d.id INNER JOIN publicadora p ON j.id_publi = p.id WHERE j.nome = ? AND j.genero = ?";
                stmt = conexaoBD.prepareStatement(sql);
                stmt.setString(1, jogo.getNome());
                stmt.setString(2, jogo.getGenero());

                // Apenas o nome e o id_dev foram informados
            } else if (jogo.getGenero() == "" && jogo.getId_publi() == "") {;
                String sql = "SELECT j.id, j.nome, j.genero, d.nome id_dev, p.nome id_publi FROM jogo j INNER JOIN desenvolvedora d ON j.id_dev = d.id INNER JOIN publicadora p ON j.id_publi = p.id WHERE j.nome = ? AND id_dev = ?";
                stmt = conexaoBD.prepareStatement(sql);
                stmt.setString(1, jogo.getNome());
                stmt.setString(2, jogo.getId_dev());
                
                // Apenas o nome e id_publi foram informados
            } else if (jogo.getGenero() == "" && jogo.getId_dev() == "") {
                String sql = "SELECT j.id, j.nome, j.genero, d.nome id_dev, p.nome id_publi FROM jogo j INNER JOIN desenvolvedora d ON j.id_dev = d.id INNER JOIN publicadora p ON j.id_publi = p.id WHERE j.nome = ? AND id_publi = ?";
                stmt = conexaoBD.prepareStatement(sql);
                stmt.setString(1, jogo.getNome());
                stmt.setString(2, jogo.getId_publi());

                // Apenas o genero e o id_dev foram informados
            } else if (jogo.getNome() == "" && jogo.getId_publi() == "") {
                String sql = "SELECT j.id, j.nome, j.genero, d.nome id_dev, p.nome id_publi FROM jogo j INNER JOIN desenvolvedora d ON j.id_dev = d.id INNER JOIN publicadora p ON j.id_publi = p.id WHERE j.genero = ? AND id_dev = ?";
                stmt = conexaoBD.prepareStatement(sql);
                stmt.setString(1, jogo.getGenero());
                stmt.setString(2, jogo.getId_dev());

                // Apenas o genero e o id_publi foram informados
            } else if (jogo.getNome() == "" && jogo.getId_dev() == "") {
                String sql = "SELECT j.id, j.nome, j.genero, d.nome id_dev, p.nome id_publi FROM jogo j INNER JOIN desenvolvedora d ON j.id_dev = d.id INNER JOIN publicadora p ON j.id_publi = p.id WHERE j.genero = ? AND id_publi = ?";
                stmt = conexaoBD.prepareStatement(sql);
                stmt.setString(1, jogo.getGenero());
                stmt.setString(2, jogo.getId_publi());

                // Apenas o id_dev e o id_publi foram informados
            } else if (jogo.getNome() == "" && jogo.getGenero() == "") {;
                String sql = "SELECT j.id, j.nome, j.genero, d.nome id_dev, p.nome id_publi FROM jogo j INNER JOIN desenvolvedora d ON j.id_dev = d.id INNER JOIN publicadora p ON j.id_publi = p.id WHERE id_dev = ? AND id_publi = ?";
                stmt = conexaoBD.prepareStatement(sql);
                stmt.setString(1, jogo.getId_dev());
                stmt.setString(2, jogo.getId_publi());

                // Apenas nome, genero e id_dev foram informados
            } else if (jogo.getId_publi() == "") {
                String sql = "SELECT j.id, j.nome, j.genero, d.nome id_dev, p.nome id_publi FROM jogo j INNER JOIN desenvolvedora d ON j.id_dev = d.id INNER JOIN publicadora p ON j.id_publi = p.id WHERE j.nome = ? AND j.genero = ? AND id_dev = ?";
                stmt = conexaoBD.prepareStatement(sql);
                stmt.setString(1, jogo.getNome());
                stmt.setString(2, jogo.getGenero());
                stmt.setString(3, jogo.getId_dev());

                // Apenas nome, genero e id_publi foram informados
            } else  if (jogo.getId_dev() == "") {
                String sql = "SELECT j.id, j.nome, j.genero, d.nome id_dev, p.nome id_publi FROM jogo j INNER JOIN desenvolvedora d ON j.id_dev = d.id INNER JOIN publicadora p ON j.id_publi = p.id WHERE j.nome = ? AND j.genero = ? AND id_publi = ?";
                stmt = conexaoBD.prepareStatement(sql);
                stmt.setString(1, jogo.getNome());
                stmt.setString(2, jogo.getGenero());
                stmt.setString(3, jogo.getId_publi());

                // Apenas nome, id_dev e id_publi foram informados
            } else if (jogo.getGenero() == "") {
                String sql = "SELECT j.id, j.nome, j.genero, d.nome id_dev, p.nome id_publi FROM jogo j INNER JOIN desenvolvedora d ON j.id_dev = d.id INNER JOIN publicadora p ON j.id_publi = p.id WHERE j.nome = ? AND id_dev = ? AND id_publi = ?";
                stmt = conexaoBD.prepareStatement(sql);
                stmt.setString(1, jogo.getNome());
                stmt.setString(2, jogo.getId_dev());
                stmt.setString(3, jogo.getId_publi());

                // Apenas genero, id_dev e id_publi foram informados
            } else if (jogo.getNome() == "") {
                String sql = "SELECT j.id, j.nome, j.genero, d.nome id_dev, p.nome id_publi FROM jogo j INNER JOIN desenvolvedora d ON j.id_dev = d.id INNER JOIN publicadora p ON j.id_publi = p.id WHERE j.genero = ? AND id_dev = ? AND id_publi = ?";
                stmt = conexaoBD.prepareStatement(sql);
                stmt.setString(1, jogo.getGenero());
                stmt.setString(2, jogo.getId_dev());
                stmt.setString(3, jogo.getId_publi());

                // Tudo exceto id foi informado
            } else {
                String sql = "SELECT j.id, j.nome, j.genero, d.nome id_dev, p.nome id_publi FROM jogo j INNER JOIN desenvolvedora d ON j.id_dev = d.id INNER JOIN publicadora p ON j.id_publi = p.id WHERE j.nome = ? AND j.genero = ? AND id_dev = ? AND id_publi = ?";
                stmt = conexaoBD.prepareStatement(sql);
                stmt.setString(1, jogo.getNome());
                stmt.setString(2, jogo.getGenero());
                stmt.setString(3, jogo.getId_dev());
                stmt.setString(4, jogo.getId_publi());
            }

            
            rs = stmt.executeQuery();

            while (rs.next()) {
                Jogo temp = new Jogo();
                temp.setId(rs.getString("id"));
                temp.setNome(rs.getString("nome"));
                temp.setGenero(rs.getString("genero"));
                temp.setId_dev(rs.getString("id_dev"));
                temp.setId_publi(rs.getString("id_publi"));

                jogos.add(temp);
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();

        } catch (SQLException e) {
            e.printStackTrace();

        } finally {
            ConnectionFactory.closeConnection(conexaoBD, stmt);
        }

        return jogos;
    }

    public void update(Jogo jogo) {
        Connection conexaoBD = null;
        PreparedStatement stmt = null;
        String sql = "UPDATE jogo SET nome = ?, genero = ?, id_dev = ?, id_publi = ? WHERE id = ?";

        try {
            conexaoBD = ConnectionFactory.getConnection();

            stmt = conexaoBD.prepareStatement(sql);
            stmt.setString(1, jogo.getNome());
            stmt.setString(2, jogo.getGenero());
            stmt.setString(3, jogo.getId_dev());
            stmt.setString(4, jogo.getId_publi());
            stmt.setString(5, jogo.getId());

            // Query
            try {
                stmt.executeUpdate();
                System.out.println("[JogoDAO] Jogo atualizado no banco de dados com sucesso.");
            } catch (SQLException e) {
                System.out.println("[JogoDAO] Erro ao atualizar jogo. " + e.getMessage());
            } 

        } catch (ClassNotFoundException e) {
            e.printStackTrace();

        } catch (SQLException e) {
            e.printStackTrace();

        } finally {
            ConnectionFactory.closeConnection(conexaoBD, stmt);
        }
    }

    public void delete(Jogo jogo) {
        Connection conexaoBD = null;
        PreparedStatement stmt = null;
        String sql = "DELETE FROM jogo WHERE id = ? AND nome = ? AND genero = ? AND id_dev = ? AND id_publi = ?";

        try {
            conexaoBD = ConnectionFactory.getConnection();

            stmt = conexaoBD.prepareStatement(sql);
            stmt.setString(1, jogo.getId());
            stmt.setString(2, jogo.getNome());
            stmt.setString(3, jogo.getGenero());
            stmt.setString(4, jogo.getId_dev());
            stmt.setString(5, jogo.getId_publi());

            // Query
            try {
                stmt.executeUpdate();
                System.out.println("[JogoDAO] Jogo excluído do banco de dados com sucesso.");
            } catch (SQLException e) {
                System.out.println("[JogoDAO] Erro ao excluir jogo. " + e.getMessage());
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();

        } catch (SQLException e) {
            e.printStackTrace();

        } finally {
            ConnectionFactory.closeConnection(conexaoBD, stmt);
        }
    }

    

    public String getDevId (String nome) {

        Connection conexaoBD = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String sql = "SELECT id FROM desenvolvedora WHERE nome = ?";
        String dev = "";

        try {
            conexaoBD = ConnectionFactory.getConnection();

            stmt = conexaoBD.prepareStatement(sql);
            stmt.setString(1, nome);

            // Query
            rs = stmt.executeQuery();
            while (rs.next()) {
                dev = rs.getString("id");
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(conexaoBD, stmt);
        }
        
        return dev;
    }

    public String getPubliId (String nome) {

        Connection conexaoBD = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String sql = "SELECT id FROM publicadora WHERE nome = ?";
        String publi = "";

        try {
            conexaoBD = ConnectionFactory.getConnection();

            stmt = conexaoBD.prepareStatement(sql);
            stmt.setString(1, nome);

            // Query
            rs = stmt.executeQuery();
            while (rs.next()) {
                publi = rs.getString("id");
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(conexaoBD, stmt);
        }
        
        return publi;
    }
}
