package contenedor;

public class Hacker {
    private ListaPosicionHacker[] hackerBlanco;
    private ListaPosicionHacker[] hackerNegro;
    private Integer cantFichasBlancas;
    private Integer cantFichasNegras;

    public Hacker()
    {
        cantFichasBlancas =16;
        cantFichasNegras = 16;
        hackerBlanco = new ListaPosicionHacker[cantFichasBlancas];
        hackerNegro = new ListaPosicionHacker[cantFichasNegras];

        hackerNegro[0] = new ListaPosicionHacker("peon1");
        hackerNegro[1] = new ListaPosicionHacker("peon2");
        hackerNegro[2] = new ListaPosicionHacker("peon3");
        hackerNegro[3] = new ListaPosicionHacker("peon4");
        hackerNegro[4] = new ListaPosicionHacker("peon5");
        hackerNegro[5] = new ListaPosicionHacker("peon6");
        hackerNegro[6] = new ListaPosicionHacker("peon7");
        hackerNegro[7] = new ListaPosicionHacker("peon8");
        hackerNegro[8] = new ListaPosicionHacker("torre1");
        hackerNegro[9] = new ListaPosicionHacker("torre2");
        hackerNegro[10] = new ListaPosicionHacker("alfil1");
        hackerNegro[11] = new ListaPosicionHacker("alfil2");
        hackerNegro[12] = new ListaPosicionHacker("caballo1");
        hackerNegro[13] = new ListaPosicionHacker("caballo2");
        hackerNegro[14] = new ListaPosicionHacker("reina");
        hackerNegro[15] = new ListaPosicionHacker("rey");

        hackerBlanco[0] = new ListaPosicionHacker("peon1");
        hackerBlanco[1] = new ListaPosicionHacker("peon2");
        hackerBlanco[2] = new ListaPosicionHacker("peon3");
        hackerBlanco[3] = new ListaPosicionHacker("peon4");
        hackerBlanco[4] = new ListaPosicionHacker("peon5");
        hackerBlanco[5] = new ListaPosicionHacker("peon6");
        hackerBlanco[6] = new ListaPosicionHacker("peon7");
        hackerBlanco[7] = new ListaPosicionHacker("peon8");
        hackerBlanco[8] = new ListaPosicionHacker("torre1");
        hackerBlanco[9] = new ListaPosicionHacker("torre2");
        hackerBlanco[10] = new ListaPosicionHacker("alfil1");
        hackerBlanco[11] = new ListaPosicionHacker("alfil2");
        hackerBlanco[12] = new ListaPosicionHacker("caballo1");
        hackerBlanco[13] = new ListaPosicionHacker("caballo2");
        hackerBlanco[14] = new ListaPosicionHacker("reina");
        hackerBlanco[15] = new ListaPosicionHacker("rey");

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

   /* public void AddCasillasHackerBlancas(String idFicha, PosicionHacker aPosocion)
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
    }*/

   //////////////arreglar///////////////
   public void RellenarListaJugadaHacker(int x, int y, String ficha, String jugador, Casilla tablero[][])
   {
       if(ficha.contains("peon"))
           MovimientoPeon(x,y,jugador,ficha);
       if(ficha.contains("torre"))
           MovimientoTorre(x,y,jugador,ficha, tablero);
       if(ficha.contains("alfil"))
           MovimientoAlfil(x,y,jugador,ficha, tablero);
       if(ficha == "reina")
       {
           MovimientoAlfil(x,y,jugador,ficha, tablero);
           MovimientoTorre(x,y,jugador,ficha, tablero);
       }
       if(ficha == "rey")
           MovimientoRey(x,y,jugador,ficha, tablero);
       if(ficha.contains("caballo"))
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
            if(tablero[y+i][x+i].getFicha().getIdFicha() == "" ||(
                    tablero[y+i][x+i].getFicha().getJugador() != "" &&
                            tablero[y+i][x+i].getFicha().getJugador() != tablero[y][x].getFicha().getJugador()))
            {
                aux = new PosicionHacker(x+i,y+i);
                if(jugador == "blanco")
                    hackerBlanco[GetIndiceBlanco(aficha)].cargarAlFinaldeLaLista(aux);
                else
                    hackerNegro[GetIndiceNegro(aficha)].cargarAlFinaldeLaLista(aux);

                if(tablero[y+i][x+i].getFicha().getJugador() != tablero[y][x].getFicha().getJugador()&&
                        tablero[y+i][x+i].getFicha().getJugador() != ""  )
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
            if(tablero[y+i][x-i].getFicha().getIdFicha() == "" ||(
                    tablero[y+i][x-i].getFicha().getJugador() != "" &&
                            tablero[y+i][x-i].getFicha().getJugador() != tablero[y][x].getFicha().getJugador()))
            {
                aux = new PosicionHacker(x-i,y+i);
                if(jugador == "blanco")
                    hackerBlanco[GetIndiceBlanco(aficha)].cargarAlFinaldeLaLista(aux);
                else
                    hackerNegro[GetIndiceNegro(aficha)].cargarAlFinaldeLaLista(aux);

                if(tablero[y+i][x-i].getFicha().getJugador() != tablero[y][x].getFicha().getJugador()&&
                        tablero[y+i][x-i].getFicha().getJugador() != ""  )
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
            if(tablero[y-i][x+i].getFicha().getIdFicha() == "" ||(
                    tablero[y-i][x+i].getFicha().getJugador() != "" &&
                            tablero[y-i][x+i].getFicha().getJugador() != tablero[y][x].getFicha().getJugador()))
            {
                aux = new PosicionHacker(x+i,y-i);
                if(jugador == "blanco")
                    hackerBlanco[GetIndiceBlanco(aficha)].cargarAlFinaldeLaLista(aux);
                else
                    hackerNegro[GetIndiceNegro(aficha)].cargarAlFinaldeLaLista(aux);

                if(tablero[y-i][x+i].getFicha().getJugador() != tablero[y][x].getFicha().getJugador()&&
                        tablero[y-i][x+i].getFicha().getJugador() != ""  )
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
            if(tablero[y-i][x-i].getFicha().getIdFicha() == "" ||(
                    tablero[y-i][x-i].getFicha().getJugador() != "" &&
                            tablero[y-i][x-i].getFicha().getJugador() != tablero[y][x].getFicha().getJugador()))
            {
                aux = new PosicionHacker(x-i,y-i);
                if(jugador == "blanco")
                    hackerBlanco[GetIndiceBlanco(aficha)].cargarAlFinaldeLaLista(aux);
                else
                    hackerNegro[GetIndiceNegro(aficha)].cargarAlFinaldeLaLista(aux);

                if(tablero[y-i][x-i].getFicha().getJugador() != tablero[y][x].getFicha().getJugador()
                        &&  tablero[y-i][x-i].getFicha().getJugador() != "" )
                    bandera = true;
                i++;
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
            if(tablero[y][i].getFicha().getIdFicha() == "" ||(
                    tablero[y][i].getFicha().getJugador() != "" &&
                            tablero[y][i].getFicha().getJugador() != tablero[y][x].getFicha().getJugador()))
            {
                aux = new PosicionHacker(i,y);
                if(jugador == "blanco")
                   hackerBlanco[GetIndiceBlanco(aficha)].cargarAlFinaldeLaLista(aux);
                else
                    hackerNegro[GetIndiceNegro(aficha)].cargarAlFinaldeLaLista(aux);

                 if(tablero[y][i].getFicha().getJugador() != "" &&
                        tablero[y][i].getFicha().getJugador() != tablero[y][x].getFicha().getJugador())
                {
                    break;
                }
            }
            else
                break;
        }
        for(int i = y+1 ; i < 8; i++)
        {
            if(tablero[i][x].getFicha().getIdFicha() == "" ||(
                    tablero[i][x].getFicha().getJugador() != "" &&
                            tablero[i][x].getFicha().getJugador() != tablero[y][x].getFicha().getJugador()))
            {
                aux = new PosicionHacker(x,i);
                if(jugador == "blanco")
                   hackerBlanco[GetIndiceBlanco(aficha)].cargarAlFinaldeLaLista(aux);
                else
                    hackerNegro[GetIndiceNegro(aficha)].cargarAlFinaldeLaLista(aux);

                if(tablero[i][x].getFicha().getJugador() != "" &&
                        tablero[i][x].getFicha().getJugador() != tablero[y][x].getFicha().getJugador())
                    break;
            }
            else
                break;
        }

        for(int i = x-1 ; i >=0; i--)
        {
            if(tablero[y][i].getFicha().getIdFicha() == ""||(
                    tablero[y][i].getFicha().getJugador() != "" &&
                            tablero[y][i].getFicha().getJugador() != tablero[y][x].getFicha().getJugador()))
            {
                aux = new PosicionHacker(i,y);
                if(jugador == "blanco")
                    hackerBlanco[GetIndiceBlanco(aficha)].cargarAlFinaldeLaLista(aux);
                else
                    hackerNegro[GetIndiceNegro(aficha)].cargarAlFinaldeLaLista(aux);

                if(tablero[y][i].getFicha().getJugador() != "" &&
                        tablero[y][i].getFicha().getJugador() != tablero[y][x].getFicha().getJugador())
                    break;
            }
            else
                break;
        }
        for(int i = y-1 ; i >=0; i--)
        {
            if(tablero[i][x].getFicha().getIdFicha() == "" ||(
                    tablero[i][x].getFicha().getJugador() != "" &&
                            tablero[i][x].getFicha().getJugador() != tablero[y][x].getFicha().getJugador()))
            {
                aux = new PosicionHacker(x,i);
                if(jugador == "blanco")
                    hackerBlanco[GetIndiceBlanco(aficha)].cargarAlFinaldeLaLista(aux);
                else
                    hackerNegro[GetIndiceNegro(aficha)].cargarAlFinaldeLaLista(aux);

                if (tablero[i][x].getFicha().getJugador() != "" &&
                        tablero[i][x].getFicha().getJugador() != tablero[y][x].getFicha().getJugador())
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
            if(y+1<8)
            {
                if(x+1<8)
                {
                    aux = new PosicionHacker(x + 1, y + 1);
                    hackerBlanco[GetIndiceBlanco(aficha)].cargarAlFinaldeLaLista(aux);
                }
                if(x-1>=0)
                {
                    aux = new PosicionHacker(x - 1, y + 1);
                    hackerBlanco[GetIndiceBlanco(aficha)].cargarAlFinaldeLaLista(aux);
                }
            }
       }
        else
        {
            if(y-1>=0)
            {
                if(x+1<8)
                {
                    aux = new PosicionHacker(x+1,y-1);
                    hackerNegro[GetIndiceNegro(aficha)].cargarAlFinaldeLaLista(aux);
                }
                if(x-1>=0)
                {
                aux = new PosicionHacker(x-1,y-1);
                hackerNegro[GetIndiceNegro(aficha)].cargarAlFinaldeLaLista(aux);
                }
            }
        }
     }

    public Integer GetIndiceBlanco(String aFicha)
    {
        Integer temp = -1;
        for(int i = 0; i < cantFichasBlancas; i++)
        {
            if(aFicha == hackerBlanco[i].getNombreFicha())
                return i;
        }
        return temp;
    }
    public Integer GetIndiceNegro(String aFicha)
    {
        Integer temp = -1;
        for(int i = 0; i < cantFichasNegras; i++)
        {
            if(aFicha == hackerNegro[i].getNombreFicha())
                return i;
        }
        return temp;
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

    public boolean IsReyBlancoHacker(Integer x, Integer y)
    {
        boolean temp = false;
        for(int i = 0; i < cantFichasNegras;i++)
        {
            temp = hackerNegro[i].IsHaker(x,y);
            if(temp)
                return true;
        }
        return temp;
    }
    public boolean IsReyNegroHacker(Integer x, Integer y)
    {
        boolean temp = false;
        for(int i = 0; i < cantFichasBlancas;i++)
        {
            temp = hackerBlanco[i].IsHaker(x,y);
            if(temp)
                return true;
        }
        return temp;
    }
    public boolean IsReyHacker(Integer x, Integer y, String jugador)
    {
        if(jugador == "negro")
            return IsReyBlancoHacker(x,y);
        else
            return IsReyNegroHacker(x,y);
    }
}
