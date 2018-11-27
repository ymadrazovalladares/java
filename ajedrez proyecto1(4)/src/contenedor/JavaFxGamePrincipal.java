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
       //Cliente cliente;
       //Servidor servidor;
       boolean Servidorcliente;

   public void start(Stage primaryStage)  {

        JavaFxGameTablero javaFxGameTablero= new JavaFxGameTablero();
        //Cliente_Servidor();
       /* if(Servidorcliente)
           servidor = new Servidor(javaFxGameTablero);
       else
           cliente = new Cliente(javaFxGameTablero);
*/
        //javaFxGameTablero.setServidorCliente(Servidorcliente);
        Scene scene = new Scene(javaFxGameTablero.getPane(),860,800);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

}
