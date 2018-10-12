package contenedor;

import javafx.scene.control.Button;

public class JavaFxFicha {
    private Integer idFicha;
    private Button button;
    private Integer posicionArregloX;
    private Integer posicionArregloY;


    public JavaFxFicha(Integer tableroY, Integer tableroX,Integer IdFicha) {

        this.idFicha = IdFicha;
        if(this.idFicha==null)
            button = new Button(null);
        else
            button = new Button(String.valueOf(this.idFicha));

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

    public Integer getIdFicha() {
        return idFicha;
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
}