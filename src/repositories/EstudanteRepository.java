package repositories;

import model.EstudanteModel;
import database.ConexaoFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EstudanteRepository {

    private final Connection connection;

    public EstudanteRepository() {
        // Estabelece a conexao com o banco de dados
        this.connection = new ConexaoFactory().getConexao();
    }

    // Implementação do CRUD

    // C -> Criar um novo usuário na tabela
    public void insert(EstudanteModel estudante) {
        String sql = "INSERT INTO estudante(nomeCompleto, anoMatricula, email, endereco, CEP, telefone, usuario, senha, curso, observacoes, ativo) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, estudante.getNomeCompleto());
            statement.setString(2, estudante.getAnoMatricula());
            statement.setString(3, estudante.getEmail());
            statement.setString(4, estudante.getEndereco());
            statement.setString(5, estudante.getCEP());
            statement.setString(6, estudante.getTelefone());
            statement.setString(7, estudante.getUsuario());
            statement.setString(8, estudante.getSenha());
            statement.setString(9, estudante.getCurso());
            statement.setString(10, estudante.getObservacoes());
            statement.setBoolean(11, estudante.isAtivo());

            statement.executeUpdate();

            ResultSet resultado = statement.getGeneratedKeys();
            if (resultado.next()) {
                estudante.setId(resultado.getInt(1));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    // R -> Retrieve (puxar os dados dos estudantes do banco de dados para a tabela)
    public List<EstudanteModel> findAll() {
        List<EstudanteModel> estudantes = new ArrayList<>();

        String sql = "SELECT * FROM estudante";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            ResultSet resultado = statement.executeQuery();

            while (resultado.next()) {
                EstudanteModel estudante = new EstudanteModel();
                estudante.setId(resultado.getInt("id"));
                estudante.setNomeCompleto(resultado.getString("nomeCompleto"));
                estudante.setAnoMatricula(resultado.getString("anoMatricula"));
                estudante.setEmail(resultado.getString("email"));
                estudante.setEndereco(resultado.getString("endereco"));
                estudante.setCEP(resultado.getString("CEP"));
                estudante.setTelefone(resultado.getString("telefone"));
                estudante.setUsuario(resultado.getString("usuario"));
                estudante.setSenha(resultado.getString("senha"));
                estudante.setCurso(resultado.getString("curso"));
                estudante.setObservacoes(resultado.getString("observacoes"));
                estudante.setAtivo(resultado.getBoolean("isAtivo"));

                estudantes.add(estudante);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return estudantes;
    }

    // U -> Update (atualizar os dados dos alunos na tabela)
    public void update(EstudanteModel estudante) {
        String sql = "UPDATE estudante SET nomeCompleto = ?, anoMatricula = ?, email = ?, endereco = ?, CEP = ?, telefone = ?, usuario = ?, senha = ?, curso = ?, observacoes = ?, ativo = ? WHERE id = ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, estudante.getNomeCompleto());
            statement.setString(2, estudante.getAnoMatricula());
            statement.setString(3, estudante.getEmail());
            statement.setString(4, estudante.getEndereco());
            statement.setString(5, estudante.getCEP());
            statement.setString(6, estudante.getTelefone());
            statement.setString(7, estudante.getUsuario());
            statement.setString(8, estudante.getSenha());
            statement.setString(9, estudante.getCurso());
            statement.setString(10, estudante.getObservacoes());
            statement.setBoolean(11, estudante.isAtivo());
            statement.setLong(12, estudante.getId());

            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    // D -> Deletar um estudante da tabela
    public void delete(int idEstudante) {
        String sql = "DELETE FROM estudante WHERE id = ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, idEstudante);

            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
