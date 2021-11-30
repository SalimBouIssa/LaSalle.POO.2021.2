package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;

import model.Publicadora;
import jdbc.ConnectionFactory;

public class PublicadoraDAO {
    
    public void create(Publicadora publi) {
        Connection conexaoBD = null;
        PreparedStatement stmt = null;
        String sql = "INSERT INTO publicadora(id, nome, local) VALUES (?, ?, ?)";

        try {
            conexaoBD = ConnectionFactory.getConnection();

            stmt = conexaoBD.prepareStatement(sql);
            stmt.setString(1, publi.getId());
            stmt.setString(2, publi.getNome());
            stmt.setString(3, publi.getLocal());

            // Query
            try {
                stmt.executeUpdate();
                System.out.println("[PublicadoraDAO] Publicadora inserida no banco de dados com sucesso.");
            } catch (SQLException e) {
                System.out.println("[PublicadoraDAO] Erro ao inserir publicadora. " + e.getMessage());
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();

        } catch (SQLException e) {
            e.printStackTrace();

        } finally {
            ConnectionFactory.closeConnection(conexaoBD, stmt);
        }
    }

    public List<Publicadora> readAll() {
        Connection conexaoBD = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        String sql = "SELECT id, nome, local FROM publicadora";
        List<Publicadora> publis = new ArrayList<Publicadora>();

        try {
            conexaoBD = ConnectionFactory.getConnection();
            stmt = conexaoBD.prepareStatement(sql);
            
            rs = stmt.executeQuery();

            while (rs.next()) {
                Publicadora publi = new Publicadora();
                publi.setId(rs.getString("id"));
                publi.setNome(rs.getString("nome"));
                publi.setLocal(rs.getString("local"));

                publis.add(publi);
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();

        } catch (SQLException e) {
            e.printStackTrace();

        } finally {
            ConnectionFactory.closeConnection(conexaoBD, stmt);
        }

        return publis;
    }

    public List<Publicadora> select(Publicadora publi) {
        Connection conexaoBD = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        // Apenas a matrícula foi imformada
        
        List<Publicadora> publis = new ArrayList<Publicadora>();

        try {
            conexaoBD = ConnectionFactory.getConnection();
            // Nenhum foi informado
            if (publi.getId() == "" && publi.getNome() == "" && publi.getLocal() == ""){
                String sql = "SELECT id, nome, local FROM publicadora";
                stmt = conexaoBD.prepareStatement(sql);
                // Apenas a id foi informada
            } else if (publi.getNome() == "" && publi.getLocal() == "") {
                String sql = "SELECT id, nome, local FROM publicadora WHERE id = ?";
                stmt = conexaoBD.prepareStatement(sql);
                stmt.setString(1, publi.getId());
            // Apenas o local foi informado
            } else if (publi.getNome() == "" && publi.getId() == "") {
                String sql = "SELECT id, nome, local FROM publicadora WHERE local = ?";
                stmt = conexaoBD.prepareStatement(sql);
                stmt.setString(1, publi.getLocal());
            // Apenas o nome foi informado
            } else if (publi.getId() == "" && publi.getLocal() == "") {
                String sql = "SELECT id, nome, local FROM publicadora WHERE nome = ?";
                stmt = conexaoBD.prepareStatement(sql);
                stmt.setString(1, publi.getNome());
            // Id e nome foi informado
            } else if (publi.getLocal() == "") {
                String sql = "SELECT id, nome, local FROM publicadora WHERE id = ? AND nome = ?";
                stmt = conexaoBD.prepareStatement(sql);
                stmt.setString(1, publi.getId());
                stmt.setString(2, publi.getNome());
            // Id e local foi informado
            } else if (publi.getNome() == "") {
                String sql = "SELECT id, nome, local FROM publicadora WHERE id = ? AND local = ?";
                stmt = conexaoBD.prepareStatement(sql);
                stmt.setString(1, publi.getId());
                stmt.setString(2, publi.getLocal());
            // Nome e local foi informado
            } else if (publi.getId() == "") {
                String sql = "SELECT id, nome, local FROM publicadora WHERE nome = ? AND local = ?";
                stmt = conexaoBD.prepareStatement(sql);
                stmt.setString(1, publi.getNome());
                stmt.setString(2, publi.getLocal());
            // Todos foram informados
            } else {
                String sql = "SELECT id, nome, local FROM publicadora WHERE id = ? AND nome = ? AND local = ?";
                stmt = conexaoBD.prepareStatement(sql);
                stmt.setString(1, publi.getId());
                stmt.setString(2, publi.getNome());
                stmt.setString(3, publi.getLocal());
            }
            
            rs = stmt.executeQuery();

            while (rs.next()) {
                Publicadora temp = new Publicadora();
                temp.setId(rs.getString("id"));
                temp.setNome(rs.getString("nome"));
                temp.setLocal(rs.getString("local"));

                publis.add(temp);
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();

        } catch (SQLException e) {
            e.printStackTrace();

        } finally {
            ConnectionFactory.closeConnection(conexaoBD, stmt);
        }

        return publis;
    }

    public void update(Publicadora publi) {
        Connection conexaoBD = null;
        PreparedStatement stmt = null;
        String sql = "UPDATE publicadora SET nome = ?, local = ? WHERE id = ?";

        try {
            conexaoBD = ConnectionFactory.getConnection();

            stmt = conexaoBD.prepareStatement(sql);
            stmt.setString(1, publi.getNome());
            stmt.setString(2, publi.getLocal());
            stmt.setString(3, publi.getId());

            // Query
            try {
                stmt.executeUpdate();
                System.out.println("[PublicadoraDAO] Publicadora atualizada no banco de dados com sucesso.");
            } catch (SQLException e) {
                System.out.println("[PublicadoraDAO] Erro ao atualizar publicadora. " + e.getMessage());
            }
            
        } catch (ClassNotFoundException e) {
            e.printStackTrace();

        } catch (SQLException e) {
            e.printStackTrace();

        } finally {
            ConnectionFactory.closeConnection(conexaoBD, stmt);
        }
    }

    public void delete(Publicadora publi) {
        Connection conexaoBD = null;
        PreparedStatement stmt = null;
        String sql = "DELETE FROM publicadora WHERE nome = ? AND local = ? AND id = ?";

        try {
            conexaoBD = ConnectionFactory.getConnection();

            stmt = conexaoBD.prepareStatement(sql);
            stmt.setString(1, publi.getNome());
            stmt.setString(2, publi.getLocal());
            stmt.setString(3, publi.getId());

            // Query
            try {
                stmt.executeUpdate();
                System.out.println("[PublicadoraDAO] Publicadora excluída do banco de dados com sucesso.");
            } catch (SQLException e) {
                System.out.println("[PublicadoraDAO] Erro ao excluir publicadora. " + e.getMessage());
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();

        } catch (SQLException e) {
            e.printStackTrace();

        } finally {
            ConnectionFactory.closeConnection(conexaoBD, stmt);
        }
    }

    public List<String> readAllNome() {
        Connection conexaoBD = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        String sql = "SELECT nome FROM publicadora";
        List<String> publis = new ArrayList<String>();

        try {
            conexaoBD = ConnectionFactory.getConnection();
            stmt = conexaoBD.prepareStatement(sql);
            
            rs = stmt.executeQuery();

            while (rs.next()) {
                publis.add(rs.getString("nome"));
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();

        } catch (SQLException e) {
            e.printStackTrace();

        } finally {
            ConnectionFactory.closeConnection(conexaoBD, stmt);
        }

        return publis;
    }
}
