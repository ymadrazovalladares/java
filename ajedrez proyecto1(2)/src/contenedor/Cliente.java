package contenedor;

import javafx.scene.image.ImageView;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Cliente {
    private Casilla casilla = new Casilla();
    private Casilla tablero[][] = new Casilla[8][8];
    private Socket socket;
    private String cadena;
    private DataInputStream bufferDeEntrada = null;
    private DataOutputStream bufferDeSalida = null;
    Scanner teclado = new Scanner(System.in);
    final String COMANDO_TERMINACION = "salir()";

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
            for(int i = 0; i<8; i++)
                for(int j = 0; j<8; j++)
                    this.tablero[i][j] = aTablero[i][j];
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
                if(st != "" && st != cadena)
                    DescomponerString(st);
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

        tablero[Integer.parseInt(aux[3])][Integer.parseInt(aux[2])].getButton().setGraphic(
                this.tablero[Integer.parseInt(aux[1])][Integer.parseInt(aux[0])].getButton().getGraphic());
        tablero[Integer.parseInt(aux[3])][Integer.parseInt(aux[2])].setFicha(this.tablero
                [Integer.parseInt(aux[1])][Integer.parseInt(aux[0])].getFicha());

        tablero[Integer.parseInt(aux[1])][Integer.parseInt(aux[0])].setFicha(new JavaFxFicha());
        tablero[Integer.parseInt(aux[1])][Integer.parseInt(aux[0])].getButton().setGraphic(new ImageView());
        casilla = tablero[Integer.parseInt(aux[3])][Integer.parseInt(aux[2])];
        cadena = "";
    }

    public void escribirDatos() {
        /*String entrada = "";
        while (true) {
            System.out.print("[Usted] => ");
            entrada = teclado.nextLine();
            if(entrada.length() > 0)
                enviar(entrada);
        }*/
    }
    public String getCadena() {
        return cadena;
    }

    public void setCadena(String cadena) {
        this.cadena = cadena;
    }

    public Casilla getCasilla() {
        return casilla;
    }

    /* public static void main(String[] argumentos) {
        Cliente cliente = new Cliente();
        Scanner escaner = new Scanner(System.in);
        mostrarTexto("Ingresa la IP: [localhost por defecto] ");
        String ip = escaner.nextLine();
        if (ip.length() <= 0) ip = "localhost";

        mostrarTexto("Puerto: [5050 por defecto] ");
        String puerto = escaner.nextLine();
        if (puerto.length() <= 0) puerto = "5050";
        cliente.ejecutarConexion(ip, Integer.parseInt(puerto));
        cliente.escribirDatos();
    }*/
}