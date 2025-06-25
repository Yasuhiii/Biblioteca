package biblioteca;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Biblioteca bib = new Biblioteca();
        Scanner sc = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\n--- Menu Biblioteca ---");
            System.out.println("1. Adicionar Livro");
            System.out.println("2. Remover Livro");
            System.out.println("3. Adicionar Utilizador");
            System.out.println("4. Remover Utilizador");
            System.out.println("5. Emprestar Livro");
            System.out.println("6. Devolver Livro");
            System.out.println("7. Ver Livros");
            System.out.println("8. Ver Utilizadores");
            System.out.println("9. Ver Empréstimos");
            System.out.println("0. Sair");
            System.out.print("Opção: ");
            opcao = sc.nextInt(); sc.nextLine();

            switch (opcao) {
                case 1:
                    System.out.print("Título: ");
                    String t = sc.nextLine();
                    System.out.print("Autor: ");
                    String a = sc.nextLine();
                    System.out.print("ISBN: ");
                    String i = sc.nextLine();
                    System.out.print("Ano: ");
                    int an = sc.nextInt(); sc.nextLine();
                    bib.adicionarLivro(new Livro(t, a, i, an));
                    break;
                case 2:
                    System.out.print("ISBN do livro: ");
                    bib.removerLivro(sc.nextLine());
                    break;
                case 3:
                    System.out.print("Nome: ");
                    String n = sc.nextLine();
                    System.out.print("ID: ");
                    String id = sc.nextLine();
                    System.out.print("Email: ");
                    String em = sc.nextLine();
                    System.out.print("Telefone: ");
                    String tel = sc.nextLine();
                    bib.adicionarUtilizador(new Utilizador(n, id, em, tel));
                    break;
                case 4:
                    System.out.print("ID do utilizador: ");
                    bib.removerUtilizador(sc.nextLine());
                    break;
                case 5:
                    System.out.print("ISBN do livro: ");
                    String isb = sc.nextLine();
                    System.out.print("ID do utilizador: ");
                    String idi = sc.nextLine();
                    bib.emprestarLivro(isb, idi);
                    break;
                case 6:
                    System.out.print("ISBN do livro: ");
                    bib.devolverLivro(sc.nextLine());
                    break;
                case 7:
                    bib.listarLivros();
                    break;
                case 8:
                    bib.listarUtilizadores();
                    break;
                case 9:
                    bib.consultarEmprestimos();
                    break;
                case 0:
                    System.out.println("Até logo!");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (opcao != 0);

        sc.close();
    }
}