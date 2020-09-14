/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unicauca.solid.domain.access;

import co.unicauca.solid.domain.Vehicle;
import co.unicauca.solid.domain.service.Service;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Clase encargada de gestionar la conexion a la base de datos
 *
 *
 * @author Juan Lopez y Josman Muñoz
 */
public class VehicleRepository implements IVehicleRepository{

    //Variables
    private Connection conn;

    /**
     * Constructor por defecto de la clase VehicleRepository.
     */
    public VehicleRepository() {
        initDatabase();
    }

    /**
     * Funcion encargada de insertar un vehiculo en la Base de datos.
     *
     * @param par_newVehicle, Vehiculo a ser Insertado en la Base de datos.
     * @return Retorna false si el proceso para insertar el vehiculo en la BD y retorna True si
     * el proceso es exitoso.
     */
    @Override
    public boolean saveVehicle(Vehicle par_newVehicle) {
        try {
            if (par_newVehicle == null || par_newVehicle.getPlaca().isEmpty() || par_newVehicle.getMarca().isEmpty() || par_newVehicle.getColor().isEmpty()) {
                return false;
            }
            String sql = "INSERT INTO Vehicle ( Marca, Color, Placa ) " + "VALUES ( ?, ?, ? )";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, par_newVehicle.getMarca());
            pstmt.setString(2, par_newVehicle.getColor());
            pstmt.setString(3, par_newVehicle.getPlaca());
            pstmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(Service.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    /**
     * Funcion encargada de obtener los vehiculos de la Base de datos.
     *
     * @return Retorna lista de vehiculos para poder ser mostrados al usuario.
     */    
    @Override
    public List<Vehicle> listVehicles() {

        List<Vehicle> lstVehicle = new ArrayList<>();
        try {
            String sql = "SELECT Marca, Color, Placa FROM Vehicle";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Vehicle var_newVehicle = new Vehicle();
                var_newVehicle.setMarca(rs.getString("Marca"));
                var_newVehicle.setColor(rs.getString("Color"));
                var_newVehicle.setPlaca(rs.getString("Placa"));

                lstVehicle.add(var_newVehicle);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Service.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lstVehicle;
    }

    /**
     * Funcion para crear la tabla Vehicle y la base de datos (en memoria).
     */    
    private void initDatabase() {
        String sql = "CREATE TABLE IF NOT EXISTS Vehicle (\n"
                + "	Marca text PRIMARY KEY,\n"
                + "	Color text NOT NULL,\n"
                + "	Placa text NOT NULL\n"
                + ");";
        try {
            this.connect();
            Statement stmt = conn.createStatement();
            stmt.execute(sql);
        } catch (SQLException ex) {
            Logger.getLogger(Service.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Funcion que conecta la aplicacion con la base de datos.
     */
    public void connect() {
        //String url = "jdbc:sqlite:./mydatabase.db";
        String url = "jdbc:sqlite::memory:";

        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException ex) {
            Logger.getLogger(Service.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Funcion que desconecta la aplicacion de la base de datos.
     */
    public void disconnect() {
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

}
