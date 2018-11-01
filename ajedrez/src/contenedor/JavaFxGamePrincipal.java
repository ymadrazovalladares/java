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
                {   "","","","","","","",""},
                {   "","","","","","","",""},
                {   "","","","","","","",""},
                {   "","","","","","","",""},
                {   "","","","","","","",""},
                {   "","","","","","","",""},
                {   "","","","","","","",""},
                {   "","","","","","","",""}

        } ;

        JavaFxGameTablero javaFxGameTablero= new JavaFxGameTablero(tablero);
        Scene scene = new Scene(javaFxGameTablero.getPane(),800,800);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

}
