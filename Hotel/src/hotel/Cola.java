package hotel;

import java.util.Date;
import java.time.*;
import javax.swing.JOptionPane;

public class Cola {
    private Nodo inicio;
    private Nodo fin;
    private int ids = 1;
    
    public Cola() {
        this.inicio = null;
        this.fin = null;
    }
    
    public boolean vacia() {
        return (inicio==null);
    }
    
    // metodo para obtener una nueva ficha
    public int ficha() {
        Date fecha = new Date();
        LocalDate localDate = fecha.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        int year  = localDate.getYear();
        int month = localDate.getMonthValue();
        int day   = localDate.getDayOfMonth();
        Reservas reserva = new Reservas();
        reserva.setId(ids+"00"+day+""+month+""+year);
        reserva.setFicha(ids);
        Nodo nuevo = new Nodo();
        nuevo.setReserva(reserva);
        
        if (vacia()) {
            inicio = nuevo;
            fin = nuevo;
        } else {
            fin.setSiguiente(nuevo);
            fin = nuevo;
        }
        
        int id = ids++;
        return id;
    }
    
    public int atender() {
        int id = 0;
        if (!vacia()) {
            JOptionPane.showMessageDialog(null, "Atendiendo ficha numero: " + inicio.getReserva().getFicha()); 
            id = inicio.getReserva().getFicha();
            inicio = inicio.getSiguiente();
        } else {
            JOptionPane.showMessageDialog(null, "No hay cliente que atender");
        }
        
        return id;
    }
    
    public void mostrar_cola() {
        if (!vacia()) {
            String s = "";
            Nodo aux = inicio;
            while (aux!=null) {
                s+= "Ficha No: " + aux.getReserva().getFicha() + "\n";
                aux = aux.getSiguiente();
            }
            
            JOptionPane.showMessageDialog(null, "La cola contiene: \n" + s);
        } else {
            JOptionPane.showMessageDialog(null, "No hay clientes en cola");
        }
    }
    
}
