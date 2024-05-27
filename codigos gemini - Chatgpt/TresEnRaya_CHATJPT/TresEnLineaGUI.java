package TresEnRaya_CHATJPT;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class TresEnLineaGUI extends JFrame implements ActionListener {
    private JButton[][] casillas = new JButton[3][3];
    private JLabel turnoLabel;
    private JLabel marcadorLabel;
    private boolean turnoDeX;
    private boolean juegoTerminado = false;
    private int contadorX = 0;
    private int contadorO = 0;

    public TresEnLineaGUI() {
        setTitle("Tres en Línea (Tateti)");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 400);
        setLayout(new BorderLayout());

        JPanel tableroPanel = new JPanel(new GridLayout(3, 3));
        for (int fila = 0; fila < 3; fila++) {
            for (int columna = 0; columna < 3; columna++) {
                JButton casilla = new JButton();
                casilla.setPreferredSize(new Dimension(80, 80));
                casilla.addActionListener(this);
                casilla.setFont(new Font("Arial", Font.BOLD, 40));
                casillas[fila][columna] = casilla;
                tableroPanel.add(casilla);
            }
        }

        turnoLabel = new JLabel("Turno de: X", SwingConstants.CENTER);
        turnoLabel.setFont(new Font("Arial", Font.BOLD, 16));

        marcadorLabel = new JLabel("Marcador: X - " + contadorX + "   O - " + contadorO, SwingConstants.CENTER);
        marcadorLabel.setFont(new Font("Arial", Font.BOLD, 16));

        JPanel infoPanel = new JPanel(new GridLayout(2, 1));
        infoPanel.add(turnoLabel);
        infoPanel.add(marcadorLabel);

        add(tableroPanel, BorderLayout.CENTER);
        add(infoPanel, BorderLayout.SOUTH);

        setVisible(true);
        iniciarPartida();
    }

    private void iniciarPartida() {
        reiniciarJuego();
        Random random = new Random();
        turnoDeX = random.nextBoolean();
        if (!turnoDeX) {
            cambiarTurno();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (juegoTerminado) {
            iniciarPartida();
            return;
        }

        JButton casilla = (JButton) e.getSource();
        if (!casilla.getText().isEmpty()) {
            return;
        }

        if (turnoDeX) {
            casilla.setText("X");
            casilla.setForeground(Color.RED);
        } else {
            casilla.setText("O");
            casilla.setForeground(Color.BLUE);
        }

        if (hayGanador()) {
            JOptionPane.showMessageDialog(this, "¡" + (turnoDeX ? "X" : "O") + " ha ganado!");
            juegoTerminado = true;
            actualizarMarcador();
        } else if (empate()) {
            JOptionPane.showMessageDialog(this, "¡Empate!");
            juegoTerminado = true;
        } else {
            cambiarTurno();
        }
    }

    private boolean hayGanador() {
        String[][] tablero = new String[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                tablero[i][j] = casillas[i][j].getText();
            }
        }

        // Revisar filas y columnas
        for (int i = 0; i < 3; i++) {
            if (!tablero[i][0].isEmpty() && tablero[i][0].equals(tablero[i][1]) && tablero[i][0].equals(tablero[i][2])) {
                return true;
            }
            if (!tablero[0][i].isEmpty() && tablero[0][i].equals(tablero[1][i]) && tablero[0][i].equals(tablero[2][i])) {
                return true;
            }
        }

        // Revisar diagonales
        if (!tablero[0][0].isEmpty() && tablero[0][0].equals(tablero[1][1]) && tablero[0][0].equals(tablero[2][2])) {
            return true;
        }
        if (!tablero[0][2].isEmpty() && tablero[0][2].equals(tablero[1][1]) && tablero[0][2].equals(tablero[2][0])) {
            return true;
        }

        return false;
    }

    private boolean empate() {
        for (int fila = 0; fila < 3; fila++) {
            for (int columna = 0; columna < 3; columna++) {
                if (casillas[fila][columna].getText().isEmpty()) {
                    return false;
                }
            }
        }
        return true;
    }

    private void reiniciarJuego() {
        for (int fila = 0; fila < 3; fila++) {
            for (int columna = 0; columna < 3; columna++) {
                casillas[fila][columna].setText("");
            }
        }
        juegoTerminado = false;
        turnoLabel.setText("Turno de: X");
    }

    private void cambiarTurno() {
        turnoDeX = !turnoDeX;
        turnoLabel.setText("Turno de: " + (turnoDeX ? "X" : "O"));
    }

    private void actualizarMarcador() {
        if (turnoDeX) {
            contadorX++;
        } else {
            contadorO++;
        }
        marcadorLabel.setText("Marcador: X - " + contadorX + "   O - " + contadorO);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(TresEnLineaGUI::new);
    }
}