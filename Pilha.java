package biblioteca;

// Implementação simples de pilha genérica
public class Pilha<T> {
    private static class No<T> {
        T dado;
        No<T> proximo;

        No(T dado) {
            this.dado = dado;
        }
    }

    private No<T> topo;

    public void empilhar(T dado) {
        No<T> novo = new No<>(dado);
        novo.proximo = topo;
        topo = novo;
    }

    public T desempilhar() {
        if (topo == null) return null;
        T dado = topo.dado;
        topo = topo.proximo;
        return dado;
    }

    public boolean estaVazia() {
        return topo == null;
    }
}