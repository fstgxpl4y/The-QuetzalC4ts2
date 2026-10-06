package modelo;

public class EstadoMision {
    private int ciclo;
    private int energiaDisponible;
    private int datosRecolectados;
    private int datosDescargados;

    public EstadoMision() {
        this(0);
    }

    public EstadoMision(int energiaInicial) {
        this.ciclo = 0;
        this.energiaDisponible = Math.max(0, energiaInicial);
        this.datosRecolectados = 0;
        this.datosDescargados = 0;
    }

    public void avanzarCiclo() {
        ciclo++;
    }

    public void generarEnergia(int cantidad) {
        if (cantidad > 0) {
            energiaDisponible += cantidad;
        }
    }

    /** @return true si habia energia suficiente y se consumio; false si no alcanzo, no se consume nada. */
    public boolean consumirEnergia(int cantidad) {
        if (cantidad < 0 || energiaDisponible < cantidad) {
            return false;
        }
        energiaDisponible -= cantidad;
        return true;
    }

    public void registrarDatos(int cantidad) {
        if (cantidad > 0) {
            datosRecolectados += cantidad;
        }
    }

    /**
     * @return la cantidad realmente descargada.
     */
    public int descargarDatos(int cantidad) {
        int real = Math.min(Math.max(cantidad, 0), getDatosPendientes());
        datosDescargados += real;
        return real;
    }

    public int getCiclo() { return ciclo; }
    public int getEnergiaDisponible() { return energiaDisponible; }
    public int getDatosRecolectados() { return datosRecolectados; }
    public int getDatosDescargados() { return datosDescargados; }
    public int getDatosPendientes() { return datosRecolectados - datosDescargados; }

    @Override
    public String toString() {
        return "Ciclo " + ciclo + " | Energia disponible: " + energiaDisponible
                + " | Datos recolectados: " + datosRecolectados
                + " | Datos descargados: " + datosDescargados
                + " | Datos pendientes: " + getDatosPendientes();
    }
}
