public abstract class Persona {

    // Atributos
    private String nombre;
    private String telefono;

    // Constructor
    public Persona(String nombre, String telefono) {
        setNombre(nombre);
        setTelefono(telefono);
    }

    // Getter del nombre
    public String getNombre() {
        return nombre;
    }

    // Getter del teléfono
    public String getTelefono() {
        return telefono;
    }

    // Setter del nombre con validación
    public void setNombre(String nombre) {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede estar vacío.");
        }
        this.nombre = nombre;
    }

    // Setter del teléfono con validación
    public void setTelefono(String telefono) {
        if (telefono == null || telefono.trim().isEmpty()) {
            throw new IllegalArgumentException("El teléfono no puede estar vacío.");
        }
        this.telefono = telefono;
    }

    // Método abstracto que implementarán las clases hijas
    public abstract void mostrarInformacion();
}