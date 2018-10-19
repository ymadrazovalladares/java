package contenedor;
import javafx.scene.control.Button;

public class Nodo {
   // public int valor;
    private Nodo siguiente;
    private Nodo anterior;
    private Nodo superior;
    private Nodo inferior;
    private Integer idFicha;
    private Button button;
    private Integer posicionArregloX;
    private Integer posicionArregloY;
    // private JavaFxFicha aFicha;


    public Nodo()
    {
        this.siguiente = null;
        this.anterior = null;
        this.superior = null;
        this.inferior = null;
        this.idFicha = 0;
        this.button = null;
        this.posicionArregloX = 0;
        this.posicionArregloY = 0;
    }

    public Integer getIdFicha() {
        return idFicha;
    }
    public Integer getIdFicha(Integer x, Integer y)
    {
        if((x==posicionArregloX)&&(y == posicionArregloY))
           return idFicha;
        else
            return -1;
    }

    public void setIdFicha(Integer idFicha) {
        this.idFicha = idFicha;
    }

    public Button getButton() {
        return button;
    }

    public void setButton(Button button) {
        this.button = button;
    }

    public Integer getPosicionArregloX() {
        return posicionArregloX;
    }

    public void setPosicionArregloX(Integer posicionArregloX) {
        this.posicionArregloX = posicionArregloX;
    }

    public Integer getPosicionArregloY() {
        return posicionArregloY;
    }

    public void setPosicionArregloY(Integer posicionArregloY) {
        this.posicionArregloY = posicionArregloY;
    }

   Nodo(Integer tableroY, Integer tableroX, Integer valor) {
        //this.valor = valor;
        this.idFicha = valor;
        this.siguiente = null;
        this.anterior = null;
        this.superior = null;
        this.inferior = null;

        if(valor==null)
            button = new Button("0");
        else
            button = new Button(String.valueOf(valor));

        int buttonSize = 100;
        // button.setMinSize(buttonSize,buttonSize);
        button.setPrefSize(buttonSize, buttonSize);
        //button.setMaxSize(buttonSize,buttonSize);
        button.setStyle(String.format("-fx-font-size: %dpx;", (int) (0.25 * buttonSize)));

        this.posicionArregloX = 1 + tableroX;
        this.posicionArregloY = 1 + tableroY;

        posicionArregloX = posicionArregloX * 100;
        posicionArregloY = posicionArregloY * 100;

        button.setLayoutX(posicionArregloX);
        button.setLayoutY(posicionArregloY);
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
        this.anterior.setAnterior(valor.getAnterior());
        this.siguiente.setSiguiente(valor.getSiguiente());
        this.inferior.setInferior(valor.getInferior());
        this.superior.setSuperior(valor.getSuperior());

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
