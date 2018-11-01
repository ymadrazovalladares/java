package contenedor;

public class NodoPuntos {

        private double valorX;
        private double valorY;
        private NodoPuntos siguiente;

    public NodoPuntos(double valorX, double valorY) {
        this.valorX = valorX;
        this.valorY = valorY;
        this.siguiente = null;
    }
    public NodoPuntos() {
        this.valorX = 0;
        this.valorY = 0;
        this.siguiente = null;
    }

    public NodoPuntos(NodoPuntos valor)
    {
        this.valorX = valor.getValorX();
        this.valorY = valor.valorY;
        this.siguiente = valor.getSiguiente();
    }

    public double getValorX() {
        return valorX;
    }

    public void setValorX(double valorX) {
        this.valorX = valorX;
    }

    public double getValorY() {
        return valorY;
    }

    public void setValorY(double valorY) {
        this.valorY = valorY;
    }

    public NodoPuntos getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoPuntos siguiente) {
        this.siguiente = siguiente;
    }
}
