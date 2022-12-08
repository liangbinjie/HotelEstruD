package hotel;

import javax.swing.JOptionPane;
import javax.swing.JTable;

public class ListaES {
    private Nodo inicio;
    
    public ListaES() {
        this.inicio = null;
    }
    
    public boolean vacio() {
        return (inicio == null);
    }
    
    public void agregar(String id, int ficha, String cliente, long identificacion, int cantAdultos, int cantNinos, String tipoH, int cantNoches, double monto) {
        Reservas reserva = new Reservas();
        reserva.setId(id);
        reserva.setFicha(ficha);
        reserva.setCliente(cliente);
        reserva.setIdentificacion(identificacion);
        reserva.setCantAdultos(cantAdultos);
        reserva.setCantNinos(cantNinos);
        reserva.setTipoHabitacion(tipoH);
        reserva.setNoches(cantNoches);
        reserva.setMonto(monto);
        
        Nodo nuevo = new Nodo();
        nuevo.setReserva(reserva);
        
        if (vacio()) {
            inicio = nuevo;
        } else if (reserva.getFicha() < inicio.getReserva().getFicha()) {
            nuevo.setSiguiente(inicio);
            inicio = nuevo;
        } else if (inicio.getSiguiente() == null) {
            inicio.setSiguiente(nuevo);
        } else {
            Nodo aux = inicio;
            while (aux.getSiguiente() != null
                    && aux.getSiguiente().getReserva().getFicha() < reserva.getFicha()) {
                aux = aux.getSiguiente();
            }
            Nodo temp = new Nodo();
            temp.setReserva(reserva);
            temp.setSiguiente(aux.getSiguiente());
            aux.setSiguiente(temp);
        }
    }
    
    public void mostrar() {
        String s = "";
        if (!vacio()) {
            Nodo aux = inicio;
            while (aux!=null) {
                s += aux.getReserva().getId() + "\n";
                aux = aux.getSiguiente();
            }
            JOptionPane.showMessageDialog(null, s);
        }
        else {
            JOptionPane.showMessageDialog(null, "Vacio");
        }
    }
   
    // metodo para llenar la tabla al ver las reservas
    public void getReservas(JTable tabla) {
        String s = "";
        if (!vacio()) {
            Nodo aux = inicio;
            int fila = 0;
            
            while (aux!=null) {
                s = aux.getReserva().getId();
                tabla.getModel().setValueAt(s, fila, 0);
                
                s = aux.getReserva().getCliente();
                tabla.getModel().setValueAt(s, fila, 1);
                
                long id = aux.getReserva().getIdentificacion();
                tabla.getModel().setValueAt(id, fila, 2);
                
                int adultos = aux.getReserva().getCantAdultos();
                tabla.getModel().setValueAt(adultos, fila, 3);
                
                int ninos = aux.getReserva().getCantNinos();
                tabla.getModel().setValueAt(ninos, fila, 4);
                
                int noches = aux.getReserva().getNoches();
                tabla.getModel().setValueAt(noches, fila, 5);
                
                s = aux.getReserva().getTipoHabitacion();
                tabla.getModel().setValueAt(s, fila, 6);

                double monto = aux.getReserva().getMonto();
                tabla.getModel().setValueAt(monto, fila, 7);
                
                
                aux = aux.getSiguiente();
                
                fila++;
            }
            
        }
        
        else {
            JOptionPane.showMessageDialog(null, "Vacio");
        }
    }
    
    // metodo para extraer de lista enlazada simple a lista circular simple
    public void extraer() {
        if (!vacio()) {
            Nodo aux = inicio;
            Servidor.listaCFacturas = new ListaSC();
            while (aux!=null) {
                Servidor.listaCFacturas.agregar(aux.getReserva());
                aux = aux.getSiguiente();
            }
            JOptionPane.showMessageDialog(null, "Ingresos totales del dia: $" + Servidor.listaCFacturas.sumaRecur());
        } else {
            JOptionPane.showMessageDialog(null, "No hay reservas realizadas hoy");
        }
    }
}
