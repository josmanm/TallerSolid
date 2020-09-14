package co.unicauca.solid.domain;

/**
 * Clase encargada de establecer los atributos que tendra el vehiculo.
 *
 * @author Juan Lopez y Josman Muñoz
 */
public class Vehicle {

    //Variables
    private String marca;
    private String placa;
    private String color;
    private VehicleEnum tipoVehiculo;

    /**
     * Constructor por defecto de la clase Vehicle.
     */
    public Vehicle() {
    }

    /**
     * Constructor parametrizado de la clase Vehicle.
     *
     * @param tipoVehiculo, Variable tipo ENUM que define el tipo de vehiculo
     * que se ingresara a la base de datos.
     * @param marca, Variable tipo String que define la Marca del vehiculo...
     * Ej: Ferrari, Lamborghini, entre otros...
     * @param color, Variable tipo String que define el color del vehiculo...
     * Ej: Azul, Rojo, Blanco, entre otros...
     * @param placa , Variable tipo String que define la matricula del vehiculo.
     */
    public Vehicle(VehicleEnum tipoVehiculo, String marca, String color, String placa) {
        this.tipoVehiculo = tipoVehiculo;
        this.marca = marca;
        this.color = color;
        this.placa = placa;
    }

    // Setter and Getters
    public VehicleEnum gettipoVehiculo() {
        return tipoVehiculo;
    }

    public void settipoVehiculo(VehicleEnum tipoVehiculo) {
        this.tipoVehiculo = tipoVehiculo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    /**
     * Funcion encargada de sobre escribir el metodo ToString para la clase en
     * concreto.
     *
     * @return Retorna una cadena string con los atributos de la clase.
     */
    @Override
    public String toString() {
        return "Vehicle{" + "Marca=" + marca + ", name=" + color + ", price=" + placa + '}';
    }
}
