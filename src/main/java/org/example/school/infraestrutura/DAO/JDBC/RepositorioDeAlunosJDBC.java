package org.example.school.infraestrutura.DAO.JDBC;

import org.example.school.domain.student.entity.Student;
import org.example.school.domain.student.entity.StudentBuilder;
import org.example.school.domain.student.StudentNotFound;
import org.example.school.domain.student.StudentRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class RepositorioDeAlunosJDBC implements StudentRepository {
    private final Connection connection;

    /**
     * Para que esta implementação não seja responsável por
     * implementar mais que os métodos de acessos aos dados
     * a conecção foi extraida da classe, e agora é recebida
     * via parametros do contrutor.
     * @param connection
     */
    public RepositorioDeAlunosJDBC(Connection connection) {
        this.connection = connection;
    }

    // factory method
    private Student resultSetToAluno(ResultSet resultSet) throws SQLException {
        return new StudentBuilder()
            .withCpf(resultSet.getString("Cpf"))
            .withEmail(resultSet.getString("Email"))
            .withName(resultSet.getString("Nome"))
            .build();
    }

    @Override
    public void matricula(Student aluno) {
        try {
            String sql = "INSERT INTO alunos (Nome, Cpf, Email) VALUES(?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, aluno.getNome());
            statement.setString(2, aluno.getCpf());
            statement.setString(3, aluno.getEmail());
            statement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Student buscaPorCpf(String cpf) {
        String sql = "SELECT * FROM alunos WHERE Cpf = ?";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, cpf);
            ResultSet resultSet = statement.executeQuery();
            return resultSetToAluno(resultSet);
        } catch (SQLException e) {
            throw new StudentNotFound(cpf);
        }
    }

    @Override
    public List<Student> buscaTodos() {
        String sql = "SELECT * FROM alunos";

        try {
            ResultSet resultSet = connection.prepareStatement(sql)
                    .executeQuery();
        } catch (SQLException e) {
            throw new StudentNotFound();
        }

        return null;
    }
}
