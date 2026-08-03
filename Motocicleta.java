public class Motocicleta {

    // Atributos
    private String placas;
    private String marca;
    private String modelo;
    private int anio;
    private int kilometraje;
    private Cliente propietario;

    // Constructor
    public Motocicleta(String placas, String marca, String modelo,
                       int anio, int kilometraje, Cliente propietario) {

        setPlacas(placas);
        setMarca(marca);
        setModelo(modelo);
        setAnio(anio);
        setKilometraje(kilometraje);
        setPropietario(propietario);
  // Registrar automáticamente la motocicleta al cliente       
        this.propietario.agregarMotocicleta(this);
    }

    // Getters

    public String getPlacas() {
        return placas;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public int getAnio() {
        return anio;
    }

    public int getKilometraje() {
        return kilometraje;
    }

    public Cliente getPropietario() {
        return propietario;
    }

    // Setters con validaciones

    public void setPlacas(String placas) {
        if (placas == null || placas.trim().isEmpty()) {
            throw new IllegalArgumentException("Las placas no pueden estar vacías.");
        }
        this.placas = placas;
    }

    public void setMarca(String marca) {
        if (marca == null || marca.trim().isEmpty()) {
            throw new IllegalArgumentException("La marca no puede estar vacía.");
        }
        this.marca = marca;
    }

    public void setModelo(String modelo) {
        if (modelo == null || modelo.trim().isEmpty()) {
            throw new IllegalArgumentException("El modelo no puede estar vacío.");
        }
        this.modelo = modelo;
    }

    public void setAnio(int anio) {
        if (anio < 1950 || anio > 2100) {
            throw new IllegalArgumentException("El año de la motocicleta no es válido.");
        }
        this.anio = anio;
    }

    public void setKilometraje(int kilometraje) {
        if (kilometraje < 0) {
            throw new IllegalArgumentException("El kilometraje no puede ser negativo.");
        }
        this.kilometraje = kilometraje;
    }

    public void setPropietario(Cliente propietario) {
        if (propietario == null) {
            throw new IllegalArgumentException("La motocicleta debe tener un propietario.");
        }
        this.propietario = propietario;
    }

    // Método para mostrar información

    public void mostrarInformacion() {

        System.out.println("===== MOTOCICLETA =====");
        System.out.println("Placas: " + placas);
        System.out.println("Marca: " + marca);
        System.out.println("Modelo: " + modelo);
        System.out.println("Año: " + anio);
        System.out.println("Kilometraje: " + kilometraje + " km");
        System.out.println("Propietario: " + propietario.getNombre());

    }

}