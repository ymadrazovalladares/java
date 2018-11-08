package contenedor;

import javafx.scene.control.Button;

public class Casilla {

    JavaFxFicha ficha;
    private String idCasilla;
    private Button button;
    private Integer posicionArregloX;
    private Integer posicionArregloY;
    private boolean cambioColor;
    private boolean sombreada;
    private String color;
   // String jugador;


    public Casilla(Integer tableroY, Integer tableroX,String IdCasila) {


        this.sombreada = false;
        this.cambioColor = false;
        ficha = new JavaFxFicha();
       if(this.idCasilla==null)
            button = new Button(null);
        else
            button = new Button(String.valueOf(this.idCasilla));

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

    public String getCasilla() {
        return idCasilla;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean BotonPresionado()
    {
        if(ficha.getIdFicha() != "")
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
        return false;
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

    public boolean RestaurarColorCasilla()
    {
        button.setStyle(String.format("-fx-font-size: %dpx;" + color, (int) (0.25 * 100)));
        return true;
    }

    public void setIdCasilla(String idCasilla) {
        this.idCasilla = idCasilla;
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

    public JavaFxFicha getFicha() {
        return ficha;
    }

    public void setFicha(JavaFxFicha ficha) {
        this.ficha = ficha;
    }

    public void addIdFicha(String idFicha,String aJugador)
    {
        button.setText(idFicha);
        ficha.setIdFicha(idFicha);
        ficha.setJugador(aJugador);
    }
}