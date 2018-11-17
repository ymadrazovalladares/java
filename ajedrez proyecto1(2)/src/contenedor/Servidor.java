package contenedor;

import javafx.scene.image.ImageView;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;


public class Servidor {
    public Casilla tablero[][] = new Casilla[8][8];
    private Casilla casilla = new Casilla();
    private Socket socket;
    private String cadena;
    private ServerSocket serverSocket;
    private DataInputStream bufferDeEntrada = null;
    private DataOutputStream bufferDeSalida = null;
    Scanner escaner = new Scanner(System.in);
    final String COMANDO_TERMINACION = "salir()";

    public void levantarConexion(int puerto) {
        try {
            serverSocket = new ServerSocket(puerto);
            mostrarTexto("Esperando conexión entrante en el puerto " + String.valueOf(puerto) + "...");
            socket = serverSocket.accept();
            mostrarTexto("Conexión establecida con: " + socket.getInetAddress().getHostName() + "\n\n\n");
        } catch (Exception e) {
            mostrarTexto("Error en levantarConexion(): " + e.getMessage());
            System.exit(0);
        }
    }
    public void flujos() {
        try {
            bufferDeEntrada = new DataInputStream(socket.getInputStream());
            bufferDeSalida = new DataOutputStream(socket.getOutputStream());
            bufferDeSalida.flush();
        } catch (IOException e) {
            mostrarTexto("Error en la apertura de flujos");
        }
    }

    public String recibirDatos() {
        String st = "";
        try {
            do {
                st = (String) bufferDeEntrada.readUTF();
                mostrarTexto("\n[Cliente] => " + st);
                if(st != "" && st != cadena)
                    DescomponerString(st);
                cadena = st;
                System.out.print("\n[Usted] => ");
            } while (!st.equals(COMANDO_TERMINACION));
        } catch (IOException e) {
            cerrarConexion();
        }
        return st;
    }


    public void enviar(String s, Casilla aTablero[][]) {
        try {
            bufferDeSalida.writeUTF(s);
            bufferDeSalida.flush();
            for(int i = 0; i<8; i++)
                for(int j = 0; j<8; j++)
                   this.tablero[i][j] = aTablero[i][j];
        } catch (IOException e) {
            mostrarTexto("Error en enviar(): " + e.getMessage());
        }
    }

    public static void mostrarTexto(String s) {
        System.out.print(s);
    }

    public void escribirDatos() {
       /* while (true) {
            System.out.print("[Usted] => ");
            enviar(escaner.nextLine());
        }*/
    }

    public void cerrarConexion() {
        try {
            bufferDeEntrada.close();
            bufferDeSalida.close();
            socket.close();
        } catch (IOException e) {
            mostrarTexto("Excepción en cerrarConexion(): " + e.getMessage());
        } finally {
            mostrarTexto("Conversación finalizada....");
            System.exit(0);

        }
    }



    public void ejecutarConexion(int puerto) {
        Thread hilo = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        levantarConexion(puerto);
                        flujos();
                        recibirDatos();
                    } finally {
                        cerrarConexion();
                    }
                }
            }
        });
        hilo.start();
    }

    public String getCadena() {
        return cadena;
    }

    public void setCadena(String cadena) {
        this.cadena = cadena;
    }
    public void DescomponerString(String dato)
    {
        String aux1 = "";
        String aux[] = new String[4];
        int contador = 0;
        for (int i = 0; i < dato.length(); i++) {
            if (dato.toCharArray()[i] == ' ')
                contador++;
            else {
                aux1 += dato.charAt(i);
                aux[contador] = aux1;
                aux1 = "";
            }
        }

        tablero[Integer.parseInt(aux[3])][Integer.parseInt(aux[2])].getButton().setGraphic(
                this.tablero[Integer.parseInt(aux[1])][Integer.parseInt(aux[0])].getButton().getGraphic());
        tablero[Integer.parseInt(aux[3])][Integer.parseInt(aux[2])].setFicha(this.tablero
                [Integer.parseInt(aux[1])][Integer.parseInt(aux[0])].getFicha());

        tablero[Integer.parseInt(aux[1])][Integer.parseInt(aux[0])].setFicha(new JavaFxFicha());
        tablero[Integer.parseInt(aux[1])][Integer.parseInt(aux[0])].getButton().setGraphic(new ImageView());
        casilla = tablero[Integer.parseInt(aux[3])][Integer.parseInt(aux[2])];
        cadena = "";
    }

    public Casilla getCasilla() {
        return casilla;
    }

/*public static void main(String[] args) throws IOException {
        Servidor s = new Servidor();
        Scanner sc = new Scanner(System.in);

        mostrarTexto("Ingresa el puerto [5050 por defecto]: ");
        String puerto = sc.nextLine();
        if (puerto.length() <= 0) puerto = "5050";
        s.ejecutarConexion(Integer.parseInt(puerto));
        s.escribirDatos();
    }*/
}