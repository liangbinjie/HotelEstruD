package hotel;


public class Nodo {
    private Reservas reserva;
    private Nodo siguiente;
    
    public Nodo() {
        this.siguiente = null;
    }

    public Reservas getReserva() {
        return reserva;
    }

    public void setReserva(Reservas reserva) {
        this.reserva = reserva;
    }

    public Nodo getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }
    
    
}
