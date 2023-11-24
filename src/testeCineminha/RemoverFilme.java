package testeCineminha;

import java.util.List;
import java.util.Scanner;

public class RemoverFilme {

    public void removerFilme(Cinema cinema, Scanner scanner) {
        List<Filme> filmes = cinema.getFilmes();
        if (filmes.isEmpty()) {
            System.out.println("Não há filmes cadastrados para serem removidos.");
            return;
        }

        System.out.println("Selecione o filme que deseja remover:");

        for (int i = 0; i < filmes.size(); i++) {
            Filme filme = filmes.get(i);
            System.out.println((i + 1) + ". " + filme.getNome());
        }

        int indiceFilme = scanner.nextInt();
        scanner.nextLine();

        if (indiceFilme < 1 || indiceFilme > filmes.size()) {
            System.out.println("Índice inválido.");
            return;
        }

        Filme filmeRemovido = filmes.remove(indiceFilme - 1);
        System.out.println("Filme " + filmeRemovido.getNome() + " removido com sucesso.");
    }
}

