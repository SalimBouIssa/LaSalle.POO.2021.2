package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;

import model.Aluno;
import jdbc.ConnectionFactory;

public class AlunoDAO {
    
    public void create(Aluno aluno) {
        Connection conexaoBD = null;
        PreparedStatement stmt = null;
        String sql = "insert into aluno(matricula, nome, telefone) values (?, ?, ?)";

        try {
            conexaoBD = ConnectionFactory.getConnection();

            stmt = conexaoBD.prepareStatement(sql);
            stmt.setString(1, aluno.getMatricula());
            stmt.setString(2, aluno.getNome());
            stmt.setString(3, aluno.getTelefone());

            // Query
            try {
                stmt.executeUpdate();
                System.out.println("[AlunoDAO] Aluno inserido no banco de dados com sucesso.");
            } catch (SQLException e) {
                System.out.println("[AlunoDAO] Erro ao inserir aluno. " + e.getMessage());
            }        


        } catch (ClassNotFoundException e) {
            e.printStackTrace();

        } catch (SQLException e) {
            e.printStackTrace();

        } finally {
            ConnectionFactory.closeConnection(conexaoBD, stmt);
        }
    }

    public List<Aluno> readAll() {
        Connection conexaoBD = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        String sql = "select matricula, nome, telefone from aluno";
        List<Aluno> alunos = new ArrayList<Aluno>();

        try {
            conexaoBD = ConnectionFactory.getConnection();
            stmt = conexaoBD.prepareStatement(sql);
            
            rs = stmt.executeQuery();

            while (rs.next()) {
                Aluno aluno = new Aluno();
                aluno.setMatricula(rs.getString("matricula"));
                aluno.setNome(rs.getString("nome"));
                aluno.setTelefone(rs.getString("telefone"));

                alunos.add(aluno);
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();

        } catch (SQLException e) {
            e.printStackTrace();

        } finally {
            ConnectionFactory.closeConnection(conexaoBD, stmt);
        }
        return alunos;
    }

    public List<Aluno> select(Aluno aluno) {
        Connection conexaoBD = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        // Apenas a matrícula foi imformada
        
        List<Aluno> alunos = new ArrayList<Aluno>();

        try {
            conexaoBD = ConnectionFactory.getConnection();
            // Nenhum foi informado
            if (aluno.getMatricula() == "" && aluno.getNome() == "" && aluno.getTelefone() == ""){
                String sql = "select matricula, nome, telefone from aluno";
                stmt = conexaoBD.prepareStatement(sql);
                // Apenas a matrícula foi informada
            } else if (aluno.getNome() == "" && aluno.getTelefone() == "") {
                String sql = "SELECT matricula, nome, telefone FROM aluno WHERE matricula = ?";
                stmt = conexaoBD.prepareStatement(sql);
                stmt.setString(1, aluno.getMatricula());
            // Apenas o telefone foi informado
            } else if (aluno.getNome() == "" && aluno.getMatricula() == "") {
                String sql = "SELECT matricula, nome, telefone FROM aluno WHERE telefone = ?";
                stmt = conexaoBD.prepareStatement(sql);
                stmt.setString(1, aluno.getTelefone());
            // Apenas o nome foi informado
            } else if (aluno.getMatricula() == "" && aluno.getTelefone() == "") {
                String sql = "SELECT matricula, nome, telefone FROM aluno WHERE nome = ?";
                stmt = conexaoBD.prepareStatement(sql);
                stmt.setString(1, aluno.getNome());
            // Matrícula e nome foi informado
            } else if (aluno.getTelefone() == "") {
                String sql = "SELECT matricula, nome, telefone FROM aluno WHERE matricula = ? AND nome = ?";
                stmt = conexaoBD.prepareStatement(sql);
                stmt.setString(1, aluno.getMatricula());
                stmt.setString(2, aluno.getNome());
            // Matrícula e telefone foi informado
            } else if (aluno.getNome() == "") {
                String sql = "SELECT matricula, nome, telefone FROM aluno WHERE matricula = ? AND telefone = ?";
                stmt = conexaoBD.prepareStatement(sql);
                stmt.setString(1, aluno.getMatricula());
                stmt.setString(2, aluno.getTelefone());
            // Nome e telefone foi informado
            } else if (aluno.getMatricula() == "") {
                String sql = "SELECT matricula, nome, telefone FROM aluno WHERE nome = ? AND telefone = ?";
                stmt = conexaoBD.prepareStatement(sql);
                stmt.setString(1, aluno.getNome());
                stmt.setString(2, aluno.getTelefone());
            // Todos foram informados
            } else {
                String sql = "SELECT matricula, nome, telefone FROM aluno WHERE matricula = ? AND nome = ? AND telefone = ?";
                stmt = conexaoBD.prepareStatement(sql);
                stmt.setString(1, aluno.getMatricula());
                stmt.setString(2, aluno.getNome());
                stmt.setString(3, aluno.getTelefone());
            }

            
            rs = stmt.executeQuery();

            while (rs.next()) {
                Aluno temp = new Aluno();
                temp.setMatricula(rs.getString("matricula"));
                temp.setNome(rs.getString("nome"));
                temp.setTelefone(rs.getString("telefone"));

                alunos.add(temp);
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();

        } catch (SQLException e) {
            e.printStackTrace();

        } finally {
            ConnectionFactory.closeConnection(conexaoBD, stmt);
        }
        return alunos;
    }

    public void update(Aluno aluno) {
        Connection conexaoBD = null;
        PreparedStatement stmt = null;
        String sql = "update aluno set nome = ?, telefone = ? where matricula = ?";

        try {
            conexaoBD = ConnectionFactory.getConnection();

            stmt = conexaoBD.prepareStatement(sql);
            stmt.setString(1, aluno.getNome());
            stmt.setString(2, aluno.getTelefone());
            stmt.setString(3, aluno.getMatricula());

            // Query
            try {
                stmt.executeUpdate();
                System.out.println("[AlunoDAO] Aluno atualizado no banco de dados com sucesso.");
            } catch (SQLException e) {
                System.out.println("[AlunoDAO] Erro ao atualizar aluno. " + e.getMessage());
            }
            

            


        } catch (ClassNotFoundException e) {
            e.printStackTrace();

        } catch (SQLException e) {
            e.printStackTrace();

        } finally {
            ConnectionFactory.closeConnection(conexaoBD, stmt);
        }
    }

    public void delete(Aluno aluno) {
        Connection conexaoBD = null;
        PreparedStatement stmt = null;
        String sql = "delete from aluno where nome = ? and telefone = ? and matricula = ?";

        try {
            conexaoBD = ConnectionFactory.getConnection();

            stmt = conexaoBD.prepareStatement(sql);
            stmt.setString(1, aluno.getNome());
            stmt.setString(2, aluno.getTelefone());
            stmt.setString(3, aluno.getMatricula());

            // Query
            try {
                stmt.executeUpdate();
                System.out.println("[AlunoDAO] Aluno excluído do banco de dados com sucesso.");
            } catch (SQLException e) {
                System.out.println("[AlunoDAO] Erro ao excluir aluno. " + e.getMessage());
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();

        } catch (SQLException e) {
            e.printStackTrace();

        } finally {
            ConnectionFactory.closeConnection(conexaoBD, stmt);
        }
    }

    
}
