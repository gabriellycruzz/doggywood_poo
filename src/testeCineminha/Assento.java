package testeCineminha;

public class Assento {

	    private int numero;
	    private boolean ocupado;
	    private Filme filme;
	    private TipoIngresso tipoIngresso;
	    private Sala sala;

	    public Assento(int numero) {
	        this.numero = numero;
	        ocupado = false;
	    }

	    public int getNumero() {
	        return numero;
	    }

	    public boolean isOcupado() {
	        return ocupado;
	    }

	    public void setOcupado(boolean ocupado) {
	        this.ocupado = ocupado;
	    }

	    public Filme getFilme() {
	        return filme;
	    }

	    public void setFilme(Filme filme) {
	        this.filme = filme;
	    }

	    public TipoIngresso getTipoIngresso() {
	        return tipoIngresso;
	    }

	    public void setTipoIngresso(TipoIngresso tipoIngresso) {
	        this.tipoIngresso = tipoIngresso;
	    }

	    public Sala getSala() {
	        return sala;
	    }

	    public void setSala(Sala sala) {
	        this.sala = sala;
	    }

	    public void ocuparAssento(Filme filme, TipoIngresso tipoIngresso) {
	        this.filme = filme;
	        this.tipoIngresso = tipoIngresso;
	        ocupado = true;
	    }
	    
	    public void ocupar() {
	        ocupado = true;
	    }

	    public Ingresso getIngresso() {
	        return new Ingresso(filme, sala, this);
	    }
}

