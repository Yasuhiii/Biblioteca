package biblioteca;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

// Lógica principal do sistema
public class Biblioteca {
    public ListaLigada<Livro> livros = new ListaLigada<>();
    public ListaLigada<Utilizador> utilizadores = new ListaLigada<>();
    public ListaLigada<Emprestimo> emprestimos = new ListaLigada<>();
    public Fila<Utilizador> filaEspera = new Fila<>();
    public Pilha<String> historico = new Pilha<>();

    // Adiciona livro e salva histórico
    public void adicionarLivro(Livro l) {
        livros.adicionar(l);
        historico.empilhar("Livro adicionado: " + l.titulo);
    }

    public void atualizarLivro(String isbn, Livro novo) {
        Livro antigo = livros.buscar(l -> l.isbn.equals(isbn));
        if (antigo != null) {
            removerLivro(isbn);
            adicionarLivro(novo);
        }
    }

    public void removerLivro(String isbn) {
        Livro l = livros.buscar(lv -> lv.isbn.equals(isbn));
        if (l != null) {
            livros.remover(l);
            historico.empilhar("Livro removido: " + l.titulo);
        }
    }

    public void adicionarUtilizador(Utilizador u) {
        utilizadores.adicionar(u);
        historico.empilhar("Utilizador adicionado: " + u.nome);
    }

    public void atualizarUtilizador(String id, Utilizador novo) {
        Utilizador u = utilizadores.buscar(us -> us.id.equals(id));
        if (u != null) {
            removerUtilizador(id);
            adicionarUtilizador(novo);
        }
    }

    public void removerUtilizador(String id) {
        Utilizador u = utilizadores.buscar(us -> us.id.equals(id));
        if (u != null) {
            utilizadores.remover(u);
            historico.empilhar("Utilizador removido: " + u.nome);
        }
    }

    public Livro buscarLivro(String termo) {
        return livros.buscar(l -> l.titulo.contains(termo) || l.autor.contains(termo) || l.isbn.equals(termo));
    }

    public Utilizador buscarUtilizador(String termo) {
        return utilizadores.buscar(u -> u.nome.contains(termo) || u.id.equals(termo));
    }

    public void listarLivros() {
        livros.listar();
    }

    public void listarUtilizadores() {
        utilizadores.listar();
    }

    public void emprestarLivro(String isbn, String id) {
        Livro l = buscarLivro(isbn);
        Utilizador u = buscarUtilizador(id);

        if (l != null && u != null) {
            Emprestimo e = new Emprestimo(l, u, LocalDate.now(), LocalDate.now().plusDays(14));
            emprestimos.adicionar(e);
            historico.empilhar("Empréstimo: " + l.titulo + " para " + u.nome);
        } else {
            System.out.println("Livro ou utilizador não encontrado.");
        }
    }

    public void devolverLivro(String isbn) {
        Emprestimo e = emprestimos.buscar(emp -> emp.livro.isbn.equals(isbn));
        if (e != null) {
            e.dataDevolucao = LocalDate.now();
            historico.empilhar("Devolução: " + e.livro.titulo + " de " + e.utilizador.nome);
        }
    }

    public void consultarEmprestimos() {
        emprestimos.listar();
    }
}