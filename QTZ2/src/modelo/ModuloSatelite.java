package modelo;

import java.util.Locale;

public abstract class ModuloSatelite implements Comparable<ModuloSatelite> {
    public static final int SALUD_MAXIMA = 100;

    private final int id;
    private String nombre;
    private int salud;
    private double costoConstruccion;

    public ModuloSatelite(int id, String nombre, int salud, double costo) {
        this.id = id;
        this.nombre = validarNombre(nombre);
        this.salud = limitarSalud(salud);
        this.costoConstruccion = validarCosto(costo);
    }

    public ModuloSatelite(int id, String nombre, double costo) {
        this(id, nombre, SALUD_MAXIMA, costo);
    }

    public void procesarCiclo(EstadoMision estado) {
        if (estado == null || !estaOperativo()) {
            return;
        }
        ejecutarCiclo(estado);
    }

    protected abstract void ejecutarCiclo(EstadoMision estado);

    public abstract String getCategoria();

    protected abstract String getDetalles();


    public void recibirDanio(int puntos) {
        if (puntos > 0) {
            salud = limitarSalud(salud - puntos);
        }
    }

    public void recibirDanio(int puntos, String causa) {
        recibirDanio(puntos);
    }

    public void reparar() {
        salud = SALUD_MAXIMA;
    }

    public void reparar(int puntos) {
        if (puntos > 0) {
            salud = limitarSalud(salud + puntos);
        }
    }

    public boolean estaOperativo() {
        return salud > 0;
    }

    protected int escalarPorSalud(int valor) {
        return valor * salud / SALUD_MAXIMA;
    }

    public int getId() { return id; }
    public String getNombre() { return nombre; }
    public int getSalud() { return salud; }
    public double getCostoConstruccion() { return costoConstruccion; }

    public void setNombre(String nombre) { this.nombre = validarNombre(nombre); }
    public void setSalud(int salud) { this.salud = limitarSalud(salud); }
    public void setCostoConstruccion(double costo) { this.costoConstruccion = validarCosto(costo); }

    // ------------------------------------------------------------ validaciones privadas

    private static int limitarSalud(int s) {
        return Math.max(0, Math.min(SALUD_MAXIMA, s));
    }

    private static String validarNombre(String n) {
        if (n == null || n.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre del modulo no puede estar vacio");
        }
        return n.trim();
    }

    private static double validarCosto(double c) {
        if (c < 0) {
            throw new IllegalArgumentException("El costo de construccion no puede ser negativo");
        }
        return c;
    }

    @Override
    public int compareTo(ModuloSatelite otro) {
        return Double.compare(this.costoConstruccion, otro.costoConstruccion);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ModuloSatelite)) return false;
        return id == ((ModuloSatelite) o).id;
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(id);
    }

    @Override
    public String toString() {
        return String.format(Locale.US, "[%s] #%d %s | Salud: %d/%d | Costo: %.2f XP | %s",
                getCategoria(), id, nombre, salud, SALUD_MAXIMA, costoConstruccion, getDetalles());
    }
}
