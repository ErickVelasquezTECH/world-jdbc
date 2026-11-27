package org.example;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProbandoJDBC {
    private final String bdatos = "jdbc:mysql://localhost:3306/world";
    private final String usuario = "root";
    private final String contrasena = "Sandia4you";

    public List<String> showCountryLimit5() {

        try (Connection conexion = DriverManager.getConnection(bdatos, usuario, contrasena);
             Statement sentencia = conexion.createStatement();
             ResultSet resul = sentencia.executeQuery("SELECT Name, CounTryCode FROM city LIMIT 5");
        ) {
            List<String> resultados = new ArrayList<>();
            Class.forName("com.mysql.cj.jdbc.Driver");


            while (resul.next()) {
                resultados.add(resul.getString(1) + ", " + resul.getString(2));
            }

            return resultados;
        } catch (ClassNotFoundException | SQLException cn) {
            cn.printStackTrace();
        }
        return null;
    }

    public void insertInventadaCity(){
        try (Connection conexion = DriverManager.getConnection(bdatos, usuario, contrasena);
             Statement sentencia = conexion.createStatement();
        ) {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String sql = "INSERT INTO city (Name, CountryCode, District, Population) VALUES ('Inventada2', 'ABW', 'Lum', 5)";
            sentencia.executeUpdate(sql);
        } catch (ClassNotFoundException | SQLException cn) {
            cn.printStackTrace();
        }
    }


    public void updateCityCase1() {
        try (Connection conexion = DriverManager.getConnection(bdatos, usuario, contrasena);
             Statement sentencia = conexion.createStatement();
        ) {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String sql = "UPDATE city SET District ='AAA', Population = 25 WHERE Name='Inventada'";
            sentencia.executeUpdate(sql);
        } catch (ClassNotFoundException | SQLException cn) {
            cn.printStackTrace();
        }
    }

    public void updateCityCase2() {
        try (Connection conexion = DriverManager.getConnection(bdatos, usuario, contrasena);
             PreparedStatement sentencia = conexion.prepareStatement(
                     "UPDATE city SET District =?, Population = ? WHERE Name=? "
             );
        ) {
            Class.forName("com.mysql.cj.jdbc.Driver");
            sentencia.setString(1, "AAA");
            sentencia.setInt(2, 25);
            sentencia.setString(3, "Inventada");
            sentencia.executeUpdate();

        } catch (ClassNotFoundException | SQLException cn) {
            cn.printStackTrace();
        }
    }


    public void deleteCity2Case1() {
        try (Connection conexion = DriverManager.getConnection(bdatos, usuario, contrasena);
             Statement sentencia = conexion.createStatement();
        ) {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String sql = "DELETE FROM city WHERE Name='Inventada2'";
            sentencia.executeUpdate(sql);
        } catch (ClassNotFoundException | SQLException cn) {
            cn.printStackTrace();
        }
    }

    public void deleteCity2Case2() {
        try (Connection conexion = DriverManager.getConnection(bdatos, usuario, contrasena);
             PreparedStatement sentencia = conexion.prepareStatement(
                     "DELETE FROM city WHERE Name = ?"
             );
        ) {
            Class.forName("com.mysql.cj.jdbc.Driver");
            sentencia.setString(1, "Inventada2");
            sentencia.executeUpdate();
        } catch (ClassNotFoundException | SQLException cn) {
            cn.printStackTrace();
        }
    }


}

