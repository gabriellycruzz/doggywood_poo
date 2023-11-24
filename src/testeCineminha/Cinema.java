package testeCineminha;

import java.util.ArrayList;
import java.util.List;

public class Cinema {
    private List<Sala> salas;
    private List<Filme> filmes;
    private List<Ingresso> ingressos;

    public Cinema() {
        salas = new ArrayList<>();
        filmes = new ArrayList<>();
        ingressos = new ArrayList<>();
    }

    public void addSala(Sala sala) {
        salas.add(sala);
    }

    public List<Sala> getSalas() {
        return salas;
    }
    
    public void removerSala(Sala sala) {
        salas.remove(sala);
    }


    public void adicionarFilme(Filme filme) {
        filmes.add(filme);
    }

    public void removerFilme(Filme filme) {
        filmes.remove(filme);
    }
    

    public List<Filme> getFilmes() {
        return filmes;
    }

    public void adicionarIngresso(Ingresso ingresso) {
        ingressos.add(ingresso);
    }

    public void removerIngresso(Ingresso ingresso) {
        ingressos.remove(ingresso);
    }

    public List<Ingresso> getIngressos() {
        return ingressos;
    }
}
