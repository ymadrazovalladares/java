package contenedor;

public class Estructura {
    Integer valor;
    String origen;
    String destino;

    public Estructura(Integer valor, String origen, String destino) {
        this.valor = valor;
        this.origen = origen;
        this.destino = destino;
    }

    public Estructura(String destino)
    {
        this.valor = 0;
        this.origen = "";
        this.destino = destino;
    }

    public Estructura( )
    {
        this.valor = 0;
        this.origen = "";
        this.destino = "";
    }

    public Integer getValor() {
        return valor;
    }

    public void setValor(Integer valor) {
        this.valor = valor;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }
}
