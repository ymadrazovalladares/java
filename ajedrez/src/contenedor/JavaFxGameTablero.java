package contenedor;

import javafx.scene.layout.Pane;

public class JavaFxGameTablero {

    Pane pane;
    Casilla tablero[][];
    private int fichaMarcadaX;
    private int fichaMarcadaY;
    private boolean fichaMarcada;
    private boolean sombreada;

    public JavaFxGameTablero()
    {
        tablero = new Casilla[8][8];
        pane = new Pane();
        fichaMarcadaX = 0;
        fichaMarcadaY = 0;
        fichaMarcada = false;
        sombreada = false;
        setCasilla();
    }

    public void setCasilla(){
        for (Integer i=0; i<8;i++)
            for (Integer j=0; j<8;j++) {

                Casilla acasilla = new Casilla(i, j, "");
                acasilla.getButton().setOnMouseClicked(event -> {
                    moverFicha(acasilla);
                });

                this.tablero[i][j] = acasilla;
                pane.getChildren().add(acasilla.getButton());
            }
        ArmarJuego();
    }

    public void ArmarJuego()
    {
        PiezasBlancas();
        PiezasNegras();
    }

    public void PiezasBlancas()
    {
        this.tablero[0][0].addIdFicha("Torre","blanco");
        this.tablero[0][1].addIdFicha("caballo","blanco");
        this.tablero[0][2].addIdFicha("Alfil","blanco");
        this.tablero[0][3].addIdFicha("Reina","blanco");
        this.tablero[0][4].addIdFicha("Rey","blanco");
        this.tablero[0][5].addIdFicha("Alfil","blanco");
        this.tablero[0][6].addIdFicha("caballo","blanco");
        this.tablero[0][7].addIdFicha("Torre","blanco");
        this.tablero[1][0].addIdFicha("peon","blanco");
        this.tablero[1][1].addIdFicha("peon","blanco");
        this.tablero[1][2].addIdFicha("peon","blanco");
        this.tablero[1][3].addIdFicha("peon","blanco");
        this.tablero[1][4].addIdFicha("peon","blanco");
        this.tablero[1][5].addIdFicha("peon","blanco");
        this.tablero[1][6].addIdFicha("peon","blanco");
        this.tablero[1][7].addIdFicha("peon","blanco");

  }

    public void PiezasNegras()
    {
        this.tablero[7][0].addIdFicha("Torre","negro");
        this.tablero[7][1].addIdFicha("caballo","negro");
        this.tablero[7][2].addIdFicha("Alfil","negro");
        this.tablero[7][3].addIdFicha("Reina","negro");
        this.tablero[7][4].addIdFicha("Rey","negro");
        this.tablero[7][5].addIdFicha("Alfil","negro");
        this.tablero[7][6].addIdFicha("caballo","negro");
        this.tablero[7][7].addIdFicha("Torre","negro");
        this.tablero[6][0].addIdFicha("peon","negro");
        this.tablero[6][1].addIdFicha("peon","negro");
        this.tablero[6][2].addIdFicha("peon","negro");
        this.tablero[6][3].addIdFicha("peon","negro");
        this.tablero[6][4].addIdFicha("peon","negro");
        this.tablero[6][5].addIdFicha("peon","negro");
        this.tablero[6][6].addIdFicha("peon","negro");
        this.tablero[6][7].addIdFicha("peon","negro");

    }


     public void moverFicha(Casilla acasilla){

        int x1 = acasilla.getPosicionArregloY()/100;
        int y1 = acasilla.getPosicionArregloX()/100;

          if(fichaMarcada == false)
          {
              fichaMarcadaX = x1;
              fichaMarcadaY = y1;
              fichaMarcada = tablero[x1][y1].BotonPresionado();

              /*if(acasilla.getIdFicha() == "peon")
                {
                 // MostrarJugada(x1,y1);
                }*/
          }
          else
          {
              if (fichaMarcada == true && fichaMarcadaX == x1 && fichaMarcadaY == y1)
              {
                  fichaMarcadaX = 10;
                  fichaMarcadaY = 10;
                  fichaMarcada = tablero[x1][y1].BotonPresionado();
                  tablero[x1][y1].RestaurarColorCasilla();
              }
          }
        /* else
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
                      if(acasilla.isSombreada())
                          Movimiento(acasilla);
                      fichaMarcadaX = 10;
                      fichaMarcadaY = 10;
                      fichaMarcada = tablero[x1][y1].BotonPresionado();
                      sombreada = false;
                      RestaurarColores();

                  }
              }*/
          }

        public void Movimiento(Casilla acasilla)
        {
            /*acasilla.setIdFicha(this.tablero[fichaMarcadaX][fichaMarcadaY].getIdFicha());
            acasilla.getButton().setText(this.tablero[fichaMarcadaX][fichaMarcadaY].getIdFicha());
            this.tablero[fichaMarcadaX][fichaMarcadaY].setIdFicha("");
            this.tablero[fichaMarcadaX][fichaMarcadaY].getButton().setText("");
*/
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
       /* if(this.tablero[x][y].getJugador() == "blanco")
         {
            this.tablero[x + 1][y].Sombrear();
            this.tablero[x + 2][y].Sombrear();
         }
         else
        {
            this.tablero[x - 1][y].Sombrear();
            this.tablero[x - 2][y].Sombrear();

        }
        sombreada = true;*/
    }

    public void RestaurarColores()
    {
        for (Integer i=0; i<8;i++)
            for (Integer j=0; j<8;j++) {
                this.tablero[i][j].RestaurarColorCasilla();
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

    public Casilla[][] getTablero() {
        return tablero;
    }

    public void setTablero(Casilla[][] tablero) {
        this.tablero = tablero;
    }
}