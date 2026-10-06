package vista;

import java.util.List;
import java.util.Scanner;
import modelo.ModuloSatelite;

/**
 * VISTA (MVC): unica clase que lee del teclado e imprime en consola.
 * No contiene reglas de negocio ni conoce el catalogo.
 * Solo usa metodos publicos de ModuloSatelite (toString), nunca sus atributos.
 */
public class VistaConsola {
    private final Scanner scanner = new Scanner(System.in);

    public void mostrarMenu() {
        System.out.println();
        System.out.println(" /\\_/\\");
        System.out.println("( o.o )  QUETZAL-2 : CENTRO DE CONTROL  (estilo The Battle Cats)");
        System.out.println(" > ^ <");
        System.out.println("==================================================================");
        System.out.println(" 1. Listar todos los modulos");
        System.out.println(" 2. Buscar modulo por ID");
        System.out.println(" 3. Buscar modulo por nombre");
        System.out.println(" 4. Ordenar catalogo por costo de construccion");
        System.out.println(" 0. Salir");
        System.out.println("==================================================================");
    }

    /** Muestra la ficha completa de un modulo (un dato por linea). */
    public void mostrar(ModuloSatelite modulo) {
        String[] partes = modulo.toString().split(" \\| ");
        System.out.println("------------------------------------------------------------------");
        System.out.println(partes[0]);
        for (int i = 1; i < partes.length; i++) {
            System.out.println("    " + partes[i]);
        }
        System.out.println("------------------------------------------------------------------");
    }

    /** Overloading: lista compacta (una linea por modulo). */
    public void mostrar(List<ModuloSatelite> modulos) {
        System.out.println("------------------------------------------------------------------");
        if (modulos.isEmpty()) {
            System.out.println("El catalogo esta vacio.");
        }
        for (ModuloSatelite m : modulos) {
            System.out.println(m);
        }
        System.out.println("------------------------------------------------------------------");
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    /** Repite la pregunta hasta que el usuario escriba un entero valido. */
    public int leerEntero(String pregunta) {
        while (true) {
            System.out.print(pregunta);
            String linea = scanner.hasNextLine() ? scanner.nextLine().trim() : "0";
            try {
                return Integer.parseInt(linea);
            } catch (NumberFormatException e) {
                System.out.println("Entrada invalida: escriba un numero entero.");
            }
        }
    }

    public String leerTexto(String pregunta) {
        System.out.print(pregunta);
        return scanner.hasNextLine() ? scanner.nextLine().trim() : "";
    }
}
