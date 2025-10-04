public abstract class Proceso {
    protected String nombre;
    protected int pid;

    public Proceso(String nombre, int pid) {
        this.nombre = nombre;
        this.pid = pid;
    }
    public String getNombre() {
        return nombre;
    }
    public int getPid() {
        return pid;
    }
    public abstract String ejecutar();
    
    @Override
    public String toString() {
        return "Proceso: " + nombre + " (PID: " + pid + ")";
    }
}