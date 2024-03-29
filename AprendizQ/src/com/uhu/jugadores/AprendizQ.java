package com.uhu.jugadores;

import java.util.StringTokenizer;

import com.uhu.QLearning.Accion;
import com.uhu.QLearning.EstadoTetris;
import com.uhu.QLearning.ModeloQ;
import com.uhu.utils.Respuesta;

public class AprendizQ extends Jugador {

	private ModeloQ modeloQ;
	private int contPartidas;
	private int partidas;
	private double score = 0;
	private double scoreTotal;
	private double scoreMaximo;
	private int lineas;
	private EstadoTetris s;
	private EstadoTetris sP;
	private int a;
	private int piezaAnt;
	private int pieza;

	public AprendizQ(int partidas) {
		super("Javier.martin816", "AprendizQ_V5.3");
		this.contPartidas = 0;
		this.partidas = partidas;
		this.pieza = -1;
		this.piezaAnt = -1;
		this.a = -1;
		this.s = null;
		this.sP = null;
		this.score = 0;
		this.scoreTotal = 0;
		this.scoreMaximo = 0;
		// TODO:
		// this.modeloQ = new ModeloQ();
		this.modeloQ = new ModeloQ("TablasQ/TablaQ_");
	}

	@Override
	public void inicializar() {
		contPartidas++;
		s = null;
		sP = null;

		// TODO:
		if (modeloQ.getEpsilon() > 0.1)
			modeloQ.setEpsilon(modeloQ.getEpsilon() - 0.003);

		// TODO:
		if (contPartidas % 50 == 0) {
			modeloQ.escribirTablaQ();
		}

		// TODO:
		if (contPartidas > partidas) {
			modeloQ.escribirTablaQ();
			System.out.println("\n\n\t Puntuaci�n media en " + partidas + " partidas es: "
					+ (double) scoreTotal / (double) partidas);
			System.out.println("\n\n\t Puntuaci�n m�xima: " + scoreMaximo);
			System.exit(1);
			System.exit(1);
		} else
			super.arrancar();

	}

	@Override
	public Respuesta pensar(String percepcion) {
		StringTokenizer st = new StringTokenizer(percepcion, ";");
		String orden = st.nextToken().trim().toUpperCase();

		if (orden.equalsIgnoreCase("FIN")) {
			st.nextToken(); // Nombre
			st.nextToken(); // Jugador
			score = Double.parseDouble(st.nextToken());
			if (score > scoreMaximo)
				scoreMaximo = score;
			scoreTotal += score;
			System.out.println("\n\n\n//////////////////////////////////////////////////// Partida: " + contPartidas);
			System.out.println("Score: " + score);
			System.out.println("Epsilon: " + modeloQ.getEpsilon());
			System.out.println("///////////////////////////////////////////////////////////////////");
			inicializar();
		} else if (orden.equalsIgnoreCase("MOV")) {
			if (s == null) {
				s = parsearEstado(percepcion);
				modeloQ.addEstado(s, pieza);
				a = modeloQ.seleccionarAccionEpsilonGreedy(s, pieza);
				return Accion.convertir(a, pieza);
			} else {
				sP = parsearEstado(percepcion);
				modeloQ.addEstado(sP, pieza);

				// TODO:
				double r;
				if (lineas > 0)
					r = lineas * 10;
				else
					r = (s.getMaxAlt() - sP.getMaxAlt()) * 10 + 15 * (s.getHoles() - sP.getHoles())
							+ (s.getBumpiness() - sP.getBumpiness()) * 7;

				modeloQ.actualizarQ(s, a, sP, r, piezaAnt, pieza);

				// TODO:
				// Depurar:
				// System.out.println("///////////////////////////////////////////////////////////////////");
				// System.out.println("Desde el estado:" + s);
				// System.out.println("Al estado:" + sP);
				// System.out.println("Con accion:" + a);
				// System.out.println("REWARD:" + r);

				s = sP;
				a = modeloQ.seleccionarAccionEpsilonGreedy(s, pieza);

				return Accion.convertir(a, pieza);
			}
		} else {
			System.out.println("No entiendo el mensaje");
			System.out.println(percepcion);
			return new Respuesta(0, 0);
		}
		return null;
	}

	public EstadoTetris parsearEstado(String percepcion) {
		StringTokenizer st = new StringTokenizer(percepcion, ";");
		st.nextToken();

		piezaAnt = pieza;
		pieza = Integer.parseInt(st.nextToken());

		st.nextToken(); // Pieza siguiente
		String Mapa = st.nextToken();
		st.nextToken();
		lineas = Integer.parseInt(st.nextToken());

		// CALCULO LAS ALTURAS
		int alturas[] = new int[10];
		for (int i = 0; i < 22; i++) {
			for (int j = 0; j < 10; j++) {
				if (Character.getNumericValue(Mapa.charAt((21 - i) + (j + 1) * 24)) != 0)
					alturas[j] = i + 1;
			}
		}

		// CALCULO LOS HUECOS
		int holes[] = new int[10];
		int sumHoles = 0;
		for (int i = 0; i < 22; i++) {
			for (int j = 0; j < 10; j++) {
				if (Character.getNumericValue(Mapa.charAt(i + (j + 1) * 24)) == 0 && alturas[j] > (22 - i))
					holes[j]++;
			}
		}
		for (int i = 0; i < holes.length; i++) {
			sumHoles += holes[i];
		}

		// CALCULO BUMPINESS TOTAL

		int bumpinessTotal = 0;
		for (int i = 0; i < alturas.length - 1; i++) {
			bumpinessTotal += Math.abs(alturas[i] - alturas[i + 1]);
		}
		// System.out.println(bumpinessTotal);

		// CALCULO LA ALTURA M�XIMA
		int maxAlt = 0;
		for (int i = 0; i < alturas.length; i++) {
			if (alturas[i] > maxAlt)
				maxAlt = alturas[i];
		}

		// TODO:
		// PARA PIEZA 3 = 2 alturas
		// PARA PIEZA 0 = 4 alturas
		// PARA PIEZA 5 = 3 alturas
		// PARA PIEZA 1 = 3 alturas
		// PARA PIEZA 2 = 3 alturas
		// PARA PIEZA 4 = 3 alturas
		// PARA PIEZA 6 = 3 alturas
		int alt = 2;
		switch (pieza) {
		case 3:
			alt = 2;
			break;
		case 0:
			alt = 4;
			break;
		case 1:
		case 2:
		case 4:
		case 5:
		case 6:
			alt = 3;
			break;
		default:
			alt = 3;
			break;
		}

		// TODO:
		alt = 5;

		// CALCULO LAS X ALTURAS M�XIMAS
		int maxAltRel = maxAlt;
		if (maxAlt > alt) {
			int dif = maxAlt - alt;
			for (int i = 0; i < alturas.length; i++) {
				alturas[i] = alturas[i] - dif;
				if (alturas[i] < 0)
					alturas[i] = 0;
			}
			maxAltRel = maxAlt - dif;
		}

		int bumpiness[] = new int[9];
		for (int i = 0; i < alturas.length - 1; i++) {
			bumpiness[i] = alturas[i] - alturas[i + 1];
		}

		// DEVUELVO EL ESTADO DEL INSTANTE DEL TABLERO
		return new EstadoTetris(alturas, sumHoles, bumpinessTotal, maxAlt, bumpiness, maxAltRel, pieza);
	}

}
