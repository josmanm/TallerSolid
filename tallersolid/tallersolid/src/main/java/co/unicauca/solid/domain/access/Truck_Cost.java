package co.unicauca.solid.domain.access;

import co.unicauca.solid.domain.Vehicle;
import co.unicauca.solid.domain.access.ITimeParking;

/**
 * Clase encargada de otorgar la logica necesaria para el calculo de costos de
 * un camion.
 *
 * @author Juan Lopez y Josman Muñoz
 */
public class Truck_Cost implements ITimeParking {

    /**
     * Funcion encargada de calcular el costo del estacionamiento.
     *
     * @param parVehicle, Vehiculo (Truck) que ingresara a la funcion.
     * @param time, Parametro de tipo double que el vehiculo estuvo ocupando un
     * lugar en el estacionamiento, se usara para calcular el costo al final.
     * @return Retorna costo a pagar dependiendo del tiempo.
     */
    @Override
    public double CalculateCost(Vehicle parVehicle, double time) {
        double valorfijo = 15000;
        double tarifa = 500;

        if (Sorteo((int) (Math.random() * 1000 + 1))) {
            return 0;
        } else {

            time = (time / 60);

            if (time == 24) {
                return valorfijo;
            }
            if (time < 24) {
                return 10000;
            }
            if (time > 24) {
                return valorfijo + CalculateCost(parVehicle, (24 - time) * 60);
            }
        }

        time = time - 1;
        return Math.round((time * tarifa + valorfijo) / 100) * 100;
    }

    private boolean Sorteo(int parNumero) {
        int varNumero = (int) (Math.random() * 1000 + 1);
        if (parNumero == varNumero) {
            return true;
        }
        return false;
    }

}
