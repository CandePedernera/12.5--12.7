public class TipoSocio {
    int codigo;
private String nombre;
private int edad;
Fecha f;
public TipoSocio(String n, int c, int e, int d, int m, int a)
{
 codigo = c;
 nombre = n;
 edad = e;
 f = new Fecha(d, m, a);
}
public int getCodigo()
{
 return codigo;
}
public void setCodigo(int codigo) {
    this.codigo = codigo;
}
public String getNombre() {
    return nombre;
}
public void setNombre(String nombre) {
    this.nombre = nombre;
}
public int getEdad() {
    return edad;
}
public void setEdad(int edad) {
    this.edad = edad;
}
public Fecha getF() {
    return f;
}
public void setF(Fecha f) {
    this.f = f;
}
}
