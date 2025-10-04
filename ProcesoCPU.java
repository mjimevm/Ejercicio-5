public class ProcesoCPU extends Proceso {
    public ProcesoCPU(String nombre, int pid) {
        super(nombre, pid);
    }
    @Override
    public String ejecutar() {
        return toString() + " ejecutó proceso de CPU.";
    }
}