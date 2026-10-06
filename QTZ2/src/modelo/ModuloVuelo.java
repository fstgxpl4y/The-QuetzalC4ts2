package modelo;

public abstract class ModuloVuelo extends ModuloSatelite {
    private int consumoEnergia;

    public ModuloVuelo(int id, String nombre, int salud, double costo, int consumoEnergia) {
        super(id, nombre, salud, costo);
        this.consumoEnergia = Math.max(0, consumoEnergia);
    }

    public ModuloVuelo(int id, String nombre, double costo, int consumoEnergia) {
        super(id, nombre, costo);
        this.consumoEnergia = Math.max(0, consumoEnergia);
    }

    public abstract int calcularDatos();

    @Override
    protected void ejecutarCiclo(EstadoMision estado) {
        if (estado.consumirEnergia(consumoEnergia)) {
            estado.registrarDatos(escalarPorSalud(calcularDatos()));
        }
    }

    @Override
    public String getCategoria() { return "Vuelo"; }

    @Override
    protected String getDetalles() { return "Consumo de energia: " + consumoEnergia; }

    public int getConsumoEnergia() { return consumoEnergia; }
    public void setConsumoEnergia(int consumoEnergia) { this.consumoEnergia = Math.max(0, consumoEnergia); }
}