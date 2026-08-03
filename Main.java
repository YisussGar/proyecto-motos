import java.util.Scanner;

public class Main {

    // Scanner para leer datos
    private static Scanner scanner = new Scanner(System.in);

    // Taller del sistema
    private static Taller taller = new Taller();

    public static void main(String[] args) {

        int opcion;

        do {

            mostrarMenu();

            System.out.print("Seleccione una opción: ");

            while (!scanner.hasNextInt()) {
                System.out.println("Debe ingresar un número.");
                scanner.next();
            }

            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {

                case 1:
                    registrarCliente();
                    break;

                case 2:
                    registrarMecanico();
                    break;

                case 3:
                    registrarMotocicleta();
                    break;

                case 4:
                    registrarOrdenServicio();
                    break;

                case 5:
                    buscarCliente();
                    break;

                case 6:
                    buscarMotocicleta();
                    break;

                case 7:
                    taller.mostrarClientes();
                    break;

                case 8:
                    taller.mostrarMecanicos();
                    break;

                case 9:
                    taller.mostrarMotocicletas();
                    break;

                case 10:
                    taller.mostrarOrdenesServicio();
                    break;

                case 11:
                    mostrarIngresos();
                    break;

                case 0:
                    System.out.println("\nGracias por utilizar el sistema.");
                    break;

                default:
                    System.out.println("\nOpción no válida.");

            }

        } while (opcion != 0);

        scanner.close();
    }

    // ==========================================
    // MENÚ
    // ==========================================

    public static void mostrarMenu() {

        System.out.println("\n======================================");
        System.out.println(" TALLER DE MOTOCICLETAS ");
        System.out.println("======================================");
        System.out.println("1. Registrar cliente");
        System.out.println("2. Registrar mecánico");
        System.out.println("3. Registrar motocicleta");
        System.out.println("4. Registrar orden de servicio");
        System.out.println("5. Buscar cliente");
        System.out.println("6. Buscar motocicleta");
        System.out.println("7. Mostrar clientes");
        System.out.println("8. Mostrar mecánicos");
        System.out.println("9. Mostrar motocicletas");
        System.out.println("10. Mostrar órdenes");
        System.out.println("11. Mostrar ingresos");
        System.out.println("0. Salir");
        System.out.println("======================================");

    }
    
    // ==========================================
    // REGISTRAR CLIENTE
    // ==========================================

    public static void registrarCliente() {

        try {

            System.out.println("\n--- Registrar Cliente ---");

            System.out.print("ID: ");
            int id = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Nombre: ");
            String nombre = scanner.nextLine();

            System.out.print("Teléfono: ");
            String telefono = scanner.nextLine();

            System.out.print("Dirección: ");
            String direccion = scanner.nextLine();

            Cliente cliente = new Cliente(id, nombre, telefono, direccion);

            taller.agregarCliente(cliente);

            System.out.println("\nCliente registrado correctamente.");

        } catch (Exception e) {

            System.out.println("\nError: " + e.getMessage());
            scanner.nextLine();

        }
    
    }
 // ==========================================
    // REGISTRAR MECÁNICO
    // ==========================================

    public static void registrarMecanico() {

        try {

            System.out.println("\n--- Registrar Mecánico ---");

            System.out.print("ID: ");
            int id = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Nombre: ");
            String nombre = scanner.nextLine();

            System.out.print("Teléfono: ");
            String telefono = scanner.nextLine();

            System.out.print("Especialidad: ");
            String especialidad = scanner.nextLine();

            Mecanico mecanico =
                    new Mecanico(id, nombre, telefono, especialidad);

            taller.agregarMecanico(mecanico);

            System.out.println("\nMecánico registrado correctamente.");

        } catch (Exception e) {

            System.out.println("\nError: " + e.getMessage());
            scanner.nextLine();

        }

    }

    // ==========================================
    // REGISTRAR MOTOCICLETA
    // ==========================================

    public static void registrarMotocicleta() {

        try {

            System.out.println("\n--- Registrar Motocicleta ---");

            System.out.print("Placas: ");
            String placas = scanner.nextLine();

            System.out.print("Marca: ");
            String marca = scanner.nextLine();

            System.out.print("Modelo: ");
            String modelo = scanner.nextLine();

            System.out.print("Año: ");
            int anio = scanner.nextInt();

            System.out.print("Kilometraje: ");
            int kilometraje = scanner.nextInt();

            System.out.print("ID del cliente propietario: ");
            int idCliente = scanner.nextInt();
            scanner.nextLine();

            Cliente propietario = taller.buscarCliente(idCliente);

            if (propietario == null) {
                System.out.println("\nNo existe un cliente con ese ID.");
                return;
            }

            Motocicleta motocicleta =
                    new Motocicleta(
                            placas,
                            marca,
                            modelo,
                            anio,
                            kilometraje,
                            propietario
                    );

            taller.agregarMotocicleta(motocicleta);

            System.out.println("\nMotocicleta registrada correctamente.");

        } catch (Exception e) {

            System.out.println("\nError: " + e.getMessage());
            scanner.nextLine();

        }

    }
    
