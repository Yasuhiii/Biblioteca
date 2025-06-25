package biblioteca;

import java.time.LocalDate;

// Classe que representa um empréstimo de livro
public class Emprestimo {
    public Livro livro;
    public Utilizador utilizador;
    public LocalDate dataEmprestimo;
    public LocalDate dataPrevista;
    public LocalDate dataDevolucao;

    public Emprestimo(Livro livro, Utilizador utilizador, LocalDate dataEmprestimo, LocalDate dataPrevista) {
        this.livro = livro;
        this.utilizador = utilizador;
        this.dataEmprestimo = dataEmprestimo;
        this.dataPrevista = dataPrevista;
        this.dataDevolucao = null;
    }

    public String toString() {
        return livro.titulo + " emprestado a " + utilizador.nome + " em " + dataEmprestimo + ", devolução prevista: " + dataPrevista;
    }
}