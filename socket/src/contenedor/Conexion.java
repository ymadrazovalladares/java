package contenedor;

import java.util.Scanner;

import static contenedor.Servidor.mostrarTexto;

public class Conexion {
    public static void main(String[] argumentos) {
        mostrarTexto("Cliente 0/Servidor 1");
        Scanner escaner = new Scanner(System.in);
        String estado = escaner.nextLine();
       if(estado.toCharArray()[0] == '0')
       {
           Cliente cliente = new Cliente();

           mostrarTexto("Ingresa la IP: [localhost por defecto] ");
           String ip = escaner.nextLine();
           if (ip.length() <= 0) ip = "localhost";

           mostrarTexto("Puerto: [5050 por defecto] ");
           String puerto = escaner.nextLine();
           if (puerto.length() <= 0) puerto = "5050";
           cliente.ejecutarConexion(ip, Integer.parseInt(puerto));
           cliente.escribirDatos();
       }
       if(estado.toCharArray()[0] == '1')
       {
           Servidor s = new Servidor();
           Scanner sc = new Scanner(System.in);

           mostrarTexto("Ingresa el puerto [5050 por defecto]: ");
           String puerto = sc.nextLine();
           if (puerto.length() <= 0) puerto = "5050";
           s.ejecutarConexion(Integer.parseInt(puerto));
           s.escribirDatos();

       }




    }
}
