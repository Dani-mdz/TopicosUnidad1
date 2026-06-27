package Clases;

public class Auto {
    private int idAuto;
    private Cliente cliente;
    private String marca;
    private String modelo;
    private String color;
    private String observaciones;
    private String tipoVehiculo;

    public Auto() {}

    public Auto(int idAuto, Cliente cliente, String marca, String modelo, String color, String observaciones) {
        this.idAuto = idAuto;
        this.cliente = cliente;
        this.marca = marca;
        this.modelo = modelo;
        this.color = color;
        this.observaciones = observaciones;
    }

    public Auto(int idAuto, String marca, String modelo, String color, String observaciones, String telefono) {
        this.idAuto = idAuto;
        this.marca = marca;
        this.modelo = modelo;
        this.color = color;
        this.observaciones = observaciones;
        this.cliente = new Cliente(idAuto, "", "", telefono);
    }

    public int getId() {
        return idAuto;
    }

    public void setId(int id) {
        this.idAuto = id;
    }

    public int getIdCliente() {
        return (cliente != null) ? cliente.getIdCliente() : 0;
    }

    public String getTelefono() {
        return (cliente != null) ? cliente.getNumeroTelefono() : "";
    }

    public void setTelefono(String telefono) {
        if (this.cliente == null) {
            this.cliente = new Cliente(this.idAuto, "", "", telefono);
        } else {
            this.cliente.setNumeroTelefono(telefono);
        }
    }

    public String getTipoVehiculo() { return tipoVehiculo; }
    public void setTipoVehiculo(String tipoVehiculo) { this.tipoVehiculo = tipoVehiculo; }
    
    public int getIdAuto() { return idAuto; }
    public void setIdAuto(int idAuto) { this.idAuto = idAuto; }
    
    public Cliente getCliente() { return cliente; }
    public void setCliente(Cliente cliente) { this.cliente = cliente; }
    
    public String getMarca() { return marca; }
    public void setMarca(String marca) { this.marca = marca; }
    
    public String getModelo() { return modelo; }
    public void setModelo(String modelo) { this.modelo = modelo; }
    
    public String getColor() { return color; }
    public void setColor(String color) { this.color = color; }
    
    public String getObservaciones() { return observaciones; }
    public void setObservaciones(String observaciones) { this.observaciones = observaciones; }

    @Override
    public String toString() { 
        return marca + " " + modelo + " (" + color + ")"; 
    }
}