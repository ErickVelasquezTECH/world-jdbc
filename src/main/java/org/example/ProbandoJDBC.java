package org.example;

import java.sql.*;
import java.util.List;

public class ProbandoJDBC {
    private static final String bdatos = "jdbc:mysql://localhost:3306/world";
    private static final String usuario = "root";
    private static final String contrasena = "Sandia4you";

    public static void main(String[] args) {



        try (Connection conexion = DriverManager.getConnection(bdatos, usuario, contrasena);
             Statement sentencia = conexion.createStatement();
             ResultSet resul = sentencia.executeQuery("SELECT Name, CounTryCode FROM city LIMIT 5");
        ) {
            Class.forName("com.mysql.cj.jdbc.Driver");

            while (resul.next()) {
                System.out.printf("%s, %s%n", resul.getString(1), resul.getString(2));
            }


        } catch (ClassNotFoundException cn) {
            cn.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


    public List<String> showDatesLimit5()


}

