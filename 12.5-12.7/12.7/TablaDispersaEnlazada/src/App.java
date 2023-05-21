
import java.util.Scanner;
public class App {
  public static void main(String[] args) throws Exception {

    Scanner leer;
    leer = new Scanner(System.in);
    int op, codBusca, cod, dia, mes, anio, edad;
    String name;
    borrarPantalla();
    TablaDispersaEnlazada TD = new TablaDispersaEnlazada();
    do {
      menu();
      op = controlOpcion();
      switch (op) {
        case 1:
        borrarPantalla();
        System.out.println("INGRESAR DATOS DE LOS SOCIOS");
          System.out.print("Ingresa el nombre: "); name= leer.nextLine();
          System.out.print("Ingresa la edad: ");edad= leer.nextInt(); 
          leer.nextLine();
          System.out.println("Ahora se ingresara la fecha de alta del socio");
          System.out.print("ingresa el dia:  "); dia=leer.nextInt();
          leer.nextLine(); 
          System.out.print("ingresa el mes:  "); mes=leer.nextInt();
          leer.nextLine(); 
          System.out.print("ingresa el año:  "); anio=leer.nextInt();
          leer.nextLine(); 
          System.out.print("Ingresa el codigo del socio: "); cod=leer.nextInt(); 
          leer.nextLine(); 
          TipoSocio socioNew = new TipoSocio(name, cod, edad, dia, mes, anio);
          TD.insertar(socioNew);
          borrarPantalla();
          System.out.println("   EL SOCIO FUE INGRESADO   ");
          
          break;
        case 2:
          borrarPantalla();
          System.out.println(" Ingrese el codigo de socio a buscar");
          codBusca = leer.nextInt();
          leer.nextLine(); 
          Elemento sociobusca = TD.buscar(codBusca);
          while(sociobusca != null){
            if (sociobusca != null) {
              System.out.println("DATOS DEL SOCIO");
      
              System.out.println("   Codigo: " + sociobusca.getSocio().getCodigo());
              System.out.println("   Nombre: " + sociobusca.getSocio().getNombre());
              System.out.println("   Edad: " + sociobusca.getSocio().getEdad());
              System.out.println("   Fecha de alta: " + sociobusca.getSocio().getF());
  
            } else {
              System.out.println("NO SE ENCUENTRA SOCIO");
            }
            sociobusca= sociobusca.sgte; 
          }

          break;
        case 3:
          borrarPantalla();
          System.out.println(" Ingrese el codigo del socio a eliminar");
          codBusca = leer.nextInt();

          Elemento elimsoc = TD.buscar(codBusca);
          if (elimsoc != null) {
            TD.eliminar(codBusca);
            System.out.println("Socio encontrado y eliminado");
            pause();
            borrarPantalla();
          } else {
            System.out.println("El socio no fue encontrado.");
          }
          break;
        case 4:
        for (int i = 0; i < TD.M; i++) {
          
            if (TD.tabla[i] != null) {
              System.out.println("SOCIOS EN LA POSICIÓN " + i);
              Elemento actual = TD.tabla[i];
              while (actual != null) {
                TipoSocio socio = actual.getSocio();
                System.out.println("-----------------------------");
                System.out.println("Código: " + socio.getCodigo());
                System.out.println("Nombre: " + socio.getNombre());
                System.out.println("Edad: " + socio.getEdad());
                System.out.println("Fecha de registro: " + socio.getF());
                actual = actual.sgte;
                if (actual == null) {
                  System.out.println("NO HAY MAS SOCIOS EN LA POSICIÓN " );
                  System.out.println("");
                  System.out.println("");
                }
              }
            }
          }
          break;
          case 5:
          System.out.println(" Gracias por utilizar el sistema");
          break;
      }
      pause();
      borrarPantalla();
    } while (op != 5);

  }

  //PROCEDIMIENTO

  public static void menu() {
    System.out.println("             MENÙ                  ");
    System.out.println("1. Cargar un socio                ");
    System.out.println("2. Buscar un socio                ");
    System.out.println("3. Eliminar un socio              ");
    System.out.println("4. Mostrar toda la lista enlazada ");
    System.out.println("5. Salir                          ");
  }
  public static int controlOpcion() {
    Scanner leer;
    leer = new Scanner(System.in);
    int op = 0;
    boolean opcionValida = false;
    String input;
    while (!opcionValida) {
      System.out.println(" Ingrese la opción deseada:    ");
     
      input = leer.nextLine();
      try {
        op = Integer.parseInt(input);
        if (op >= 1 && op <= 6) {
          opcionValida = true;
        } else {
          System.out.println("");
          System.out.println("op Incorrecta! Ingrese un valor entre 1 y 5.");
          pause();
          borrarPantalla();
          menu();
        }
      } catch (Exception e) {
        System.out.println("");
        System.out.println("Debe ingresar un valor numérico");
        pause();
        borrarPantalla();
        menu();
      }
    }
    return op;
  }
  public static void borrarPantalla() {
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