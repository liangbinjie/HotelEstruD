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
        if (inicio == null) {
            return true;
        } else {
            return false;
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
