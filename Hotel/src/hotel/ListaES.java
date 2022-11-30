package hotel;

import javax.swing.JOptionPane;

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
}
