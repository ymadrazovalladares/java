package contenedor;

import javafx.scene.control.Button;
import javafx.scene.control.Dialog;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class JavaFxGameTablero {

    private Pane pane;
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
                    if(this.getTurno() != acasilla.getFicha().getJugador() ||acasilla.isSombreada() == true)
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
        this.tablero[0][0].addIdFicha("torre1","blanco", "torreB");
        this.tablero[0][1].addIdFicha("caballo1","blanco","caballoB");
        this.tablero[0][2].addIdFicha("alfil1","blanco", "alfilB");
        this.tablero[0][3].addIdFicha("reina","blanco","reinaB");
        this.tablero[0][4].addIdFicha("rey","blanco","reyB");
        this.tablero[0][5].addIdFicha("alfil2","blanco","alfilB");
        this.tablero[0][6].addIdFicha("caballo2","blanco","caballoB");
        this.tablero[0][7].addIdFicha("torre2","blanco","torreB");
        this.tablero[1][0].addIdFicha("peon1","blanco","peonB");
        this.tablero[1][1].addIdFicha("peon2","blanco","peonB");
        this.tablero[1][2].addIdFicha("peon3","blanco","peonB");
        this.tablero[1][3].addIdFicha("peon4","blanco","peonB");
        this.tablero[1][4].addIdFicha("peon5","blanco","peonB");
        this.tablero[1][5].addIdFicha("peon6","blanco","peonB");
        this.tablero[1][6].addIdFicha("peon7","blanco","peonB");
        this.tablero[1][7].addIdFicha("peon8","blanco","peonB");

  }

    public void PiezasNegras()
    {
        this.tablero[7][0].addIdFicha("torre1","negro","torre");
        this.tablero[7][1].addIdFicha("caballo1","negro","caballo");
        this.tablero[7][2].addIdFicha("alfil1","negro", "alfil");
        this.tablero[7][3].addIdFicha("reina","negro", "reina");
        this.tablero[7][4].addIdFicha("rey","negro","rey");
        this.tablero[7][5].addIdFicha("alfil2","negro","alfil");
        this.tablero[7][6].addIdFicha("caballo2","negro","caballo");
        this.tablero[7][7].addIdFicha("torre2","negro","torre");
        this.tablero[6][0].addIdFicha("peon1","negro","peon");
        this.tablero[6][1].addIdFicha("peon2","negro","peon");
        this.tablero[6][2].addIdFicha("peon3","negro","peon");
        this.tablero[6][3].addIdFicha("peon4","negro","peon");
        this.tablero[6][4].addIdFicha("peon5","negro","peon");
        this.tablero[6][5].addIdFicha("peon6","negro","peon");
        this.tablero[6][6].addIdFicha("peon7","negro","peon");
        this.tablero[6][7].addIdFicha("peon8","negro","peon");

    }


     public void moverFicha(Casilla acasilla) {

         int x1 = acasilla.getPosicionArregloY() / 100;
         int y1 = acasilla.getPosicionArregloX() / 100;
         //if(this.getTurno() != acasilla.getFicha().getJugador())
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
                     RevisarHacker();
                   }
                }
           }
        // RevisarHacker();
     }
        public void Movimiento(Casilla acasilla)
        {
           /* Image image = new Image(getClass().getResourceAsStream("peon.png"));
            Button temp = new Button();
            temp.setGraphic(this.tablero[fichaMarcadaX][fichaMarcadaY].getButton().getGraphic());
            */
          if(acasilla.isSombreada())
            {
                LimpiarTablaFichas(GetCasilla(fichaMarcadaX, fichaMarcadaY));
                acasilla.setFicha(this.tablero[fichaMarcadaX][fichaMarcadaY].getFicha());

               // acasilla.getButton().setText(acasilla.getFicha().getIdFicha());
                acasilla.getButton().setGraphic(this.tablero[fichaMarcadaX][fichaMarcadaY].getButton().getGraphic());

                this.tablero[fichaMarcadaX][fichaMarcadaY].getButton().setGraphic(new ImageView());

                this.tablero[fichaMarcadaX][fichaMarcadaY].setFicha(new JavaFxFicha());
                this.setTurno(acasilla.getFicha().getJugador());
                RestaurarColores();
                ActualizarTablaFichas(acasilla);
          }
  }

    public void MostrarJugada(int x, int y)
    {
        if(this.tablero[x][y].getFicha().getIdFicha().contains("peon"))
          MovimientoPeon(x,y);
        if(this.tablero[x][y].getFicha().getIdFicha().contains("torre"))
            MovimientoTorre(x,y);
        if(this.tablero[x][y].getFicha().getIdFicha().contains("alfil"))
            MovimientoAlfil(x,y);
        if(this.tablero[x][y].getFicha().getIdFicha().contains("reina"))
        {
            MovimientoAlfil(x,y);
            MovimientoTorre(x,y);
        }
        if(this.tablero[x][y].getFicha().getIdFicha().contains("rey"))
            MovimientoRey(x,y);
        if(this.tablero[x][y].getFicha().getIdFicha().contains("caballo"))
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
                if(hacker.IsReyHacker(y,x+1,getTurno()) == false)
                  this.tablero[x+1][y].Sombrear(this.tablero[x][y].getFicha().getJugador());
        }
        if(y+1<8)
        {
            if(this.tablero[x][y+1].getFicha().getIdFicha() == "" ||
                    (this.tablero[x][y+1].getFicha().getIdFicha() != "" &&
                            this.tablero[x][y+1].getFicha().getJugador() != this.tablero[x][y].getFicha().getJugador()))
                if(hacker.IsReyHacker(y+1,x,getTurno()) == false)
                  this.tablero[x][y+1].Sombrear(this.tablero[x][y].getFicha().getJugador());
        }
        if(x-1>=0 )
          {
            if (this.tablero[x - 1][y].getFicha().getIdFicha() == "" ||
                    (this.tablero[x - 1][y].getFicha().getIdFicha() != "" &&
                            this.tablero[x - 1][y].getFicha().getJugador() != this.tablero[x][y].getFicha().getJugador()))
                if(hacker.IsReyHacker(y,x-1,getTurno()) == false)
                  this.tablero[x - 1][y].Sombrear(this.tablero[x][y].getFicha().getJugador());
          }
          if(y-1>=0)
          {
              if(this.tablero[x][y-1].getFicha().getIdFicha() == "" ||
                      (this.tablero[x][y-1].getFicha().getIdFicha() != "" &&
                              this.tablero[x][y-1].getFicha().getJugador() != this.tablero[x][y].getFicha().getJugador()))
                   if(hacker.IsReyHacker(y-1,x,getTurno()) == false)
                      this.tablero[x][y-1].Sombrear(this.tablero[x][y].getFicha().getJugador());
          }
        if(x+1 < 8 && y+1 < 8)
        {
            if(this.tablero[x+1][y+1].getFicha().getIdFicha() == "" ||
                    (this.tablero[x+1][y+1].getFicha().getIdFicha() != "" &&
                            this.tablero[x+1][y+1].getFicha().getJugador() != this.tablero[x][y].getFicha().getJugador()))
                if(hacker.IsReyHacker(y+1,x+1,getTurno()) == false)
                  this.tablero[x+1][y+1].Sombrear(this.tablero[x][y].getFicha().getJugador());
        }
        if(x+1 < 8 && y-1 >= 0)
        {
            if(this.tablero[x+1][y-1].getFicha().getIdFicha() == "" ||
                    (this.tablero[x+1][y-1].getFicha().getIdFicha() != "" &&
                            this.tablero[x+1][y-1].getFicha().getJugador() != this.tablero[x][y].getFicha().getJugador()))
                if(hacker.IsReyHacker(y-1,x+1,getTurno()) == false)
                   this.tablero[x+1][y-1].Sombrear(this.tablero[x][y].getFicha().getJugador());
        }
        if(x-1 >= 0 && y+1 < 8)
        {
            if(this.tablero[x-1][y+1].getFicha().getIdFicha() == "" ||
                    (this.tablero[x-1][y+1].getFicha().getIdFicha() != "" &&
                            this.tablero[x-1][y+1].getFicha().getJugador() != this.tablero[x][y].getFicha().getJugador()))
                if(hacker.IsReyHacker(y+1,x-1,getTurno()) == false)
                   this.tablero[x-1][y+1].Sombrear(this.tablero[x][y].getFicha().getJugador());
        }
        if(x-1 >= 0 && y-1 >= 0)
        {
            if(this.tablero[x-1][y-1].getFicha().getIdFicha() == "" ||
                    (this.tablero[x-1][y-1].getFicha().getIdFicha() != "" &&
                            this.tablero[x-1][y-1].getFicha().getJugador() != this.tablero[x][y].getFicha().getJugador()))
                if(hacker.IsReyHacker(y-1,x-1,getTurno()) == false)
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

    public void EliminarTablaFichas()
    {
        String fichaEliminar = tablero[fichaMarcadaX][fichaMarcadaY].getFicha().getIdFicha();
        String jugador = tablero[fichaMarcadaX][fichaMarcadaY].getFicha().getJugador();
        if(jugador == "blanco")
        {
            hacker.EliminarFichaBlanca(fichaEliminar);
        }
        if(jugador == "negro")
        {
            hacker.EliminarFichaNegras(fichaEliminar);
        }
    }

    public void LimpiarTablaFichas(Casilla aCasilla)
    {
        String fichaActualizar = aCasilla.getFicha().getIdFicha();
        String jugador = aCasilla.getFicha().getJugador();
        if(jugador == "blanco")
            hacker.LimpiarPosicionesFichaBlanca(fichaActualizar);
        if(jugador == "negro")
            hacker.LimpiarPosicionesFichaNegra(fichaActualizar);

       // hacker.RellenarListaJugadaHacker(aCasilla.getPosicionArregloX()/100,aCasilla.getPosicionArregloY()/100,fichaActualizar, jugador, tablero);
    }
    public void ActualizarTablaFichas(Casilla aCasilla)
    {
        String fichaActualizar = aCasilla.getFicha().getIdFicha();
        String jugador = aCasilla.getFicha().getJugador();
        LimpiarTablaFichas(aCasilla);
        hacker.RellenarListaJugadaHacker(aCasilla.getPosicionArregloX()/100,aCasilla.getPosicionArregloY()/100,fichaActualizar, jugador, tablero);
    }

    public Casilla CasillaRey(String jugador)
    {
        for(int i = 0; i < 8; i++)
        {
            for(int j = 0; j < 8; j++)
            {
                if(tablero[i][j].getFicha().getIdFicha() == "rey" && tablero[i][j].getFicha().getJugador() == jugador)
                    return tablero[i][j];
            }
        }
        return null;
    }
    public void RevisarHacker()
    {
        Casilla temp = new Casilla();
        boolean isHacker = false;
        if(getTurno() == "negro")
        {
            temp = CasillaRey("blanco");
            isHacker = hacker.IsReyBlancoHacker(temp.getPosicionArregloX()/100, temp.getPosicionArregloY()/100);
        }
        if(getTurno() == "blanco")
        {
            temp = CasillaRey("negro");
            isHacker = hacker.IsReyNegroHacker(temp.getPosicionArregloX()/100, temp.getPosicionArregloY()/100);
        }
        if(isHacker)
            tablero[temp.getPosicionArregloY()/100][temp.getPosicionArregloX()/100].ColorHacker();
    }

    public Casilla GetCasilla(int x, int y)
    {
        return tablero[x][y];
    }
}