public class Daemon extends Proceso {
    public Daemon(String nombre, int pid) {
        super(nombre, pid);
    }
    @Override
    public String ejecutar() {
        return toString() + " ejecutó proceso Daemon.";
    }
}