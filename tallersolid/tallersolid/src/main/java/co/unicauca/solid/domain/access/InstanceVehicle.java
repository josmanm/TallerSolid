/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unicauca.solid.domain.access;

import co.unicauca.solid.domain.VehicleEnum;
import co.unicauca.solid.domain.access.Truck_Cost;
import co.unicauca.solid.domain.access.ITimeParking;
import co.unicauca.solid.domain.access.Car_Cost;
import co.unicauca.solid.domain.access.Motorcycle_Cost;
import java.util.EnumMap;
import java.util.Map;

/**
 *
 * @author juang
 */
public class InstanceVehicle {
    
    private static InstanceVehicle var_Instance;
    private Map<VehicleEnum,ITimeParking> TimeCostDictionary;
    
    private InstanceVehicle (){
        //si se requiere otro tipo de vehiculo , se abre un registro en entre diccionario
        //par ano violar el principio 
        TimeCostDictionary = new EnumMap<>(VehicleEnum.class);
        TimeCostDictionary.put(VehicleEnum.CARRO, new Car_Cost());    
        TimeCostDictionary.put(VehicleEnum.CAMION,new Truck_Cost());
        TimeCostDictionary.put(VehicleEnum.MOTOCICLETA, new Motorcycle_Cost());
        
    }
    
    /**
     * Funcion que se encarga de retornar  la instancia de la clase 
     * @return Retorna una instancia unica del vehiculo.
     */    
    public static InstanceVehicle getInstance(){
        
        if (var_Instance == null) {
            var_Instance = new InstanceVehicle();                    
        }
        return var_Instance;
    }
    
    /**
     * 
     * Funcion que se encarga de determinar para un vehiculo la clase que se encargara de calcular 
     * el costo del parqueadero
     * @param varTipoVeh parametro de tipo Vehiculo 
     * @return Retorna una instancia con algun tipo de vehiculo.
     */
    
    public ITimeParking getInstanceVehicle(VehicleEnum varTipoVeh){
        ITimeParking varResultado = null;
    
        if (TimeCostDictionary.containsKey(varTipoVeh)) {
            varResultado = TimeCostDictionary.get(varTipoVeh);
        }
        return varResultado;
    }
    
    
}
