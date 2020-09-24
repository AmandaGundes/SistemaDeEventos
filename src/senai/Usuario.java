package senai;

public class Usuario {
	
	private String nome;
	private PacoteEnum pacote;

	public Usuario(String nome) {
		this.nome = nome;
		this.pacote = PacoteEnum.GRATUITO;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public PacoteEnum getPacote() {
		return pacote;
	}

	public void setPacote(PacoteEnum pacote) {
		this.pacote = pacote;
	}

	@Override
	public String toString() {
		return "Usuario [nome=" + nome + "]";
	}
	

}
