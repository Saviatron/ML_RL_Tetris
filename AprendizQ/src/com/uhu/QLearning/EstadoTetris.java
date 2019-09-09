package com.uhu.QLearning;

import java.io.Serializable;
import java.util.Arrays;

public class EstadoTetris implements Serializable {

	private static final long serialVersionUID = 8664684158675419204L;

	private int[] alturas;
	private int[] bumpiness;
	private int holes;
	private int bumpinessTotal;
	private int maxAlt;
	private int maxAltRel;

	private int cabe;

	public EstadoTetris(int[] alturas, int holes, int bumpinessTotal, int maxAlt, int[] bumpiness, int maxAltRel,
			int pieza) {
		this.alturas = alturas;
		this.holes = holes;
		this.bumpinessTotal = bumpinessTotal;
		this.bumpiness = bumpiness;
		this.maxAlt = maxAlt;
		this.maxAltRel = maxAltRel;
		this.cabe = -1;
		parsearEstado(pieza);
	}

	public void parsearEstado(int Pieza) {
		// TODO:
		boolean buscar = true;

		// TODO:
		if (alturas != null)
			switch (Pieza) {
			case 0:
				// System.out.println(Arrays.toString(bumpiness));
				for (int i = bumpiness.length - 1; i >= 0 && buscar; i--) {
					if (bumpiness[i] == -5) {
						cabe = 7 + i;
						buscar = false;
					}
				}
				for (int i = bumpiness.length - 1; i >= 0 && buscar; i--) {
					if (bumpiness[i] == 5) {
						cabe = 8 + i;
						buscar = false;
					}
				}
				for (int i = bumpiness.length - 1; i >= 0 && buscar; i--) {
					if (bumpiness[i] == -4) {
						cabe = 7 + i;
						buscar = false;
					}
				}
				for (int i = bumpiness.length - 1; i >= 0 && buscar; i--) {
					if (bumpiness[i] == 4) {
						cabe = 8 + i;
						buscar = false;
					}
				}
				for (int i = 0; i < bumpiness.length - 2 && buscar; i++) {
					if (bumpiness[i] == 0 && bumpiness[i + 1] == 0 && bumpiness[i + 2] == 0 && alturas[i] < maxAltRel) {
						cabe = i;
						buscar = false;
					}
				}
				for (int i = bumpiness.length - 1; i >= 0 && buscar; i--) {
					if (bumpiness[i] == -3 && alturas[i] < maxAltRel - 3) {
						cabe = 7 + i;
						buscar = false;
					}
				}
				for (int i = bumpiness.length - 1; i >= 0 && buscar; i--) {
					if (bumpiness[i] == 3 && alturas[i + 1] < maxAltRel - 3) {
						cabe = 8 + i;
						buscar = false;
					}
				}
				for (int i = bumpiness.length - 1; i >= 0 && buscar; i--) {
					if (bumpiness[i] == -2 && alturas[i] < maxAltRel - 3) {
						cabe = 7 + i;
						buscar = false;
					}
				}
				for (int i = bumpiness.length - 1; i >= 0 && buscar; i--) {
					if (bumpiness[i] == 2 && alturas[i + 1] < maxAltRel - 3) {
						cabe = 8 + i;
						buscar = false;
					}
				}
				for (int i = bumpiness.length - 1; i >= 0 && buscar; i--) {
					if (bumpiness[i] == -1 && alturas[i] < maxAltRel - 3) {
						cabe = 7 + i;
						buscar = false;
					}
				}
				for (int i = bumpiness.length - 1; i >= 0 && buscar; i--) {
					if (bumpiness[i] == 1 && alturas[i + 1] < maxAltRel - 3) {
						cabe = 8 + i;
						buscar = false;
					}
				}
				for (int i = bumpiness.length - 1; i >= 0 && buscar; i--) {
					if (bumpiness[i] == 0 && alturas[i] < maxAltRel - 3) {
						cabe = 7 + i;
						buscar = false;
					}
				}

				for (int i = bumpiness.length - 1; i >= 0 && buscar; i--) {
					if (bumpiness[i] == -3) {
						cabe = 7 + i;
						buscar = false;
					}
				}
				for (int i = bumpiness.length - 1; i >= 0 && buscar; i--) {
					if (bumpiness[i] == 3) {
						cabe = 8 + i;
						buscar = false;
					}
				}
				for (int i = 0; i < bumpiness.length - 2 && buscar; i++) {
					if (bumpiness[i] == 0 && bumpiness[i + 1] == 0 && bumpiness[i + 2] == 0) {
						cabe = i;
						buscar = false;
					}
				}
				for (int i = bumpiness.length - 1; i >= 0 && buscar; i--) {
					if (bumpiness[i] == -2) {
						cabe = 7 + i;
						buscar = false;
					}
				}
				for (int i = bumpiness.length - 1; i >= 0 && buscar; i--) {
					if (bumpiness[i] == 2) {
						cabe = 8 + i;
						buscar = false;
					}
				}
				for (int i = bumpiness.length - 1; i >= 0 && buscar; i--) {
					if (bumpiness[i] == -1) {
						cabe = 7 + i;
						buscar = false;
					}
				}
				for (int i = bumpiness.length - 1; i >= 0 && buscar; i--) {
					if (bumpiness[i] == 1) {
						cabe = 8 + i;
						buscar = false;
					}
				}
				for (int i = bumpiness.length - 1; i >= 0 && buscar; i--) {
					if (bumpiness[i] == 0) {
						cabe = 7 + i;
						buscar = false;
					}
				}
				if (cabe == -1)
					cabe = 0;
				// System.out.println("Cabe: "+cabe);
				break;
			case 1:
				// PRIMERO QUE QUEPA ENTERA
				for (int i = 0; i < bumpiness.length && buscar; i++) {
					if (bumpiness[i] == 2 && alturas[i + 1] < maxAltRel - 2) {
						cabe = 25 + i;
						buscar = false;
					}
				}
				for (int i = 0; i < bumpiness.length - 1 && buscar; i++) {
					if (bumpiness[i] == -1 && bumpiness[i + 1] == 0 && alturas[i] < maxAltRel - 1) {
						cabe = 17 + i;
						buscar = false;
					}
				}
				for (int i = 0; i < bumpiness.length - 1 && buscar; i++) {
					if (bumpiness[i] == 0 && bumpiness[i + 1] == 0 && alturas[i] < maxAltRel - 1) {
						cabe = i;
						buscar = false;
					}
				}
				for (int i = 0; i < bumpiness.length && buscar; i++) {
					if (bumpiness[i] == 0 && alturas[i] < maxAltRel - 2) {
						cabe = 8 + i;
						buscar = false;
					}
				}

				// DESPUES QUE QUEPA SOLO UN TROZO
				for (int i = 0; i < bumpiness.length - 1 && buscar; i++) {
					if (bumpiness[i] == 0 && bumpiness[i + 1] == 0 && alturas[i] < maxAltRel) {
						cabe = i;
						buscar = false;
					}
				}
				for (int i = 0; i < bumpiness.length && buscar; i++) {
					if (bumpiness[i] > 1 && alturas[i + 1] < maxAltRel) {
						cabe = 25 + i;
						buscar = false;
					}
				}
				for (int i = 0; i < bumpiness.length - 1 && buscar; i++) {
					if (bumpiness[i] < 0 && bumpiness[i + 1] == 0 && alturas[i + 1] < maxAltRel) {
						cabe = 17 + i;
						buscar = false;
					}
				}
				for (int i = 0; i < bumpiness.length && buscar; i++) {
					if (bumpiness[i] == 0 && alturas[i] < maxAltRel) {
						cabe = 8 + i;
						buscar = false;
					}
				}

				if (cabe == -1)
					cabe = 0;
				break;
			case 2:

				// PRIMERO QUE QUEPA ENTERA
				for (int i = 0; i < bumpiness.length && buscar; i++) {
					if (bumpiness[i] == -2 && alturas[i + 1] < maxAltRel - 2) {
						cabe = 25 + i;
						buscar = false;
					}
				}
				for (int i = 0; i < bumpiness.length - 1 && buscar; i++) {
					if (bumpiness[i] == 0 && bumpiness[i + 1] == 1 && alturas[i] < maxAltRel) {
						cabe = i;
						buscar = false;
					}
				}
				for (int i = 0; i < bumpiness.length - 1 && buscar; i++) {
					if (bumpiness[i] == 0 && bumpiness[i + 1] == 0 && alturas[i] < maxAltRel - 1) {
						cabe = 17 + i;
						buscar = false;
					}
				}
				for (int i = 0; i < bumpiness.length && buscar; i++) {
					if (bumpiness[i] == 0 && alturas[i] < maxAltRel - 2) {
						cabe = 8 + i;
						buscar = false;
					}
				}

				// DESPUES QUE QUEPA SOLO UN TROZO
				for (int i = 0; i < bumpiness.length && buscar; i++) {
					if (bumpiness[i] < -1 && alturas[i] < maxAltRel) {
						cabe = 25 + i;
						buscar = false;
					}
				}
				for (int i = 0; i < bumpiness.length - 1 && buscar; i++) {
					if (bumpiness[i] == 0 && bumpiness[i + 1] > 1 && alturas[i + 1] < maxAltRel) {
						cabe = i;
						buscar = false;
					}
				}
				for (int i = 0; i < bumpiness.length - 1 && buscar; i++) {
					if (bumpiness[i] == 0 && bumpiness[i + 1] == 0 && alturas[i] < maxAltRel) {
						cabe = 17 + i;
						buscar = false;
					}
				}
				for (int i = 0; i < bumpiness.length && buscar; i++) {
					if (bumpiness[i] == 0 && alturas[i] < maxAltRel) {
						cabe = 8 + i;
						buscar = false;
					}
				}

				if (cabe == -1)
					cabe = 17;
				break;
			case 3:
				for (int i = 0; i < bumpiness.length && buscar; i++) {
					if (bumpiness[i] == 0 && alturas[i] == 0) {
						cabe = i;
						buscar = false;
					}
				}
				for (int i = 0; i < bumpiness.length && buscar; i++) {
					if (bumpiness[i] == 0 && alturas[i] == 1) {
						cabe = i;
						buscar = false;
					}
				}
				for (int i = 0; i < bumpiness.length && buscar; i++) {
					if (bumpiness[i] == 0 && alturas[i] == 2) {
						cabe = i;
						buscar = false;
					}
				}
				for (int i = 0; i < bumpiness.length && buscar; i++) {
					if (bumpiness[i] == 0 && alturas[i] == 3) {
						cabe = i;
						buscar = false;
					}
				}
				for (int i = 0; i < bumpiness.length && buscar; i++) {
					if (bumpiness[i] == 0 && alturas[i] == 4) {
						cabe = i;
						buscar = false;
					}
				}
				for (int i = 0; i < bumpiness.length && buscar; i++) {
					if (bumpiness[i] == 0 && alturas[i] == 5) {
						cabe = i;
						buscar = false;
					}
				}
				if (cabe == -1)
					cabe = 0;
				break;
			case 4:

				// PRIMERO QUE QUEPA ENTERA
				for (int i = 0; i < bumpiness.length - 1 && buscar; i++) {
					if (bumpiness[i] == 0 && bumpiness[i + 1] == -1 && alturas[i] < maxAltRel - 1) {
						cabe = i;
						buscar = false;
					}
				}
				for (int i = 0; i < bumpiness.length && buscar; i++) {
					if (bumpiness[i] == 1 && alturas[i] < maxAltRel - 1) {
						cabe = 8 + i;
						buscar = false;
					}
				}
				for (int i = 0; i < bumpiness.length - 1 && buscar; i++) {
					if (bumpiness[i] <= 0 && bumpiness[i + 1] == -1 && alturas[i] < maxAltRel - 1) {
						cabe = i;
						buscar = false;
					}
				}
				for (int i = 0; i < bumpiness.length && buscar; i++) {
					if (bumpiness[i] == 0 && alturas[i] < maxAltRel - 2) {
						cabe = 8 + i;
						buscar = false;
					}
				}
				for (int i = 0; i < bumpiness.length && buscar; i++) {
					if (bumpiness[i] >= 1 && alturas[i] < maxAltRel) {
						cabe = 8 + i;
						buscar = false;
					}
				}

				if (cabe == -1)
					cabe = 7;
				break;
			case 5:
				// PRIMERO QUE QUEPA ENTERA
				for (int i = 0; i < bumpiness.length - 1 && buscar; i++) {
					if (bumpiness[i] == 1 && bumpiness[i + 1] == -1 && alturas[i] < maxAltRel) {
						cabe = 17 + i;
						buscar = false;
					}
				}
				for (int i = 0; i < bumpiness.length && buscar; i++) {
					if (bumpiness[i] == 1 && alturas[i] < maxAltRel - 1) {
						cabe = 8 + i;
						buscar = false;
					}
				}
				for (int i = 0; i < bumpiness.length && buscar; i++) {
					if (bumpiness[i] == -1 && alturas[i + 1] < maxAltRel - 1) {
						cabe = 25 + i;
						buscar = false;
					}
				}
				for (int i = 0; i < bumpiness.length - 1 && buscar; i++) {
					if (bumpiness[i] == 0 && bumpiness[i + 1] == 0 && alturas[i] < maxAltRel - 1) {
						cabe = i;
						buscar = false;
					}
				}

				// DESPUES QUE QUEPA SOLO UN TROZO
				for (int i = 0; i < bumpiness.length - 1 && buscar; i++) {
					if (bumpiness[i] > 0 && bumpiness[i + 1] < 0 && bumpiness[i] == bumpiness[i + 1]
							&& alturas[i] < maxAltRel) {
						cabe = 17 + i;
						buscar = false;
					}
				}
				for (int i = 0; i < bumpiness.length && buscar; i++) {
					if (bumpiness[i] > 0 && alturas[i] < maxAltRel) {
						cabe = 8 + i;
						buscar = false;
					}
				}
				for (int i = 0; i < bumpiness.length && buscar; i++) {
					if (bumpiness[i] < 0 && alturas[i + 1] < maxAltRel) {
						cabe = 25 + i;
						buscar = false;
					}
				}
				for (int i = 0; i < bumpiness.length - 1 && buscar; i++) {
					if (bumpiness[i] == 0 && bumpiness[i + 1] == 0 && alturas[i] < maxAltRel) {
						cabe = i;
						buscar = false;
					}
				}
				for (int i = 0; i < bumpiness.length && buscar; i++) {
					if (bumpiness[i] > 0 && alturas[i] < maxAltRel + 1) {
						cabe = 8 + i;
						buscar = false;
					}
				}
				for (int i = 0; i < bumpiness.length && buscar; i++) {
					if (bumpiness[i] < 0 && alturas[i + 1] < maxAltRel + 1) {
						cabe = 25 + i;
						buscar = false;
					}
				}
				for (int i = 0; i < bumpiness.length && buscar; i++) {
					if (bumpiness[i] == 0 && alturas[i] < maxAltRel) {
						cabe = 25 + i;
						buscar = false;
					}
				}

				if (cabe == -1)
					cabe = 0;
				break;
			case 6:
				// PRIMERO QUE QUEPA ENTERA
				for (int i = 0; i < bumpiness.length - 1 && buscar; i++) {
					if (bumpiness[i] == 1 && bumpiness[i + 1] == 0 && alturas[i] < maxAltRel) {
						cabe = i;
						buscar = false;
					}
				}
				for (int i = 0; i < bumpiness.length && buscar; i++) {
					if (bumpiness[i] == -1 && alturas[i] < maxAltRel - 2) {
						cabe = 8 + i;
						buscar = false;
					}
				}
				for (int i = 0; i < bumpiness.length - 1 && buscar; i++) {
					if (bumpiness[i] == 1 && bumpiness[i + 1] >= 0 && alturas[i + 1] < maxAltRel) {
						cabe = i;
						buscar = false;
					}
				}
				for (int i = 0; i < bumpiness.length && buscar; i++) {
					if (bumpiness[i] == 0 && alturas[i] < maxAltRel - 2) {
						cabe = 8 + i;
						buscar = false;
					}
				}
				for (int i = 0; i < bumpiness.length && buscar; i++) {
					if (bumpiness[i] <= -1 && alturas[i + 1] < maxAltRel) {
						cabe = 8 + i;
						buscar = false;
					}
				}

				if (cabe == -1)
					cabe = 0;
				break;
			default:
				System.err.println("NO SE RECONOCE LA PIEZA");
				break;
			}
	}

	public int getCabe() {
		return cabe;
	}

	public void setCabe(int cabe) {
		this.cabe = cabe;
	}

	public int[] getAlturas() {
		return alturas;
	}

	public void setAlturas(int[] alturas) {
		this.alturas = alturas;
	}

	public int getHoles() {
		return holes;
	}

	public void setHoles(int holes) {
		this.holes = holes;
	}

	public int getBumpiness() {
		return bumpinessTotal;
	}

	public void setBumpiness(int bumpiness) {
		this.bumpinessTotal = bumpiness;
	}

	public int getMaxAlt() {
		return maxAlt;
	}

	public void setMaxAlt(int maxAlt) {
		this.maxAlt = maxAlt;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == this) {
			return true;
		}
		if (!(obj instanceof EstadoTetris)) {
			return false;
		}
		EstadoTetris ET = (EstadoTetris) obj;
		return cabe == ET.getCabe();
	}

	@Override
	public int hashCode() {
		return cabe;
	}

	@Override
	public String toString() {
		return "Estado:\n Cabe: " + cabe + "\n Alturas: " + Arrays.toString(alturas) + "\n maxAltRel: " + maxAltRel
				+ "\n bumpiness: " + bumpinessTotal;
	}
}
