import java.util.ArrayList;
import java.util.List;

public class Controlador {
    private Proceso procesoActual;
    private List<Proceso> listaProcesos;

    public Controlador() {
        this.listaProcesos = new ArrayList<>();
        listaProcesos.add(new ProcesoCPU("sum", 201));
        listaProcesos.add(new ProcesoCPU("sub", 202));
        listaProcesos.add(new ProcesoCPU("mul", 203));
        listaProcesos.add(new ProcesoCPU("div", 204));
        listaProcesos.add(new ProcesoIO("read", 301));
        listaProcesos.add(new ProcesoIO("write", 302));
        listaProcesos.add(new ProcesoIO("open", 303));
        listaProcesos.add(new ProcesoIO("close", 304));
        listaProcesos.add(new Daemon("logger", 401));
        listaProcesos.add(new Daemon("monitor", 402));
        listaProcesos.add(new Daemon("updater", 403));
        listaProcesos.add(new Daemon("backup", 404));
    }
    public List<Proceso> getListaProcesos() {
        return listaProcesos;
    }
    public boolean validarProceso(Proceso proceso) {
        for (Proceso p : listaProcesos) {
            if (p.getPid() == proceso.getPid() && p.getNombre().equals(proceso.getNombre())
                && p.getClass() == proceso.getClass()) {
                return true;
            }
        }
        return false;
    }
    public void setProceso(Proceso nuevoProceso) {
        this.procesoActual = nuevoProceso;
    }
    public void ejecutarProceso(Proceso proceso) {
        setProceso(proceso);
        System.out.println(proceso.ejecutar());
    }
    public void ejecutarTodos() {
        for (Proceso p : listaProcesos) {
            System.out.println(p.ejecutar());
        }
    }
    public List<Proceso> getProcesosPorTipo(Class<?> tipo) {
        List<Proceso> result = new ArrayList<>();
        for (Proceso p : listaProcesos) {
            if (tipo.isInstance(p)) {
                result.add(p);
            }
        }
        return result;
    }
    
}