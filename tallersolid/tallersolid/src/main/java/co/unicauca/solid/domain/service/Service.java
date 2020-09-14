/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unicauca.solid.domain.service;

import co.unicauca.solid.domain.access.VehicleRepository;
import co.unicauca.solid.domain.Vehicle;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase encargada de hacer puente para gestionar la conexion con la base de
 * datos.
 *
 *
 * @author Juan Lopez y Josman Muñoz
 */
public class Service {

    //Variables
    private VehicleRepository repository;

    /**
     * Constructor por defecto de la clase Service.
     */
    public Service() {
        repository = new VehicleRepository();
    }

    /**
     * Lógica de acceso a datos
     *
     * @param par_newVehicle , Vehiculo a ser almacenado en la Base de datos.
     * @return true si fue posible guardar el producto, false en caso contrario.
     */
    public boolean saveVehicle(Vehicle par_newVehicle) {

        if (par_newVehicle == null || par_newVehicle.getPlaca().isEmpty() || par_newVehicle.getMarca().isEmpty() || par_newVehicle.getColor().isEmpty()) {
            return false;
        }
        repository.saveVehicle(par_newVehicle);
        return true;
    }

    /**
     * Funcion encargada de recibir lista de los vehiculos almacenados en la
     * base de datos.
     *
     * @return Retorna lista de vehiculos almacenados en la base de datos.
     */
    public List<Vehicle> listVehicles() {
        List<Vehicle> lstVehicle = new ArrayList<>();
        lstVehicle = repository.listVehicles();
        return lstVehicle;
    }
}
