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
	
	public Evento(String nome, LocalDate data, String descricao, Usuario organizador) {
		this.nome = nome;
		this.data = data;
		this.descricao = descricao;
		this.organizador = organizador;
		this.participantes = new MeuArrayList<Usuario>();
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
	
	public void addParticipante(Usuario participante) {
		if (participante == this.organizador) {
			throw new RuntimeException("O participante informado é o organizador do evento.");
		}
		this.participantes.add(participante);
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
