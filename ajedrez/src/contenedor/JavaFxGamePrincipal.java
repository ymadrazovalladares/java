package contenedor;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import static contenedor.Servidor.mostrarTexto;
import java.util.Scanner;

public  class JavaFxGamePrincipal extends Application {


    public static void main(String args[]){
        launch(args);

    }


    @Override
    public void start(Stage primaryStage)  {

         Servidor servidor = new Servidor();
         Cliente cliente = new Cliente();
        JavaFxGameTablero javaFxGameTablero= new JavaFxGameTablero(servidor,cliente);
        Scene scene = new Scene(javaFxGameTablero.getPane(),860,800);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

}
