package com.uhu.QLearning;

import com.uhu.utils.Respuesta;

public abstract class Accion {

	private static Respuesta acciones0[] = new Respuesta[] { new Respuesta(-4, 0), new Respuesta(-3, 0),
			new Respuesta(-2, 0), new Respuesta(-1, 0), new Respuesta(0, 0), new Respuesta(1, 0), new Respuesta(2, 0),
			new Respuesta(-5, 1), new Respuesta(-4, 1), new Respuesta(-3, 1), new Respuesta(-2, 1),
			new Respuesta(-1, 1), new Respuesta(0, 1), new Respuesta(1, 1), new Respuesta(2, 1), new Respuesta(3, 1),
			new Respuesta(4, 1) };

	private static Respuesta acciones1[] = new Respuesta[] { new Respuesta(-4, 0), new Respuesta(-3, 0),
			new Respuesta(-2, 0), new Respuesta(-1, 0), new Respuesta(0, 0), new Respuesta(1, 0), new Respuesta(2, 0),
			new Respuesta(3, 0), new Respuesta(-5, 1), new Respuesta(-4, 1), new Respuesta(-3, 1), new Respuesta(-2, 1),
			new Respuesta(-1, 1), new Respuesta(0, 1), new Respuesta(1, 1), new Respuesta(2, 1), new Respuesta(3, 1),
			new Respuesta(-4, 2), new Respuesta(-3, 2), new Respuesta(-2, 2), new Respuesta(-1, 2), new Respuesta(0, 2),
			new Respuesta(1, 2), new Respuesta(2, 2), new Respuesta(3, 2), new Respuesta(-4, 3), new Respuesta(-3, 3),
			new Respuesta(-2, 3), new Respuesta(-1, 3), new Respuesta(0, 3), new Respuesta(1, 3), new Respuesta(2, 3),
			new Respuesta(3, 3), new Respuesta(4, 3) };

	private static Respuesta acciones2[] = new Respuesta[] { new Respuesta(-4, 0), new Respuesta(-3, 0),
			new Respuesta(-2, 0), new Respuesta(-1, 0), new Respuesta(0, 0), new Respuesta(1, 0), new Respuesta(2, 0),
			new Respuesta(3, 0), new Respuesta(-4, 1), new Respuesta(-3, 1), new Respuesta(-2, 1), new Respuesta(-1, 1),
			new Respuesta(0, 1), new Respuesta(1, 1), new Respuesta(2, 1), new Respuesta(3, 1), new Respuesta(4, 1),
			new Respuesta(-4, 2), new Respuesta(-3, 2), new Respuesta(-2, 2), new Respuesta(-1, 2), new Respuesta(0, 2),
			new Respuesta(1, 2), new Respuesta(2, 2), new Respuesta(3, 2), new Respuesta(-5, 3), new Respuesta(-4, 3),
			new Respuesta(-3, 3), new Respuesta(-2, 3), new Respuesta(-1, 3), new Respuesta(0, 3), new Respuesta(1, 3),
			new Respuesta(2, 3), new Respuesta(3, 3) };

	private static Respuesta acciones3[] = new Respuesta[] { new Respuesta(-4, 0), new Respuesta(-3, 0),
			new Respuesta(-2, 0), new Respuesta(-1, 0), new Respuesta(0, 0), new Respuesta(1, 0), new Respuesta(2, 0),
			new Respuesta(3, 0), new Respuesta(4, 0) };

	private static Respuesta acciones4[] = new Respuesta[] { new Respuesta(-4, 0), new Respuesta(-3, 0),
			new Respuesta(-2, 0), new Respuesta(-1, 0), new Respuesta(0, 0), new Respuesta(1, 0), new Respuesta(2, 0),
			new Respuesta(3, 0), new Respuesta(-4, 1), new Respuesta(-3, 1), new Respuesta(-2, 1), new Respuesta(-1, 1),
			new Respuesta(0, 1), new Respuesta(1, 1), new Respuesta(2, 1), new Respuesta(3, 1), new Respuesta(4, 1) };

	private static Respuesta acciones5[] = new Respuesta[] { new Respuesta(-4, 0), new Respuesta(-3, 0),
			new Respuesta(-2, 0), new Respuesta(-1, 0), new Respuesta(0, 0), new Respuesta(1, 0), new Respuesta(2, 0),
			new Respuesta(3, 0), new Respuesta(-4, 1), new Respuesta(-3, 1), new Respuesta(-2, 1), new Respuesta(-1, 1),
			new Respuesta(0, 1), new Respuesta(1, 1), new Respuesta(2, 1), new Respuesta(3, 1), new Respuesta(4, 1),
			new Respuesta(-4, 2), new Respuesta(-3, 2), new Respuesta(-2, 2), new Respuesta(-1, 2), new Respuesta(0, 2),
			new Respuesta(1, 2), new Respuesta(2, 2), new Respuesta(3, 2), new Respuesta(-5, 3), new Respuesta(-4, 3),
			new Respuesta(-3, 3), new Respuesta(-2, 3), new Respuesta(-1, 3), new Respuesta(0, 3), new Respuesta(1, 3),
			new Respuesta(2, 3), new Respuesta(3, 3) };

	private static Respuesta acciones6[] = new Respuesta[] { new Respuesta(-4, 0), new Respuesta(-3, 0),
			new Respuesta(-2, 0), new Respuesta(-1, 0), new Respuesta(0, 0), new Respuesta(1, 0), new Respuesta(2, 0),
			new Respuesta(3, 0), new Respuesta(-4, 1), new Respuesta(-3, 1), new Respuesta(-2, 1), new Respuesta(-1, 1),
			new Respuesta(0, 1), new Respuesta(1, 1), new Respuesta(2, 1), new Respuesta(3, 1), new Respuesta(4, 1) };

	public static Respuesta convertir(int accion, int pieza) {
		switch (pieza) {
		case 0:
			// TODO: Si es una sola pieza, ser� la pieza 0
			// return acciones6[accion];
			return acciones0[accion];
		case 1:
			return acciones1[accion];
		case 2:
			return acciones2[accion];
		case 3:
			return acciones3[accion];
		case 4:
			return acciones4[accion];
		case 5:
			return acciones5[accion];
		case 6:
			return acciones6[accion];
		default:
			System.err.println("ACCION INVALIDA");
			return null;
		}
	}
}
