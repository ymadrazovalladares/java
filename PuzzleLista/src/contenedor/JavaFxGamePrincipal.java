package contenedor;

public  class JavaFxGamePrincipal  {

    public static void main(String args[]){
        int tablero[][]= {
                {    1,   2, 3,  4},
                {   0, 5, 6,  7},
                {   8,  9, 10,  11},
                {   12,   13,  14, 15}   } ;
        ListaDoblementeEnlazada aux = new ListaDoblementeEnlazada();
        aux.PushMatrix(tablero);
        aux.CambiarNodos(5);

    }
}


