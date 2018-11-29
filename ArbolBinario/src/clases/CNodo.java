package clases;

public class CNodo{
    private Integer valor;
    private CNodo hIzq;
    private CNodo hDer;
    private CNodo padre;

    public CNodo(Integer valor){
        this.valor=valor;
        hIzq=null;
        hDer=null;
        padre =null;
    }
    public CNodo( ){

        hIzq=null;
        hDer=null;
        padre =null;
    }

    public CNodo getPadre() {
        return padre;
    }

    public void setPadre(CNodo padre) {
        this.padre = padre;
    }


    public Integer getValor() {
        return valor;
    }

    public void setValor(Integer valor) {
        this.valor = valor;
    }

    public CNodo gethIzq() {
        return hIzq;
    }

    public void sethIzq(CNodo hIzq) {
        this.hIzq = hIzq;
    }

    public CNodo gethDer() {
        return hDer;
    }

    public void sethDer(CNodo hDer) {
        this.hDer = hDer;
    }
}
