package contenedor;

public class ListaPosicionHacker {
    private String nombreFicha;
    private PosicionHacker inicioLista;
    private PosicionHacker finalLista;
    private Integer totalAlmacenados;

    public Integer getTotalalmacenados(){
        return this.totalAlmacenados;
    }

    public PosicionHacker getInicioLista() {
        return inicioLista;
    }

    public void setInicioLista(PosicionHacker inicioLista) {
        this.inicioLista = inicioLista;
    }

    public ListaPosicionHacker(String aNombreFicha) {
        inicioLista =null;
        finalLista =null;
        nombreFicha = aNombreFicha;
        totalAlmacenados =0;
    }
    public ListaPosicionHacker(PosicionHacker aNodoPunto,String aNombre) {
        inicioLista =aNodoPunto;
        finalLista =aNodoPunto;
        nombreFicha = aNombre;
        totalAlmacenados =0;
    }
    public void cargarAlFinaldeLaLista(PosicionHacker  valor){
        if(finalLista ==null) {
            cargarAlInicioDeLaLista(valor);
            return;
        }
        PosicionHacker newnodo = new PosicionHacker(valor);

        finalLista.setSiguiente(newnodo);
        finalLista = newnodo;
        totalAlmacenados++;
        return;
    }
    public void cargarAlInicioDeLaLista(PosicionHacker valor)
    {
        PosicionHacker newnodo = new PosicionHacker(valor);
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

    public  PosicionHacker[] getListaNodosPuntos(){

        PosicionHacker temporal = inicioLista;
        PosicionHacker[] vector;
        vector = new PosicionHacker[this.totalAlmacenados];

        Integer contador=0;
        while(temporal!=null)
        {
            vector[contador] = temporal;
            contador++;
            temporal= temporal.getSiguiente();
        }

        return (vector);
     }

    public String getNombreFicha() {
        return nombreFicha;
    }

    public void setNombreFicha(String nombreFicha) {
        this.nombreFicha = nombreFicha;
    }

    public void VaciarLista()
    {
        inicioLista = null;
        finalLista = null;
        totalAlmacenados = 0;
    }
    public boolean IsHaker(int x, int y)
    {
        PosicionHacker temp = inicioLista;
        while (temp != null)
        {
            if(temp.getValorX() == x && temp.getValorY() == y)
                return true;
            temp = temp.getSiguiente();
        }
        return false;
    }


}
