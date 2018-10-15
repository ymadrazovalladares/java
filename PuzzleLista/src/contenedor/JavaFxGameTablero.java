package contenedor;

import javafx.scene.layout.Pane;

public class JavaFxGameTablero {
    Pane pane;
    ListaDoblementeEnlazada tablero = new ListaDoblementeEnlazada();

    public JavaFxGameTablero(Integer datostablero[][])
    {
        pane = new Pane();
        setFichas(datostablero);
    }

    public void setFichas(Integer tablero[][])
    {
        this.tablero.PushMatrix(tablero);
        Integer temp[][] = new Integer[this.tablero.getTotalX()][this.tablero.getTotalX()];
        temp = this.tablero.getListaDoble();
        for (Integer i=0; i<temp.length;i++)
            for (Integer j=0; j<temp[0].length;j++)
            {

                Nodo javaFxFicha = new Nodo(i, j, temp[i][j]);
                javaFxFicha.getButton().setOnMouseClicked(event ->
                {
                  this.tablero.CambiarNodos(this.tablero.BuscarPorPosicion(javaFxFicha));
                }
                );

               pane.getChildren().add(javaFxFicha.getButton());
            }
    }


    public Pane getPane() {
        return pane;
    }

    public void setPane(Pane pane) {
        this.pane = pane;
    }


}