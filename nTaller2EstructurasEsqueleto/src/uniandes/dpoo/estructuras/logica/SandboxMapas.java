package uniandes.dpoo.estructuras.logica;

import java.util.*;

/**
 * Esta clase tiene un conjunto de métodos para practicar operaciones sobre mapas.
 *
 * Todos los métodos deben operar sobre el atributo mapaCadenas que se declara como un Map.
 * 
 * En este mapa, las llaves serán cadenas y los valores serán también cadenas. La relación entre los dos será que cada llave será igual a la cadena del valor, pero invertida.
 * 
 * El objetivo de usar el tipo Map es que sólo puedan usarse métodos de esa interfaz y no métodos adicionales provistos por la implementación concreta (HashMap).
 * 
 * No pueden agregarse nuevos atributos.
 */
public class SandboxMapas {

    private Map<String, String> mapaCadenas;

    public SandboxMapas() {
        mapaCadenas = new HashMap<>();
    }

    public List<String> getValoresComoLista() {
        List<String> valores = new ArrayList<>(mapaCadenas.values());
        Collections.sort(valores);
        return valores;
    }

    public List<String> getLlavesComoListaInvertida() {
        List<String> llaves = new ArrayList<>(mapaCadenas.keySet());
        llaves.sort(Collections.reverseOrder());
        return llaves;
    }

    public String getPrimera() {
        return mapaCadenas.isEmpty() ? null : Collections.min(mapaCadenas.keySet());
    }

    public String getUltima() {
        return mapaCadenas.isEmpty() ? null : Collections.max(mapaCadenas.values());
    }

    public Collection<String> getLlaves() {
        List<String> llavesMayusculas = new ArrayList<>();
        for (String llave : mapaCadenas.keySet()) {
            llavesMayusculas.add(llave.toUpperCase());
        }
        return llavesMayusculas;
    }

    public int getCantidadCadenasDiferentes() {
        Set<String> valoresUnicos = new HashSet<>(mapaCadenas.values());
        return valoresUnicos.size();
    }

    public void agregarCadena(String cadena) {
        String llaveInvertida = new StringBuilder(cadena).reverse().toString();
        mapaCadenas.put(llaveInvertida, cadena);
    }

    public void eliminarCadenaConLLave(String llave) {
        mapaCadenas.remove(llave);
    }

    public void eliminarCadenaConValor(String valor) {
        String llaveInvertida = new StringBuilder(valor).reverse().toString();
        mapaCadenas.remove(llaveInvertida);
    }

    public void reiniciarMapaCadenas(List<Object> objetos) {
        mapaCadenas.clear();
        for (Object obj : objetos) {
            String cadena = obj.toString();
            String llaveInvertida = new StringBuilder(cadena).reverse().toString();
            mapaCadenas.put(llaveInvertida, cadena);
        }
    }

    public void volverMayusculas() {
        Map<String, String> mapaNuevo = new HashMap<>();
        for (Map.Entry<String, String> entry : mapaCadenas.entrySet()) {
            String llaveMayusculas = entry.getKey().toUpperCase();
            mapaNuevo.put(llaveMayusculas, entry.getValue());
        }
        mapaCadenas = mapaNuevo;
    }

    public boolean compararValores(String[] otroArreglo) {
        Set<String> valores = new HashSet<>(mapaCadenas.values());
        for (String valor : otroArreglo) {
            if (!valores.contains(valor)) {
                return false;
            }
        }
        return true;
    }
}
