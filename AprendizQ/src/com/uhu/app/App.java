package com.uhu.app;

import com.uhu.jugadores.*;

public class App {

	public static void main(String args[]) {
		AprendizQ jugador = new AprendizQ(500); /*** JUGADOR Aprendiz ***/
		jugador.inicializar();
		jugador.jugar();
	}
}
