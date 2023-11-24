package testeCineminha;

import java.util.Scanner;

public class CompraIngresso {
	public static void comprarIngresso(Cinema cinema, Scanner scanner, Filme filmeSelecionado) {
        System.out.println("Selecione o filme:");
        MostrarFilmes.mostrarFilmes(cinema.getFilmes());
        int filmeIndex = scanner.nextInt() - 1;
        scanner.nextLine();

        if (filmeIndex >= 0 && filmeIndex < cinema.getFilmes().size()) {
            Filme filmeSelecionado1 = cinema.getFilmes().get(filmeIndex);

            System.out.println("Selecione a sala:");
            mostrarSalas(cinema);
            int salaIndex = scanner.nextInt() - 1;
            scanner.nextLine();

            if (salaIndex >= 0 && salaIndex < cinema.getSalas().size()) {
                Sala salaSelecionada = cinema.getSalas().get(salaIndex);

                if (salaSelecionada.getAssentosDisponiveis() > 0) {
                    System.out.println("Escolha o tipo de ingresso:");
                    System.out.println("1. Inteiro");
                    System.out.println("2. Meia-entrada");

                    int tipoIngresso = scanner.nextInt();
                    scanner.nextLine();

                    if (tipoIngresso == 1) {
                        venderIngressoInteiro(salaSelecionada, filmeSelecionado1);
                    } else if (tipoIngresso == 2) {
                        venderIngressoMeia(cinema, salaSelecionada, filmeSelecionado1, scanner);
                    } else {
                        System.out.println("Opção inválida.");
                    }
                } else {
                    System.out.println("Não há assentos disponíveis nesta sala.");
                }
            } else {
                System.out.println("Sala não encontrada.");
            }
        } else {
            System.out.println("Filme não encontrado.");
        }
    }

    private static void mostrarSalas(Cinema cinema) {
        System.out.println("Lista de salas cadastradas:");
        for (Sala sala : cinema.getSalas()) {
            System.out.println("Número: " + sala.getNumero());
            System.out.println("Capacidade: " + sala.getCapacidade());
            System.out.println("Assentos disponíveis: " + sala.getAssentosDisponiveis());
            System.out.println("------------------------");
        }
    }

    private static void venderIngressoInteiro(Sala sala, Filme filme) {
        Assento assentoDisponivel = sala.buscarAssentoDisponivel();
        if (assentoDisponivel != null) {
            assentoDisponivel.ocuparAssento(filme, TipoIngresso.INTEIRO);
            System.out.println("Ingresso vendido: " + assentoDisponivel.getTipoIngresso());
        } else {
            System.out.println("Não há assentos disponíveis nesta sala.");
        }
    }

    private static void venderIngressoMeia(Cinema cinema, Sala sala, Filme filme, Scanner scanner) {
        System.out.println("Selecione o tipo de meia-entrada:");
        System.out.println("1. Estudante");
        System.out.println("2. Menor de idade");
        System.out.println("3. Idoso");

        int tipoMeia = scanner.nextInt();
        scanner.nextLine();

        TipoIngresso tipoIngresso;

        switch (tipoMeia) {
            case 1:
                tipoIngresso = TipoIngresso.MEIA_ESTUDANTE;
                break;
            case 2:
                tipoIngresso = TipoIngresso.MEIA_MENOR_IDADE;
                break;
            case 3:
                tipoIngresso = TipoIngresso.MEIA_IDOSO;
                break;
            default:
                System.out.println("Opção inválida.");
                return;
        }

        Assento assentoDisponivel = sala.buscarAssentoDisponivel();
        if (assentoDisponivel != null) {
            assentoDisponivel.ocuparAssento(filme, tipoIngresso);
            cinema.adicionarIngresso(assentoDisponivel.getIngresso());
            System.out.println("Ingresso de meia-entrada vendido: " + assentoDisponivel.getTipoIngresso());
        } else {
            System.out.println("Não há assentos disponíveis nesta sala.");
        }
    }
}