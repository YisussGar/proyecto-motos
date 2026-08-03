import java.util.ArrayList;

/**
 * Clase que administra la información del taller.
 * Almacena clientes, mecánicos, motocicletas y órdenes de servicio.
 *
 * @author Equipo
 * @version 1.0
 */
public class Taller {

    // Colecciones
    private ArrayList<Cliente> clientes;
    private ArrayList<Mecanico> mecanicos;
    private ArrayList<Motocicleta> motocicletas;
    private ArrayList<OrdenServicio> ordenesServicio;

    /**
     * Constructor.
     */
    public Taller() {
        clientes = new ArrayList<>();
        mecanicos = new ArrayList<>();
        motocicletas = new ArrayList<>();
        ordenesServicio = new ArrayList<>();
    }

    // ==================================================
    // CLIENTES
    // ==================================================

    public void agregarCliente(Cliente cliente) throws ExcepcionTaller {

        if (cliente == null) {
            throw new ExcepcionTaller("El cliente no puede ser nulo.");
        }

        if (buscarCliente(cliente.getIdCliente()) != null) {
            throw new ExcepcionTaller("Ya existe un cliente con ese ID.");
        }

        clientes.add(cliente);
    }

    public Cliente buscarCliente(int idCliente) {

        for (Cliente cliente : clientes) {

            if (cliente.getIdCliente() == idCliente) {
                return cliente;
            }

        }

        return null;
    }

    public void eliminarCliente(int idCliente) throws ExcepcionTaller {

        Cliente cliente = buscarCliente(idCliente);

        if (cliente == null) {
            throw new ExcepcionTaller("No existe un cliente con ese ID.");
        }

        clientes.remove(cliente);
    }

    public void mostrarClientes() {

        if (clientes.isEmpty()) {
            System.out.println("No hay clientes registrados.");
            return;
        }

        for (Cliente cliente : clientes) {
            cliente.mostrarInformacion();
            System.out.println();
        }

    }

    // ==================================================
    // MECÁNICOS
    // ==================================================

    public void agregarMecanico(Mecanico mecanico) throws ExcepcionTaller {

        if (mecanico == null) {
            throw new ExcepcionTaller("El mecánico no puede ser nulo.");
        }

        if (buscarMecanico(mecanico.getIdMecanico()) != null) {
            throw new ExcepcionTaller("Ya existe un mecánico con ese ID.");
        }

        mecanicos.add(mecanico);
    }

    public Mecanico buscarMecanico(int idMecanico) {

        for (Mecanico mecanico : mecanicos) {

            if (mecanico.getIdMecanico() == idMecanico) {
                return mecanico;
            }

        }

        return null;
    }

    public void mostrarMecanicos() {

        if (mecanicos.isEmpty()) {
            System.out.println("No hay mecánicos registrados.");
            return;
        }

        for (Mecanico mecanico : mecanicos) {
            mecanico.mostrarInformacion();
            System.out.println();
        }

    }

    // ==================================================
    // MOTOCICLETAS
    // ==================================================

    public void agregarMotocicleta(Motocicleta motocicleta)
            throws ExcepcionTaller {

        if (motocicleta == null) {
            throw new ExcepcionTaller("La motocicleta no puede ser nula.");
        }

        if (buscarMotocicleta(motocicleta.getPlacas()) != null) {
            throw new ExcepcionTaller("Ya existe una motocicleta con esas placas.");
        }

        motocicletas.add(motocicleta);
    }

    public Motocicleta buscarMotocicleta(String placas) {

        for (Motocicleta motocicleta : motocicletas) {

            if (motocicleta.getPlacas().equals(placas)) {
                return motocicleta;
            }

        }

        return null;
    }

    public void eliminarMotocicleta(String placas)
            throws ExcepcionTaller {

        Motocicleta motocicleta = buscarMotocicleta(placas);

        if (motocicleta == null) {
            throw new ExcepcionTaller("No existe una motocicleta con esas placas.");
        }

        motocicletas.remove(motocicleta);
    }

    public void mostrarMotocicletas() {

        if (motocicletas.isEmpty()) {
            System.out.println("No hay motocicletas registradas.");
            return;
        }

        for (Motocicleta motocicleta : motocicletas) {
            motocicleta.mostrarInformacion();
            System.out.println();
        }

    }

    // ==================================================
    // ÓRDENES DE SERVICIO
    // ==================================================

    public void agregarOrdenServicio(OrdenServicio orden)
            throws ExcepcionTaller {

        if (orden == null) {
            throw new ExcepcionTaller("La orden de servicio no puede ser nula.");
        }

        if (buscarOrden(orden.getFolio()) != null) {
            throw new ExcepcionTaller("Ya existe una orden con ese folio.");
        }

        ordenesServicio.add(orden);
    }

    public OrdenServicio buscarOrden(int folio) {

        for (OrdenServicio orden : ordenesServicio) {

            if (orden.getFolio() == folio) {
                return orden;
            }

        }

        return null;
    }

    public void eliminarOrdenServicio(int folio)
            throws ExcepcionTaller {

        OrdenServicio orden = buscarOrden(folio);

        if (orden == null) {
            throw new ExcepcionTaller("No existe una orden con ese folio.");
        }

        ordenesServicio.remove(orden);
    }

    public void modificarEstadoOrden(int folio, String nuevoEstado)
            throws ExcepcionTaller {

        OrdenServicio orden = buscarOrden(folio);

        if (orden == null) {
            throw new ExcepcionTaller("No existe una orden con ese folio.");
        }

        orden.setEstado(nuevoEstado);
    }

    public void mostrarOrdenesServicio() {

        if (ordenesServicio.isEmpty()) {
            System.out.println("No hay órdenes de servicio registradas.");
            return;
        }

        for (OrdenServicio orden : ordenesServicio) {
            orden.mostrarInformacion();
            System.out.println();
        }

    }

    // ==================================================
    // CÁLCULOS
    // ==================================================

    public double calcularIngresosTotales() {

        double total = 0;

        for (OrdenServicio orden : ordenesServicio) {
            total += orden.obtenerCostoTotal();
        }

        return total;
    }

    // ==================================================
    // GETTERS
    // ==================================================

    public ArrayList<Cliente> getClientes() {
        return clientes;
    }

    public ArrayList<Mecanico> getMecanicos() {
        return mecanicos;
    }

    public ArrayList<Motocicleta> getMotocicletas() {
        return motocicletas;
    }

    public ArrayList<OrdenServicio> getOrdenesServicio() {
        return ordenesServicio;
    }

}