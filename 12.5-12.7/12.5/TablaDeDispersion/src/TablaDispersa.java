public class TablaDispersa {
    Cancion T[];
    static final int Tam = 101;
    private int numElementos;
    private double factorCarga;

    public TablaDispersa() {
        T = new Cancion[Tam];
        for (int j = 0; j < Tam; j++) {
            T[j] = null;
            numElementos = 0;
            factorCarga = 0.0;
        }
    }

    long transformaCadena(String clave) {
        long d;
        d = 0;
        for (int j = 0; j < Math.min(10, clave.length()); j++) {
            d = d * 27 + (int) clave.charAt(j);
        }
        if (d < 0)
            d = -d;
        return d;
    }

    public int direccion(String clave) {
        int i = 0, p;
        long d;
        d = transformaCadena(clave);
        // aplica aritmética modular para obtener dirección base
        p = (int) (d % 101);
        
        // bucle de exploración
        while (T[p] != null && !T[p].elCodigo().equals(clave)) {
            i++;
            p = p + i * i;
            p = p % Tam; // considera el array como circular
        }
        return p;
    }

    public void insertar(Cancion c) {
        int posicion;
        posicion = direccion(c.elCodigo());
        T[posicion] = c;
        numElementos++;
        factorCarga = (double) (numElementos) / Tam;

        if (factorCarga > 0.5)
            System.out.println("\n!! Factor de carga supera el 50%.!!"   + " Conviene aumentar el tamaño.");
    }

    public Cancion buscar(String clave) {
        Cancion pc;
        int posicion;
        posicion = direccion(clave);
        pc = T[posicion];

        if (pc != null)
            if (!pc.esAlta)
                pc = null;

        return pc;
    }

    public void eliminar(String clave) {
        int posicion;
        posicion = direccion(clave);
        if (T[posicion] != null) {
            System.out.println("Los  siguientes datos seran eliminados:");
            T[posicion].muestra();
            T[posicion].esAlta = false;
            System.out.println("\nCanción eliminada");
        } else {
            System.out.println("\nCancion no encontrada.");
        }

    }

}
