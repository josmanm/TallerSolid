/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unicauca.solid.domain.access;
import co.unicauca.solid.domain.Vehicle;
import java.util.List;
/**
 *Interfaz que se encarga de 
 * @author Juan Lopez y Josman Muñoz
 */
public interface IVehicleRepository {
    /**
     * 
     * @param par_newVehicle
     * @return 
     */
    boolean saveVehicle(Vehicle par_newVehicle);
    /**
     * 
     * @return 
     */
    List <Vehicle> listVehicles();
}
