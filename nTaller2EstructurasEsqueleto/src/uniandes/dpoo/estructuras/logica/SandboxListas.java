package uniandes.dpoo.estructuras.logica;

import java.util.*;

/**
 * Esta clase tiene un conjunto de métodos para practicar operaciones sobre listas de enteros y de cadenas.
 *
 * Todos los métodos deben operar sobre los atributos listaEnteros y listaCadenas.
 * 
 * No pueden agregarse nuevos atributos.
 * 
 * Implemente los métodos usando operaciones sobre listas (ie., no haga cosas como construir arreglos para evitar la manipulación de listas).
 * 
 * Intente usar varias formas de recorrer las listas (while, for, for each, iteradores ... )
 */
public class SandboxListas {

    private List<Integer> listaEnteros;
    private List<String> listaCadenas;

    public SandboxListas() {
        listaEnteros = new ArrayList<>();
        listaCadenas = new LinkedList<>();
    }

    public List<Integer> getCopiaEnteros() {
        return new ArrayList<>(listaEnteros);
    }

    public List<String> getCopiaCadenas() {
        return new LinkedList<>(listaCadenas);
    }

    public int[] getEnterosComoArreglo() {
        int[] arreglo = new int[listaEnteros.size()];
        for (int i = 0; i < listaEnteros.size(); i++) {
            arreglo[i] = listaEnteros.get(i);
        }
        return arreglo;
    }

    public int getCantidadEnteros() {
        return listaEnteros.size();
    }

    public int getCantidadCadenas() {
        return listaCadenas.size();
    }

    public void agregarEntero(int entero) {
        listaEnteros.add(entero);
    }

    public void agregarCadena(String cadena) {
        listaCadenas.add(cadena);
    }

    public void eliminarEntero(int valor) {
        listaEnteros.removeIf(e -> e == valor);
    }

    public void eliminarCadena(String cadena) {
        listaCadenas.removeIf(c -> c.equals(cadena));
    }

    public void insertarEntero(int entero, int posicion) {
        if (posicion < 0) {
            listaEnteros.add(0, entero);
        } else if (posicion >= listaEnteros.size()) {
            listaEnteros.add(entero);
        } else {
            listaEnteros.add(posicion, entero);
        }
    }

    public void eliminarEnteroPorPosicion(int posicion) {
        if (posicion >= 0 && posicion < listaEnteros.size()) {
            listaEnteros.remove(posicion);
        }
    }

    public void reiniciarArregloEnteros(double[] valores) {
        listaEnteros.clear();
        for (double valor : valores) {
            listaEnteros.add((int) valor);
        }
    }

    public void reiniciarArregloCadenas(List<Object> objetos) {
        listaCadenas.clear();
        for (Object obj : objetos) {
            listaCadenas.add(obj.toString());
        }
    }

    public void volverPositivos() {
        for (int i = 0; i < listaEnteros.size(); i++) {
            int valor = listaEnteros.get(i);
            if (valor < 0) {
                listaEnteros.set(i, -valor);
            }
        }
    }

    public void organizarEnteros() {
        listaEnteros.sort(Collections.reverseOrder());
    }

    public void organizarCadenas() {
        Collections.sort(listaCadenas);
    }

    public int contarApariciones(int valor) {
        int count = 0;
        for (int i : listaEnteros) {
            if (i == valor) {
                count++;
            }
        }
        return count;
    }

    public int contarApariciones(String cadena) {
        int count = 0;
        for (String s : listaCadenas) {
            if (s.equalsIgnoreCase(cadena)) {
                count++;
            }
        }
        return count;
    }

    public int contarEnterosRepetidos() {
        Set<Integer> unicos = new HashSet<>();
        Set<Integer> repetidos = new HashSet<>();
        for (int i : listaEnteros) {
            if (!unicos.add(i)) {
                repetidos.add(i);
            }
        }
        return repetidos.size();
    }

    public boolean compararArregloEnteros(int[] otroArreglo) {
        if (listaEnteros.size() != otroArreglo.length) {
            return false;
        }
        for (int i = 0; i < listaEnteros.size(); i++) {
            if (!listaEnteros.get(i).equals(otroArreglo[i])) {
                return false;
            }
        }
        return true;
    }

    public void generarEnteros(int cantidad, int minimo, int maximo) {
        listaEnteros.clear();
        Random random = new Random();
        for (int i = 0; i < cantidad; i++) {
            int valor = random.nextInt((maximo - minimo) + 1) + minimo;
            listaEnteros.add(valor);
        }
    }
}
