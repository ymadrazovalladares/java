package contenedor;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Scanner;

import static contenedor.Servidor.mostrarTexto;

public  class JavaFxGamePrincipal extends Application {

    public static void main(String args[]){
        launch(args);

    }
       Cliente cliente;
       Servidor servidor;
       boolean Servidorcliente;

    @Override
    public void start(Stage primaryStage)  {

        JavaFxGameTablero javaFxGameTablero= new JavaFxGameTablero();
        cliente = new Cliente(javaFxGameTablero);
        servidor = new Servidor(javaFxGameTablero);
        Cliente_Servidor();
        javaFxGameTablero.setServidorCliente(Servidorcliente);
        Scene scene = new Scene(javaFxGameTablero.getPane(),860,800);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public void Cliente_Servidor() {
        mostrarTexto("Cliente 0/Servidor 1");
        Scanner escaner = new Scanner(System.in);
        String estado = escaner.nextLine();
        if (estado.toCharArray()[0] == '0') {

            mostrarTexto("Ingresa la IP: [localhost por defecto] ");
            String ip = escaner.nextLine();
            if (ip.length() <= 0) ip = "localhost";
            mostrarTexto("Puerto: [5050 por defecto] ");
            String puerto = escaner.nextLine();
            if (puerto.length() <= 0) puerto = "5050";
            cliente.ejecutarConexion(ip, Integer.parseInt(puerto));
            Servidorcliente = false;
         }
        if (estado.toCharArray()[0] == '1') {
            Scanner sc = new Scanner(System.in);
            mostrarTexto("Ingresa el puerto [5050 por defecto]: ");
            String puerto = sc.nextLine();
            if (puerto.length() <= 0) puerto = "5050";
            servidor.ejecutarConexion(Integer.parseInt(puerto));
            Servidorcliente = true;
        }

    }
}
