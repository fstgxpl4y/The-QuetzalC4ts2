package modelo;

public class CamaraOrbital extends ModuloVuelo {
    private int resolucionMP;

    public CamaraOrbital(int id, String nombre, int salud, double costo, int consumo, int resolucionMP) {
        super(id, nombre, salud, costo, consumo);
        this.resolucionMP = Math.max(1, resolucionMP);
    }

    public CamaraOrbital(int id, String nombre, double costo, int consumo, int resolucionMP) {
        super(id, nombre, costo, consumo);
        this.resolucionMP = Math.max(1, resolucionMP);
    }

    @Override
    public int calcularDatos() { return resolucionMP; }

    @Override
    protected String getDetalles() { return super.getDetalles() + " | Resolucion: " + resolucionMP + " MP"; }

    public int getResolucionMP() { return resolucionMP; }
    public void setResolucionMP(int resolucionMP) { this.resolucionMP = Math.max(1, resolucionMP); }
}
