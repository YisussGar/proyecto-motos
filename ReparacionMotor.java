public class ReparacionMotor extends Servicio {

    // Atributos propios
    private double costoRefacciones;
    private double costoDiagnostico;

    // Constructor
    public ReparacionMotor(int idServicio,
                           String nombreServicio,
                           double costoManoObra,
                           String descripcion,
                           double costoRefacciones,
                           double costoDiagnostico) {

        super(idServicio, nombreServicio, costoManoObra, descripcion);

        setCostoRefacciones(costoRefacciones);
        setCostoDiagnostico(costoDiagnostico);
    }

    // Getters

    public double getCostoRefacciones() {
        return costoRefacciones;
    }

    public double getCostoDiagnostico() {
        return costoDiagnostico;
    }

    // Setters

    public void setCostoRefacciones(double costoRefacciones) {

        if (costoRefacciones < 0) {
            throw new IllegalArgumentException("El costo de las refacciones no puede ser negativo.");
        }

        this.costoRefacciones = costoRefacciones;
    }

    public void setCostoDiagnostico(double costoDiagnostico) {

        if (costoDiagnostico < 0) {
            throw new IllegalArgumentException("El costo del diagnóstico no puede ser negativo.");
        }

        this.costoDiagnostico = costoDiagnostico;
    }

    // Polimorfismo
    @Override
    public double calcularCosto() {

        return getCostoManoObra() + costoRefacciones + costoDiagnostico;

    }

    // Sobrescritura
    @Override
    public void mostrarInformacion() {

        super.mostrarInformacion();

        System.out.println("Costo de refacciones: $" + costoRefacciones);
        System.out.println("Costo del diagnóstico: $" + costoDiagnostico);
        System.out.println("Costo total: $" + calcularCosto());

    }

}