package modelo;

public class PanelSolar extends ModuloEnergia {
    private int eficiencia;

    public PanelSolar(int id, String nombre, int salud, double costo, int potenciaNominal, int eficiencia) {
        super(id, nombre, salud, costo, potenciaNominal);
        this.eficiencia = Math.max(0, Math.min(100, eficiencia));
    }

    public int calcularProduccion() { return getCapacidad() * eficiencia / 100; }

    @Override
    protected void ejecutarCiclo(EstadoMision estado) {
        estado.generarEnergia(escalarPorSalud(calcularProduccion()));
    }

    @Override
    protected String getDetalles() {
        return "Potencia nominal: " + getCapacidad() + " | Eficiencia: " + eficiencia
                + "% | Produccion por ciclo: " + calcularProduccion();
    }

    public int getEficiencia() { return eficiencia; }
    public void setEficiencia(int eficiencia) { this.eficiencia = Math.max(0, Math.min(100, eficiencia)); }
}