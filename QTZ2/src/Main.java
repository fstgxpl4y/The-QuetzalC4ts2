import controlador.ControladorSimulador;
import modelo.CargaInicial;
import modelo.CatalogoModulos;
import vista.VistaConsola;

public class Main {
    public static void main(String[] args) {
        CatalogoModulos catalogo = new CatalogoModulos();
        CargaInicial.cargar(catalogo);
        VistaConsola vista = new VistaConsola();
        new ControladorSimulador(catalogo, vista).iniciar();
    }
}
