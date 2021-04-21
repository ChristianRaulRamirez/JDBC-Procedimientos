package com.procemientos.almacenados;
import java.sql.*;

public class Conexion {

    private Conexion(){
        
    }

    private static final String URL = "jdbc:mysql://localhost/escuela";
    private static final String USER = "Christian";
    private static final String PASSWORD = "holamundo";
    private static Conexion instancia;
    private static Connection conexion;
    
    public Connection conectar(){
        try{
            conexion = DriverManager.getConnection(URL, USER, PASSWORD);
            return conexion;
        }catch(SQLException error){
            System.out.println(error);
        }
        return conexion;
    }

    public void cerrarResultado(ResultSet resultado) {
        try {
            resultado.close();
        } catch (SQLException error) {
            System.out.println(error);
        }
    }

    public void desconectar(Connection conexion) {
        try {
            conexion.close();
        } catch (SQLException error) {
            System.out.println(error);
        }
    }

    public void cerrarConsultaPreparada(PreparedStatement statement) {
        try {
            statement.close();
        } catch (SQLException error) {
            System.out.println(error);
        }
    }
    
    public static Conexion getInstance(){
        if(instancia == null){
            instancia = new Conexion();
        }
        return instancia;
    }
}