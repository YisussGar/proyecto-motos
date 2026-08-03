public class CambioAceite extends Servicio {

    // Atributos propios
    private String tipoAceite;
    private double costoAceite;

    // Constructor
    public CambioAceite(int idServicio,
                        String nombreServicio,
                        double costoManoObra,
                        String descripcion,
                        String tipoAceite,
                        double costoAceite) {

        super(idServicio, nombreServicio, costoManoObra, descripcion);

        setTipoAceite(tipoAceite);
        setCostoAceite(costoAceite);
    }

    // Getters

    public String getTipoAceite() {
        return tipoAceite;
    }

    public double getCostoAceite() {
        return costoAceite;
    }

    // Setters

    public void setTipoAceite(String tipoAceite) {

        if (tipoAceite == null || tipoAceite.trim().isEmpty()) {
            throw new IllegalArgumentException("El tipo de aceite no puede estar vacío.");
        }

        this.tipoAceite = tipoAceite.trim();
    }

    public void setCostoAceite(double costoAceite) {

        if (costoAceite < 0) {
            throw new IllegalArgumentException("El costo del aceite no puede ser negativo.");
        }

        this.costoAceite = costoAceite;
    }

    // Polimorfismo
    @Override
    public double calcularCosto() {

        return getCostoManoObra() + costoAceite;

    }

    // Sobrescritura
    @Override
    public void mostrarInformacion() {

        super.mostrarInformacion();

        System.out.println("Tipo de aceite: " + tipoAceite);
        System.out.println("Costo del aceite: $" + costoAceite);
        System.out.println("Costo total: $" + calcularCosto());

    }

}