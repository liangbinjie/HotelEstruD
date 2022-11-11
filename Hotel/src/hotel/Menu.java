package hotel;

import javax.swing.JOptionPane;

public class Menu {
    Cola c = new Cola();
    int op;
    
    public void menu() {
        op = Integer.parseInt(JOptionPane.showInputDialog(null, "MENU PRINCIPAL"
                + "\n1. Obtener ficha"
                + "\n2. Mostrar cola"
                + "\n3. Atender"));
        
        switch(op) {
            case 1 -> {
                c.nueva_ficha();
                menu();
                break;
            }
            
            case 2 -> {
                c.mostrar_cola();
                menu();
                break;
            }
            
            case 3 -> {
                c.atender();
                menu();
                break;
            }
            
            default -> {
                    System.exit(0);
                    }
        }
    }
}
