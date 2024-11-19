package competenciaatletica;

import java.util.ArrayList;

public class Competencia {
    private final ArrayList<Atleta> atletas;

    public Competencia() {
        this.atletas = new ArrayList<>();
    }

    public void registrarAtleta(String nombre, String nacionalidad, double tiempo) {
        if (atletas.size() < 10) {
            atletas.add(new Atleta(nombre, nacionalidad, tiempo));
            System.out.println("Atleta registrado exitosamente.");
        } else {
            System.out.println("Ya se han registrado los 10 atletas.");
        }
    }

    public Atleta obtenerCampeon() {
        if (atletas.isEmpty()) {
            return null;
        }
        Atleta campeon = atletas.get(0);
        for (Atleta atleta : atletas) {
            if (atleta.getTiempo() < campeon.getTiempo()) {
                campeon = atleta;
            }
        }
        return campeon;
    }

    public void mostrarAtletasPorPais(String pais) {
        boolean encontrado = false;
        for (Atleta atleta : atletas) {
            if (atleta.getNacionalidad().equalsIgnoreCase(pais)) {
                System.out.println(atleta);
                encontrado = true;
            }
        }
        if (!encontrado) {
            System.out.println("No hay atletas de " + pais + ".");
        }
    }

    public double calcularTiempoPromedio() {
        if (atletas.isEmpty()) {
            return 0.0;
        }
        double suma = 0;
        for (Atleta atleta : atletas) {
            suma += atleta.getTiempo();
        }
        return suma / atletas.size();
    }
}
