package contenedor;

public class Nodo {
    public int valor;
    private Nodo siguiente;
    private Nodo anterior;
    private Nodo superior;
    private Nodo inferior;

    Nodo(int valor) {
        this.valor = valor;
        this.siguiente = null;
        this.anterior = null;
        this.superior = null;
        this.inferior = null;
    }
    Nodo() {

        this.siguiente = null;
        this.anterior = null;
        this.superior = null;
        this.inferior = null;
    }

    public Nodo getSuperior() {
        return superior;
    }

    public void setSuperior(Nodo superior) {
        this.superior = superior;
    }

    public Nodo getInferior() {
        return inferior;
    }

    public void setInferior(Nodo inferior) {
        this.inferior = inferior;
    }

    Nodo(Nodo valor) {
        this.anterior = null;
        this.superior = null;
        this.inferior = null;
        this.superior = null;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public Nodo getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }
    public Nodo getAnterior() {
        return anterior;
    }

    public void setAnterior(Nodo anterior) {
        this.anterior = anterior;
    }
}
