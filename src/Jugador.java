import java.util.Random;

import javax.swing.JPanel;

public class Jugador {

    private final int TOTAL_CARTAS = 10;
    private final int MARGEN_SUPERIOR = 10;
    private final int MARGEN_IZQUIERDA = 10;
    private final int DISTANCIA = 40;

    private Carta[] cartas = new Carta[TOTAL_CARTAS];
    private Random r = new Random();

    public void repartir() {
        for (int i = 0; i < cartas.length; i++) {
            cartas[i] = new Carta(r);
        }
    }

    public void mostrar(JPanel pnl) {
        pnl.removeAll();
        int posicion = MARGEN_IZQUIERDA + DISTANCIA * (TOTAL_CARTAS - 1);
        for (Carta carta : cartas) {
            carta.mostrar(pnl, posicion, MARGEN_SUPERIOR);
            posicion -= DISTANCIA;
        }
        pnl.repaint();
    }

    public String getResumen() {
        int[] contadores = new int[NombreCarta.values().length];
        for (int i = 0; i < cartas.length; i++) {
            contadores[cartas[i].getNombre().ordinal()]++;
        }

        // Grupos por nombre (sin importar pinta)
        String grupos = "";
        for (int i = 0; i < contadores.length; i++) {
            if (contadores[i] >= 2) {
                grupos += Grupo.values()[contadores[i]] + " de " + NombreCarta.values()[i] + "\n";
            }
        }

        // Escaleras por pinta
        boolean[][] tiene = new boolean[Pinta.values().length][NombreCarta.values().length];
        for (int i = 0; i < cartas.length; i++) {
            tiene[cartas[i].getPinta().ordinal()][cartas[i].getNombre().ordinal()] = true;
        }

        // Marcar qué cartas están en escalera
        boolean[][] enEscalera = new boolean[Pinta.values().length][NombreCarta.values().length];
        String escaleras = "";
        for (int p = 0; p < Pinta.values().length; p++) {
            int inicio = -1;
            int longitud = 0;
            for (int n = 0; n < NombreCarta.values().length; n++) {
                if (tiene[p][n]) {
                    if (longitud == 0) inicio = n;
                    longitud++;
                } else {
                    if (longitud >= 2) {
                        escaleras += Grupo.values()[longitud] + " de " + Pinta.values()[p]
                                + " de " + NombreCarta.values()[inicio]
                                + " a " + NombreCarta.values()[inicio + longitud - 1] + "\n";
                        for (int k = inicio; k < inicio + longitud; k++) enEscalera[p][k] = true;
                    }
                    longitud = 0;
                }
            }
            if (longitud >= 2) {
                escaleras += Grupo.values()[longitud] + " de " + Pinta.values()[p]
                        + " de " + NombreCarta.values()[inicio]
                        + " a " + NombreCarta.values()[inicio + longitud - 1] + "\n";
                for (int k = inicio; k < inicio + longitud; k++) enEscalera[p][k] = true;
            }
        }

        
        int puntaje = 0;
        for (int i = 0; i < cartas.length; i++) {
            int nombre = cartas[i].getNombre().ordinal();
            int pinta = cartas[i].getPinta().ordinal();
            boolean enGrupo = contadores[nombre] >= 2;
            boolean enEsc = enEscalera[pinta][nombre];
            if (!enGrupo && !enEsc) {
                puntaje += cartas[i].getNombre().getValor();
            }
        }

        String resultado = "";
        if (!grupos.isEmpty()) resultado += grupos + "\n";
        if (!escaleras.isEmpty()) resultado += escaleras + "\n";
        resultado += "\nPuntos:\n" + puntaje;
        return resultado;
    }

}
