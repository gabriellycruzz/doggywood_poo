package testeCineminha;

import java.util.Scanner;

public class RemoverSala {
	
	public void removerSala(Cinema cinema, Scanner scanner) {
        System.out.println("\n=== Remover Sala ===");
        System.out.println("Lista de salas cadastradas:");

        if (cinema.getSalas().isEmpty()) {
            System.out.println("Não há salas cadastradas.");
            return;
        }

        mostrarSalas(cinema);

        System.out.println("Digite o número da sala a ser removida:");
        int salaNumero = scanner.nextInt();
        scanner.nextLine();

        Sala salaRemovida = null;
        for (Sala sala : cinema.getSalas()) {
            if (sala.getNumero() == salaNumero) {
                salaRemovida = sala;
                break;
            }
        }

        if (salaRemovida != null) {
            cinema.removerSala(salaRemovida);
            System.out.println("Sala removida com sucesso!");
        } else {
            System.out.println("Sala não encontrada.");
        }
    }

    private void mostrarSalas(Cinema cinema) {
        System.out.println("\n=== Salas Cadastradas ===");
        for (Sala sala : cinema.getSalas()) {
            System.out.println("Número: " + sala.getNumero());
            System.out.println("Capacidade: " + sala.getCapacidade());
            System.out.println("Assentos disponíveis: " + sala.getAssentosDisponiveis());
            System.out.println("------------------------");
        }
    }

}
