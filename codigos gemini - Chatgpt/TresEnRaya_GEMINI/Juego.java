package TresEnRaya_GEMINI;

import java.util.Scanner;

public class Juego {
        Scanner sc = new Scanner(System.in);
        private Tablero tablero;
        private Jugador jugador1;
        private Jugador jugador2;
        private boolean turnoJugador1;

        public Juego() {
            tablero = new Tablero();
            jugador1 = new Jugador('X');
            jugador2 = new Jugador('O');
            turnoJugador1 = true;
        }

        public void iniciarJuego() {
            while (!juegoTerminado()) {
                mostrarTurno();
                marcarCasilla();
                mostrarTablero();
                verificarGanador();
                cambiarTurno();
            }

            mostrarGanador();
        }

        private void mostrarTurno() {
            System.out.println("Turno: " + (turnoJugador1 ? jugador1.getSimbolo() : jugador2.getSimbolo()));
        }

        private void marcarCasilla() {
            int fila, columna;
            char simbolo = turnoJugador1 ? jugador1.getSimbolo() : jugador2.getSimbolo();

            do {
                System.out.print("Ingrese fila (0-2): ");
                fila = sc.nextInt();
                sc.nextLine(); // Consumir salto de línea

                System.out.print("Ingrese columna (0-2): ");
                columna = sc.nextInt();
                sc.nextLine(); // Consumir salto de línea
            } while (!tablero.marcarCasilla(fila, columna, simbolo));
        }

        private void mostrarTablero() {
            tablero.mostrarTablero();
        }

        private boolean verificarGanador() {
            char simbolo = turnoJugador1 ? jugador1.getSimbolo() : jugador2.getSimbolo();

            if (tablero.verificarGanador(simbolo)) {
                System.out.println("¡Ganó el jugador " + simbolo + "!");
                return true;
            }

            if (tablero.estaLleno()) {
                System.out.println("¡Empate!");
                return true;
            }

            return false;
        }

        private void cambiarTurno() {
            turnoJugador1 = !turnoJugador1;
        }

        private boolean juegoTerminado() {
            return verificarGanador() || tablero.estaLleno();
        }

        private void mostrarGanador() {
            if (juegoTerminado()) {
                System.out.println("Fin del juego.");
            }
        }
}