package contenedor;

public class UsaListaDobleGenerica
{
    public static <aFigura> void main(String args[])
    {
        NodoPuntos nodoPuntos = new NodoPuntos();
        ListaNodos listaNodos = new ListaNodos();
        nodoPuntos.setValorX(20.3);
        nodoPuntos.setValorY(41.5);
        listaNodos.cargarAlInicioDeLaLista(nodoPuntos);
        nodoPuntos.setValorX(10.5);
        nodoPuntos.setValorY(47.5);
        listaNodos.cargarAlFinaldeLaLista(nodoPuntos);
        nodoPuntos.setValorX(2.3);
        nodoPuntos.setValorY(4.5);
        listaNodos.cargarAlFinaldeLaLista(nodoPuntos);

        Figura aFigura = new Figura("rojo",listaNodos);
        ListaDobleGenericaClase<Figura> listaDoble= new ListaDobleGenericaClase<Figura>();
        listaDoble.cargarAlInicioDeLaLista(aFigura);

        //cargar otra figura
        NodoPuntos nodoPuntos1 = new NodoPuntos();
        ListaNodos listaNodos1 = new ListaNodos();
        nodoPuntos1.setValorX(21.0);
        nodoPuntos1.setValorY(44.3);
        listaNodos1.cargarAlInicioDeLaLista(nodoPuntos1);
        nodoPuntos1.setValorX(66.5);
        nodoPuntos1.setValorY(12.6);
        listaNodos1.cargarAlFinaldeLaLista(nodoPuntos1);
        nodoPuntos1.setValorX(6.1);
        nodoPuntos1.setValorY(5.3);
        listaNodos1.cargarAlFinaldeLaLista(nodoPuntos1);
        nodoPuntos1.setValorX(6.2);
        nodoPuntos1.setValorY(9.5);
        listaNodos1.cargarAlFinaldeLaLista(nodoPuntos1);

        Figura aFigura1 = new Figura("amarillo",listaNodos1);
        listaDoble.cargarAlFinaldeLaLista(aFigura1);
        Nodo<Figura> temp = new Nodo<Figura>();
        temp = listaDoble.getInicioLista();
        NodoPuntos puntosXY;
        for(int i = 1; i <= listaDoble.totalAlmacenados; i++)
        {
            puntosXY = temp.getValor().getaNodoPuntos().getInicioLista();
           System.out.println(temp.getValor().Color);
            for(int j = 1; j <= temp.getValor().TotalPuntos; j++)
            {
               System.out.println("(" + puntosXY.getValorX()+","+ puntosXY.getValorY()+")");
               puntosXY = puntosXY.getSiguiente();
            }
            temp = temp.getSiguiente();
        }

    };



}
