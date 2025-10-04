import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Iniciando el sistema de control de procesos...");
        Controlador controlador = new Controlador();
        Scanner teclado = new Scanner(System.in);
        int opcion = 0;

        while (opcion != 5) {
            System.out.println("\n***************************************************************");
            System.out.println("Procesos disponibles:");
            System.out.println("***************************************************************");
            System.out.println("1. Ver y ejecutar ProcesoCPU");
            System.out.println("2. Ver y ejecutar ProcesoIO");
            System.out.println("3. Ver y ejecutar Daemons");
            System.out.println("4. Ejecutar todos los procesos");
            System.out.println("5. Salir");
            System.out.println("***************************************************************");
            System.out.print("Seleccione una opción: ");

            opcion = teclado.nextInt();

            switch (opcion) {
                case 1: {
                    List<Proceso> lista = controlador.getProcesosPorTipo(ProcesoCPU.class);
                    for (Proceso p : lista) {
                        System.out.println(p);
                    }
                    System.out.print("\nIngrese el PID del proceso a ejecutar: ");
                    int pid = teclado.nextInt();
                    System.out.print("Ingrese el nombre del proceso: ");
                    String nombre = teclado.next();
                    Proceso proceso = new ProcesoCPU(nombre, pid);
                    if (!controlador.validarProceso(proceso)) {
                        System.out.println("Proceso inválido. Error al ejecutar...");
                    } else {
                        controlador.ejecutarProceso(proceso);
                    }
                    break;
                }
                case 2: {
                    List<Proceso> lista = controlador.getProcesosPorTipo(ProcesoIO.class);
                    for (Proceso p : lista) {
                        System.out.println(p);
                    }
                    System.out.print("\nIngrese el PID del proceso a ejecutar: ");
                    int pid = teclado.nextInt();
                    System.out.print("Ingrese el nombre del proceso: ");
                    String nombre = teclado.next();
                    Proceso proceso = new ProcesoIO(nombre, pid);
                    if (!controlador.validarProceso(proceso)) {
                        System.out.println("Proceso inválido. Error al ejecutar...");
                    } else {
                        controlador.ejecutarProceso(proceso);
                    }
                    break;
                }
                case 3: {
                    List<Proceso> lista = controlador.getProcesosPorTipo(Daemon.class);
                    for (Proceso p : lista) {
                        System.out.println(p);
                    }
                    System.out.print("\nIngrese el PID del proceso a ejecutar: ");
                    int pid = teclado.nextInt();
                    System.out.print("Ingrese el nombre del proceso: ");
                    String nombre = teclado.next();
                    Proceso proceso = new Daemon(nombre, pid);
                    if (!controlador.validarProceso(proceso)) {
                        System.out.println("Proceso inválido. Error al ejecutar...");
                    } else {
                        controlador.ejecutarProceso(proceso);
                    }
                    break;
                }
                case 4:
                    System.out.println("\nEjecutando todos los procesos:");
                    controlador.ejecutarTodos();
                    break;
                case 5:
                    System.out.println("Saliendo...");
                    System.out.println("El sistema se ha detenido.");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        }
    }
}