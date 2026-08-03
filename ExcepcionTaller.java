/**
 * Excepción personalizada para el sistema del Taller de Motocicletas.
 * Se utiliza para controlar errores específicos del sistema.
 *
 * @author Equipo
 * @version 1.0
 */
public class ExcepcionTaller extends Exception {

    /**
     * Constructor que recibe un mensaje de error.
     *
     * @param mensaje Descripción del error.
     */
    public ExcepcionTaller(String mensaje) {
        super(mensaje);
    }

    /**
     * Constructor que recibe un mensaje y la causa del error.
     *
     * @param mensaje Descripción del error.
     * @param causa Excepción que originó el problema.
     */
    public ExcepcionTaller(String mensaje, Throwable causa) {
        super(mensaje, causa);
    }

}