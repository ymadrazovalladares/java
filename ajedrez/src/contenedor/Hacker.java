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
   public void RellenarListaJugadaHacker(int x, int y, String ficha, String jugador, Casilla tablero[][])
   {
       if(ficha == "peon")
           MovimientoPeon(x,y,jugador,ficha);
       if(ficha == "Torre")
           MovimientoTorre(x,y,jugador,ficha, tablero);
       if(ficha == "Alfil")
           MovimientoAlfil(x,y,jugador,ficha, tablero);
       if(ficha == "Reina")
       {
           MovimientoAlfil(x,y,jugador,ficha, tablero);
           MovimientoTorre(x,y,jugador,ficha, tablero);
       }
       if(ficha == "Rey")
           MovimientoRey(x,y,jugador,ficha, tablero);
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

    public void MovimientoRey(int x, int y,String jugador,String aficha, Casilla tablero[][])
    {
        PosicionHacker aux = new PosicionHacker();
        if(x+1<8)
        {
            if(tablero[x+1][y].getFicha().getIdFicha() == "" ||
                    (tablero[x+1][y].getFicha().getIdFicha() != "" &&
                            tablero[x+1][y].getFicha().getJugador() != tablero[x][y].getFicha().getJugador()))
            {
                aux = new PosicionHacker(x+1,y);
                if(jugador == "blanco")
                    hackerBlanco[GetIndiceBlanco(aficha)].cargarAlFinaldeLaLista(aux);
                else
                    hackerNegro[GetIndiceNegro(aficha)].cargarAlFinaldeLaLista(aux);
            }

        }
        if(y+1<8)
        {
            if(tablero[x][y+1].getFicha().getIdFicha() == "" ||
                    (tablero[x][y+1].getFicha().getIdFicha() != "" &&
                            tablero[x][y+1].getFicha().getJugador() != tablero[x][y].getFicha().getJugador()))
            {
                aux = new PosicionHacker(x,y+1);
                if(jugador == "blanco")
                    hackerBlanco[GetIndiceBlanco(aficha)].cargarAlFinaldeLaLista(aux);
                else
                    hackerNegro[GetIndiceNegro(aficha)].cargarAlFinaldeLaLista(aux);
            }

        }
        if(x-1>=0 )
        {
            if (tablero[x - 1][y].getFicha().getIdFicha() == "" ||
                    (tablero[x - 1][y].getFicha().getIdFicha() != "" &&
                            tablero[x - 1][y].getFicha().getJugador() != tablero[x][y].getFicha().getJugador()))
            {
                aux = new PosicionHacker(x-1,y);
                if(jugador == "blanco")
                    hackerBlanco[GetIndiceBlanco(aficha)].cargarAlFinaldeLaLista(aux);
                else
                    hackerNegro[GetIndiceNegro(aficha)].cargarAlFinaldeLaLista(aux);
            }

        }
        if(y-1>=0)
        {
            if(tablero[x][y-1].getFicha().getIdFicha() == "" ||
                    (tablero[x][y-1].getFicha().getIdFicha() != "" &&
                            tablero[x][y-1].getFicha().getJugador() != tablero[x][y].getFicha().getJugador()))
            {
                aux = new PosicionHacker(x,y-1);
                if(jugador == "blanco")
                    hackerBlanco[GetIndiceBlanco(aficha)].cargarAlFinaldeLaLista(aux);
                else
                    hackerNegro[GetIndiceNegro(aficha)].cargarAlFinaldeLaLista(aux);
            }

        }
        if(x+1 < 8 && y+1 < 8)
        {
            if(tablero[x+1][y+1].getFicha().getIdFicha() == "" ||
                    (tablero[x+1][y+1].getFicha().getIdFicha() != "" &&
                            tablero[x+1][y+1].getFicha().getJugador() != tablero[x][y].getFicha().getJugador()))
            {
                aux = new PosicionHacker(x+1,y+1);
                if(jugador == "blanco")
                    hackerBlanco[GetIndiceBlanco(aficha)].cargarAlFinaldeLaLista(aux);
                else
                    hackerNegro[GetIndiceNegro(aficha)].cargarAlFinaldeLaLista(aux);
            }

        }
        if(x+1 < 8 && y-1 >= 0)
        {
            if(tablero[x+1][y-1].getFicha().getIdFicha() == "" ||
                    (tablero[x+1][y-1].getFicha().getIdFicha() != "" &&
                            tablero[x+1][y-1].getFicha().getJugador() != tablero[x][y].getFicha().getJugador()))
            {
                aux = new PosicionHacker(x+1,y-1);
                if(jugador == "blanco")
                    hackerBlanco[GetIndiceBlanco(aficha)].cargarAlFinaldeLaLista(aux);
                else
                    hackerNegro[GetIndiceNegro(aficha)].cargarAlFinaldeLaLista(aux);
            }

        }
        if(x-1 >= 0 && y+1 < 8)
        {
            if(tablero[x-1][y+1].getFicha().getIdFicha() == "" ||
                    (tablero[x-1][y+1].getFicha().getIdFicha() != "" &&
                            tablero[x-1][y+1].getFicha().getJugador() != tablero[x][y].getFicha().getJugador()))
            {
                aux = new PosicionHacker(x-1,y+1);
                if(jugador == "blanco")
                    hackerBlanco[GetIndiceBlanco(aficha)].cargarAlFinaldeLaLista(aux);
                else
                    hackerNegro[GetIndiceNegro(aficha)].cargarAlFinaldeLaLista(aux);
            }

        }
        if(x-1 >= 0 && y-1 >= 0)
        {
            if(tablero[x-1][y-1].getFicha().getIdFicha() == "" ||
                    (tablero[x-1][y-1].getFicha().getIdFicha() != "" &&
                            tablero[x-1][y-1].getFicha().getJugador() != tablero[x][y].getFicha().getJugador()))
            {
                aux = new PosicionHacker(x-1,y-1);
                if(jugador == "blanco")
                    hackerBlanco[GetIndiceBlanco(aficha)].cargarAlFinaldeLaLista(aux);
                else
                    hackerNegro[GetIndiceNegro(aficha)].cargarAlFinaldeLaLista(aux);
            }

        }

    }

    public void MovimientoAlfil(int x, int y,String jugador,String aficha, Casilla tablero[][])
    {
        boolean bandera = false;
        int i = 1;
        PosicionHacker aux = new PosicionHacker();
        while (!bandera && x+i < 8 && y+i < 8)
        {
            if(tablero[x+i][y+i].getFicha().getIdFicha() == "" ||(
                    tablero[x+i][y+i].getFicha().getJugador() != "" &&
                            tablero[x+i][y+i].getFicha().getJugador() != tablero[x][y].getFicha().getJugador()))
            {
                aux = new PosicionHacker(x+i,y+i);
                if(jugador == "blanco")
                    hackerBlanco[GetIndiceBlanco(aficha)].cargarAlFinaldeLaLista(aux);
                else
                    hackerNegro[GetIndiceNegro(aficha)].cargarAlFinaldeLaLista(aux);

                if(tablero[x+i][y+i].getFicha().getJugador() != tablero[x][y].getFicha().getJugador()&&
                        tablero[x+i][y+i].getFicha().getJugador() != ""  )
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
            if(tablero[x-i][y+i].getFicha().getIdFicha() == "" ||(
                    tablero[x-i][y+i].getFicha().getJugador() != "" &&
                            tablero[x-i][y+i].getFicha().getJugador() != tablero[x][y].getFicha().getJugador()))
            {
                aux = new PosicionHacker(x-i,y+i);
                if(jugador == "blanco")
                    hackerBlanco[GetIndiceBlanco(aficha)].cargarAlFinaldeLaLista(aux);
                else
                    hackerNegro[GetIndiceNegro(aficha)].cargarAlFinaldeLaLista(aux);

                if(tablero[x-i][y+i].getFicha().getJugador() != tablero[x][y].getFicha().getJugador()&&
                        tablero[x-i][y+i].getFicha().getJugador() != ""  )
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
            if(tablero[x+i][y-i].getFicha().getIdFicha() == "" ||(
                    tablero[x+i][y-i].getFicha().getJugador() != "" &&
                            tablero[x+i][y-i].getFicha().getJugador() != tablero[x][y].getFicha().getJugador()))
            {
                aux = new PosicionHacker(x+i,y-i);
                if(jugador == "blanco")
                    hackerBlanco[GetIndiceBlanco(aficha)].cargarAlFinaldeLaLista(aux);
                else
                    hackerNegro[GetIndiceNegro(aficha)].cargarAlFinaldeLaLista(aux);

                if(tablero[x+i][y-i].getFicha().getJugador() != tablero[x][y].getFicha().getJugador()&&
                        tablero[x+i][y-i].getFicha().getJugador() != ""  )
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
            if(tablero[x-i][y-i].getFicha().getIdFicha() == "" ||(
                    tablero[x-i][y-i].getFicha().getJugador() != "" &&
                            tablero[x-i][y-i].getFicha().getJugador() != tablero[x][y].getFicha().getJugador()))
            {
                aux = new PosicionHacker(x-i,y-i);
                if(jugador == "blanco")
                    hackerBlanco[GetIndiceBlanco(aficha)].cargarAlFinaldeLaLista(aux);
                else
                    hackerNegro[GetIndiceNegro(aficha)].cargarAlFinaldeLaLista(aux);

                if(tablero[x-i][y-i].getFicha().getJugador() != tablero[x][y].getFicha().getJugador()&&
                        tablero[x-i][y-i].getFicha().getJugador() != ""  )
                    bandera = true;i++;
            }
            else
                bandera = true;
        }
    }

    public void MovimientoTorre(Integer x, Integer y,String jugador,String aficha, Casilla tablero[][])
    {
        PosicionHacker aux = new PosicionHacker();
        for(int i = x+1 ; i < 8; i++)
        {
            if(tablero[i][y].getFicha().getIdFicha() == "" ||(
                    tablero[i][y].getFicha().getJugador() != "" &&
                            tablero[i][y].getFicha().getJugador() != tablero[x][y].getFicha().getJugador()))
            {
                aux = new PosicionHacker(i,y);
                if(jugador == "blanco")
                   hackerBlanco[GetIndiceBlanco(aficha)].cargarAlFinaldeLaLista(aux);
                else
                    hackerNegro[GetIndiceNegro(aficha)].cargarAlFinaldeLaLista(aux);

                 if(tablero[i][y].getFicha().getJugador() != "" &&
                        tablero[i][y].getFicha().getJugador() != tablero[x][y].getFicha().getJugador())
                {
                    break;
                }
            }
            else
                break;
        }
        for(int i = y+1 ; i < 8; i++)
        {
            if(tablero[x][i].getFicha().getIdFicha() == "" ||(
                    tablero[x][i].getFicha().getJugador() != "" &&
                            tablero[x][i].getFicha().getJugador() != tablero[x][y].getFicha().getJugador()))
            {
                aux = new PosicionHacker(x,i);
                if(jugador == "blanco")
                   hackerBlanco[GetIndiceBlanco(aficha)].cargarAlFinaldeLaLista(aux);
                else
                    hackerNegro[GetIndiceNegro(aficha)].cargarAlFinaldeLaLista(aux);

                if(tablero[x][i].getFicha().getJugador() != "" &&
                        tablero[x][i].getFicha().getJugador() != tablero[x][y].getFicha().getJugador())
                    break;
            }
            else
                break;
        }

        for(int i = x-1 ; i >=0; i--)
        {
            if(tablero[i][y].getFicha().getIdFicha() == ""||(
                    tablero[i][y].getFicha().getJugador() != "" &&
                            tablero[i][y].getFicha().getJugador() != tablero[x][y].getFicha().getJugador()))
            {
                aux = new PosicionHacker(i,y);
                if(jugador == "blanco")
                    hackerBlanco[GetIndiceBlanco(aficha)].cargarAlFinaldeLaLista(aux);
                else
                    hackerNegro[GetIndiceNegro(aficha)].cargarAlFinaldeLaLista(aux);

                if(tablero[i][y].getFicha().getJugador() != "" &&
                        tablero[i][y].getFicha().getJugador() != tablero[x][y].getFicha().getJugador())
                    break;
            }
            else
                break;
        }
        for(int i = y-1 ; i >=0; i--)
        {
            if(tablero[x][i].getFicha().getIdFicha() == "" ||(
                    tablero[x][i].getFicha().getJugador() != "" &&
                            tablero[x][i].getFicha().getJugador() != tablero[x][y].getFicha().getJugador()))
            {
                aux = new PosicionHacker(x,i);
                if(jugador == "blanco")
                    hackerBlanco[GetIndiceBlanco(aficha)].cargarAlFinaldeLaLista(aux);
                else
                    hackerNegro[GetIndiceNegro(aficha)].cargarAlFinaldeLaLista(aux);

                if (tablero[x][i].getFicha().getJugador() != "" &&
                        tablero[x][i].getFicha().getJugador() != tablero[x][y].getFicha().getJugador())
                    break;
            }
            else
                break;
        }
    }

    public void MovimientoPeon(int x, int y,String jugador,String aficha)
    {
        PosicionHacker aux = new PosicionHacker();
        if(jugador == "blanco")
        {
            if(x+1<8)
            {
                aux = new PosicionHacker(x+1,y+1);
                hackerBlanco[GetIndiceBlanco(aficha)].cargarAlFinaldeLaLista(aux);
                aux = new PosicionHacker(x+1,y-1);
                hackerBlanco[GetIndiceBlanco(aficha)].cargarAlFinaldeLaLista(aux);
            }
        }
        else
        {
            if(x-1>= 0)
            {
                aux = new PosicionHacker(x-1,y+1);
                hackerNegro[GetIndiceNegro(aficha)].cargarAlFinaldeLaLista(aux);
                aux = new PosicionHacker(x-1,y-1);
                hackerNegro[GetIndiceNegro(aficha)].cargarAlFinaldeLaLista(aux);
            }
        }
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

    public void LimpiarPosicionesFichaBlanca(String ficha)
    {
        for(int i = 0;i < cantFichasBlancas; i++)
        {
            if(ficha == hackerBlanco[i].getNombreFicha())
            {
                hackerBlanco[i].VaciarLista();
                break;
            }
        }
    }

    public void LimpiarPosicionesFichaNegra(String ficha)
    {
        for(int i = 0;i < cantFichasNegras; i++)
        {
            if(ficha == hackerNegro[i].getNombreFicha())
            {
                hackerNegro[i].VaciarLista();
                break;
            }
        }
    }
}
