package DoblementeEnlazada;

public class UsaListaDobleEnlazada {
    public static void main(String args[]){
        ListaDoblementeEnlazada listaDoble= new ListaDoblementeEnlazada();
        listaDoble.cargarAlInicioDeLaLista(500);
        listaDoble.cargarAlInicioDeLaLista(650);
        listaDoble.cargarAlFinaldeLaLista(700);
        for (Integer valor :listaDoble.getListaDoble(1))
        {
            System.out.println( valor);
        }
        System.out.println( "-------------------------");
        ListaDoblementeEnlazada listaDoble1= new ListaDoblementeEnlazada();
        listaDoble1.cargarOrdenadamente(250);
        listaDoble1.cargarAlInicioDeLaLista(200);
        listaDoble1.cargarListaOrdenada(listaDoble);
        for (Integer valor :listaDoble1.getListaDoble(2))
        {
            System.out.println( valor);
        }

        System.out.println( "se limpia la lista");//se limpia la lista


    }
}
