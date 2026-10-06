package modelo;

public class AntenaParabolica extends ModuloTierra {
    private double diametroMetros;

    public AntenaParabolica(int id, String nombre, int salud, double costo, int consumo,
                            int anchoBanda, double diametroMetros) {
        super(id, nombre, salud, costo, consumo, anchoBanda);
        this.diametroMetros = Math.max(0.1, diametroMetros);
    }

    @Override
    public int calcularDescarga() { return getAnchoBanda() + (int) Math.round(diametroMetros * 2); }

    @Override
    protected String getDetalles() {
        return super.getDetalles() + " | Diametro: " + diametroMetros + " m";
    }

    public double getDiametroMetros() { return diametroMetros; }
    public void setDiametroMetros(double diametroMetros) { this.diametroMetros = Math.max(0.1, diametroMetros); }
}
