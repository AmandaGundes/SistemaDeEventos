package senai;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public abstract class Evento implements Agendamento {
	
	private String nome;
	private LocalDate data;
	private String descricao;
	private Usuario organizador;
	protected List<Usuario> participantes;
	private CategoriaEvento categoria;
	
	public Evento(String nome, LocalDate data, String descricao, Usuario organizador) {
		this.nome = nome;
		this.data = data;
		this.descricao = descricao;
		this.organizador = organizador;
		this.participantes = new MeuArrayList<Usuario>();
		this.categoria = CategoriaEvento.CONFERENCIA;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}
	
	public void setData(String data) {
		String format = "dd/MM/yyyy";
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
		this.data = LocalDate.parse(data, formatter);
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Usuario getOrganizador() {
		return organizador;
	}

	public void setOrganizador(Usuario organizador) {
		this.organizador = organizador;
	}
	
	public CategoriaEvento getCategoria() {
		return categoria;
	}

	public void setCategoria(CategoriaEvento categoria) {
		this.categoria = categoria;
	}

	public void addParticipante(Usuario participante) {
		if (participante == this.organizador) {
			throw new RuntimeException("O participante informado é o organizador do evento.");
		}
		this.verificarLimitesPacote();
		this.participantes.add(participante);
	}
	
	protected void verificarLimitesPacote() {
		switch (this.organizador.getPacote()) {
		case GRATUITO:
			if (this.participantes.size() > 50) {
				throw new RuntimeException("O pacote gratuito permite eventos de até 50 pessoas");
			}
			break;
		case BASICO:
			if (this.participantes.size() > 100) {
				throw new RuntimeException("O pacote básico permite eventos de até 100 pessoas");
			}
			break;
		case PROFISSIONAL:
			if (this.participantes.size() > 500) {
				throw new RuntimeException("O pacote profissional permite eventos de até 500 pessoas");
			}
			break;
		case PREMIUM:
			if (this.participantes.size() > 1000) {
				throw new RuntimeException("O pacote premium permite eventos de até 1000 pessoas");
			}
			break;
		default:
			break;
		}
	}
	
	public void verificarCategoriaEvento() {
		switch (this.getCategoria()) {
		case PALESTRA:
			System.out.println("Este evento é uma palestra.");
			break;
		case SIMPOSIO:
			System.out.println("Este evento é um simpósio.");
			break;
		case CONFERENCIA:
			System.out.println("Este evento é uma conferência.");
			break;
		case SHOW:
			System.out.println("Este evento é um show.");
			break;
		case APRESENTACAO:
			System.out.println("Este evento é uma apresentação.");
			break;
		default:
			break;
		}
	}
	
	public void removeParticipante(Usuario participante) {
		this.participantes.remove(participante);
	}

	@Override
	public String toString() {
		return "Evento [nome=" + nome + ", data=" + data + ", descricao=" + descricao + ", organizador=" + organizador
				+ ", participantes=" + participantes + "]";
	}

	

}
