package contenedor;

import javafx.scene.control.Button;

public class JavaFxFicha {

    private String idFicha;
    private String jugador;
    private Integer peso;

    public JavaFxFicha() {

        this.idFicha = "";
        this.jugador = "";
        this.peso = 0;
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

    public Integer getPeso() {
        return peso;
    }

    public void setPeso(Integer peso) {
        this.peso = peso;
    }
}