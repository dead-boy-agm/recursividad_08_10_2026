package src; 

public class CatalogoArreglo<T> implements Catalogo<T> {
    private final Object[] elementos;
    private int cantidad;

    public CatalogoArreglo(int capacidad) {
        if (capacidad <= 0) {
            throw new IllegalArgumentException("La capacidad debe ser mayor que 0");
        }
        this.elementos = new Object[capacidad];
        this.cantidad = 0;
    }

    @Override
    public void agregar(T elemento) {
        if (cantidad == elementos.length) {
            throw new IllegalStateException(
                "El catalogo esta lleno (capacidad: " + elementos.length + ")");
        }
        elementos[cantidad++] = elemento;
    }

    @Override
    @SuppressWarnings("unchecked")
    public T obtener(int indice) {
        validarIndice(indice);
        return (T) elementos[indice];
    }

    @Override
    @SuppressWarnings("unchecked")
    public T eliminar(int indice) {
        validarIndice(indice);
        T eliminado = (T) elementos[indice];
        for (int i = indice; i < cantidad - 1; i++) {
            elementos[i] = elementos[i + 1];
        }
        elementos[--cantidad] = null;
        return eliminado;
    }

    @Override
    public int buscar(T elemento) {
        for (int i = 0; i < cantidad; i++) {
            if (elemento == null ? elementos[i] == null : elemento.equals(elementos[i])) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int tamanio() {
        return cantidad;
    }

    private void validarIndice(int indice) {
        if (indice < 0 || indice >= cantidad) {
            throw new IndexOutOfBoundsException(
                "Indice invalido: " + indice + " (tamanio actual: " + cantidad + ")");
        }
    }
}