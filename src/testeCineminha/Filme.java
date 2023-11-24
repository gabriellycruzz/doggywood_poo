package testeCineminha;

import java.time.LocalDate;

public class Filme {

    private String nome;
    private int duracao;
    private String genero;
    private String classificacao;
    private String sinopse;
    private String diretor;
    private LocalDate dataEstreia;

    public Filme(String nome, int duracao, String genero, String classificacao, String sinopse, String diretor, LocalDate dataEstreia) {
        this.nome = nome;
        this.duracao = duracao;
        this.genero = genero;
        this.classificacao = classificacao;
        this.sinopse = sinopse;
        this.diretor = diretor;
        this.dataEstreia = dataEstreia;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getDuracao() {
        return duracao;
    }

    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getClassificacao() {
        return classificacao;
    }

    public void setClassificacao(String classificacao) {
        this.classificacao = classificacao;
    }

    public String getSinopse() {
        return sinopse;
    }

    public void setSinopse(String sinopse) {
        this.sinopse = sinopse;
    }

    public String getDiretor() {
        return diretor;
    }

    public void setDiretor(String diretor) {
        this.diretor = diretor;
    }

    public LocalDate getDataEstreia() {
        return dataEstreia;
    }

    public void setDataEstreia(LocalDate dataEstreia) {
        this.dataEstreia = dataEstreia;
    }
}
