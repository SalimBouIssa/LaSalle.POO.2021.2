package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;

import model.Desenvolvedora;
import jdbc.ConnectionFactory;

public class DesenvolvedoraDAO {
    
    public void create (Desenvolvedora dev) {
        Connection conexaoBD = null;
        PreparedStatement stmt = null;
        String sql = "INSERT INTO desenvolvedora(id, nome, local) VALUES (?, ?, ?)";

        try {
            conexaoBD = ConnectionFactory.getConnection();

            stmt = conexaoBD.prepareStatement(sql);
            stmt.setString(1, dev.getId());
            stmt.setString(2, dev.getNome());
            stmt.setString(3, dev.getLocal());

            // Query
            try {
                stmt.executeUpdate();
                System.out.println("[DesenvolvedoraDAO] Desenvolvedora inserida no banco de dados com sucesso.");
            } catch (SQLException e) {
                System.out.println("[DesenvolvedoraDAO] Erro ao inserir desenvolvedora. " + e.getMessage());
            }        


        } catch (ClassNotFoundException e) {
            e.printStackTrace();

        } catch (SQLException e) {
            e.printStackTrace();

        } finally {
            ConnectionFactory.closeConnection(conexaoBD, stmt);
        }
    }

    public List<Desenvolvedora> readAll () {
        Connection conexaoBD = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        String sql = "SELECT id, nome, local FROM desenvolvedora";
        List<Desenvolvedora> devs = new ArrayList<Desenvolvedora>();

        try {
            conexaoBD = ConnectionFactory.getConnection();
            stmt = conexaoBD.prepareStatement(sql);
            
            rs = stmt.executeQuery();

            while (rs.next()) {
                Desenvolvedora dev = new Desenvolvedora();
                dev.setId(rs.getString("id"));
                dev.setNome(rs.getString("nome"));
                dev.setLocal(rs.getString("local"));
                devs.add(dev);
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();

        } catch (SQLException e) {
            e.printStackTrace();

        } finally {
            ConnectionFactory.closeConnection(conexaoBD, stmt);
        }

        return devs;
    }

    public List<Desenvolvedora> select (Desenvolvedora dev) {
        Connection conexaoBD = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        // Apenas a matrícula foi imformada
        
        List<Desenvolvedora> devs = new ArrayList<Desenvolvedora>();

        try {
            conexaoBD = ConnectionFactory.getConnection();
            // Nenhum foi informado
            if (dev.getId() == "" && dev.getNome() == "" && dev.getLocal() == ""){
                String sql = "SELECT id, nome, local FROM desenvolvedora";
                stmt = conexaoBD.prepareStatement(sql);
                // Apenas a id foi informada
            } else if (dev.getNome() == "" && dev.getLocal() == "") {
                String sql = "SELECT id, nome, local FROM desenvolvedora WHERE id = ?";
                stmt = conexaoBD.prepareStatement(sql);
                stmt.setString(1, dev.getId());
            // Apenas o local foi informado
            } else if (dev.getNome() == "" && dev.getId() == "") {
                String sql = "SELECT id, nome, local FROM desenvolvedora WHERE local = ?";
                stmt = conexaoBD.prepareStatement(sql);
                stmt.setString(1, dev.getLocal());
            // Apenas o nome foi informado
            } else if (dev.getId() == "" && dev.getLocal() == "") {
                String sql = "SELECT id, nome, local FROM desenvolvedora WHERE nome = ?";
                stmt = conexaoBD.prepareStatement(sql);
                stmt.setString(1, dev.getNome());
            // Id e nome foi informado
            } else if (dev.getLocal() == "") {
                String sql = "SELECT id, nome, local FROM desenvolvedora WHERE id = ? AND nome = ?";
                stmt = conexaoBD.prepareStatement(sql);
                stmt.setString(1, dev.getId());
                stmt.setString(2, dev.getNome());
            // Id e local foi informado
            } else if (dev.getNome() == "") {
                String sql = "SELECT id, nome, local FROM desenvolvedora WHERE id = ? AND local = ?";
                stmt = conexaoBD.prepareStatement(sql);
                stmt.setString(1, dev.getId());
                stmt.setString(2, dev.getLocal());
            // Nome e local foi informado
            } else if (dev.getId() == "") {
                String sql = "SELECT id, nome, local FROM desenvolvedora WHERE nome = ? AND local = ?";
                stmt = conexaoBD.prepareStatement(sql);
                stmt.setString(1, dev.getNome());
                stmt.setString(2, dev.getLocal());
            // Todos foram informados
            } else {
                String sql = "SELECT id, nome, local FROM desenvolvedora WHERE id = ? AND nome = ? AND local = ?";
                stmt = conexaoBD.prepareStatement(sql);
                stmt.setString(1, dev.getId());
                stmt.setString(2, dev.getNome());
                stmt.setString(3, dev.getLocal());
            }

            
            rs = stmt.executeQuery();

            while (rs.next()) {
                Desenvolvedora temp = new Desenvolvedora();
                temp.setId(rs.getString("id"));
                temp.setNome(rs.getString("nome"));
                temp.setLocal(rs.getString("local"));

                devs.add(temp);
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();

        } catch (SQLException e) {
            e.printStackTrace();

        } finally {
            ConnectionFactory.closeConnection(conexaoBD, stmt);
        }

        return devs;
    }

    public void update (Desenvolvedora dev) {
        Connection conexaoBD = null;
        PreparedStatement stmt = null;
        String sql = "UPDATE desenvolvedora SET nome = ?, local = ? WHERE id = ?";

        try {
            conexaoBD = ConnectionFactory.getConnection();

            stmt = conexaoBD.prepareStatement(sql);
            stmt.setString(1, dev.getNome());
            stmt.setString(2, dev.getLocal());
            stmt.setString(3, dev.getId());

            // Query
            try {
                stmt.executeUpdate();
                System.out.println("[DesenvolvedoraDAO] Desenvolvedora atualizada no banco de dados com sucesso.");
            } catch (SQLException e) {
                System.out.println("[DesenvolvedoraDAO] Erro ao atualizar desenvolvedora. " + e.getMessage());
            }
            

            


        } catch (ClassNotFoundException e) {
            e.printStackTrace();

        } catch (SQLException e) {
            e.printStackTrace();

        } finally {
            ConnectionFactory.closeConnection(conexaoBD, stmt);
        }
    }

    public void delete (Desenvolvedora dev) {
        Connection conexaoBD = null;
        PreparedStatement stmt = null;
        String sql = "DELETE FROM desenvolvedora WHERE nome = ? AND local = ? AND id = ?";

        try {
            conexaoBD = ConnectionFactory.getConnection();

            stmt = conexaoBD.prepareStatement(sql);
            stmt.setString(1, dev.getNome());
            stmt.setString(2, dev.getLocal());
            stmt.setString(3, dev.getId());

            // Query
            try {
                stmt.executeUpdate();
                System.out.println("[DesenvolvedoraDAO] Desenvolvedora excluída do banco de dados com sucesso.");
            } catch (SQLException e) {
                System.out.println("[DesenvolvedoraDAO] Erro ao excluir desenvolvedora. " + e.getMessage());
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();

        } catch (SQLException e) {
            e.printStackTrace();

        } finally {
            ConnectionFactory.closeConnection(conexaoBD, stmt);
        }
    }

    public List<String> readAllNome () {
        Connection conexaoBD = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        String sql = "SELECT nome FROM desenvolvedora";
        List<String> devs = new ArrayList<String>();

        try {
            conexaoBD = ConnectionFactory.getConnection();
            stmt = conexaoBD.prepareStatement(sql);
            
            rs = stmt.executeQuery();

            while (rs.next()) {
                devs.add(rs.getString("nome"));
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();

        } catch (SQLException e) {
            e.printStackTrace();

        } finally {
            ConnectionFactory.closeConnection(conexaoBD, stmt);
        }

        return devs;
    }
}
