package contenedor;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public  class JavaFxGamePrincipal extends Application {

    public static void main(String args[]){
        launch(args);

    }


    @Override
    public void start(Stage primaryStage)  {
        String tablero[][]= {
                {    "a",   "b", "c",  "d"},
                { null,  "f", "e",  "i"},
                {   "o",  "p",  "p",  "k"},
                {   "n",   "m",  "l", "j"}

        } ;

        JavaFxGameTablero javaFxGameTablero= new JavaFxGameTablero(tablero);
        Scene scene = new Scene(javaFxGameTablero.getPane(),600,600);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

}
