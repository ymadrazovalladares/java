package contenedor;

public class ListaNodos {
    NodoPuntos inicioLista;
    NodoPuntos finalLista;
    Integer totalAlmacenados;

    public Integer getTotalalmacenados(){
        return this.totalAlmacenados;
    }

    public NodoPuntos getInicioLista() {
        return inicioLista;
    }

    public void setInicioLista(NodoPuntos inicioLista) {
        this.inicioLista = inicioLista;
    }

    public ListaNodos() {
        inicioLista =null;
        finalLista =null;
        totalAlmacenados =0;
    }
    public ListaNodos(NodoPuntos aNodoPunto) {
        inicioLista =aNodoPunto;
        finalLista =aNodoPunto;
        totalAlmacenados =0;
    }
    public void cargarAlFinaldeLaLista(NodoPuntos  valor){
        if(finalLista ==null) {
            cargarAlInicioDeLaLista(valor);
            return;
        }
       NodoPuntos newnodo = new NodoPuntos(valor);

        finalLista.setSiguiente(newnodo);
        finalLista = newnodo;
        totalAlmacenados++;
        return;
    }
    public void cargarAlInicioDeLaLista(NodoPuntos valor)
    {
        NodoPuntos newnodo = new NodoPuntos(valor);
        if(inicioLista ==null){
            inicioLista =newnodo;
            finalLista = newnodo;
            totalAlmacenados++;
            return;
        }

        newnodo.setSiguiente(inicioLista.getSiguiente());
        inicioLista = newnodo;
        totalAlmacenados++;
        return;
    }
}
