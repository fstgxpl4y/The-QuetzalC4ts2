package modelo;

public class SensorClimaEspacial extends ModuloVuelo {
    private String magnitudMedida;
    private int sensibilidad;

    public SensorClimaEspacial(int id, String nombre, int salud, double costo, int consumo,
                               String magnitudMedida, int sensibilidad) {
        super(id, nombre, salud, costo, consumo);
        this.magnitudMedida = magnitudMedida;
        this.sensibilidad = Math.max(1, sensibilidad);
    }

    @Override
    public int calcularDatos() { return sensibilidad * 3; }

    @Override
    protected String getDetalles() {
        return super.getDetalles() + " | Magnitud medida: " + magnitudMedida + " | Sensibilidad: " + sensibilidad;
    }

    public String getMagnitudMedida() { return magnitudMedida; }
    public void setMagnitudMedida(String magnitudMedida) { this.magnitudMedida = magnitudMedida; }
    public int getSensibilidad() { return sensibilidad; }
    public void setSensibilidad(int sensibilidad) { this.sensibilidad = Math.max(1, sensibilidad); }
}
