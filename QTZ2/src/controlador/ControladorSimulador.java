package controlador;

import modelo.CatalogoModulos;
import modelo.ModuloSatelite;
import vista.VistaConsola;

/**
 * CONTROLADOR (MVC): recibe la opcion del operador, llama al Modelo y le pide a la
 * Vista que muestre el resultado. No calcula ni imprime directamente.
 *
 * Nota de diseno: el menu solo expone las 4 operaciones del enunciado (listar, buscar
 * por ID, buscar por nombre y ordenar por costo). Ninguna modifica el estado de los
 * modulos, asi que lo mostrado siempre corresponde a la carga inicial.
 */
public class ControladorSimulador {
    private final CatalogoModulos catalogo;
    private final VistaConsola vista;
    private boolean activo;

    public ControladorSimulador(CatalogoModulos catalogo, VistaConsola vista) {
        this.catalogo = catalogo;
        this.vista = vista;
        this.activo = true;
    }

    public void iniciar() {
        while (activo) {
            vista.mostrarMenu();
            ejecutar(vista.leerEntero("Seleccione una opcion: "));
        }
        vista.mostrarMensaje("Fin de la mision. Nyaa~ hasta pronto!");
    }

    private void ejecutar(int opcion) {
        switch (opcion) {
            case 1:
                vista.mostrar(catalogo.getModulos());
                vista.mostrarMensaje("Total de modulos construidos: " + catalogo.cantidad());
                break;
            case 2:
                buscarPorId();
                break;
            case 3:
                buscarPorNombre();
                break;
            case 4:
                ordenar();
                break;
            case 0:
                activo = false;
                break;
            default:
                vista.mostrarMensaje("Opcion no valida. Elija una opcion del menu.");
        }
    }

    private void buscarPorId() {
        int id = vista.leerEntero("ID del modulo: ");
        mostrarResultado(catalogo.buscar(id));
    }

    private void buscarPorNombre() {
        String nombre = vista.leerTexto("Nombre (o parte del nombre): ");
        mostrarResultado(catalogo.buscar(nombre));
    }

    private void mostrarResultado(ModuloSatelite modulo) {
        if (modulo == null) {
            vista.mostrarMensaje("No se encontro ningun modulo con ese dato.");
        } else {
            vista.mostrar(modulo);
        }
    }

    private void ordenar() {
        int sentido = vista.leerEntero("Orden por costo: 1) Ascendente  2) Descendente: ");
        catalogo.ordenarPorCosto(sentido != 2);
        vista.mostrar(catalogo.getModulos());
    }

}
