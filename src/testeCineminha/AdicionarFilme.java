package testeCineminha;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class AdicionarFilme {
	
	private String nome;
    private int duracao;
    private String genero;
    private String classificacao;
    private String sinopse;
    private String diretor;
    private LocalDate dataEstreia;
	
    private Scanner scanner;
    public AdicionarFilme(Scanner scanner) {
        this.scanner = scanner;

    }
    
    public Filme adicionarFilme() {
    	System.out.println("Digite a duração do filme (em minutos): ");
    	int duracao = scanner.nextInt();
    	scanner.nextLine();
    	
    	System.out.println("Digite o nome do filme: ");
        String nome = scanner.nextLine();

    	System.out.println("Digite o gênero do filme: ");
    	String genero = scanner.nextLine();

    	System.out.println("Digite a classificação indicativa do filme: ");
    	String classificacao = scanner.nextLine();

    	System.out.println("Digite a sinopse do filme: ");
    	String sinopse = scanner.nextLine();

    	System.out.println("Digite o diretor do filme :");
    	String diretor = scanner.nextLine();
        
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate dataEstreia = null;
        while (dataEstreia == null) {
            System.out.println("Digite a data de estreia do filme (no formato aaaa-mm-dd): ");
            String dataEstreiaStr = scanner.next();
            try {
                dataEstreia = LocalDate.parse(dataEstreiaStr, formatter);
            } catch (DateTimeParseException e) {
                System.out.println("Data inválida. Tente novamente.");
            }
        }
        
    	
    	
        Filme filme = new Filme(nome, duracao, genero, classificacao, sinopse, diretor, dataEstreia);
        return filme;
    }
}
