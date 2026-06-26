package Clases;

import java.util.ArrayList;
import java.util.List;

public class GestorDatos {
    private static ArrayList<Auto> listaAutos = new ArrayList<>();
    private static ArrayList<Servicios> catalogoServicios = new ArrayList<>();
    private static ArrayList<Orden> ordenesPendientes = new ArrayList<>();
    
    private static int contadorIdCliente = 1;
    private static int contadorOrdenes = 1;

    static {
        catalogoServicios.add(new Servicios(1, "Express", 90.0, "Servicio"));
        catalogoServicios.add(new Servicios(2, "Básico", 150.0, "Servicio")); 
        catalogoServicios.add(new Servicios(3, "Detallado", 950.0, "Servicio")); 
        catalogoServicios.add(new Servicios(4, "Lavado de motor", 200.0, "Extra"));
        catalogoServicios.add(new Servicios(5, "Aire para llantas", 30.0, "Extra"));
        catalogoServicios.add(new Servicios(6, "Lavado de chasis", 150.0, "Extra"));
        catalogoServicios.add(new Servicios(7, "Verificar niveles", 50.0, "Extra"));
        catalogoServicios.add(new Servicios(8, "Pulido y encerado", 450.0, "Extra"));
        catalogoServicios.add(new Servicios(9, "Paño de microfibra", 60.0, "Adicional"));
        catalogoServicios.add(new Servicios(10, "Aromatizante", 40.0, "Adicional"));
        catalogoServicios.add(new Servicios(11, "Limpia parabrisas", 80.0, "Adicional"));
    }
    public static int generarSiguienteIdCliente() { return contadorIdCliente++; }
    public static int obtenerSiguienteIdCliente() { return contadorIdCliente; }
    public static int obtenerSiguienteNumeroOrden() { return contadorOrdenes++; }
    public static void agregarRegistro(Auto auto) { listaAutos.add(auto); }
    public static void agregarCliente(Auto auto) { listaAutos.add(auto); }
    
    public static ArrayList<Auto> obtenerRegistros() { return listaAutos; }
    public static ArrayList<Auto> obtenerListaClientes() { return listaAutos; }
    
    public static Auto buscarPorTelefono(String telefono) {
        for (Auto auto : listaAutos) {
            if (auto.getCliente().getNumeroTelefono().equals(telefono)) {
                return auto;
            }
        }
        return null;
    }

    public static Auto buscarPorIdCliente(int idCliente) {
        for (Auto auto : listaAutos) {
            if (auto.getIdCliente() == idCliente) {
                return auto;
            }
        }
        return null;
    }

    public static void eliminarRegistro(int idCliente) {
        listaAutos.removeIf(auto -> auto.getIdCliente() == idCliente);
    }

    public static void actualizarRegistro(Auto autoActualizado) {
        for (int i = 0; i < listaAutos.size(); i++) {
            if (listaAutos.get(i).getIdCliente() == autoActualizado.getIdCliente()) {
                listaAutos.set(i, autoActualizado);
                break;
            }
        }
    }

    public static ArrayList<Servicios> getCatalogoServicios() { return catalogoServicios; }
    public static void registrarOrden(Orden orden) { ordenesPendientes.add(orden); }
    public static ArrayList<Orden> obtenerOrdenesPendientes() { return ordenesPendientes; }
    
    public static Orden buscarOrden(int numeroOrden) {
        for (Orden o : ordenesPendientes) {
            if (o.getNumeroOrden() == numeroOrden) return o;
        }
        return null;
    }

    public static void eliminarOrdenPendiente(int numeroOrden) {
        ordenesPendientes.removeIf(o -> o.getNumeroOrden() == numeroOrden);
    }
    public static class Orden {
        private int numeroOrden;
        private Auto auto;
        private List<Servicios> serviciosAplicados;
        private double totalCosto;
        private String fechaHora;

        public Orden(int numeroOrden, Auto auto, List<Servicios> serviciosAplicados, double totalCosto, String fechaHora) {
            this.numeroOrden = numeroOrden;
            this.auto = auto;
            this.serviciosAplicados = serviciosAplicados;
            this.totalCosto = totalCosto;
            this.fechaHora = fechaHora;
        }
        public int getNumeroOrden() { return numeroOrden; }
        public Auto getAuto() { return auto; }
        public List<Servicios> getServiciosAplicados() { return serviciosAplicados; }
        public double getTotalCosto() { return totalCosto; }
        public String getFechaHora() { return fechaHora; }
    }
}