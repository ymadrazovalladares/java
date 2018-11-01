package contenedor;

import javafx.scene.control.Button;

public class JavaFxFicha {
    private String idFicha;
    private Button button;
    private Integer posicionArregloX;
    private Integer posicionArregloY;


    public JavaFxFicha(Integer tableroY, Integer tableroX,String IdFicha) {

        this.idFicha = IdFicha;
        if(this.idFicha==null)
            button = new Button(null);
        else
            button = new Button(String.valueOf(this.idFicha));

        int buttonSize = 100;
        // button.setMinSize(buttonSize,buttonSize);
        button.setPrefSize(buttonSize, buttonSize);
        //button.setMaxSize(buttonSize,buttonSize);
        String color;
        if ((tableroX %2 == 0 && tableroY %2 == 1)||(tableroX %2 == 1 && tableroY %2 == 0))
            color = "-fx-background-color: black;";
        else
            color = "-fx-background-color: white;";
        button.setStyle(String.format("-fx-font-size: %dpx;" + color, (int) (0.25 * buttonSize)));


            this.posicionArregloX =  tableroX;
            this.posicionArregloY =  tableroY;

        posicionArregloX = posicionArregloX * 100;
        posicionArregloY = posicionArregloY * 100;

        button.setLayoutX(posicionArregloX);
        button.setLayoutY(posicionArregloY);
    }

    public String getIdFicha() {
        return idFicha;
    }

    public void setIdFicha(String idFicha) {
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