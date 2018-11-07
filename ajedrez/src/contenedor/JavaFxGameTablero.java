package contenedor;

import javafx.scene.layout.Pane;

public class JavaFxGameTablero {
    Pane pane;
    JavaFxFicha tablero[][];
    private int fichaMarcadaX;
    private int fichaMarcadaY;
    private boolean fichaMarcada;
    private boolean sombreada;

    public JavaFxGameTablero()
    {
        tablero = new JavaFxFicha[8][8];
        pane = new Pane();
        fichaMarcadaX = 0;
        fichaMarcadaY = 0;
        fichaMarcada = false;
        sombreada = false;
        setFichas();
    }

    public void setFichas(){
        for (Integer i=0; i<8;i++)
            for (Integer j=0; j<8;j++) {

                JavaFxFicha javaFxFicha = new JavaFxFicha(i, j, "");
                javaFxFicha.getButton().setOnMouseClicked(event -> {
                    moverFicha(javaFxFicha);
                });

                this.tablero[i][j] = javaFxFicha;
                pane.getChildren().add(javaFxFicha.getButton());
            }
        ArmarJuego();
    }

    public void ArmarJuego()
    {
        PiezasBlancas();
        PiezasNegras();
        SincronizarFichaBoton();
    }

    public void PiezasBlancas()
    {
        this.tablero[0][0].getButton().setText("Torre");
        this.tablero[0][1].getButton().setText("caballo");
        this.tablero[0][2].getButton().setText("Alfil");
        this.tablero[0][3].getButton().setText("Reina");
        this.tablero[0][4].getButton().setText("Rey");
        this.tablero[0][5].getButton().setText("Alfil");
        this.tablero[0][6].getButton().setText("caballo");
        this.tablero[0][7].getButton().setText("Torre");
        this.tablero[1][0].getButton().setText("peon");
        this.tablero[1][1].getButton().setText("peon");
        this.tablero[1][2].getButton().setText("peon");
        this.tablero[1][3].getButton().setText("peon");
        this.tablero[1][4].getButton().setText("peon");
        this.tablero[1][5].getButton().setText("peon");
        this.tablero[1][6].getButton().setText("peon");
        this.tablero[1][7].getButton().setText("peon");

        for (Integer i=0; i<2;i++)
            for (Integer j=0; j<8;j++) {
                this.tablero[i][j].setJugador("blanco");
            }

  }

    public void PiezasNegras()
    {
        this.tablero[7][0].getButton().setText("Torre");
        this.tablero[7][1].getButton().setText("caballo");
        this.tablero[7][2].getButton().setText("Alfil");
        this.tablero[7][3].getButton().setText("Reina");
        this.tablero[7][4].getButton().setText("Rey");
        this.tablero[7][5].getButton().setText("Alfil");
        this.tablero[7][6].getButton().setText("caballo");
        this.tablero[7][7].getButton().setText("Torre");
        this.tablero[6][0].getButton().setText("peon");
        this.tablero[6][1].getButton().setText("peon");
        this.tablero[6][2].getButton().setText("peon");
        this.tablero[6][3].getButton().setText("peon");
        this.tablero[6][4].getButton().setText("peon");
        this.tablero[6][5].getButton().setText("peon");
        this.tablero[6][6].getButton().setText("peon");
        this.tablero[6][7].getButton().setText("peon");

        for (Integer i=6; i<8;i++)
            for (Integer j=0; j<8;j++) {
                this.tablero[i][j].setJugador("negro");
            }
    }

    public void SincronizarFichaBoton()
    {
        for (Integer i=0; i<8;i++)
            for (Integer j=0; j<8;j++) {
                this.tablero[i][j].setIdFicha(this.tablero[i][j].getButton().getText());
            }

    }

     public void moverFicha(JavaFxFicha javaFxFicha){

        //int xNull = getFichaNull().getPosicionArregloY()/100;
        //int yNull = getFichaNull().getPosicionArregloX()/100;

        int x1 = javaFxFicha.getPosicionArregloY()/100;
        int y1 = javaFxFicha.getPosicionArregloX()/100;

          if(fichaMarcada == false)
          {
              fichaMarcadaX = x1;
              fichaMarcadaY = y1;
              fichaMarcada = tablero[x1][y1].BotonPresionado();
              if(javaFxFicha.getIdFicha() == "peon")
                {
                  MostrarJugada(x1,y1);
                }
          }
         else
              {
                  if (fichaMarcada == true && fichaMarcadaX == x1 && fichaMarcadaY == y1)
                  {
                      fichaMarcadaX = 10;
                      fichaMarcadaY = 10;
                      fichaMarcada = tablero[x1][y1].BotonPresionado();
                      sombreada = false;
                      RestaurarColores();
                  }
                  else
                  {
                      if(javaFxFicha.isSombreada())
                          Movimiento(javaFxFicha);
                      fichaMarcadaX = 10;
                      fichaMarcadaY = 10;
                      fichaMarcada = tablero[x1][y1].BotonPresionado();
                      sombreada = false;
                      RestaurarColores();

                  }
              }
          }

        public void Movimiento(JavaFxFicha javaFxFicha)
        {
            javaFxFicha.setIdFicha(this.tablero[fichaMarcadaX][fichaMarcadaY].getIdFicha());
            javaFxFicha.getButton().setText(this.tablero[fichaMarcadaX][fichaMarcadaY].getIdFicha());
            this.tablero[fichaMarcadaX][fichaMarcadaY].setIdFicha("");
            this.tablero[fichaMarcadaX][fichaMarcadaY].getButton().setText("");

        }
       /* if(MovePermitido(xNull,yNull,x1,y1))
         {
           String tempIdFicha =javaFxFicha.getIdFicha();

           JavaFxFicha fichanull = getFichaNull();
           fichanull.getButton().setText(String.valueOf(tempIdFicha));
           fichanull.setIdFicha(tempIdFicha);

           javaFxFicha.getButton().setText(null);
           javaFxFicha.setIdFicha(null);
         }*/


    public void MostrarJugada(int x, int y)
    {
        if(this.tablero[x][y].getJugador() == "blanco")
         {
            this.tablero[x + 1][y].Sombrear();
            this.tablero[x + 2][y].Sombrear();
         }
         else
        {
            this.tablero[x - 1][y].Sombrear();
            this.tablero[x - 2][y].Sombrear();

        }
        sombreada = true;
    }

    public void RestaurarColores()
    {
        for (Integer i=0; i<8;i++)
            for (Integer j=0; j<8;j++) {
                this.tablero[i][j].RestaurarColorFicha();
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