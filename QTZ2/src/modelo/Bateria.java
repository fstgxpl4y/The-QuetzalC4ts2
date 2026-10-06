package modelo;

public class Bateria extends ModuloEnergia {
    private static final int UMBRAL_BAJO = 20; 
    private static final int RITMO = 10;       

    private int cargaActual;

 
    public Bateria(int id, String nombre, int salud, double costo, int capacidadMaxima, int cargaActual) {
        super(id, nombre, salud, costo, capacidadMaxima);
        this.cargaActual = Math.max(0, Math.min(capacidadMaxima, cargaActual));
    }

    @Override
    protected void ejecutarCiclo(EstadoMision estado) {
        int energia = estado.getEnergiaDisponible();
        if (energia < UMBRAL_BAJO && cargaActual > 0) {
            int libera = Math.min(RITMO, cargaActual);
            cargaActual -= libera;
            estado.generarEnergia(escalarPorSalud(libera));
        } else if (energia >= 2 * UMBRAL_BAJO && cargaActual < getCapacidad()) {
            int almacena = Math.min(RITMO, getCapacidad() - cargaActual);
            if (estado.consumirEnergia(almacena)) {
                cargaActual += almacena;
            }
        }
    }

    @Override
    protected String getDetalles() {
        return "Capacidad maxima: " + getCapacidad() + " | Carga actual: " + cargaActual;
    }

    public int getCargaActual() { return cargaActual; }
    public void setCargaActual(int carga) { this.cargaActual = Math.max(0, Math.min(getCapacidad(), carga)); }
}
