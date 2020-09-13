package senai;

import java.time.LocalDate;

public class EventoPresencial extends Evento {

	private String localizacao;
	private int capacidadeMaxima;

	public EventoPresencial(String nome, LocalDate data, String descricao, Usuario organizador, String localizacao,
			int capacidadeMaxima) {
		super(nome, data, descricao, organizador);
		this.localizacao = localizacao;
		this.capacidadeMaxima = capacidadeMaxima;
	}

	public String getLocalizacao() {
		return localizacao;
	}

	public void setLocalizacao(String localizacao) {
		this.localizacao = localizacao;
	}

	public int getCapacidadeMaxima() {
		return capacidadeMaxima;
	}

	public void setCapacidadeMaxima(int capacidadeMaxima) {
		this.capacidadeMaxima = capacidadeMaxima;
	}
	
	@Override
	public void addParticipante(Usuario participante) {
		if (this.getCapacidadeMaxima() <= this.capacidadeMaxima) {
			super.addParticipante(participante);
		}
		
	}

	@Override
	public String toString() {
		return "EventoPresencial [localizacao=" + localizacao + ", capacidadeMaxima=" + capacidadeMaxima + "]";
	}
	
	

}
