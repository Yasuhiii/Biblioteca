package biblioteca;

// Implementação simples de fila genérica
public class Fila<T> {
    private static class No<T> {
        T dado;
        No<T> proximo;

        No(T dado) {
            this.dado = dado;
        }
    }

    private No<T> inicio;
    private No<T> fim;

    public void enfileirar(T dado) {
        No<T> novo = new No<>(dado);
        if (fim != null) {
            fim.proximo = novo;
        }
        fim = novo;
        if (inicio == null) {
            inicio = fim;
        }
    }

    public T desenfileirar() {
        if (inicio == null) return null;
        T dado = inicio.dado;
        inicio = inicio.proximo;
        if (inicio == null) fim = null;
        return dado;
    }

    public boolean estaVazia() {
        return inicio == null;
    }
}