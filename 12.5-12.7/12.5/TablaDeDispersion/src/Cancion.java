import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Cancion {
    String artista, nomCan, genero, codigo;
    boolean esAlta;

    public Cancion(String artista, String nomCan, String genero, String codigo) {
        this.artista = artista;
        this.nomCan = nomCan;
        this.genero = genero;
        this.codigo= codigo;
    }

    public void asigna() {
        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));

        try {
            System.out.print("\n  Codigo (de no mas 10 caracteres): ");
            codigo = entrada.readLine();
            System.out.print("  Nombre de la canción: ");
            nomCan = entrada.readLine();
            System.out.print("  Nombre del artista: ");
            artista = entrada.readLine();
            System.out.print("  Genero de la cancion: ");
            genero = entrada.readLine();
        } catch (IOException e) {
            System.out.println(" Ingreso de datos invalidos" +
                    e.getMessage() + " . No Pudo cargarse la canción");
            esAlta = false;
        }
    }

    public String elCodigo() {
        return codigo;
    }

    public Cancion() {
        esAlta = true;
        asigna();
    }

    public void muestra() {
        System.out.println("_________________________________");
        System.out.println("  Nombre de la canción: " + nomCan);
        System.out.println("  Nombre del artista: " + artista);
        System.out.println("  Genero: " + genero);
        System.out.println("__________________________________");
    }

}
