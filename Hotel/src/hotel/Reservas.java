package hotel;


public class Reservas {
    private String id;
    private int ficha;
    private String cliente;
    private long identificacion; // identificacion del cliente
    private int cantAdultos;
    private int cantNinos;
    private String tipoHabitacion;
    private int noches;
    private double monto;
    
    public Reservas() {
        this.id = "";
        this.ficha = 0;
        this.cliente = "";
        this.identificacion = 0;
        this.cantAdultos = 0;
        this.cantNinos = 0;
        this.tipoHabitacion = "";
        this.noches = 0;
        this.monto = 0.00d;

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public long getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(long identificacion) {
        this.identificacion = identificacion;
    }

    public int getCantAdultos() {
        return cantAdultos;
    }

    public void setCantAdultos(int cantAdultos) {
        this.cantAdultos = cantAdultos;
    }

    public int getCantNinos() {
        return cantNinos;
    }

    public void setCantNinos(int cantNinos) {
        this.cantNinos = cantNinos;
    }

    public String getTipoHabitacion() {
        return tipoHabitacion;
    }

    public void setTipoHabitacion(String tipoHabitacion) {
        this.tipoHabitacion = tipoHabitacion;
    }

    public int getNoches() {
        return noches;
    }

    public void setNoches(int noches) {
        this.noches = noches;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    } 

    public int getFicha() {
        return ficha;
    }

    public void setFicha(int ficha) {
        this.ficha = ficha;
    }
    
    
}
