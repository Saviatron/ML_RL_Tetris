package com.uhu.jugadores;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.StringTokenizer;

import com.uhu.QLearning.EstadoTetris;
import com.uhu.utils.Respuesta;

public class JugadorQ extends Jugador {

	ArrayList<Hashtable<EstadoTetris, Respuesta>> LA = new ArrayList<>();
	int cantPiezas = 7;
	int cantEstados[] = new int[cantPiezas];
	EstadoTetris estado;
	int pieza;
	int contPartida = 0;
	int totalPartidas = 0;
	int score = 0;
	int scoreTotal = 0;
	int scoreMaximo = 0;

	public JugadorQ(int partidas) {
		super("Javier.martin816", "JugadorQ_V2.1");
		this.totalPartidas = partidas;
		leerListaAcciones("ListaDeAcciones/LA");
	}

	@Override
	public void inicializar() {
		contPartida++;

		if (contPartida > totalPartidas) {
			System.out.println("\n\n\t Puntuaci�n media en " + totalPartidas + " partidas es: "
					+ (double) scoreTotal / (double) totalPartidas);
			System.out.println("\n\n\t Puntuaci�n m�xima: " + scoreMaximo);
			System.exit(1);
		} else
			super.arrancar();
	}

	@Override
	public Respuesta pensar(String percepcion) {

		StringTokenizer st = new StringTokenizer(percepcion, ";");
		String orden = st.nextToken().trim().toUpperCase();

		if (orden.equalsIgnoreCase("FIN")) {
			System.out.println("\n\n\n//////////////////////////////////////////////////// Partida: " + contPartida);
			System.out.println("Jugador: " + st.nextToken() + " - " + st.nextToken());
			score = Integer.parseInt(st.nextToken());
			scoreTotal += score;
			if (score > scoreMaximo)
				scoreMaximo = score;
			System.out.println("Score: " + score);
			System.out.println("///////////////////////////////////////////////////////////////////");

			inicializar();
			// System.exit(1);

		} else if (orden.equalsIgnoreCase("MOV")) {
			estado = parsearEstado(percepcion);
			// TODO:
			// ESCOGEMOS LA ACCION DIRECTAMENTE DE LA LISTA
			return LA.get(pieza).get(estado);

		} else {
			System.out.println("No entiendo el mensaje");
			System.out.println(percepcion);
			return new Respuesta(0, 0);
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	public void leerListaAcciones(String file) {
		try {
			System.out.println("Se van a leer las Listas de Acciones...");
			FileInputStream savedFile = new FileInputStream(file + ".dat");
			ObjectInputStream in = new ObjectInputStream(savedFile);
			LA = (ArrayList<Hashtable<EstadoTetris, Respuesta>>) in.readObject();
			in.close();
			for (int i = 0; i < cantPiezas; i++) {
				cantEstados[i] = LA.get(i).size();
				System.out.println("Lista de Acciones de la pieza " + i + ":");
				System.out.println("Cantidad de estados: " + cantEstados[i]);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public EstadoTetris parsearEstado(String percepcion) {
		// System.out.println(percepcion);
		StringTokenizer st = new StringTokenizer(percepcion, ";");
		st.nextToken();
		pieza = Integer.parseInt(st.nextToken());

		st.nextToken(); // Pieza siguiente
		String Mapa = st.nextToken();
		st.nextToken();

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
