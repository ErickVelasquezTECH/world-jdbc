package org.example;

import java.sql.*;

public class Exercise1 {
    private final String bdatos = "jdbc:mysql://localhost:3306/world";
    private final String usuario = "root";
    private final String contrasena = "Sandia4you";


    public void provocandoError() {
        try (Connection connection = DriverManager.getConnection(bdatos, usuario, contrasena);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(
                     "SELECT * FROM tierno LIMIT 5"
             )
        ) {
            Class.forName("com.mysql.cj.jdbc.Driver");

            while (resultSet.next()){
                System.out.printf("%s", resultSet.getString(1));
            }

        } catch (SQLException e) {
            System.out.printf("%s",  e.getErrorCode());
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }


    }
}
