package Cliente;
import java.io.DataOutputStream;
import java.io.IOException;
import Conexion.Conexion;
public class Cliente extends Conexion {
	//Usamos constructor de la clase Conexion para el cliente
    public Cliente() throws IOException{
    	super("cliente");
    } 
    //con este método iniciamos el cliente y la conexion con el servidor
    public void startClient() {
        try {
            //Flujo de datos hacia el servidor
            salidaServidor = new DataOutputStream(cs.getOutputStream());
            salidaServidor.writeUTF("Suma 45 y 5");
            cs.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}