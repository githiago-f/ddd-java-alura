package org.example.school.infraestrutura.DAL.JDBC;

import org.example.school.domain.student.entity.Student;
import org.example.school.domain.student.entity.StudentBuilder;
import org.example.school.domain.student.StudentNotFound;
import org.example.school.domain.student.StudentRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class StudentRepositoryJDBC implements StudentRepository {
    private final Connection connection;

    /**
     * Para que esta implementação não seja responsável por
     * implementar mais que os métodos de acessos aos dados
     * a conecção foi extraida da classe, e agora é recebida
     * via parametros do contrutor.
     * @param connection
     */
    public StudentRepositoryJDBC(Connection connection) {
        this.connection = connection;
    }

    // factory method
    private Student resultSetToAluno(ResultSet resultSet) throws SQLException {
        return new StudentBuilder()
            .withCpf(resultSet.getString("cpf"))
            .withEmail(resultSet.getString("email"))
            .withName(resultSet.getString("name"))
            .build();
    }

    @Override
    public void matricula(Student student) {
        try {
            String sql = "INSERT INTO students (name, cpf, email, password) VALUES(?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, student.getName());
            statement.setString(2, student.getCpf());
            statement.setString(3, student.getEmail());
            statement.setString(4, student.getPassword());
            statement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Student buscaPorCpf(String cpf) {
        String sql = "SELECT * FROM students WHERE cpf = ?";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, cpf);
            ResultSet resultSet = statement.executeQuery();
            return resultSetToAluno(resultSet);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw new StudentNotFound(cpf);
        }
    }

    @Override
    public List<Student> buscaTodos() {
        String sql = "SELECT * FROM students";

        try {
            ResultSet resultSet = connection.prepareStatement(sql)
                    .executeQuery();
        } catch (SQLException e) {
            throw new StudentNotFound();
        }
        return null;
    }
}
