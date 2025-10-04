public class ProcesoIO extends Proceso {
    public ProcesoIO(String nombre, int pid) {
        super(nombre, pid);
    }
    @Override
    public String ejecutar() {
        return toString() + " ejecutó proceso de I/O.";
    }
}