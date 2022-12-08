package hotel;

import javax.swing.JOptionPane;

public class ListaSC{

    private Nodo inicio;
    private Nodo fin;

    public ListaSC() {
        this.inicio = null;
        this.fin = null;
    }

    public boolean vacio() {
        return (inicio == null);
    }

    public void agregar(Reservas reserva) {
        Nodo nuevo = new Nodo();
        nuevo.setReserva(reserva);
        
        if (vacio()) {
            inicio = nuevo;
            fin = nuevo;
        } else if (reserva.getFicha() < inicio.getReserva().getFicha()) {
            nuevo.setSiguiente(inicio);
            inicio = nuevo;
            fin.setSiguiente(inicio);
        } else if (reserva.getFicha() > inicio.getReserva().getFicha()) {
            fin.setSiguiente(nuevo);
            fin = nuevo;
            fin.setSiguiente(inicio);
        } else {
            Nodo aux = inicio;
            while (aux.getReserva().getFicha() < reserva.getFicha()) {
                aux = aux.getSiguiente();
            }
            nuevo.setSiguiente(aux.getSiguiente());
            aux.setSiguiente(nuevo);
        }

    }

    public void mostrar() {
        String s = "";
        if (!vacio()) {
            Nodo aux = inicio;
            s += aux.getReserva().getMonto();
            aux = aux.getSiguiente();
            while (aux != inicio) {
                s += aux.getReserva().getMonto();
                aux = aux.getSiguiente();
            }
            JOptionPane.showMessageDialog(null, "Contenido de la lista:\n" + s,
                    "Lista", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Lista Vacía",
                    "Vacía", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public double sumaRecur(){
       return suma(inicio.getReserva().getMonto(),inicio.getSiguiente());
        
    }
    
    
    private double suma(double monto, Nodo node){
        if(node!=inicio){
            monto+=node.getReserva().getMonto();
            return suma(monto, node.getSiguiente());
        }else{
            return monto;
        }
    }
}
