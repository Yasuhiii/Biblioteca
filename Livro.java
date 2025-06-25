package biblioteca;

// Classe simples que representa um livro
public class Livro {
    public String titulo;
    public String autor;
    public String isbn;
    public int ano;

    public Livro(String titulo, String autor, String isbn, int ano) {
        this.titulo = titulo;
        this.autor = autor;
        this.isbn = isbn;
        this.ano = ano;
    }

    public String toString() {
        return titulo + " - " + autor + " - " + isbn + " - " + ano;
    }
}