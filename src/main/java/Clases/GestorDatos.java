package Clases;

import java.util.ArrayList;

public class GestorDatos {
    
    private static ArrayList<Auto> clientesRegistrados = new ArrayList<>();
    private static ArrayList<Orden> ordenesPendientes = new ArrayList<>();
    
    private static int contadorOrdenes = 1;
    private static int contadorClientes = 1; 
    
    public static void registrarAuto(Auto auto) {
        clientesRegistrados.add(auto);
    }

    public static Auto buscarPorTelefono(String telefono) {
        for (Auto a : clientesRegistrados) {
            String telAuto = a.getTelefono().replaceAll("[^\\d]", "");
            String telBuscado = telefono.replaceAll("[^\\d]", "");
            
            if (telAuto.equals(telBuscado)) {
                return a;
            }
        }
        return null; // Si no lo encuentra
    }
    public static ArrayList<Auto> obtenerListaClientes() {
        return clientesRegistrados;
    }

    public static Auto buscarPorIdCliente(int idCliente) {
        for (Auto a : clientesRegistrados) {
            if (a.getId() == idCliente) { 
                return a;
            }
        }
        return null;
    }

    public static void eliminarRegistro(int idCliente) {
        Auto autoAEliminar = buscarPorIdCliente(idCliente);
        if (autoAEliminar != null) {
            clientesRegistrados.remove(autoAEliminar);
        }
    }

    public static int generarSiguienteIdCliente() {
        return contadorClientes;
    }

    public static void agregarCliente(Auto nuevoAuto) {
        clientesRegistrados.add(nuevoAuto);
        contadorClientes++;
    }

    public static void actualizarRegistro(Auto autoModificado) {
        for (int i = 0; i < clientesRegistrados.size(); i++) {
            if (clientesRegistrados.get(i).getId() == autoModificado.getId()) {
                clientesRegistrados.set(i, autoModificado);
                break;
            }
        }
    }
    public static int obtenerSiguienteNumeroOrden() {
        return contadorOrdenes;
    }

    public static void registrarOrden(Orden nuevaOrden) {
        ordenesPendientes.add(nuevaOrden);
        contadorOrdenes++; 
    }

    public static ArrayList<Orden> obtenerOrdenesPendientes() {
        return ordenesPendientes;
    }

    public static void eliminarOrden(Orden orden) {
        ordenesPendientes.remove(orden);
    }
    
    public static class Orden {
        private int numeroOrden;
        private Auto auto;
        private ArrayList<Servicios> servicios;
        private double precioTotal;
        private String fecha;

        // Constructor
        public Orden(int numeroOrden, Auto auto, ArrayList<Servicios> servicios, double precioTotal, String fecha) {
            this.numeroOrden = numeroOrden;
            this.auto = auto;
            this.servicios = servicios;
            this.precioTotal = precioTotal;
            this.fecha = fecha;
        }
        
        public int getNumeroOrden() {
            return numeroOrden;
        }

        public Auto getAuto() {
            return auto;
        }

        public ArrayList<Servicios> getServicios() {
            return servicios;
        }

        public double getPrecioTotal() {
            return precioTotal;
        }
        
        public String getFecha() {
            return fecha;
        }
    }
}