package contenedor;

public class Hacker {
    private ListaPosicionHacker[] hackerBlanco;
    private ListaPosicionHacker[] hackerNegro;
    private Integer cantFichasBlancas;
    private Integer cantFichasNegras;

    public Hacker() {
        cantFichasBlancas =16;
        cantFichasNegras = 16;
        hackerBlanco = new ListaPosicionHacker[cantFichasBlancas];
        hackerNegro = new ListaPosicionHacker[cantFichasNegras];
    }

    public ListaPosicionHacker[] getHackerBlanco() {
        return hackerBlanco;
    }

    public void setHackerBlanco(ListaPosicionHacker[] hackerBlanco) {
        this.hackerBlanco = hackerBlanco;
    }

    public ListaPosicionHacker[] getHackerNegro() {
        return hackerNegro;
    }

    public void setHackerNegro(ListaPosicionHacker[] hackerNegro) {
        this.hackerNegro = hackerNegro;
    }

    public Integer getCantFichasBlancas() {
        return cantFichasBlancas;
    }

    public void setCantFichasBlancas(Integer cantFichasBlancas) {
        this.cantFichasBlancas = cantFichasBlancas;
    }

    public Integer getCantFichasNegras() {
        return cantFichasNegras;
    }

    public void setCantFichasNegras(Integer cantFichasNegras) {
        this.cantFichasNegras = cantFichasNegras;
    }

    public void EliminarFichaBlanca(String idFicha)
    {
        int contador = 0;
        for(int i = 0; i < cantFichasBlancas - contador ; i++)
        {
            if(idFicha == hackerBlanco[i].getNombreFicha())
            {
                contador++;
            }
            hackerBlanco[i] = hackerBlanco[i+contador];
        }
        cantFichasBlancas--;
    }
    public void EliminarFichaNegras(String idFicha)
    {
        int contador = 0;
        for(int i = 0; i < cantFichasNegras - contador ; i++)
        {
            if(idFicha == hackerNegro[i].getNombreFicha())
            {
                contador++;
            }
            hackerNegro[i] = hackerNegro[i+contador];
        }
        cantFichasNegras--;
    }

    public void AddCasillasHackerBlancas(String idFicha, PosicionHacker aPosocion)
    {
        for(int i = 0; i < cantFichasBlancas ; i++)
        {
            if(idFicha == hackerBlanco[i].getNombreFicha())
            {
                hackerBlanco[i].cargarAlFinaldeLaLista(aPosocion);
            }
         }
    }

    public void AddCasillasHackerNegras(String idFicha, PosicionHacker aPosocion)
    {
        for(int i = 0; i < cantFichasNegras ; i++)
        {
            if(idFicha == hackerNegro[i].getNombreFicha())
            {
                hackerNegro[i].cargarAlFinaldeLaLista(aPosocion);
            }
        }
    }

   //////////////arreglar///////////////
   public void RellenarListaJugadaHacker(int x, int y, String ficha, String jugador)
   {
       if(ficha == "peon")
           MovimientoPeon(x,y,jugador,ficha);
       if(ficha == "Torre")
           MovimientoTorre(x,y,jugador,ficha);
       if(ficha == "Alfil")
           MovimientoAlfil(x,y,jugador,ficha);
       if(ficha == "Reina")
       {
           MovimientoAlfil(x,y,jugador,ficha);
           MovimientoTorre(x,y,jugador,ficha);
       }
       if(ficha == "Rey")
           MovimientoRey(x,y,jugador,ficha);
       if(ficha == "caballo")
           MovimientoCaballo(x,y,jugador, ficha);
   }

    public  void MovimientoCaballo(int x, int y,String jugador,String aficha)
    {
        PosicionHacker aux = new PosicionHacker();
        if(x+1 < 8 && y+2 < 8) {
            aux = new PosicionHacker(x+1,y+2);
            if(jugador == "blanco")
                hackerBlanco[GetIndiceBlanco(aficha)].cargarAlFinaldeLaLista(aux);
            else
                hackerNegro[GetIndiceNegro(aficha)].cargarAlFinaldeLaLista(aux);
        }
        if(x+1 < 8 && y-2 >= 0)
        {
            aux = new PosicionHacker(x+1,y-2);
            if(jugador == "blanco")
                hackerBlanco[GetIndiceBlanco(aficha)].cargarAlFinaldeLaLista(aux);
            else
                hackerNegro[GetIndiceNegro(aficha)].cargarAlFinaldeLaLista(aux);
        }
        if(x+2 < 8 && y+1 < 8)
        {
            aux = new PosicionHacker(x+2,y+1);
            if(jugador == "blanco")
                hackerBlanco[GetIndiceBlanco(aficha)].cargarAlFinaldeLaLista(aux);
            else
                hackerNegro[GetIndiceNegro(aficha)].cargarAlFinaldeLaLista(aux);
        }
        if(x+2 < 8 && y-1 >= 0)
        {
            aux = new PosicionHacker(x+2,y-1);
            if(jugador == "blanco")
                hackerBlanco[GetIndiceBlanco(aficha)].cargarAlFinaldeLaLista(aux);
            else
                hackerNegro[GetIndiceNegro(aficha)].cargarAlFinaldeLaLista(aux);
        }
        if(x-1 >= 0 && y+2 < 8)
        {
            aux = new PosicionHacker(x-1,y+2);
            if(jugador == "blanco")
                hackerBlanco[GetIndiceBlanco(aficha)].cargarAlFinaldeLaLista(aux);
            else
                hackerNegro[GetIndiceNegro(aficha)].cargarAlFinaldeLaLista(aux);
        }
        if(x-1 >= 0 && y-2 >= 0)
        {
            aux = new PosicionHacker(x-1,y-2);
            if(jugador == "blanco")
                hackerBlanco[GetIndiceBlanco(aficha)].cargarAlFinaldeLaLista(aux);
            else
                hackerNegro[GetIndiceNegro(aficha)].cargarAlFinaldeLaLista(aux);
        }
        if(x-2 >= 0 && y+1 < 8)
        {
            aux = new PosicionHacker(x-2,y+1);
            if(jugador == "blanco")
                hackerBlanco[GetIndiceBlanco(aficha)].cargarAlFinaldeLaLista(aux);
            else
                hackerNegro[GetIndiceNegro(aficha)].cargarAlFinaldeLaLista(aux);
        }
        if(x-2 >= 0 && y-1 >= 0)
        {
            aux = new PosicionHacker(x-2,y-1);
            if(jugador == "blanco")
                hackerBlanco[GetIndiceBlanco(aficha)].cargarAlFinaldeLaLista(aux);
            else
                hackerNegro[GetIndiceNegro(aficha)].cargarAlFinaldeLaLista(aux);
        }
    }

    public void MovimientoRey(int x, int y,String jugador,String aficha)
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

    public void MovimientoAlfil(int x, int y,String jugador,String aficha)
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

    public void MovimientoTorre(Integer x, Integer y,String jugador,String aficha)
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

    public void MovimientoPeon(int x, int y,String jugador,String aficha)
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

    public Integer GetIndiceBlanco(String aFicha)
    {
        Integer temp = -1;
        for(int i = 0; i < cantFichasBlancas; i++)
        {
            if(aFicha == hackerBlanco[i].getNombreFicha())
                temp = i;
        }
        return -1;
    }
    public Integer GetIndiceNegro(String aFicha)
    {
        Integer temp = -1;
        for(int i = 0; i < cantFichasNegras; i++)
        {
            if(aFicha == hackerNegro[i].getNombreFicha())
                temp = i;
        }
        return -1;
    }

}
