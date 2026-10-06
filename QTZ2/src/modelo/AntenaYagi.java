package modelo;

public class AntenaYagi extends ModuloTierra {
    private int elementos;

    public AntenaYagi(int id, String nombre, int salud, double costo, int consumo, int anchoBanda, int elementos) {
        super(id, nombre, salud, costo, consumo, anchoBanda);
        this.elementos = Math.max(1, elementos);
    }

    @Override
    public int calcularDescarga() { return getAnchoBanda() + elementos; }

    @Override
    protected String getDetalles() { return super.getDetalles() + " | Elementos: " + elementos; }

    public int getElementos() { return elementos; }
    public void setElementos(int elementos) { this.elementos = Math.max(1, elementos); }
}
