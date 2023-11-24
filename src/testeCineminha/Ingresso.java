package testeCineminha;

public class Ingresso {
	   private int numero;
	    private TipoIngresso tipoIngresso;
	    private Filme filme;
	    private Sala sala;
	    private Assento assento;

	    public Ingresso(Filme filme, Sala sala, Assento assento) {
	        this.filme = filme;
	        this.sala = sala;
	        this.assento = assento;
	        this.tipoIngresso = assento.getTipoIngresso();
	        this.numero = assento.getNumero();
	        this.sala = assento.getSala();
	    }

	    public int getNumero() {
	        return numero;
	    }

	    public TipoIngresso getTipoIngresso() {
	        return tipoIngresso;
	    }

	    public Filme getFilme() {
	        return filme;
	    }

	    public Sala getSala() {
	        return sala;
	    }

	    public Assento getAssento() {
	        return assento;
	    }
	}
