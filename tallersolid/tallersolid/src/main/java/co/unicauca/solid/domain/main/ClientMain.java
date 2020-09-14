/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unicauca.solid.domain.main;

import co.unicauca.solid.domain.access.Parking;
import co.unicauca.solid.domain.Vehicle;
import co.unicauca.solid.domain.VehicleEnum;
import co.unicauca.solid.domain.service.Service;

/**
 *
 * @author juang
 */
public class ClientMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //MAIN PARA PRIMER PROTOTIPO
        // TODO code application logic here
        Service service = new Service();
        Parking parking= new Parking();
        
        // Crear dos productos y grabarlos
        Vehicle newProduct = new Vehicle(VehicleEnum.CARRO,"Ferrari","Rojo","250.000");         
        service.saveVehicle(newProduct);
        
        double costOne= parking.CalculateTimeCost(newProduct,90);
        
        newProduct = new Vehicle(VehicleEnum.CAMION,"Bughati","Azul","300.000");
        service.saveVehicle(newProduct);
        
        double CostTwo= parking.CalculateTimeCost(newProduct,50);
        
        newProduct= new Vehicle(VehicleEnum.MOTOCICLETA,"Mazda","Gris","shs-321");
        service.saveVehicle(newProduct);
        
        double Costthree= parking.CalculateTimeCost(newProduct,50);
        
        
        System.out.println("valor :"+costOne);
        
        System.out.println("valor :"+CostTwo);
        
        System.out.println("valor"+Costthree);
        
        // Listar los productos
        for(Vehicle p: service.listVehicles()){
            System.out.println(p);
        }
    }
    
}
