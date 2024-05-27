import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Bienvenido a la calculadora con manejo de excepciones");

        while (true) {
            System.out.print("Ingrese el primer número: ");
            double num1 = obtenerNumero(sc);

            System.out.print("Ingrese el operador (+, -, *, /): ");
            char operador = sc.next().charAt(0);

            System.out.print("Ingrese el segundo número: ");
            double num2 = obtenerNumero(sc);

            double resultado = calcular(num1, operador, num2);

            System.out.printf("El resultado de %f %c %f es: %f\n", num1, operador, num2, resultado);

            System.out.print("¿Desea realizar otra operación? (s/n): ");
            String respuesta = sc.next().toLowerCase();

            if (!respuesta.equals("s")) {
                break;
            }
        }

        System.out.println("¡Gracias por usar la calculadora!");
        sc.close();
    }

    private static double obtenerNumero(Scanner sc) {
        while (true) {
            try {
                return Double.parseDouble(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Error: Ingrese un número válido.");
            }
        }
    }

    private static double calcular(double num1, char operador, double num2) {
        switch (operador) {
            case '+':
                return num1 + num2;
            case '-':
                return num1 - num2;
            case '*':
                return num1 * num2;
            case '/':
                if (num2 == 0) {
                    throw new ArithmeticException("División por cero");
                }
                return num1 / num2;
            default:
                throw new IllegalArgumentException("Operador no válido");
        }
    }
}
