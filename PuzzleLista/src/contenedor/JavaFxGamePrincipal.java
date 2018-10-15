package contenedor;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public  class JavaFxGamePrincipal extends Application
{

    public static void main(String args[])
        {
          launch(args);

        }
    @Override
    public void start(Stage primaryStage) throws Exception
    {
        Integer tablero[][]= {
                {    1,   5, 15,  9},
                {    0,   8, 14,  6},
                {   12,  11,  2,  3},
                {   4,   10,  7, 13}

        } ;

        JavaFxGameTablero javaFxGameTablero= new JavaFxGameTablero(tablero);
        Scene scene = new Scene(javaFxGameTablero.getPane(),600,600);
        primaryStage.setScene(scene);
        primaryStage.show();
    }



        /*Integer tablero[][]= {
                {    1,   2, 3,  4},
                {   0, 5, 6,  7},
                {   8,  9, 10,  11},
                {   12,   13,  14, 15}   } ;
        /*ListaDoblementeEnlazada aux = new ListaDoblementeEnlazada();
        aux.PushMatrix(tablero);
        aux.CambiarNodos(12);
        int temp[][] = new int[aux.getTotalX()][aux.getTotalY()];
        temp = aux.getListaDoble();
        for(int i = 0; i < aux.getTotalX();i++)
        {
            for(int j = 0; j < aux.getTotalY();j++)
            {
                System.out.print(temp[i][j] + " ");
            }
            System.out.println("");
        }*/

}


