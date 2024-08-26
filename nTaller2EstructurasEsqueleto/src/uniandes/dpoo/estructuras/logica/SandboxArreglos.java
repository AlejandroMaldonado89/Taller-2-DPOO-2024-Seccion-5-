package uniandes.dpoo.estructuras.logica;

import java.util.Arrays;
import java.util.HashMap;

public class SandboxArreglos {

    private int[] arregloEnteros;
    private String[] arregloCadenas;

    public SandboxArreglos() {
        arregloEnteros = new int[]{};
        arregloCadenas = new String[]{};
    }

    public int[] getCopiaEnteros() {
        return Arrays.copyOf(arregloEnteros, arregloEnteros.length);
    }

    public String[] getCopiaCadenas() {
        return Arrays.copyOf(arregloCadenas, arregloCadenas.length);
    }

    public int getCantidadEnteros() {
        return arregloEnteros.length;
    }

    public int getCantidadCadenas() {
        return arregloCadenas.length;
    }

    public void agregarEntero(int entero) {
        arregloEnteros = Arrays.copyOf(arregloEnteros, arregloEnteros.length + 1);
        arregloEnteros[arregloEnteros.length - 1] = entero;
    }

    public void agregarCadena(String cadena) {
        arregloCadenas = Arrays.copyOf(arregloCadenas, arregloCadenas.length + 1);
        arregloCadenas[arregloCadenas.length - 1] = cadena;
    }

    public void eliminarEntero(int valor) {
        int[] nuevoArreglo = new int[arregloEnteros.length];
        int index = 0;
        for (int i : arregloEnteros) {
            if (i != valor) {
                nuevoArreglo[index++] = i;
            }
        }
        arregloEnteros = Arrays.copyOf(nuevoArreglo, index);
    }

    public void eliminarCadena(String cadena) {
        String[] nuevoArreglo = new String[arregloCadenas.length];
        int index = 0;
        for (String s : arregloCadenas) {
            if (!s.equals(cadena)) {
                nuevoArreglo[index++] = s;
            }
        }
        arregloCadenas = Arrays.copyOf(nuevoArreglo, index);
    }

    public void insertarEntero(int entero, int posicion) {
        int[] nuevoArreglo = new int[arregloEnteros.length + 1];
        if (posicion < 0) {
            posicion = 0;
        } else if (posicion > arregloEnteros.length) {
            posicion = arregloEnteros.length;
        }
        for (int i = 0, j = 0; i < nuevoArreglo.length; i++) {
            if (i == posicion) {
                nuevoArreglo[i] = entero;
            } else {
                nuevoArreglo[i] = arregloEnteros[j++];
            }
        }
        arregloEnteros = nuevoArreglo;
    }

    public void eliminarEnteroPorPosicion(int posicion) {
        if (posicion < 0 || posicion >= arregloEnteros.length) {
            return;
        }
        int[] nuevoArreglo = new int[arregloEnteros.length - 1];
        for (int i = 0, j = 0; i < arregloEnteros.length; i++) {
            if (i != posicion) {
                nuevoArreglo[j++] = arregloEnteros[i];
            }
        }
        arregloEnteros = nuevoArreglo;
    }

    public void reiniciarArregloEnteros(double[] valores) {
        arregloEnteros = new int[valores.length];
        for (int i = 0; i < valores.length; i++) {
            arregloEnteros[i] = (int) valores[i];
        }
    }

    public void reiniciarArregloCadenas(Object[] objetos) {
        arregloCadenas = new String[objetos.length];
        for (int i = 0; i < objetos.length; i++) {
            arregloCadenas[i] = objetos[i].toString();
        }
    }

    public void volverPositivos() {
        for (int i = 0; i < arregloEnteros.length; i++) {
            if (arregloEnteros[i] < 0) {
                arregloEnteros[i] = -arregloEnteros[i];
            }
        }
    }

    public void organizarEnteros() {
        Arrays.sort(arregloEnteros);
    }

    public void organizarCadenas() {
        Arrays.sort(arregloCadenas);
    }

    public int contarApariciones(int valor) {
        int count = 0;
        for (int i : arregloEnteros) {
            if (i == valor) {
                count++;
            }
        }
        return count;
    }

    public int contarApariciones(String cadena) {
        int count = 0;
        for (String s : arregloCadenas) {
            if (s.equalsIgnoreCase(cadena)) {
                count++;
            }
        }
        return count;
    }

    public int[] buscarEntero(int valor) {
        int[] posiciones = new int[arregloEnteros.length];
        int index = 0;
        for (int i = 0; i < arregloEnteros.length; i++) {
            if (arregloEnteros[i] == valor) {
                posiciones[index++] = i;
            }
        }
        return Arrays.copyOf(posiciones, index);
    }

    public int[] calcularRangoEnteros() {
        if (arregloEnteros.length == 0) {
            return new int[]{};
        }
        int min = arregloEnteros[0];
        int max = arregloEnteros[0];
        for (int i : arregloEnteros) {
            if (i < min) {
                min = i;
            }
            if (i > max) {
                max = i;
            }
        }
        return new int[]{min, max};
    }

    public HashMap<Integer, Integer> calcularHistograma() {
        HashMap<Integer, Integer> histograma = new HashMap<>();
        for (int i : arregloEnteros) {
            histograma.put(i, histograma.getOrDefault(i, 0) + 1);
        }
        return histograma;
    }

    public int contarEnterosRepetidos() {
        HashMap<Integer, Integer> histograma = calcularHistograma();
        int count = 0;
        for (int value : histograma.values()) {
            if (value > 1) {
                count++;
            }
        }
        return count;
    }

    public boolean compararArregloEnteros(int[] otroArreglo) {
        return Arrays.equals(arregloEnteros, otroArreglo);
    }

    public boolean mismosEnteros(int[] otroArreglo) {
        int[] copia1 = Arrays.copyOf(arregloEnteros, arregloEnteros.length);
        int[] copia2 = Arrays.copyOf(otroArreglo, otroArreglo.length);
        Arrays.sort(copia1);
        Arrays.sort(copia2);
        return Arrays.equals(copia1, copia2);
    }

    public void generarEnteros(int cantidad, int minimo, int maximo) {
        arregloEnteros = new int[cantidad];
        for (int i = 0; i < cantidad; i++) {
            arregloEnteros[i] = minimo + (int)(Math.random() * ((maximo - minimo) + 1));
        }
    }
}
