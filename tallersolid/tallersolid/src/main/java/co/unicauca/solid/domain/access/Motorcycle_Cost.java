package co.unicauca.solid.domain.access;

import co.unicauca.solid.domain.Vehicle;

/**
 * Clase encargada de otorgar la logica necesaria para el calculo de costos de
 * una motocicleta.
 *
 * @author Juan Lopez y Josman Muñoz
 */
public class Motorcycle_Cost implements ITimeParking {

    /**
     *
     * @param parVehicle, Parametro de tipo Vehicle que recibira la funcion.
     * @param time, Parametro de tipo double que representara el tiempo que la
     * motocicleta ocupo el estacionamiento.
     * @return Retorna valor que representara el costo a pagar.
     */
    @Override
    public double CalculateCost(Vehicle parVehicle, double time) {
        double valorfijo = 1000;
        double tarifa = 500;

        time = (time / 60);
        if (time <= 1) {
            return valorfijo;
        }
        time = time - 1;
        return Math.round((time * tarifa + valorfijo) / 100) * 100;

    }

}
