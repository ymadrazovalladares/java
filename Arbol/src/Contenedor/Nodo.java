package Contenedor;

public class Nodo {
	 
    private int valor;
    private Nodo siguiente;
    private Nodo anterior;
    private Nodo padre;
    private Nodo hojaIzquierda;
    private Nodo hojaDerecha;

    public Nodo getSiguiente()
    {
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

    public Nodo(int valor)
    {
        this.valor = valor;
        this.anterior = null;
        this.siguiente = null;
        this.padre = null;
        this.hojaIzquierda = null;
        this.hojaDerecha = null;
    }
    public Nodo(Nodo aNodo)
    {
        this.anterior = aNodo.getAnterior();
        this.siguiente = aNodo.getSiguiente();
        this.valor = aNodo.getValor();
        this.padre = aNodo.getPadre();
        this.hojaIzquierda = aNodo.getHojaIzquierda();
        this.hojaDerecha = aNodo.getHojaDerecha();
    }
    public void setValor(int valor) {
        this.valor = valor;
    }
 
    public int getValor() {
        return valor;
    }
 
    public Nodo getPadre() {
        return padre;
    }
 
    public void setPadre(Nodo padre) {
        this.padre = padre;
    }
 
    public Nodo getHojaIzquierda() {
        return hojaIzquierda;
    }
 
    public void setHojaIzquierda(Nodo hojaIzquierda) {
        this.hojaIzquierda = hojaIzquierda;
    }
 
    public Nodo getHojaDerecha() {
        return hojaDerecha;
    }
 
    public void setHojaDerecha(Nodo hojaDerecha) {
        this.hojaDerecha = hojaDerecha;
    }
 
}
