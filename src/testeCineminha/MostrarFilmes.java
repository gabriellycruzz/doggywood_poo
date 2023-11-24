package testeCineminha;

import java.util.List;

public class MostrarFilmes {

    public static void mostrarFilmes(List<Filme> filmes) {
        if (filmes.isEmpty()) {
            System.out.println("Não há filmes cadastrados.");
            return;
        }

        System.out.println("Lista de filmes cadastrados:");

        for (int i = 0; i < filmes.size(); i++) {
            Filme filme = filmes.get(i);
            System.out.println((i + 1) + ". " + filme.getNome());
        }
    }
}
