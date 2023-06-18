package repositories;

import model.EstudanteModel;
import database.ConexaoFactory;
import enums.CursosEnum;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EstudanteRepository {

    private Connection connection;

    public EstudanteRepository() {
        this.connection = new ConexaoFactory().getConexaoSingleton();
    }

    public void insert(EstudanteModel estudante) {
        String sql = "INSERT INTO estudante(nomeCompleto, anoMatricula, email, endereco, CEP, telefone, usuario, senha, curso, observacoes, isAtivo) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, estudante.getNomeCompleto());
            stmt.setString(2, estudante.getAnoMatricula());
            stmt.setString(3, estudante.getEmail());
            stmt.setString(4, estudante.getEndereco());
            stmt.setString(5, estudante.getCEP());
            stmt.setInt(6, estudante.getTelefone());
            stmt.setString(7, estudante.getUsuario());
            stmt.setString(8, estudante.getSenha());
            stmt.setString(9, estudante.getCurso().name());
            stmt.setString(10, estudante.getObservacoes());
            stmt.setBoolean(11, estudante.isAtivo());

            stmt.executeUpdate();

            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                estudante.setId(rs.getInt(1));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<EstudanteModel> findAll() {
        List<EstudanteModel> estudantes = new ArrayList<>();

        String sql = "SELECT * FROM estudante";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                EstudanteModel estudante = new EstudanteModel();
                estudante.setId(rs.getInt("id"));
                estudante.setNomeCompleto(rs.getString("nomeCompleto"));
                estudante.setAnoMatricula(rs.getString("anoMatricula"));
                estudante.setEmail(rs.getString("email"));
                estudante.setEndereco(rs.getString("endereco"));
                estudante.setCEP(rs.getString("CEP"));
                estudante.setTelefone(rs.getInt("telefone"));
                estudante.setUsuario(rs.getString("usuario"));
                estudante.setSenha(rs.getString("senha"));
                estudante.setCurso(CursosEnum.valueOf(rs.getString("curso")));
                estudante.setObservacoes(rs.getString("observacoes"));
                estudante.setAtivo(rs.getBoolean("isAtivo"));

                estudantes.add(estudante);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return estudantes;
    }

    public void update(EstudanteModel estudante) {
        String sql = "UPDATE estudante SET nomeCompleto = ?, anoMatricula = ?, email = ?, endereco = ?, CEP = ?, telefone = ?, usuario = ?, senha = ?, curso = ?, observacoes = ?, isAtivo = ? WHERE id = ?";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, estudante.getNomeCompleto());
            stmt.setString(2, estudante.getAnoMatricula());
            stmt.setString(3, estudante.getEmail());
            stmt.setString(4, estudante.getEndereco());
            stmt.setString(5, estudante.getCEP());
            stmt.setInt(6, estudante.getTelefone());
            stmt.setString(7, estudante.getUsuario());
            stmt.setString(8, estudante.getSenha());
            stmt.setString(9, estudante.getCurso().name());
            stmt.setString(10, estudante.getObservacoes());
            stmt.setBoolean(11, estudante.isAtivo());
            stmt.setInt(12, estudante.getId());

            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void delete(int idEstudante) {
        String sql = "DELETE FROM estudante WHERE id = ?";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, idEstudante);

            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
