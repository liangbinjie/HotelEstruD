package hotel;
import java.io.*;
import java.net.*;

public class Servidor extends Thread {
    private static final int PUERTO = 5000;
    private ServerSocket sc;
    private Socket cl;
    private DataOutputStream salida;
    private DataInputStream entrada;
    private String mensajeRecibido = "";
    protected Cola cola = new Cola();
    protected ListaES listaReservas = new ListaES();
    
    @Override
    public void run() {
        
        try {
            sc = new ServerSocket(PUERTO);
            cl = new Socket();
            
            System.out.println("Esperando conexion...");
            cl = sc.accept();
            System.out.println("Sistema conectado!");
            
            entrada = new DataInputStream(cl.getInputStream());
            salida = new DataOutputStream(cl.getOutputStream());
            while (true) {
                mensajeRecibido = entrada.readUTF();
                int f = cola.ficha();
                salida.writeInt(f);
            }
        } catch (IOException ex) {
            System.out.println("Error en el servidor");
        }
    }
}
