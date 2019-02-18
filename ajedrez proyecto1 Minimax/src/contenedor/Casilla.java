package contenedor;

import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Casilla {

    private JavaFxFicha ficha;
    private String idCasilla;
    private Button button;
    private Integer posicionArregloX;
    private Integer posicionArregloY;
    private boolean cambioColor;
    private boolean sombreada;
    private String color;

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
            color = "-fx-background-color: d38f69;";
        else
            color = "-fx-background-color: faf4f1;";
        button.setStyle(String.format("-fx-font-size: %dpx;" + color, (int) (0.25 * buttonSize)));

        this.posicionArregloX =  tableroX;
        this.posicionArregloY =  tableroY;

        posicionArregloX = posicionArregloX * 100;
        posicionArregloY = posicionArregloY * 100;

        button.setLayoutX(posicionArregloX);
        button.setLayoutY(posicionArregloY);
    }

    public Casilla()
    {
        posicionArregloX = null;
        posicionArregloY = null;
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

    public boolean Sombrear(String aJugador)
    {
       if(this.getFicha().getJugador()!= aJugador) {
           String colorTemp = "-fx-background-color: pink;";
           button.setStyle(String.format("-fx-font-size: %dpx;" + colorTemp, (int) (0.25 * 100)));
           sombreada = true;
           return true;
       }
       return false;
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

    public void addIdFicha(String idFicha,String aJugador, String figura, Integer apeso)
    {
        //button.setText(idFicha);
        Image image = new Image(getClass().getResourceAsStream(figura+".png"));
        button.setGraphic(new ImageView(image));
        ficha.setIdFicha(idFicha);
        ficha.setJugador(aJugador);
        ficha.setPeso(apeso);
    }

    public boolean isCambioColor() {
        return cambioColor;
    }

    public void setCambioColor(boolean cambioColor) {
        this.cambioColor = cambioColor;
    }
    public void ColorHacker()
    {
        String colorTemp = "-fx-background-color: pink;";
        button.setStyle(String.format("-fx-font-size: %dpx;" + colorTemp, (int) (0.25 * 100)));
    }
}