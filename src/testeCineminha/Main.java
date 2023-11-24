package testeCineminha;

import java.util.Scanner;

public class Main {
    private static final String SENHA_ADMINISTRADOR = "doggywood";

    public static void main(String[] args) {
        Cinema cinema = new Cinema();
        Scanner scanner = new Scanner(System.in);
        AdicionarFilme adicionarFilme = new AdicionarFilme(scanner);
        MostrarFilmes mostrarFilmes = new MostrarFilmes();
        RemoverFilme removerFilme = new RemoverFilme();
        AdicionarSala adicionarSala = new AdicionarSala(scanner);

        int opcao = 0;
        do {
            System.out.println("Bem-vindo ao Doggywood - O cinema dos Doguinhos!");
            System.out.println("Para iniciar, selecione uma opção:");
            System.out.println("1. Acesso Administrador");
            System.out.println("2. Acesso Cliente");
            System.out.println("3. Sair");

            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.println("Digite a senha do administrador:");
                    String senha = scanner.nextLine();
                    if (senha.equals(SENHA_ADMINISTRADOR)) {
                        menuAdministrador(cinema, scanner, adicionarFilme, mostrarFilmes, removerFilme, adicionarSala);
                    } else {
                        System.out.println("Senha incorreta. Acesso negado.");
                    }
                    break;
                case 2:
                    menuCliente(cinema, scanner, mostrarFilmes);
                    break;
                case 3:
                    System.out.println("O Doggywood agradece sua visita! Tenha um ótimo dia! Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida.");
                    break;
            }
        } while (opcao != 3);

        scanner.close();
    }

    private static void menuAdministrador(Cinema cinema, Scanner scanner, AdicionarFilme adicionarFilme, MostrarFilmes mostrarFilmes, RemoverFilme removerFilme, AdicionarSala adicionarSala) {
        int opcao = 0;
        do {
            System.out.println("\n=== Menu Administrador ===");
            System.out.println("Selecione uma opção:");
            System.out.println("1. Adicionar Filme");
            System.out.println("2. Remover Filme");
            System.out.println("3. Editar Filme");
            System.out.println("4. Adicionar Sala");
            System.out.println("5. Remover Sala");
            System.out.println("6. Voltar");

            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    Filme filme = adicionarFilme.adicionarFilme();
                    cinema.adicionarFilme(filme);
                    System.out.println("Filme adicionado com sucesso!");
                    break;
                case 2:
                    removerFilme.removerFilme(cinema, scanner);
                    break;
                case 3:
                    if (cinema.getFilmes().isEmpty()) {
                        System.out.println("Não há filmes cadastrados.");
                    } else {
                        mostrarFilmes.mostrarFilmes(cinema.getFilmes());
                        System.out.println("Digite o número do filme que deseja editar:");
                        int filmeIndex = scanner.nextInt() - 1;
                        scanner.nextLine();
                        if (filmeIndex >= 0 && filmeIndex < cinema.getFilmes().size()) {
                            Filme filmeSelecionado = cinema.getFilmes().get(filmeIndex);
                            EditarFilme editarFilme = new EditarFilme();
                            editarFilme.editarFilme(filmeSelecionado, scanner);
                        } else {
                            System.out.println("Filme não encontrado.");
                        }
                    }
                    break;
                case 4:
                    Sala sala = adicionarSala.adicionarSala();
                    cinema.addSala(sala);
                    System.out.println("Sala adicionada com sucesso!");
                    break;
                case 5:
                    RemoverSala removerSala = new RemoverSala();
                    removerSala.removerSala(cinema, scanner);
                    break;
                case 6:
                    System.out.println("Voltando ao menu principal...");
                    break;
                default:
                    System.out.println("Opção inválida.");
                    break;
            }
        } while (opcao != 6);
    }

    private static void menuCliente(Cinema cinema, Scanner scanner, MostrarFilmes mostrarFilmes) {
        int opcao = 0;
        do {
            System.out.println("\n=== Menu Cliente ===");
            System.out.println("Selecione uma opção:");
            System.out.println("1. Mostrar Filmes");
            System.out.println("2. Mostrar Salas");
            System.out.println("3. Comprar Ingresso");
            System.out.println("4. Voltar");

            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    if (cinema.getFilmes().isEmpty()) {
                        System.out.println("Não há filmes cadastrados.");
                    } else {
                        mostrarFilmes.mostrarFilmes(cinema.getFilmes());
                    }
                    break;
                case 2:
                    if (cinema.getSalas().isEmpty()) {
                        System.out.println("Não há salas cadastradas.");
                    } else {
                        mostrarSalas(cinema);
                    }
                    break;

                case 3:
                    if (cinema.getFilmes().isEmpty()) {
                        System.out.println("Não há filmes cadastrados.");
                    } else {
                        mostrarFilmes.mostrarFilmes(cinema.getFilmes());
                        System.out.println("Digite o número do filme para comprar um ingresso:");
                        int filmeIndex = scanner.nextInt() - 1;
                        scanner.nextLine();
                        if (filmeIndex >= 0 && filmeIndex < cinema.getFilmes().size()) {
                            Filme filmeSelecionado = cinema.getFilmes().get(filmeIndex);
                            Sala salaSelecionada = selecionarSala(cinema, scanner);
                            if (salaSelecionada != null) {
                                CompraIngresso compraIngresso = new CompraIngresso();
                                CompraIngresso.comprarIngresso(cinema, scanner, filmeSelecionado);

                            }
                        } else {
                            System.out.println("Filme não encontrado.");
                        }
                    }
                    break;
                case 4:
                    System.out.println("Voltando ao menu principal...");
                    break;
                default:
                    System.out.println("Opção inválida.");
                    break;
            }
        } while (opcao != 4);
    }

    private static Sala selecionarSala(Cinema cinema, Scanner scanner) {
        System.out.println("\n=== Selecionar Sala ===");
        System.out.println("Lista de salas disponíveis:");

        if (cinema.getSalas().isEmpty()) {
            System.out.println("Não há salas cadastradas.");
            return null;
        }

        mostrarSalas(cinema);

        System.out.println("Digite o número da sala:");
        int salaIndex = scanner.nextInt() - 1;
        scanner.nextLine();

        if (salaIndex >= 0 && salaIndex < cinema.getSalas().size()) {
            Sala salaSelecionada = cinema.getSalas().get(salaIndex);
            System.out.println("Sala selecionada: " + salaSelecionada.getNumero());
            return salaSelecionada;
        } else {
            System.out.println("Sala não encontrada.");
            return null;
        }
    }

    private static void mostrarSalas(Cinema cinema) {
        for (Sala sala : cinema.getSalas()) {
            System.out.println("Sala " + sala.getNumero() + " - Capacidade: " + sala.getCapacidade());
        }
    }

}
