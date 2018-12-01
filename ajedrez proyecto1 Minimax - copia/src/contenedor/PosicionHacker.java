package contenedor;

public class PosicionHacker{

        private Integer valorX;
        private Integer valorY;
        private Integer ponderacion;
        private PosicionHacker siguiente;

    public PosicionHacker(Integer valorX, Integer valorY,Integer apoderacion) {
        this.valorX = valorX;
        this.valorY = valorY;
        this.ponderacion = apoderacion;
        this.siguiente = null;
    }
    public PosicionHacker() {
        this.valorX = null;
        this.valorY = null;
        this.ponderacion = 0;
        this.siguiente = null;
    }

    public PosicionHacker(PosicionHacker valor)
    {
        this.valorX = valor.getValorX();
        this.valorY = valor.getValorY();
        this.ponderacion = valor.getPonderacion();
        this.siguiente = valor.getSiguiente();
    }

    public Integer getValorX() {
        return valorX;
    }

    public void setValorX(Integer valorX) {
        this.valorX = valorX;
    }

    public Integer getValorY() {
        return valorY;
    }

    public void setValorY(Integer valorY) {
        this.valorY = valorY;
    }

    public PosicionHacker getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(PosicionHacker siguiente) {
        this.siguiente = siguiente;
    }

    public Integer getPonderacion() {
        return ponderacion;
    }

    public void setPonderacion(Integer ponderacion) {
        this.ponderacion = ponderacion;
    }
}
