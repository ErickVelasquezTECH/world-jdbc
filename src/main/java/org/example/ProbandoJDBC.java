package org.example;

import com.google.protobuf.Empty;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProbandoJDBC {
    private static final String bdatos = "jdbc:mysql://localhost:3306/world";
    private static final String usuario = "root";
    private static final String contrasena = "Sandia4you";

    public static void main(String[] args) {




        updateCityCase1();



    }


    public static List<String> showCountryLimit5() {

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
        } catch (ClassNotFoundException cn) {
            cn.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void insertInventadaCity(){
        try (Connection conexion = DriverManager.getConnection(bdatos, usuario, contrasena);
             Statement sentencia = conexion.createStatement();
        ) {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String sql = "INSERT INTO city (Name, CountryCode, District, Population) VALUES ('Inventada', 'ABW', 'Lum', 5)";
            sentencia.executeUpdate(sql);
        } catch (ClassNotFoundException cn) {
            cn.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public static void updateCityCase1() {
        try (Connection conexion = DriverManager.getConnection(bdatos, usuario, contrasena);
             Statement sentencia = conexion.createStatement();
        ) {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String sql = "UPDATE city SET District ='AAA', Population = 25 WHERE Name='Inventada'";
            sentencia.executeUpdate(sql);
        } catch (ClassNotFoundException cn) {
            cn.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void updateCityCase2() {
        try (Connection conexion = DriverManager.getConnection(bdatos, usuario, contrasena);
             PreparedStatement sentencia = conexion.prepareStatement(
                     "UPDATE city SET District ='?', Population = ? WHERE Name='?'"
             );
        ) {
            Class.forName("com.mysql.cj.jdbc.Driver");
            sentencia.setString(1, "AAA");
            sentencia.setInt(2, 25);
            sentencia.setString(3, "Inventada");

        } catch (ClassNotFoundException cn) {
            cn.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public static void updateCity2Case1() {
        try (Connection conexion = DriverManager.getConnection(bdatos, usuario, contrasena);
             Statement sentencia = conexion.createStatement();
        ) {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String sql = "DELETE FROM city WHERE Name='Inventada2'";
            sentencia.executeUpdate(sql);
        } catch (ClassNotFoundException cn) {
            cn.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void updateCity2Case2() {
        try (Connection conexion = DriverManager.getConnection(bdatos, usuario, contrasena);
             PreparedStatement sentencia = conexion.prepareStatement(
                     "DELETE FROM city WHERE Name = ?"
             );
        ) {
            Class.forName("com.mysql.cj.jdbc.Driver");
            sentencia.setString(1, "Inventada2");

        } catch (ClassNotFoundException cn) {
            cn.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}

