package unidade3.com.abctreinamentos;

public class Curso {
	
	long cdCurso;
	String nome, url;
	double valor;
	
	public Curso(long cdCurso, String nome, String url, double valor) {
		super();
		this.cdCurso = cdCurso;
		this.nome = nome;
		this.url = url;
		this.valor = valor;
	}

	public long getCdCurso() {
		return cdCurso;
	}

	public void setCdCurso(long cdCurso) {
		this.cdCurso = cdCurso;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	@Override
	public String toString() {
		return "Curso [cdCurso=" + cdCurso + ", nome=" + nome + ", url=" + url + ", valor=" + valor + "]";
	}	
	
}
