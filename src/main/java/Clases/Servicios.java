package Clases;

public class Servicios {
    
    private int id;
    private String nombre;
    private double costo;
    private String tipo;

    // Constructor
    public Servicios(int id, String nombre, double costo, String tipo) {
        this.id = id;
        this.nombre = nombre;
        this.costo = costo;
        this.tipo = tipo;
    }
    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public double getCosto() {
        return costo;
    }

    public String getTipo() {
        return tipo;
    }
    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}