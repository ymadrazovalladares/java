package DobleEnlazada;

public class UsalistaSimple {
    public static void main(String args[]){
        ListaDobleEnlazada listaSimple= new ListaDobleEnlazada();
        listaSimple.cargarAlInicioDeLaLista(500);
        listaSimple.cargarDespuesDe(600,500);

        ListaDobleEnlazada listaSimple1= new ListaDobleEnlazada();
        listaSimple1.cargarAlInicioDeLaLista(250);
        listaSimple1.cargarAlInicioDeLaLista(200);
        listaSimple1.cargarAlInicioDeLaLista(150);

        listaSimple1.cargarOrdenadamente(180);
        for (Integer valor :listaSimple1.getListaSimple())
        {
            System.out.println( valor);
        }
        System.out.println( "se limpia la lista");//se limpia la lista
       /* listaSimple1.vaciarLista();
        for (Integer valor :listaSimple1.getListaSimple())
        {
            System.out.println( valor);
        }*/
        /*listaSimple1.cargarAntesDe(listaSimple,200);
        for (Integer valor :listaSimple1.getListaSimple())
        {
            System.out.println( valor);
        }*/
        //System.out.println( listaSimple1.eliminarPrimerElementoLista());
        //System.out.println( listaSimple1.eliminarUltimoElementoLista());
       // listaSimple1.eliminarElementoLista(150);
        //listaSimple1.eliminarElementoLista(aux);
        /*listaSimple1.cargarDespuesDe(listaSimple,200);
        for (Integer valor :listaSimple1.getListaSimple())
         {
            System.out.println( valor);
         }*/
        //listaSimple1.cargarDespuesDe(listaSimple2,200);

        //System.out.println(listaSimple1.Buscar(600));


    }
}
