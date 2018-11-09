package contenedor;

import javafx.scene.layout.Pane;

public class JavaFxGameTablero {

    Pane pane;
    private Casilla tablero[][];
    private Hacker hacker;
    private Integer fichaMarcadaX;
    private Integer fichaMarcadaY;
    private boolean fichaMarcada;
    private boolean sombreada;
    private String turno;


    public JavaFxGameTablero()
    {
        tablero = new Casilla[8][8];
        hacker = new Hacker();
        pane = new Pane();
        fichaMarcadaX = 0;
        fichaMarcadaY = 0;
        fichaMarcada = false;
        sombreada = false;
        turno = "blanco";
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


     public void moverFicha(Casilla acasilla) {

         int x1 = acasilla.getPosicionArregloY() / 100;
         int y1 = acasilla.getPosicionArregloX() / 100;
         if(this.getTurno() != acasilla.getFicha().getJugador())
         if (fichaMarcada == false && tablero[x1][y1].getFicha().getIdFicha() != "")
         {
             fichaMarcadaX = x1;
             fichaMarcadaY = y1;
             fichaMarcada = tablero[x1][y1].BotonPresionado();
             MostrarJugada(x1,y1);
         }
         else
           {
             if (fichaMarcada == true && fichaMarcadaX == x1 && fichaMarcadaY == y1)
               {
                 fichaMarcadaX = null;
                 fichaMarcadaY = null ;
                 fichaMarcada = tablero[x1][y1].BotonPresionado();
                 RestaurarColores();
               }
               else
                 {
                   if (fichaMarcada == true && acasilla.isSombreada() == true)
                    {
                     Movimiento(tablero[x1][y1]);
                     fichaMarcada = false;
                     sombreada = false;
                     RestaurarColores();
                     fichaMarcadaX = null;
                     fichaMarcadaY = null;
                   }
                }
           }
     }
        public void Movimiento(Casilla acasilla)
        {
            if(acasilla.isSombreada())
            {
                ActualizarTablaFichas(acasilla);
                acasilla.setFicha(this.tablero[fichaMarcadaX][fichaMarcadaY].getFicha());
                acasilla.getButton().setText(acasilla.getFicha().getIdFicha());
                this.tablero[fichaMarcadaX][fichaMarcadaY].getButton().setText("");
                this.tablero[fichaMarcadaX][fichaMarcadaY].setFicha(new JavaFxFicha());
                this.setTurno(acasilla.getFicha().getJugador());
                RestaurarColores();

                hacker.RellenarListaJugadaHacker(acasilla.getPosicionArregloX(),acasilla.getPosicionArregloY(),acasilla.getFicha().getIdFicha()
                                    ,acasilla.getFicha().getJugador());
            }

        }

    public void MostrarJugada(int x, int y)
    {
        if(this.tablero[x][y].getFicha().getIdFicha() == "peon")
            MovimientoPeon(x,y);
        if(this.tablero[x][y].getFicha().getIdFicha() == "Torre")
            MovimientoTorre(x,y);
        if(this.tablero[x][y].getFicha().getIdFicha() == "Alfil")
            MovimientoAlfil(x,y);
        if(this.tablero[x][y].getFicha().getIdFicha() == "Reina")
        {
            MovimientoAlfil(x,y);
            MovimientoTorre(x,y);
        }
        if(this.tablero[x][y].getFicha().getIdFicha() == "Rey")
            MovimientoRey(x,y);
        if(this.tablero[x][y].getFicha().getIdFicha() == "caballo")
            MovimientoCaballo(x,y);
    }

    public  void MovimientoCaballo(int x, int y)
    {
        if(x+1 < 8 && y+2 < 8)
           this.tablero[x+1][y+2].Sombrear(this.tablero[x][y].getFicha().getJugador());
        if(x+1 < 8 && y-2 >= 0)
            this.tablero[x+1][y-2].Sombrear(this.tablero[x][y].getFicha().getJugador());
        if(x+2 < 8 && y+1 < 8)
            this.tablero[x+2][y+1].Sombrear(this.tablero[x][y].getFicha().getJugador());
        if(x+2 < 8 && y-1 >= 0)
            this.tablero[x+2][y-1].Sombrear(this.tablero[x][y].getFicha().getJugador());

        if(x-1 >= 0 && y+2 < 8)
            this.tablero[x-1][y+2].Sombrear(this.tablero[x][y].getFicha().getJugador());
        if(x-1 >= 0 && y-2 >= 0)
            this.tablero[x-1][y-2].Sombrear(this.tablero[x][y].getFicha().getJugador());
        if(x-2 >= 0 && y+1 < 8)
            this.tablero[x-2][y+1].Sombrear(this.tablero[x][y].getFicha().getJugador());
        if(x-2 >= 0 && y-1 >= 0)
            this.tablero[x-2][y-1].Sombrear(this.tablero[x][y].getFicha().getJugador());
    }

    public void MovimientoRey(int x, int y)
    {
        if(x+1<8)
        {
            if(this.tablero[x+1][y].getFicha().getIdFicha() == "" ||
                (this.tablero[x+1][y].getFicha().getIdFicha() != "" &&
                        this.tablero[x+1][y].getFicha().getJugador() != this.tablero[x][y].getFicha().getJugador()))
               this.tablero[x+1][y].Sombrear(this.tablero[x][y].getFicha().getJugador());
        }
        if(y+1<8)
        {
            if(this.tablero[x][y+1].getFicha().getIdFicha() == "" ||
                    (this.tablero[x][y+1].getFicha().getIdFicha() != "" &&
                            this.tablero[x][y+1].getFicha().getJugador() != this.tablero[x][y].getFicha().getJugador()))
                this.tablero[x][y+1].Sombrear(this.tablero[x][y].getFicha().getJugador());
        }
        if(x-1>=0 )
          {
            if (this.tablero[x - 1][y].getFicha().getIdFicha() == "" ||
                    (this.tablero[x - 1][y].getFicha().getIdFicha() != "" &&
                            this.tablero[x - 1][y].getFicha().getJugador() != this.tablero[x][y].getFicha().getJugador()))
                this.tablero[x - 1][y].Sombrear(this.tablero[x][y].getFicha().getJugador());
          }
          if(y-1>=0)
          {
              if(this.tablero[x][y-1].getFicha().getIdFicha() == "" ||
                      (this.tablero[x][y-1].getFicha().getIdFicha() != "" &&
                              this.tablero[x][y-1].getFicha().getJugador() != this.tablero[x][y].getFicha().getJugador()))
                   this.tablero[x][y-1].Sombrear(this.tablero[x][y].getFicha().getJugador());
          }
        if(x+1 < 8 && y+1 < 8)
        {
            if(this.tablero[x+1][y+1].getFicha().getIdFicha() == "" ||
                    (this.tablero[x+1][y+1].getFicha().getIdFicha() != "" &&
                            this.tablero[x+1][y+1].getFicha().getJugador() != this.tablero[x][y].getFicha().getJugador()))
                this.tablero[x+1][y+1].Sombrear(this.tablero[x][y].getFicha().getJugador());
        }
        if(x+1 < 8 && y-1 >= 0)
        {
            if(this.tablero[x+1][y-1].getFicha().getIdFicha() == "" ||
                    (this.tablero[x+1][y-1].getFicha().getIdFicha() != "" &&
                            this.tablero[x+1][y-1].getFicha().getJugador() != this.tablero[x][y].getFicha().getJugador()))
                this.tablero[x+1][y-1].Sombrear(this.tablero[x][y].getFicha().getJugador());
        }
        if(x-1 >= 0 && y+1 < 8)
        {
            if(this.tablero[x-1][y+1].getFicha().getIdFicha() == "" ||
                    (this.tablero[x-1][y+1].getFicha().getIdFicha() != "" &&
                            this.tablero[x-1][y+1].getFicha().getJugador() != this.tablero[x][y].getFicha().getJugador()))
                this.tablero[x-1][y+1].Sombrear(this.tablero[x][y].getFicha().getJugador());
        }
        if(x-1 >= 0 && y-1 >= 0)
        {
            if(this.tablero[x-1][y-1].getFicha().getIdFicha() == "" ||
                    (this.tablero[x-1][y-1].getFicha().getIdFicha() != "" &&
                            this.tablero[x-1][y-1].getFicha().getJugador() != this.tablero[x][y].getFicha().getJugador()))
                this.tablero[x-1][y-1].Sombrear(this.tablero[x][y].getFicha().getJugador());
        }

    }

    public void MovimientoAlfil(int x, int y)
    {
        boolean bandera = false;
        int i = 1;
        while (!bandera && x+i < 8 && y+i < 8)
         {
            if(this.tablero[x+i][y+i].getFicha().getIdFicha() == "" ||(
                this.tablero[x+i][y+i].getFicha().getJugador() != "" &&
                        this.tablero[x+i][y+i].getFicha().getJugador() != this.tablero[x][y].getFicha().getJugador()))
               {
                this.tablero[x+i][y+i].Sombrear(this.tablero[x][y].getFicha().getJugador());
                if(this.tablero[x+i][y+i].getFicha().getJugador() != this.tablero[x][y].getFicha().getJugador()&&
                       this.tablero[x+i][y+i].getFicha().getJugador() != ""  )
                         bandera = true;
                i++;
               }
             else
               bandera = true;

         }
        bandera = false;
        i = 1;
        while (!bandera && x-i >=0 && y+i < 8)
        {
            if(this.tablero[x-i][y+i].getFicha().getIdFicha() == "" ||(
                    this.tablero[x-i][y+i].getFicha().getJugador() != "" &&
                            this.tablero[x-i][y+i].getFicha().getJugador() != this.tablero[x][y].getFicha().getJugador()))
               {
                this.tablero[x - i][y + i].Sombrear(this.tablero[x][y].getFicha().getJugador());
                   if(this.tablero[x-i][y+i].getFicha().getJugador() != this.tablero[x][y].getFicha().getJugador()&&
                           this.tablero[x-i][y+i].getFicha().getJugador() != ""  )
                       bandera = true;
                i++;
               }
            else
                bandera = true;
        }
        bandera = false;
        i = 1;
        while (!bandera && x+i < 8 && y-i >= 0)
        {
            if(this.tablero[x+i][y-i].getFicha().getIdFicha() == "" ||(
                    this.tablero[x+i][y-i].getFicha().getJugador() != "" &&
                            this.tablero[x+i][y-i].getFicha().getJugador() != this.tablero[x][y].getFicha().getJugador()))
            {
                this.tablero[x+i][y-i].Sombrear(this.tablero[x][y].getFicha().getJugador());
                if(this.tablero[x+i][y-i].getFicha().getJugador() != this.tablero[x][y].getFicha().getJugador()&&
                        this.tablero[x+i][y-i].getFicha().getJugador() != ""  )
                    bandera = true;
                i++;
            }
            else
                bandera = true;
        }
        i = 1;
        bandera = false;
        while (!bandera && x-i >= 0 && y-i >= 0)
        {
            if(this.tablero[x-i][y-i].getFicha().getIdFicha() == "" ||(
                    this.tablero[x-i][y-i].getFicha().getJugador() != "" &&
                            this.tablero[x-i][y-i].getFicha().getJugador() != this.tablero[x][y].getFicha().getJugador()))
            {
                this.tablero[x-i][y-i].Sombrear(this.tablero[x][y].getFicha().getJugador());

                if(this.tablero[x-i][y-i].getFicha().getJugador() != this.tablero[x][y].getFicha().getJugador()&&
                        this.tablero[x-i][y-i].getFicha().getJugador() != ""  )
                    bandera = true;i++;
            }
            else
                bandera = true;
      }
    }

    public void MovimientoTorre(Integer x, Integer y)
    {
        for(int i = x+1 ; i < 8; i++)
        {
            if(this.tablero[i][y].getFicha().getIdFicha() == "" ||(
               this.tablero[i][y].getFicha().getJugador() != "" &&
                  this.tablero[i][y].getFicha().getJugador() != this.tablero[x][y].getFicha().getJugador()))
                {
                this.tablero[i][y].Sombrear(this.tablero[x][y].getFicha().getJugador());

                if(this.tablero[i][y].getFicha().getJugador() != "" &&
                       this.tablero[i][y].getFicha().getJugador() != this.tablero[x][y].getFicha().getJugador())
               {
                   break;
               }
                }
            else
                break;
        }
        for(int i = y+1 ; i < 8; i++)
        {
            if(this.tablero[x][i].getFicha().getIdFicha() == "" ||(
                    this.tablero[x][i].getFicha().getJugador() != "" &&
                            this.tablero[x][i].getFicha().getJugador() != this.tablero[x][y].getFicha().getJugador()))
            {
                this.tablero[x][i].Sombrear(this.tablero[x][y].getFicha().getJugador());
                if(this.tablero[x][i].getFicha().getJugador() != "" &&
                        this.tablero[x][i].getFicha().getJugador() != this.tablero[x][y].getFicha().getJugador())
                       break;
            }
            else
                break;
        }

        for(int i = x-1 ; i >=0; i--)
        {
            if(this.tablero[i][y].getFicha().getIdFicha() == ""||(
                    this.tablero[i][y].getFicha().getJugador() != "" &&
                            this.tablero[i][y].getFicha().getJugador() != this.tablero[x][y].getFicha().getJugador()))
            {
                this.tablero[i][y].Sombrear(this.tablero[x][y].getFicha().getJugador());
                if(this.tablero[i][y].getFicha().getJugador() != "" &&
                    this.tablero[i][y].getFicha().getJugador() != this.tablero[x][y].getFicha().getJugador())
                break;
            }
            else
                break;
        }
        for(int i = y-1 ; i >=0; i--)
        {
            if(this.tablero[x][i].getFicha().getIdFicha() == "" ||(
                    this.tablero[x][i].getFicha().getJugador() != "" &&
                            this.tablero[x][i].getFicha().getJugador() != this.tablero[x][y].getFicha().getJugador()))
            {
                this.tablero[x][i].Sombrear(this.tablero[x][y].getFicha().getJugador());
                if (this.tablero[x][i].getFicha().getJugador() != "" &&
                        this.tablero[x][i].getFicha().getJugador() != this.tablero[x][y].getFicha().getJugador())
                    break;
            }
                else
                break;
        }
    }

    public void MovimientoPeon(int x, int y)
    {
        if(this.tablero[x][y].getFicha().getJugador() == "blanco")
        {
            if(x+1<8)
            {
                this.tablero[x + 1][y].Sombrear("blanco");
               // this.tablero[x + 2][y].Sombrear("blanco");
                if(y+1 <8 && this.tablero[x + 1][y+1].getFicha().getJugador() == "negro"
                    && this.tablero[x + 1][y+1].getFicha().getIdFicha() != ""
                        )
                {
                    this.tablero[x + 1][y+1].Sombrear("blanco");
                }
                if(y-1 >=0 && this.tablero[x + 1][y-1].getFicha().getJugador() == "negro"
                        && this.tablero[x + 1][y-1].getFicha().getIdFicha() != ""
                        )
                {
                    this.tablero[x + 1][y-1].Sombrear("blanco");
                }
            }
        }
        else
        {
            if(x-1>= 0)
            {
            this.tablero[x - 1][y].Sombrear("negro");
            //this.tablero[x - 2][y].Sombrear("negro");

                if(y+1 <8 && this.tablero[x - 1][y+1].getFicha().getJugador() == "blanco"
                        && this.tablero[x - 1][y+1].getFicha().getIdFicha() != ""
                        )
                {
                    this.tablero[x - 1][y+1].Sombrear("negro");
                }
                if(y-1 >=0 && this.tablero[x - 1][y-1].getFicha().getJugador() == "blanco"
                        && this.tablero[x - 1][y-1].getFicha().getIdFicha() != ""
                        )
                {
                    this.tablero[x - 1][y-1].Sombrear("negro");
                }

            }

        }
        sombreada = true;
    }

    public void RestaurarColores()
    {
        for (Integer i=0; i<8;i++)
            for (Integer j=0; j<8;j++) {
                this.tablero[i][j].RestaurarColorCasilla();
                this.tablero[i][j].setCambioColor(false);
                this.tablero[i][j].setSombreada(false);
            }
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

    public String getTurno() {
        return turno;
    }

    public void setTurno(String jugador) {
        this.turno = jugador;
    }

    public void ActualizarTablaFichas(Casilla aCasilla)
    {
        String fichaEliminar = aCasilla.getFicha().getIdFicha();
        String jugador = aCasilla.getFicha().getJugador();
        if(jugador == "blanco")
        {
            hacker.EliminarFichaBlanca(fichaEliminar);
        }
        if(jugador == "negro")
        {
            hacker.EliminarFichaNegras(fichaEliminar);
        }
    }
}