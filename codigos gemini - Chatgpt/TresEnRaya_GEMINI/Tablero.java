package TresEnRaya_GEMINI;

public class Tablero {
        private static final char[] SIMBOLOS = {'X', 'O', '-'};
        private char[][] casillas;

        public Tablero() {
            casillas = new char[3][3];
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    casillas[i][j] = SIMBOLOS[2];
                }
            }
        }

        public void mostrarTablero() {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    System.out.print(casillas[i][j] + " ");
                }
                System.out.println();
            }
        }

        public boolean marcarCasilla(int fila, int columna, char simbolo) {
            if (fila < 0 || fila >= 3 || columna < 0 || columna >= 3) {
                return false;
            }

            if (casillas[fila][columna] != SIMBOLOS[2]) {
                return false;
            }

            casillas[fila][columna] = simbolo;
            return true;
        }

        public boolean verificarGanador(char simbolo) {
            // Verificar filas
            for (int i = 0; i < 3; i++) {
                if (casillas[i][0] == simbolo && casillas[i][1] == simbolo && casillas[i][2] == simbolo) {
                    return true;
                }
            }

            // Verificar columnas
            for (int j = 0; j < 3; j++) {
                if (casillas[0][j] == simbolo && casillas[1][j] == simbolo && casillas[2][j] == simbolo) {
                    return true;
                }
            }

            // Verificar diagonales
            if (casillas[0][0] == simbolo && casillas[1][1] == simbolo && casillas[2][2] == simbolo) {
                return true;
            }

            if (casillas[0][2] == simbolo && casillas[1][1] == simbolo && casillas[2][0] == simbolo) {
                return true;
            }

            return false;
        }

        public boolean estaLleno() {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (casillas[i][j] == SIMBOLOS[2]) {
                        return false;
                    }
                }
            }
            return true;
        }
    }


