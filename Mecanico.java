public class Mecanico extends Persona {

    // Atributos
    private int idMecanico;
    private String especialidad;

    // Constructor
    public Mecanico(int idMecanico, String nombre, String telefono, String especialidad) {
        super(nombre, telefono);
        setIdMecanico(idMecanico);
        setEspecialidad(especialidad);
    }

    // Getters
    public int getIdMecanico() {
        return idMecanico;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    // Setters con validación
    public void setIdMecanico(int idMecanico) {
        if (idMecanico <= 0) {
            throw new IllegalArgumentException("El ID del mecánico debe ser mayor que cero.");
        }
        this.idMecanico = idMecanico;
    }

    public void setEspecialidad(String especialidad) {
        if (especialidad == null || especialidad.trim().isEmpty()) {
            throw new IllegalArgumentException("La especialidad no puede estar vacía.");
        }
        this.especialidad = especialidad;
    }

    // Método sobrescrito
    @Override
    public void mostrarInformacion() {
        System.out.println("===== MECÁNICO =====");
        System.out.println("ID: " + idMecanico);
        System.out.println("Nombre: " + getNombre());
        System.out.println("Teléfono: " + getTelefono());
        System.out.println("Especialidad: " + especialidad);
    }
}