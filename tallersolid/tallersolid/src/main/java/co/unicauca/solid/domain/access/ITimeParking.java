package co.unicauca.solid.domain.access;

import co.unicauca.solid.domain.Vehicle;

/**
 * Interfaz de tiempo en el parking Utiliza el patrón de diseño Strategy
 * @author Juan Lopez y Josman Muñoz
 */
public interface ITimeParking {

    double CalculateCost(Vehicle parVehicle, double time);
}
