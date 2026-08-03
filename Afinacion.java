public class Afinacion extends Servicio {

    // Atributos propios
    private double costoRefacciones;
    private boolean incluyeDiagnostico;

    // Constructor
    public Afinacion(int idServicio,
                     String nombreServicio,
                     double costoManoObra,
                     String descripcion,
                     double costoRefacciones,
                     boolean incluyeDiagnostico) {

        super(idServicio, nombreServicio, costoManoObra, descripcion);

        setCostoRefacciones(costoRefacciones);
        this.incluyeDiagnostico = incluyeDiagnostico;
    }

    // Getters

    public double getCostoRefacciones() {
        return costoRefacciones;
    }

    public boolean isIncluyeDiagnostico() {
        return incluyeDiagnostico;
    }

    // Setters

    public void setCostoRefacciones(double costoRefacciones) {

        if (costoRefacciones < 0) {
            throw new IllegalArgumentException("El costo de las refacciones no puede ser negativo.");
        }

        this.costoRefacciones = costoRefacciones;
    }

    public void setIncluyeDiagnostico(boolean incluyeDiagnostico) {
        setIncluyeDiagnostico(incluyeDiagnostico);
    }

    // Polimorfismo
    @Override
    public double calcularCosto() {

        double costoTotal = getCostoManoObra() + costoRefacciones;

        if (incluyeDiagnostico) {
            costoTotal += 250;
        }

        return costoTotal;
    }

    // Sobrescritura
    @Override
    public void mostrarInformacion() {

        super.mostrarInformacion();

        System.out.println("Costo de refacciones: $" + costoRefacciones);

        if (incluyeDiagnostico) {
            System.out.println("Incluye diagnóstico electrónico: Sí");
        } else {
            System.out.println("Incluye diagnóstico electrónico: No");
        }

        System.out.printf("Costo total: $%.2f%n", calcularCosto());

    }

}