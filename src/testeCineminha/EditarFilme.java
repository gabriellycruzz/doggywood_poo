package testeCineminha;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class EditarFilme {
    
    public static void editarFilme(Filme filme, Scanner scanner) {
        int opcao = 0;
        do {
            System.out.println("Opções de edição do filme:");
            System.out.println("1. Editar nome");
            System.out.println("2. Editar duração");
            System.out.println("3. Editar gênero");
            System.out.println("4. Editar classificação indicativa");
            System.out.println("5. Editar sinopse");
            System.out.println("6. Editar diretor");
            System.out.println("7. Editar data de estreia");
            System.out.println("8. Voltar");

            opcao = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcao) {
                case 1:
                    System.out.println("Digite o novo nome do filme:");
                    String nome = scanner.nextLine();
                    filme.setNome(nome);
                    System.out.println("Nome do filme atualizado.");
                    break;
                case 2:
                    System.out.println("Digite a nova duração do filme em minutos:");
                    int duracao = scanner.nextInt();
                    filme.setDuracao(duracao);
                    System.out.println("Duração do filme atualizada.");
                    break;
                case 3:
                    System.out.println("Digite o novo gênero do filme:");
                    String genero = scanner.nextLine();
                    filme.setGenero(genero);
                    System.out.println("Gênero do filme atualizado.");
                    break;
                case 4:
                    System.out.println("Digite a nova classificação indicativa do filme:");
                    String classificacao = scanner.nextLine();
                    filme.setClassificacao(classificacao);
                    System.out.println("Classificação indicativa do filme atualizada.");
                    break;
                case 5:
                    System.out.println("Digite a nova sinopse do filme:");
                    String sinopse = scanner.nextLine();
                    filme.setSinopse(sinopse);
                    System.out.println("Sinopse do filme atualizada.");
                    break;
                case 6:
                    System.out.println("Digite o novo diretor do filme:");
                    String diretor = scanner.nextLine();
                    filme.setDiretor(diretor);
                    System.out.println("Diretor do filme atualizado.");
                    break;
                case 7:
                    System.out.println("Digite a nova data de estreia do filme (formato: dd/MM/yyyy):");
                    String dataEstreiaStr = scanner.nextLine();
                    LocalDate dataEstreia = LocalDate.parse(dataEstreiaStr, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                    filme.setDataEstreia(dataEstreia);
                    System.out.println("Data de estreia do filme atualizada.");
                    break;
                case 8:
                    System.out.println("Voltando ao menu anterior...");
                    break;
                default:
                    System.out.println("Opção inválida.");
                    break;
            }
        } while (opcao != 8);
    }
}
