package testeCineminha;

import java.util.Scanner;

public class AdicionarSala {
    private Scanner scanner;

    public AdicionarSala(Scanner scanner) {
        this.scanner = scanner;
    }

    public Sala adicionarSala() {
        System.out.println("Digite o número da sala:");
        int numero = scanner.nextInt();
        scanner.nextLine(); 

        System.out.println("Digite a capacidade da sala:");
        int capacidade = scanner.nextInt();
        scanner.nextLine(); 

        Sala sala = new Sala(numero, capacidade);

        System.out.println("Digite a quantidade de assentos a serem adicionados:");
        int quantidadeAssentos = scanner.nextInt();
        scanner.nextLine(); 

        for (int i = 0; i < quantidadeAssentos; i++) {
            Assento assento = new Assento(i + 1);
            sala.adicionarAssento(assento);
        }

        return sala;
    }
}

