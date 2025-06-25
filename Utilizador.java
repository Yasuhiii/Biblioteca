package biblioteca;

// Classe simples que representa um utilizador
public class Utilizador {
    public String nome;
    public String id;
    public String email;
    public String telefone;

    public Utilizador(String nome, String id, String email, String telefone) {
        this.nome = nome;
        this.id = id;
        this.email = email;
        this.telefone = telefone;
    }

    public String toString() {
        return nome + " - " + id + " - " + email + " - " + telefone;
    }
}