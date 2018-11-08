package contenedor;

import javafx.scene.control.Button;

public class JavaFxFicha {

    private String idFicha;
    private String jugador;


    public JavaFxFicha() {

        this.idFicha = "";
        this.jugador = "";
     }

    public String getIdFicha() {
        return idFicha;
    }

    public void setIdFicha(String idFicha) {
        this.idFicha = idFicha;
    }

    public String getJugador() {
        return jugador;
    }

    public void setJugador(String jugador) {
        this.jugador = jugador;
    }
}