package contenedor;

import javafx.scene.layout.Pane;

public class JavaFxGameTablero {
    Pane pane;
    JavaFxFicha tablero[][];

    public JavaFxGameTablero(ListaDoblementeEnlazada datostablero){

        tablero = new JavaFxFicha[datostablero.length][datostablero[0].length];
        pane = new Pane();
        setFichas(datostablero);

    }

    public void setFichas(Integer tablero[][]){
        for (Integer i=0; i<tablero.length;i++)
            for (Integer j=0; j<tablero[0].length;j++) {

                JavaFxFicha javaFxFicha = new JavaFxFicha(i, j, tablero[i][j]);
                javaFxFicha.getButton().setOnMouseClicked(event -> {
                    moverFicha(javaFxFicha);
                });

                this.tablero[i][j] = javaFxFicha;
                pane.getChildren().add(javaFxFicha.getButton());
            }
    }

    public JavaFxFicha getFichaNull() {
        for (Integer x = 0; x < tablero.length; x++) {
            for (Integer y = 0; y < tablero[0].length; y++) {
                if (this.tablero[x][y].getIdFicha()==null) {

                    return this.tablero[x][y];
                }
            }
        }
        return null;
    }

    public void moverFicha(JavaFxFicha javaFxFicha){

        int xNull = getFichaNull().getPosicionArregloY()/100;
        int yNull = getFichaNull().getPosicionArregloX()/100;

        int x1 = javaFxFicha.getPosicionArregloY()/100;
        int y1 = javaFxFicha.getPosicionArregloX()/100;

        if(MovePermitido(xNull,yNull,x1,y1))
         {
            Integer tempIdFicha = javaFxFicha.getIdFicha();
        //   T tempIdFicha = javaFxFicha.getIdFicha();

           JavaFxFicha fichanull = getFichaNull();
           fichanull.getButton().setText(String.valueOf(tempIdFicha));
           fichanull.setIdFicha(tempIdFicha);

           javaFxFicha.getButton().setText(null);
           javaFxFicha.setIdFicha(null);
         }
    }
    public boolean MovePermitido(int xnull,int ynull, int xText, int yText)
    {
        if((xnull == xText) && ((ynull == yText+1)||(ynull == yText-1)))
        {
            return true;
        }
        else if((ynull == yText) && ((xnull == xText+1)||(xnull == xText-1)))
            {
                return true;
            }
        else
          return false ;

    }

    public Pane getPane() {
        return pane;
    }

    public void setPane(Pane pane) {
        this.pane = pane;
    }

    public JavaFxFicha[][] getTablero() {
        return tablero;
    }

    public void setTablero(JavaFxFicha[][] tablero) {
        this.tablero = tablero;
    }
}