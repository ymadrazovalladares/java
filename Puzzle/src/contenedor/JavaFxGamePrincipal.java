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
        Integer tablero[][]= {
                {    1,   5, 15,  9},
                { null,   8, 14,  6},
                {   12,  11,  2,  3},
                {   4,   10,  7, 13}

        } ;

        JavaFxGameTablero javaFxGameTablero= new JavaFxGameTablero(tablero);
        Scene scene = new Scene(javaFxGameTablero.getPane(),600,600);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

}
