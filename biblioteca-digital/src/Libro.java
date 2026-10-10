package src;

import java.util.Objects;

 
public class Libro {
 
    private final String titulo;
    private final String autor;
 
    public Libro(String titulo, String autor) {
        this.titulo = titulo;
        this.autor = autor;
    }
 
    public String getTitulo() { return titulo; }
    public String getAutor() { return autor; }
 
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Libro otro = (Libro) o;
        return Objects.equals(titulo, otro.titulo) && Objects.equals(autor, otro.autor);
    }
 
    @Override
    public int hashCode() {
        return Objects.hash(titulo, autor);
    }
 
    @Override
    public String toString() {
        return "Libro{titulo='" + titulo + "', autor='" + autor + "'}";
    }
}