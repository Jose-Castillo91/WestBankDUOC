import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static ArrayList<Cliente> clientes = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {


        int opcion = 0;
        do {
            mostrarMenu();
            opcion = scanner.nextInt();
            scanner.nextLine(); // limpia el buffer

            switch (opcion) {
                case 1:
                    registrarCliente();
                    break;
                case 2:
                    verDatosCliente();
                    break;
                case 3:
                    depositar();
                    break;
                case 4:
                    girar();
                    break;
                case 5:
                    consultarSaldo();
                    break;
                case 6:
                    System.out.println("Cerrando sistema, hasta luego");
                    break;
                default:
                    System.out.println("Opción inválida");
            }
        } while (opcion != 6);
    }

    public static void mostrarMenu() {
        System.out.println("\n----- Menú -----");
        System.out.println("1. Registrar cliente");
        System.out.println("2. Ver datos de cliente");
        System.out.println("3. Depositar");
        System.out.println("4. Girar");
        System.out.println("5. Consultar saldo");
        System.out.println("6. Salir");
        System.out.print("Seleccione una opción: ");
    }

    public static void registrarCliente() {
        try {
            System.out.print("Ingrese rut (Con puntos y guión): ");
            String rut = scanner.nextLine();

            System.out.print("Ingrese nombre: ");
            String nombre = scanner.nextLine();

            System.out.print("Ingrese apellido paterno: ");
            String apPaterno = scanner.nextLine();

            System.out.print("Ingrese apellido materno: ");
            String apMaterno = scanner.nextLine();

            System.out.print("Ingrese domicilio: ");
            String domicilio = scanner.nextLine();

            System.out.print("Ingrese comuna: ");
            String comuna = scanner.nextLine();

            System.out.print("Ingrese teléfono: ");
            int telefono = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Ingrese número de cuenta corriente (9 dígitos): ");
            int numeroCuenta = scanner.nextInt();
            scanner.nextLine();

            CuentaCorriente cuenta = new CuentaCorriente(numeroCuenta, 0);
            Cliente nuevoCliente = new Cliente(rut, nombre, apPaterno, apMaterno, domicilio, comuna, telefono, cuenta);
            clientes.add(nuevoCliente);

            System.out.println("Cliente registrado");
        } catch (IllegalArgumentException e) {
            System.out.println("Error al registrar cliente: " + e.getMessage());
        }
    }
    public static void verDatosCliente() {
        System.out.print("Ingrese el RUT del cliente que desea consultar (Con putos y guión): ");
        String rutBuscado = scanner.nextLine();

        boolean encontrado = false;

        for (Cliente cliente : clientes) {
            if (cliente.getRut().equals(rutBuscado)) {
                cliente.verDatos();
                encontrado = true;
                break;
            }
        }

        if (!encontrado) {
            System.out.println("Cliente no encontrado.");
        }
    }

    public static void depositar() {
        System.out.print("Ingrese el RUT del cliente: ");
        String rut = scanner.nextLine();

        for (Cliente cliente : clientes) {
            if (cliente.getRut().equals(rut)) {
                System.out.print("Ingrese monto a depositar: ");
                int monto = scanner.nextInt();
                scanner.nextLine();

                cliente.getCuenta().depositar(monto);
                return;
            }
        }

        System.out.println("Cliente no encontrado.");
    }


    public static void girar() {
        System.out.print("Ingrese el RUT del cliente: ");
        String rut = scanner.nextLine();

        for (Cliente cliente : clientes) {
            if (cliente.getRut().equals(rut)) {
                System.out.print("Ingrese monto a girar: ");
                int monto = scanner.nextInt();
                scanner.nextLine();

                cliente.getCuenta().girar(monto);
                return;
            }
        }

        System.out.println("Cliente no encontrado.");
    }


    public static void consultarSaldo() {
        System.out.print("Ingrese el RUT del cliente: ");
        String rut = scanner.nextLine();

        for (Cliente cliente : clientes) {
            if (cliente.getRut().equals(rut)) {
                cliente.getCuenta().consultarSaldo();
                return;
            }
        }

        System.out.println("Cliente no encontrado.");
    }


}
