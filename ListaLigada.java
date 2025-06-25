package biblioteca;

// Implementação simples de lista ligada genérica
public class ListaLigada<T> {
    private No<T> inicio;

    // Classe interna para representar um nó
    private static class No<T> {
        T dado;
        No<T> proximo;

        No(T dado) {
            this.dado = dado;
            this.proximo = null;
        }
    }

    public void adicionar(T dado) {
        No<T> novo = new No<>(dado);
        if (inicio == null) {
            inicio = novo;
        } else {
            No<T> temp = inicio;
            while (temp.proximo != null) {
                temp = temp.proximo;
            }
            temp.proximo = novo;
        }
    }

    public void remover(T dado) {
        if (inicio == null) return;
        if (inicio.dado.equals(dado)) {
            inicio = inicio.proximo;
            return;
        }
        No<T> atual = inicio;
        while (atual.proximo != null && !atual.proximo.dado.equals(dado)) {
            atual = atual.proximo;
        }
        if (atual.proximo != null) {
            atual.proximo = atual.proximo.proximo;
        }
    }

    public void listar() {
        No<T> atual = inicio;
        while (atual != null) {
            System.out.println(atual.dado);
            atual = atual.proximo;
        }
    }

    public T buscar(java.util.function.Predicate<T> criterio) {
        No<T> atual = inicio;
        while (atual != null) {
            if (criterio.test(atual.dado)) {
                return atual.dado;
            }
            atual = atual.proximo;
        }
        return null;
    }
}