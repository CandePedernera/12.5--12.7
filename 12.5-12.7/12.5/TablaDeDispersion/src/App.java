import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        int op;
        Scanner Leer;
        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));

        TablaDispersa tabla;
        tabla = new TablaDispersa();
        Leer = new Scanner(System.in);
        do {
            System.out.println("==============================");
            System.out.println("|            MENÚ            |");
            System.out.println("==============================");
            System.out.println("| 1. Ingresar canción        |");
            System.out.println("| 2. Eliminar canción.       |");
            System.out.println("| 3. Buscar canción.         |");
            System.out.println("| 4. Salir                   |");
            System.out.println("==============================");
            op = Leer.nextInt();
            Leer.nextLine();
            while (op > 4 || op < 1) {
                System.out.println("Ingresa una opción valida: ");
                op = Leer.nextInt();
            }
            switch (op) {
                case 1:
                    Cancion cancio = new Cancion();
                    if (cancio.esAlta) {
                        tabla.insertar(cancio);
                        System.out.println("\nCancion cargada con éxito.");
                    } else {
                        System.out.println("\nNo se pudo cargar la cancion.");
                    }
                    break;
                case 2:
                    System.out.print("\nIntroduce el código de la cancion que desea eliminar: ");
                    try {
                        String codigoEliminar = entrada.readLine();
                        tabla.eliminar(codigoEliminar);
                    } catch (IOException e) {
                        System.out.println("Ingreso un valor incorrecto.");
                    }
                    break;
                case 3:
                    System.out.print("\nIntroduce el código de la cancion que desea buscar: ");
                    try {
                        String codigoBuscar = entrada.readLine();
                        Cancion cancionEncontrada = tabla.buscar(codigoBuscar);
                        if (cancionEncontrada != null) {
                            cancionEncontrada.muestra();
                        } else {
                            System.out.println("\nCancion no encontrada.");
                        }
                    } catch (IOException e) {
                        System.out.println("Ingreso un valor incorrecto.");
                    }
                    break;
                default:
                    break;
            }
            pause();
            limPant();
        } while (op != 4);
    }

    // PROCEDIMIENTOS
    public static void limPant() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void pause() {
        Scanner leer;
        leer = new Scanner(System.in);
        System.out.println("Presione cualquier tecla para continuar...");
        leer.nextLine();
    }
}
