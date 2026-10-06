package modelo;

public abstract class ModuloEnergia extends ModuloSatelite {
    private int capacidad;

    public ModuloEnergia(int id, String nombre, int salud, double costo, int capacidad) {
        super(id, nombre, salud, costo);
        this.capacidad = Math.max(1, capacidad);
    }

    @Override
    public String getCategoria() { return "Energia"; }

    @Override
    protected String getDetalles() { return "Capacidad: " + capacidad; }

    public int getCapacidad() { return capacidad; }
    public void setCapacidad(int capacidad) { this.capacidad = Math.max(1, capacidad); }
}
