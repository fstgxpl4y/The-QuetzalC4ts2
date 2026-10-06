package modelo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class CatalogoModulos {
    private final List<ModuloSatelite> modulos = new ArrayList<>();

    /** @return false si el modulo es nulo o ya existe uno con el mismo ID. */
    public boolean agregar(ModuloSatelite modulo) {
        if (modulo == null || modulos.contains(modulo)) {
            return false;
        }
        return modulos.add(modulo);
    }

    public List<ModuloSatelite> getModulos() {
        return Collections.unmodifiableList(modulos);
    }

    public int cantidad() {
        return modulos.size();
    }

    /** @return el modulo con ese ID o null si no existe. */
    public ModuloSatelite buscar(int id) {
        for (ModuloSatelite m : modulos) {
            if (m.getId() == id) {
                return m;
            }
        }
        return null;
    }

    /** Busca por nombre sin distinguir mayusculas: primero coincidencia exacta, luego parcial. @return null si no hay. */
    public ModuloSatelite buscar(String nombre) {
        if (nombre == null || nombre.trim().isEmpty()) {
            return null;
        }
        String q = nombre.trim().toLowerCase();
        for (ModuloSatelite m : modulos) {
            if (m.getNombre().toLowerCase().equals(q)) {
                return m;
            }
        }
        for (ModuloSatelite m : modulos) {
            if (m.getNombre().toLowerCase().contains(q)) {
                return m;
            }
        }
        return null;
    }

    public void ordenarPorCosto() {
        Collections.sort(modulos);
    }

    public void ordenarPorCosto(boolean ascendente) {
        Collections.sort(modulos);
        if (!ascendente) {
            Collections.reverse(modulos);
        }
    }

    public void procesarCiclo(EstadoMision estado) {
        estado.avanzarCiclo();
        for (ModuloSatelite m : modulos) {
            m.procesarCiclo(estado);
        }
    }
}
