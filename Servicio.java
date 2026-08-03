public abstract class Servicio {

    // Atributos
    private int idServicio;
    private String nombreServicio;
    private double costoManoObra;
    private String descripcion;

    // Constructor
    public Servicio(int idServicio, String nombreServicio,
                    double costoManoObra, String descripcion) {

        setIdServicio(idServicio);
        setNombreServicio(nombreServicio);
        setCostoManoObra(costoManoObra);
        setDescripcion(descripcion);
    }

    // Getters

    public int getIdServicio() {
        return idServicio;
    }

    public String getNombreServicio() {
        return nombreServicio;
    }

    public double getCostoManoObra() {
        return costoManoObra;
    }

    public String getDescripcion() {
        return descripcion;
    }

    // Setters

    public void setIdServicio(int idServicio) {

        if(idServicio <= 0){
            throw new IllegalArgumentException("El ID del servicio debe ser mayor que cero.");
        }

        this.idServicio = idServicio;
    }

    public void setNombreServicio(String nombreServicio) {

        if(nombreServicio == null || nombreServicio.trim().isEmpty()){
            throw new IllegalArgumentException("El nombre del servicio no puede estar vacío.");
        }

        this.nombreServicio = nombreServicio.trim();
    }

    public void setCostoManoObra(double costoManoObra) {

        if(costoManoObra < 0){
            throw new IllegalArgumentException("El costo de mano de obra no puede ser negativo.");
        }

        this.costoManoObra = costoManoObra;
    }

    public void setDescripcion(String descripcion) {

        if(descripcion == null || descripcion.trim().isEmpty()){
            throw new IllegalArgumentException("La descripción no puede estar vacía.");
        }

        this.descripcion = descripcion.trim();
    }

    // Método abstracto que implementarán las clases hijas
    public abstract double calcularCosto();

    // Método que también podrán sobrescribir si es necesario
    public void mostrarInformacion(){

        System.out.println("Servicio: " + nombreServicio);
        System.out.println("Descripción: " + descripcion);
        System.out.println("Costo mano de obra: $" + costoManoObra);

    }

}