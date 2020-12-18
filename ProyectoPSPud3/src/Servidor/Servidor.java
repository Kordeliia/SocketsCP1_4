package Servidor;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import Conexion.Conexion;
//heredamos de la clase conexion a traves de extends Conxion para usar los sockets
public class Servidor extends Conexion {
	//Usamos constructor para servidor de Conexion
    public Servidor() throws IOException{
    	super("servidor");
    	}
  //Con este metodo se inicia el servidor
    public void startServer() {
        try {
        	System.out.println("Iniciando conexi�n del servidor");
        	//Acepta y espera la conexion del cliente
        	cs = ss.accept(); 
            System.out.println("Cliente en l�nea");
            //Obtenemos flujo de salida del cliente
            salidaCliente = new DataOutputStream(cs.getOutputStream());
            //Se devuelve mensaje al cliente
            salidaCliente.writeUTF("Petici�n recibida y aceptada");
            //Se obtiene el flujo entrante desde el cliente
            BufferedReader entrada = new BufferedReader(new InputStreamReader(cs.getInputStream()));
            //se crea un bucle que se ejecuta mientras existan mensajes dede cliente
            if((mensajeServidor=entrada.readLine())!=null) {
                System.out.println("El resultado es 50");
            }
            System.out.println("Fin de la conexi�n");
            //cerramos conexion con cliente
            ss.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}