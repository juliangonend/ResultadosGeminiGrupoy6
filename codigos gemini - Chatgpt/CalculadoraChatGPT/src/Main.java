import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("Ingrese el primer número:");
            double numero1 = Double.parseDouble(scanner.nextLine());

            System.out.println("Ingrese el segundo número:");
            double numero2 = Double.parseDouble(scanner.nextLine());

            System.out.println("Ingrese la operación (+, -, *, /):");
            String operacion = scanner.nextLine();

            double resultado = 0;

            switch (operacion) {
                case "+":
                    resultado = numero1 + numero2;
                    break;
                case "-":
                    resultado = numero1 - numero2;
                    break;
                case "*":
                    resultado = numero1 * numero2;
                    break;
                case "/":
                    if (numero2 == 0) {
                        throw new ArithmeticException("¡No se puede dividir por cero!");
                    }
                    resultado = numero1 / numero2;
                    break;
                default:
                    throw new IllegalArgumentException("Operación no válida");
            }

            System.out.println("El resultado es: " + resultado);

        } catch (NumberFormatException e) {
            System.out.println("Error: Ingrese un número válido");
        } catch (ArithmeticException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
