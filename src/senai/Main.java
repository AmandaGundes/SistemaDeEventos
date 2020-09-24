package senai;

import java.time.LocalDate;

public class Main {

	public static void main(String[] args) {
		System.out.println("... Sistema de Eventos ...");
		Usuario usuario1 = new Usuario("João");
		Usuario usuario2 = new Usuario("Maria");
		Usuario usuario3 = new Usuario("André");
		Usuario usuario4 = new Usuario("Lucas");
		Usuario usuario5 = new Usuario("Amanda");
		
		System.out.println("... Evento 1 ...");
		EventoPresencial evento1 = new EventoPresencial("Java for Dummies", LocalDate.of(2020, 9, 11), "Evento presencial criado para iniciantes no Java", usuario1, "SENAI/SC", 2);
		try {
			evento1.addParticipante(usuario2);
		} catch (RuntimeException e) {
			e.printStackTrace();
		}
		try {
			evento1.addParticipante(usuario3);
		} catch (RuntimeException e) {
			e.printStackTrace();
		}
		try {
			evento1.addParticipante(usuario4);
		} catch (RuntimeException e) {
			e.printStackTrace();
		}
		try {
			evento1.addParticipante(usuario5);
		} catch (RuntimeException e) {
			e.printStackTrace();
		}
		evento1.setData("12/10/2020");
		evento1.verificarLimitesPacote();
		evento1.verificarCategoriaEvento();
		System.out.println(evento1);
		
		System.out.println("... Evento 2 ...");
		EventoVirtual evento2 = new EventoVirtual("Python for Dummies", LocalDate.of(2020, 9, 11), "Evento virtual criado para iniciantes no Python", usuario2, "https://eventovirtual.com.br");
		try {
			evento2.addParticipante(usuario2);
		} catch (RuntimeException e) {
			e.printStackTrace();
		}
		evento2.verificarLimitesPacote();
		evento2.verificarCategoriaEvento();
		System.out.println(evento2);
		
		System.out.println("... Compromisso ...");
		Compromisso compromisso = new Compromisso("Reunião de Planejamento", LocalDate.of(2020, 10, 11));
		
		Agendamento[] agendamentos = new Agendamento[3];
		agendamentos[0] = evento1;
		agendamentos[1] = evento2;
		agendamentos[2] = compromisso;
		for (Agendamento agendamento : agendamentos) {
			System.out.println(agendamento);
		}
		
		System.out.println("... FIM ...");


	}

	@Override
	public String toString() {
		return "Main []";
	}

}
