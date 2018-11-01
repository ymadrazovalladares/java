package contenedor;
import java.lang.reflect.Array;

public class ListaDobleGenericaClase<T> {
    Nodo<T> inicioLista;
    Nodo<T> finalLista;
    Integer totalAlmacenados;

    public Integer getTotalalmacenados(){
        return this.totalAlmacenados;
    }


    public ListaDobleGenericaClase() {
        inicioLista =null;
        finalLista =null;
        totalAlmacenados =0;
    }

    public void cargarAlFinaldeLaLista(T  valor){
        if(finalLista ==null) {
            cargarAlInicioDeLaLista(valor);
            return;
        }
        Nodo<T> newnodo = new Nodo<T>(valor);
        finalLista.setSiguiente(newnodo);
        finalLista = newnodo;
        totalAlmacenados++;
        return;
    }

    public Nodo<T> getInicioLista() {
        return inicioLista;
    }

    public void setInicioLista(Nodo<T> inicioLista) {
        this.inicioLista = inicioLista;
    }

    public void cargarAlInicioDeLaLista(T valor)
    {
        Nodo<T> newnodo = new Nodo<T>(valor);
        if(inicioLista ==null){
            inicioLista =newnodo;
            finalLista = newnodo;
            totalAlmacenados++;
            return;
        }

        newnodo.setSiguiente(inicioLista);
        inicioLista = newnodo;
        totalAlmacenados++;
        return;
    }

    public  T[] getListaDoble(){

        Nodo<T> temporal = inicioLista;
        T[] vector;
        vector = (T[]) Array.newInstance(temporal.getValor().getClass(),this.totalAlmacenados);


        Integer contador=0;
        while(temporal!=null){
            vector[contador] = temporal.getValor();
            contador++;
           // System.out.print(temporal.getValor());
            temporal= temporal.getSiguiente();
        }

        return (vector);

    }

}