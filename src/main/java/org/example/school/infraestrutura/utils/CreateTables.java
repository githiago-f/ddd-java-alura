package org.example.school.infraestrutura.utils;

import java.sql.Connection;
import java.sql.SQLException;

public class CreateTables {
    private final Connection connection;

    public CreateTables(Connection connection) {
        this.connection = connection;
    }

    public void createStudents() throws SQLException {
        connection.prepareStatement("DROP TABLE IF EXISTS students").execute();
        String sql =
            "CREATE TABLE IF NOT EXISTS students (" +
                "cpf TEXT,"+
                "name TEXT," +
                "email TEXT UNIQUE,"+
                "password TEXT" +
            ");";
        connection.prepareStatement(sql).execute();
    }
}
