package co.unicauca.solid.domain.access;

import co.unicauca.solid.domain.Vehicle;

/**
 * Clase encargada de establecer la logica necesaria para el estacionamiento.
 *
 * @author Juan Lopez y Josman Muñoz
 */
public class Parking {

    /**
     * Funcion encargada de recuperar una instancia de la interfaz ITimeParking
     * y hacer de puente para calcular el costo.
     *
     * @param parVehicle, Variable de tipo Vehicle.
     * @param time, Variable de tipo double que representara el tiempo que el
     * vehiculo estuvo en el estacionamiento.
     * @return Retorna un valor double que representara el costo total a "pagar"
     * por el uso del estacionamiento.
     */
    public double CalculateTimeCost(Vehicle parVehicle, double time) {

        if (parVehicle == null) {
            return -1;
        }
        //El parqueadero devuelve un instancia de la jerarquia 
        ITimeParking timeParking = InstanceVehicle.getInstance().getInstanceVehicle(parVehicle.gettipoVehiculo());
        double varResultado = timeParking.CalculateCost(parVehicle, time);
        return varResultado;
    }
}