        // ==========================================
    // REGISTRAR ORDEN DE SERVICIO
    // ==========================================

    public static void registrarOrdenServicio() {

        try {

            System.out.println("\n--- Registrar Orden de Servicio ---");

            System.out.print("Folio: ");
            int folio = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Fecha: ");
            String fecha = scanner.nextLine();

            System.out.print("Estado: ");
            String estado = scanner.nextLine();

            System.out.print("ID del cliente: ");
            int idCliente = scanner.nextInt();

            Cliente cliente = taller.buscarCliente(idCliente);

            if (cliente == null) {
                System.out.println("Cliente no encontrado.");
                scanner.nextLine();
                return;
            }

            scanner.nextLine();

            System.out.print("Placas de la motocicleta: ");
            String placas = scanner.nextLine();

            Motocicleta motocicleta = taller.buscarMotocicleta(placas);

            if (motocicleta == null) {
                System.out.println("Motocicleta no encontrada.");
                return;
            }

            System.out.print("ID del mecánico: ");
            int idMecanico = scanner.nextInt();

            Mecanico mecanico = taller.buscarMecanico(idMecanico);

            if (mecanico == null) {
                System.out.println("Mecánico no encontrado.");
                scanner.nextLine();
                return;
            }

            scanner.nextLine();

            System.out.println("\nTipo de servicio");
            System.out.println("1. Cambio de aceite");
            System.out.println("2. Afinación");
            System.out.print("Seleccione una opción: ");

            int opcion = scanner.nextInt();
            scanner.nextLine();

            Servicio servicio;

            if (opcion == 1) {

                System.out.print("ID del servicio: ");
                int idServicio = scanner.nextInt();
                scanner.nextLine();

                System.out.print("Nombre del servicio: ");
                String nombre = scanner.nextLine();

                System.out.print("Costo de mano de obra: ");
                double manoObra = scanner.nextDouble();
                scanner.nextLine();

                System.out.print("Descripción: ");
                String descripcion = scanner.nextLine();

                System.out.print("Tipo de aceite: ");
                String tipoAceite = scanner.nextLine();

                System.out.print("Costo del aceite: ");
                double costoAceite = scanner.nextDouble();
                scanner.nextLine();

                servicio = new CambioAceite(
                        idServicio,
                        nombre,
                        manoObra,
                        descripcion,
                        tipoAceite,
                        costoAceite);

            } else if (opcion == 2) {

                System.out.print("ID del servicio: ");
                int idServicio = scanner.nextInt();
                scanner.nextLine();

                System.out.print("Nombre del servicio: ");
                String nombre = scanner.nextLine();

                System.out.print("Costo de mano de obra: ");
                double manoObra = scanner.nextDouble();

                System.out.print("Costo de refacciones: ");
                double refacciones = scanner.nextDouble();

                System.out.print("¿Incluye diagnóstico? (true/false): ");
                boolean diagnostico = scanner.nextBoolean();
                scanner.nextLine();

                System.out.print("Descripción: ");
                String descripcion = scanner.nextLine();

                servicio = new Afinacion(
                        idServicio,
                        nombre,
                        manoObra,
                        descripcion,
                        refacciones,
                        diagnostico);

            } else {

                System.out.println("Opción inválida.");
                return;

            }

            OrdenServicio orden =
                    new OrdenServicio(
                            folio,
                            fecha,
                            estado,
                            cliente,
                            motocicleta,
                            mecanico,
                            servicio);

            taller.agregarOrdenServicio(orden);

            System.out.println("\nOrden registrada correctamente.");

        } catch (Exception e) {

            System.out.println("\nError: " + e.getMessage());
            scanner.nextLine();

        }

    }
    
        // ==========================================
    // BUSCAR CLIENTE
    // ==========================================

    public static void buscarCliente() {

        try {

            System.out.println("\n--- Buscar Cliente ---");

            System.out.print("Ingrese el ID del cliente: ");
            int id = scanner.nextInt();
            scanner.nextLine();

            Cliente cliente = taller.buscarCliente(id);

            if (cliente == null) {
                System.out.println("Cliente no encontrado.");
            } else {
                cliente.mostrarInformacion();
            }

        } catch (Exception e) {

            System.out.println("\nError: " + e.getMessage());
            scanner.nextLine();

        }

    }

    // ==========================================
    // BUSCAR MOTOCICLETA
    // ==========================================

    public static void buscarMotocicleta() {

        try {

            System.out.println("\n--- Buscar Motocicleta ---");

            System.out.print("Ingrese las placas: ");
            String placas = scanner.nextLine();

            Motocicleta motocicleta = taller.buscarMotocicleta(placas);

            if (motocicleta == null) {
                System.out.println("Motocicleta no encontrada.");
            } else {
                motocicleta.mostrarInformacion();
            }

        } catch (Exception e) {

            System.out.println("\nError: " + e.getMessage());

        }

    }

    // ==========================================
    // MOSTRAR INGRESOS
    // ==========================================

    public static void mostrarIngresos() {

        double total = taller.calcularIngresosTotales();

        System.out.println("\n===== INGRESOS DEL TALLER =====");
        System.out.printf("Total acumulado: $%.2f%n", total);

    }

}