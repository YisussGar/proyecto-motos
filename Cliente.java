import java.util.ArrayList;

public class Cliente extends Persona {

    // Atributos
    private int idCliente;
    private String direccion;
    private ArrayList<Motocicleta> motocicletas;

    // Constructor
    public Cliente(int idCliente, String nombre, String telefono, String direccion) {
        super(nombre, telefono);
        setIdCliente(idCliente);
        setDireccion(direccion);

        // Inicializar la lista de motocicletas
        motocicletas = new ArrayList<Motocicleta>();
    }

    // Getters
    public int getIdCliente() {
        return idCliente;
    }

    public String getDireccion() {
        return direccion;
    }

    public ArrayList<Motocicleta> getMotocicletas() {
        return motocicletas;
    }

    // Setters
    public void setIdCliente(int idCliente) {
        if (idCliente <= 0) {
            throw new IllegalArgumentException("El ID del cliente debe ser mayor que cero.");
        }
        this.idCliente = idCliente;
    }

    public void setDireccion(String direccion) {
        if (direccion == null || direccion.trim().isEmpty()) {
            throw new IllegalArgumentException("La dirección no puede estar vacía.");
        }
        this.direccion = direccion;
    }

    // Métodos para administrar motocicletas

    public void agregarMotocicleta(Motocicleta motocicleta) {
        if (motocicleta == null) {
            throw new IllegalArgumentException("La motocicleta no puede ser nula.");
        }
        motocicletas.add(motocicleta);
    }

    public void eliminarMotocicleta(Motocicleta motocicleta) {
        motocicletas.remove(motocicleta);
    }

    // Método sobrescrito
    @Override
    public void mostrarInformacion() {
        System.out.println("===== CLIENTE =====");
        System.out.println("ID: " + idCliente);
        System.out.println("Nombre: " + getNombre());
        System.out.println("Teléfono: " + getTelefono());
        System.out.println("Dirección: " + direccion);
        System.out.println("Motocicletas registradas: " + motocicletas.size());
    }
}