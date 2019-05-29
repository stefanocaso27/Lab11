package it.polito.tdp.bar.model;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Evento implements Comparable<Evento> {
	
	public enum TipoEvento {
		ARRIVO_GRUPPO,
		USCITA
	}
	
	private int numEvento;
	private LocalTime tempo ;
	private TipoEvento tipo ;
	private List<Tavolo> tavoli = new ArrayList<>();
	
	public Evento(int numEvento, LocalTime tempo, TipoEvento tipo) {
		super();
		this.numEvento = numEvento;
		this.tempo = tempo;
		this.tipo = tipo;
	}

	@Override
	public int compareTo(Evento o) {
		// TODO Auto-generated method stub
		return 0;
	}

	public LocalTime getTempo() {
		return tempo;
	}

	public void setTempo(LocalTime tempo) {
		this.tempo = tempo;
	}

	public TipoEvento getTipo() {
		return tipo;
	}

	public void setTipo(TipoEvento tipo) {
		this.tipo = tipo;
	}

	public int getNumEvento() {
		return numEvento;
	}

	public void setNumEvento(int numEvento) {
		this.numEvento = numEvento;
	}

	@Override
	public String toString() {
		return "Evento [tempo=" + tempo + ", tipo=" + tipo + "]";
	}

}
