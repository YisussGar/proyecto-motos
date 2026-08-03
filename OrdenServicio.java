/**
 * Representa una orden de servicio dentro del taller.
 * Relaciona un cliente, una motocicleta, un mecánico y un servicio.
 *
 * @author Equipo
 */
public class OrdenServicio {

    // Atributos
    private int folio;
    private String fecha;
    private String estado;

    private Cliente cliente;
    private Motocicleta motocicleta;
    private Mecanico mecanico;
    private Servicio servicio;

    // Constructor
    public OrdenServicio(int folio,
                         String fecha,
                         String estado,
                         Cliente cliente,
                         Motocicleta motocicleta,
                         Mecanico mecanico,
                         Servicio servicio) {

        setFolio(folio);
        setFecha(fecha);
        setEstado(estado);
        setCliente(cliente);
        setMotocicleta(motocicleta);
        setMecanico(mecanico);
        setServicio(servicio);
    }

    // Getters

    public int getFolio() {
        return folio;
    }

    public String getFecha() {
        return fecha;
    }

    public String getEstado() {
        return estado;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Motocicleta getMotocicleta() {
        return motocicleta;
    }

    public Mecanico getMecanico() {
        return mecanico;
    }

    public Servicio getServicio() {
        return servicio;
    }

    // Setters con validaciones

    public void setFolio(int folio) {
        if (folio <= 0) {
            throw new IllegalArgumentException("El folio debe ser mayor que cero.");
        }
        this.folio = folio;
    }

    public void setFecha(String fecha) {
        if (fecha == null || fecha.trim().isEmpty()) {
            throw new IllegalArgumentException("La fecha no puede estar vacía.");
        }
        this.fecha = fecha.trim();
    }

    public void setEstado(String estado) {
        if (estado == null || estado.trim().isEmpty()) {
            throw new IllegalArgumentException("El estado no puede estar vacío.");
        }
         this.estado = estado.trim();
    }

    public void setCliente(Cliente cliente) {
        if (cliente == null) {
            throw new IllegalArgumentException("Debe asignarse un cliente.");
        }
        this.cliente = cliente;
    }

    public void setMotocicleta(Motocicleta motocicleta) {
        if (motocicleta == null) {
            throw new IllegalArgumentException("Debe asignarse una motocicleta.");
        }
        this.motocicleta = motocicleta;
    }

    public void setMecanico(Mecanico mecanico) {
        if (mecanico == null) {
            throw new IllegalArgumentException("Debe asignarse un mecánico.");
        }
        this.mecanico = mecanico;
    }

    public void setServicio(Servicio servicio) {
        if (servicio == null) {
            throw new IllegalArgumentException("Debe asignarse un servicio.");
        }
        this.servicio = servicio;
    }

    // Obtiene el costo utilizando polimorfismo
    public double obtenerCostoTotal() {
        return servicio.calcularCosto();
    }

    // Muestra la información de la orden
    public void mostrarInformacion() {

        System.out.println("===== ORDEN DE SERVICIO =====");
        System.out.println("Folio: " + folio);
        System.out.println("Fecha: " + fecha);
        System.out.println("Estado: " + estado);

        System.out.println("\nCliente: " + cliente.getNombre());
        System.out.println("Motocicleta: "
                + motocicleta.getMarca() + " "
                + motocicleta.getModelo());

        System.out.println("Mecánico: " + mecanico.getNombre());

        System.out.println("Servicio: "
                + servicio.getNombreServicio());

        System.out.printf("Costo total: $%.2f%n", obtenerCostoTotal());
    }

}