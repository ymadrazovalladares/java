package contenedor;

import javafx.scene.control.Button;

public class JavaFxFicha {
    private String idFicha;
    private Button button;
    private Integer posicionArregloX;
    private Integer posicionArregloY;
    private boolean cambioColor;
    private boolean sombreada;
    String color;
    String jugador;


    public JavaFxFicha(Integer tableroY, Integer tableroX,String IdFicha) {

        this.idFicha = IdFicha;
        this.sombreada = false;
        this.cambioColor = false;
        this.jugador = "";
        if(this.idFicha==null)
            button = new Button(null);
        else
            button = new Button(String.valueOf(this.idFicha));

        int buttonSize = 100;
        button.setPrefSize(buttonSize, buttonSize);

//se le pone el color a los botones
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

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getJugador() {
        return jugador;
    }

    public void setJugador(String jugador) {
        this.jugador = jugador;
    }

    public boolean BotonPresionado()
    {
        if (!cambioColor)
        {
            String colorTemp = "-fx-background-color: yellow;";
            button.setStyle(String.format("-fx-font-size: %dpx;" + colorTemp, (int) (0.25 * 100)));
            cambioColor = true;
            return true;
        }
        else
        {
            button.setStyle(String.format("-fx-font-size: %dpx;" + color, (int) (0.25 * 100)));
            cambioColor = false;
            return false;
        }
    }

    public boolean Sombrear()
    {
        String colorTemp = "-fx-background-color: pink;";
        button.setStyle(String.format("-fx-font-size: %dpx;" + colorTemp, (int) (0.25 * 100)));
        sombreada = true;
        return true;
    }

    public String getColorFicha() {
        return color;
    }

    public void setColorFicha(String colorFicha) {
        this.color = colorFicha;

    }

    public boolean RestaurarColorFicha()
    {
        button.setStyle(String.format("-fx-font-size: %dpx;" + color, (int) (0.25 * 100)));
        return true;
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

    public boolean isSombreada() {
        return sombreada;
    }

    public void setSombreada(boolean sombreada) {
        this.sombreada = sombreada;
    }
}