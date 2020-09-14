/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unicauca.solid.main;

import co.unicauca.solid.domain.access.Parking;
import co.unicauca.solid.domain.Vehicle;
import co.unicauca.solid.domain.VehicleEnum;
import java.text.ParseException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author SANTIAGO MUÑOZ
 */
public class ClientMainTest {
    
    public ClientMainTest() {
    }
    /**
     * Test de la clase Vehiculo
     * @throws java.text.ParseException
     */
    @Test
    public void Vehicle()throws ParseException{
        System.out.println("Vehicle Car");
        Vehicle newProduct= new Vehicle(VehicleEnum.CARRO,"Ferrari","Rojo","250.000");
        //falta comparacion para tipo de vehiiculo
        assertEquals("CARRO",newProduct.gettipoVehiculo().toString());
        assertEquals("Ferrari",newProduct.getMarca());
        assertEquals("Rojo",newProduct.getColor());
        assertEquals("250.000", newProduct.getPlaca());
        
        Vehicle newProduct2= new Vehicle(VehicleEnum.MOTOCICLETA, "eco", "rojo", "shs-587");   
        assertEquals("MOTOCICLETA", newProduct2.gettipoVehiculo().toString());
        assertEquals("eco", newProduct2.getMarca());
        assertEquals("rojo", newProduct2.getColor());
        assertEquals("shs-587", newProduct2.getPlaca());
        
        Vehicle newVehicle3=new Vehicle(VehicleEnum.CAMION, "NISSAN", "Azul y blanco", "sqk-817");
        assertEquals("CAMION", newVehicle3.gettipoVehiculo().toString());
        assertEquals("NISSAN", newVehicle3.getMarca());
        assertEquals("Azul y blanco", newVehicle3.getColor());
        assertEquals("sqk-817", newVehicle3.getPlaca());        
    }
    
    @Test
    public void Parking() throws ParseException{
        Parking parking= new Parking();
        
        Vehicle newProduct= new Vehicle(VehicleEnum.CARRO,"Ferrari","Rojo","250.000");
        double costOne= parking.CalculateTimeCost(newProduct,90);
        assertEquals(costOne, 2500.0,00.1);
        
        costOne = parking.CalculateTimeCost(newProduct, 60);
        assertEquals(costOne, 2000.0, 000.1);

        costOne = parking.CalculateTimeCost(newProduct, 105);
        assertEquals(costOne, 2800.0, 000.1);
        
        newProduct = new Vehicle(VehicleEnum.CAMION,"Bughati","Azul","300.000");
        double CostTwo= parking.CalculateTimeCost(newProduct,600);
        assertEquals(CostTwo, 10000.0,00.1);
        
        
        
        newProduct= new Vehicle(VehicleEnum.MOTOCICLETA,"Mazda","Gris","shs-321");
        double Costthree= parking.CalculateTimeCost(newProduct,60);
        assertEquals(Costthree, 1000.0,0.001);
        
        Costthree = parking.CalculateTimeCost(newProduct, 89);
        assertEquals(Costthree, 1200.0, 0.001);
        
    }
    
}
