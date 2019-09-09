package com.uhu.app;

import com.uhu.jugadores.*;

public class App {

	public static void main(String args[]) {
		JugadorQ jugador = new JugadorQ(50); /*** JUGADOR Q ***/
		jugador.inicializar();
		jugador.jugar();
	}
}
