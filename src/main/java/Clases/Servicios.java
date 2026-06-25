package Clases;

public class Servicios {
    private int idServicio;
    private String nombreServicio;
    private double costo;
    private String tipo;

    public Servicios() {}

    public Servicios(int idServicio, String nombreServicio, double costo, String tipo) {
        this.idServicio = idServicio;
        this.nombreServicio = nombreServicio;
        this.costo = costo;
        this.tipo = tipo;
    }

    public int getIdServicio() { return idServicio; }
    public void setIdServicio(int idServicio) { this.idServicio = idServicio; }
    public String getNombreServicio() { return nombreServicio; }
    public void setNombreServicio(String nombreServicio) { this.nombreServicio = nombreServicio; }
    public double getCosto() { return costo; }
    public void setCosto(double costo) { this.costo = costo; }
    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }

    @Override
    public String toString() { return nombreServicio + " ($" + costo + ")"; }
}