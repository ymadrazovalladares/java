package contenedor;

import javafx.scene.image.ImageView;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Cliente {
    private JavaFxGameTablero tablero;
    private Socket socket;
    private String cadena;
    private DataInputStream bufferDeEntrada = null;
    private DataOutputStream bufferDeSalida = null;
    Scanner teclado = new Scanner(System.in);
    final String COMANDO_TERMINACION = "salir()";

    public Cliente( ) {
        tablero = null;
        this.socket = socket;
        this.cadena = cadena;
        this.bufferDeEntrada = bufferDeEntrada;
        this.bufferDeSalida = bufferDeSalida;
        this.teclado = teclado;
    }

    public void levantarConexion(String ip, int puerto) {
        try {
            socket = new Socket(ip, puerto);
            mostrarTexto("Conectado a :" + socket.getInetAddress().getHostName());
        } catch (Exception e) {
            mostrarTexto("Excepción al levantar conexión: " + e.getMessage());
            System.exit(0);
        }
    }

    public static void mostrarTexto(String s) {
        System.out.println(s);
    }

    public void abrirFlujos() {
        try {
            bufferDeEntrada = new DataInputStream(socket.getInputStream());
            bufferDeSalida = new DataOutputStream(socket.getOutputStream());
            bufferDeSalida.flush();
        } catch (IOException e) {
            mostrarTexto("Error en la apertura de flujos");
        }
    }

    public void enviar(String s, Casilla aTablero[][]) {
        try {
            bufferDeSalida.writeUTF(s);
            bufferDeSalida.flush();
           } catch (IOException e) {
            mostrarTexto("IOException on enviar");
        }
    }

    public void cerrarConexion() {
        try {
            bufferDeEntrada.close();
            bufferDeSalida.close();
            socket.close();
            mostrarTexto("Conexión terminada");
        } catch (IOException e) {
            mostrarTexto("IOException on cerrarConexion()");
        }finally{
            System.exit(0);
        }
    }

    public void ejecutarConexion(String ip, int puerto) {
        Thread hilo = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    levantarConexion(ip, puerto);
                    abrirFlujos();
                    recibirDatos();
                } finally {
                    cerrarConexion();
                }
            }
        });
        hilo.start();
    }

    public void recibirDatos() {
        String st = "";
        try {
            do {
                st = (String) bufferDeEntrada.readUTF();
                mostrarTexto("\n[Servidor] => " + st);
                if(st != "" && st != cadena) {
                    DescomponerString(st);
                }
                cadena = st;
                System.out.print("\n[Usted] => ");
            } while (!st.equals(COMANDO_TERMINACION));
        } catch (IOException e) {}

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
        tablero.setFichaMarcadaX(Integer.parseInt(aux[1]));
        tablero.setFichaMarcadaY(Integer.parseInt(aux[0]));
        tablero.getTablero()[Integer.parseInt(aux[3])][Integer.parseInt(aux[2])].setSombreada(true);
        tablero.Movimiento(tablero.getTablero()[Integer.parseInt(aux[3])][Integer.parseInt(aux[2])]);
        cadena = "";
        tablero.ActualizarTablaFichas(tablero.getTablero()[Integer.parseInt(aux[3])][Integer.parseInt(aux[2])]);
        tablero.RevisarHacker();
    }

    public JavaFxGameTablero getTablero() {
        return tablero;
    }

    public void setTablero(JavaFxGameTablero tablero) {
        this.tablero = tablero;
    }

}