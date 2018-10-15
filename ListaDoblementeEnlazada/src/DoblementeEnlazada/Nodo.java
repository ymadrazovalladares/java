package DoblementeEnlazada;

public class Nodo {
  private Integer valor;
  private Nodo siguiente;
  private Nodo anterior;

  Nodo(Integer valor) {
      this.valor = valor;
      this.siguiente = null;
      this.anterior = null;
  }
    Nodo(Nodo valor) {
        this.valor = valor.getValor();
        this.anterior = valor.getAnterior();
        this.siguiente = valor.getSiguiente();
    }

    public Integer getValor() {
        return valor;
    }

    public void setValor(Integer valor) {
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
