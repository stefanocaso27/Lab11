package it.polito.tdp.bar.model;

import java.time.Duration;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Random;

import it.polito.tdp.bar.model.Evento.TipoEvento;

public class Simulatore {
	
	// Coda degli eventi
		private PriorityQueue<Evento> queue = new PriorityQueue<>();
		
	// Stato del mondo
		private List<Evento> eventi;
		
	// Variabili interne
		private Random rand = new Random();
		private Duration T_ARRIVAL = Duration.ofMinutes(rand.nextInt(10)+1);
		
		public Simulatore() {
			this.eventi = new ArrayList<Evento>();
		}
		
	// Parametri di simulazione
		private LocalTime T_inizio = LocalTime.of(8, 0);
		
	// Statistiche raccolte
		private int numeroTotaleClienti ;
		private int numeroClientiSoddisfatti;
		private int numeroClientiInsoddisfatti;
		
		public void init() {
			//creare eventi
			LocalTime oraArrivo = T_inizio;
			eventi.clear();
			
			for (int i = 0; i < 2000; i++) {
				Evento e = new Evento(i+1, oraArrivo, TipoEvento.ARRIVO_GRUPPO);
				eventi.add(e);
				
				oraArrivo = oraArrivo.plus(T_ARRIVAL);
			}
		}
		
		public void run() {

			while (!queue.isEmpty()) {
				Evento ev = queue.poll();
				
				switch (ev.getTipo()) {
				case ARRIVO_GRUPPO:
					queue.add(new Evento(ev.getNumEvento(), ev.getTempo(), ev.getTipo()));
					
					break;
					
				case USCITA:
					queue.add(new Evento (ev.getNumEvento(), ev.getTempo(), ev.getTipo()));
					
					break;
				}
			}
			
			
		}
		
}
