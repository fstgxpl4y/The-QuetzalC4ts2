package modelo;

public abstract class ModuloTierra extends ModuloSatelite {
    private int consumoEnergia;
    private int anchoBanda;

    public ModuloTierra(int id, String nombre, int salud, double costo, int consumoEnergia, int anchoBanda) {
        super(id, nombre, salud, costo);
        this.consumoEnergia = Math.max(0, consumoEnergia);
        this.anchoBanda = Math.max(1, anchoBanda);
    }

    public abstract int calcularDescarga();

    @Override
    protected void ejecutarCiclo(EstadoMision estado) {
        if (estado.getDatosPendientes() > 0 && estado.consumirEnergia(consumoEnergia)) {
            estado.descargarDatos(escalarPorSalud(calcularDescarga()));
        }
    }

    @Override
    public String getCategoria() { return "Tierra"; }

    @Override
    protected String getDetalles() {
        return "Consumo de energia: " + consumoEnergia + " | Ancho de banda: " + anchoBanda;
    }

    public int getConsumoEnergia() { return consumoEnergia; }
    public void setConsumoEnergia(int consumoEnergia) { this.consumoEnergia = Math.max(0, consumoEnergia); }
    public int getAnchoBanda() { return anchoBanda; }
    public void setAnchoBanda(int anchoBanda) { this.anchoBanda = Math.max(1, anchoBanda); }
}
