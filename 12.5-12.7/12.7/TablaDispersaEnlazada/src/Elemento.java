public class Elemento {
    TipoSocio socio;
    Elemento sgte;
public Elemento(TipoSocio e)
{
 socio = e;
 sgte = null;//Este es el puntero siguiente que conecta en las listas enlazadas 
}
public TipoSocio getSocio()
{
 return socio;
}
}
