package testeCineminha;

import java.util.ArrayList;
import java.util.List;

public class Sala {
    private int numero;
    private int capacidade;
    private List<Assento> assentos;

    public Sala(int numero, int capacidade) {
        this.numero = numero;
        this.capacidade = capacidade;
        this.assentos = new ArrayList<>();
    }

    public int getNumero() {
        return numero;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public List<Assento> getAssentos() {
        return assentos;
    }

    public void adicionarAssentos(int quantidade) {
        for (int i = 0; i < quantidade; i++) {
            Assento assento = new Assento(i + 1);
            assentos.add(assento);
        }
    }

    public int getAssentosDisponiveis() {
        int assentosOcupados = 0;
        for (Assento assento : assentos) {
            if (assento.isOcupado()) {
                assentosOcupados++;
            }
        }
        return capacidade - assentosOcupados;
    }

    public int getAssentosOcupados() {
        return capacidade - getAssentosDisponiveis();
    }

    public Assento buscarAssento(int numeroAssento) {
        for (Assento assento : assentos) {
            if (assento.getNumero() == numeroAssento) {
                return assento;
            }
        }
        return null;
    }

    public boolean isAssentoOcupado(int numeroAssento) {
        Assento assento = buscarAssento(numeroAssento);
        return (assento != null && assento.isOcupado());
    }
    
    public Assento buscarAssentoDisponivel() {
        for (Assento assento : assentos) {
            if (!assento.isOcupado()) {
                return assento;
            }
        }
        
        
        return null;
    }
    
    public void adicionarAssento(Assento assento) {
        assentos.add(assento);
    }
} 