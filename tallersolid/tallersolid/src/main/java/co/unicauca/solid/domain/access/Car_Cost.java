/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unicauca.solid.domain.access;

import co.unicauca.solid.domain.Vehicle;

/**
 * Clase encargada de otorgar la logica necesaria para el calculo de costos de
 * un carro.
 *
 * @author Juan Lopez y Josman Muñoz
 */
public class Car_Cost implements ITimeParking {

    /**
     ** Funcion encargada de calcular el costo del estacionamiento.
     *
     * @param parVehicle, Vehiculo (Carro) que ingresara a la funcion.
     * @param time, Parametro de tipo double que el vehiculo estuvo ocupando un
     * lugar en el estacionamiento, se usara para calcular el costo al final.
     * @return Retorna costo a pagar dependiendo del tiempo y otros parametros
     * definidos por el problema a resolver.
     */
    @Override
    public double CalculateCost(Vehicle parVehicle, double time) {
        double valorfijo = 2000;
        double tarifa = 1000;
        time = time / 60;

        if (time <= 1.0) {
            return valorfijo;
        } else {
            time = time - 1;
            return Math.round((time * tarifa + valorfijo) / 100) * 100;
        }
    }
}
