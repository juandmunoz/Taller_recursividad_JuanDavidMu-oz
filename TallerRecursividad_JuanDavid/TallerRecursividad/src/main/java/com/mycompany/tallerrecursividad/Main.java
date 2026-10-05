package com.mycompany.tallerrecursividad;

import java.util.Scanner;

public class Main {

    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int opcion;

        do {
            mostrarMenu();
            opcion = leerEntero("Seleccione una opción: ");

            try {
                ejecutar(opcion);
            } catch (IllegalArgumentException | ArithmeticException e) {
                System.out.println("Error: " + e.getMessage());
            }

            if (opcion != 0) {
                System.out.println("\nPresione ENTER para continuar...");
                sc.nextLine();
            }
        } while (opcion != 0);

        System.out.println("Programa finalizado.");
    }

    private static void mostrarMenu() {
        System.out.println("       TALLER DE RECURSIVIDAD      ");
        System.out.println(" 1. Factorial");
        System.out.println(" 2. Invertir un número");
        System.out.println(" 3. Sumatoria ");
        System.out.println(" 4. Sumar los dígitos de un número");
        System.out.println(" 5. Sumatoria hasta n");
        System.out.println(" 6. Potencia");
        System.out.println(" 7. Máximo común divisor ");
        System.out.println(" 8. Copiar una cadena");
        System.out.println(" 9. Cociente de división entera");
        System.out.println("10. Multiplicación mediante sumas");
        System.out.println("11. Suma de un arreglo");
        System.out.println("12. Suma de una matriz");
        System.out.println("13. Serie de Fibonacci");
        System.out.println("14. Función de Ackermann");
        System.out.println(" 0. Salir");
    }

    private static void ejecutar(int opcion) {
        switch (opcion) {
            case 1 -> {
                int n = leerEntero("Ingrese n: ");
                System.out.println("Factorial = " + Recursividad.factorial(n));
            }
            case 2 -> {
                long n = leerLong("Ingrese el número: ");
                System.out.println("Número invertido = " + Recursividad.invertirNumero(n));
            }
            case 3 -> {
                int n = leerEntero("Ingrese n: ");
                System.out.printf("Sumatoria = %.6f%n", Recursividad.sumatoriaFraccion(n));
            }
            case 4 -> {
                long n = leerLong("Ingrese el número: ");
                System.out.println("Suma de dígitos = " + Recursividad.sumaDigitos(n));
            }
            case 5 -> {
                int n = leerEntero("Ingrese n: ");
                System.out.println("Sumatoria = " + Recursividad.sumatoriaHastaN(n));
            }
            case 6 -> {
                long base = leerLong("Ingrese la base: ");
                int exponente = leerEntero("Ingrese el exponente: ");
                System.out.println("Resultado = " + Recursividad.potencia(base, exponente));
            }
            case 7 -> {
                long m = leerLong("Ingrese M: ");
                long n = leerLong("Ingrese N: ");
                System.out.println("MCD = " + Recursividad.mcd(m, n));
            }
            case 8 -> {
                System.out.print("Ingrese la cadena: ");
                String cadena = sc.nextLine();
                String copia = Recursividad.copiarCadena(cadena);
                System.out.println("Cadena original: " + cadena);
                System.out.println("Cadena copiada:  " + copia);
            }
            case 9 -> {
                long dividendo = leerLong("Ingrese el dividendo: ");
                long divisor = leerLong("Ingrese el divisor: ");
                System.out.println("Cociente = "
                        + Recursividad.cocienteDivision(dividendo, divisor));
            }
            case 10 -> {
                long a = leerLong("Ingrese el primer número: ");
                long b = leerLong("Ingrese el segundo número: ");
                System.out.println("Producto = " + Recursividad.multiplicacion(a, b));
            }
            case 11 -> ejecutarSumaArreglo();
            case 12 -> ejecutarSumaMatriz();
            case 13 -> ejecutarFibonacci();
            case 14 -> ejecutarAckermann();
            case 0 -> { }
            default -> System.out.println("Opción no válida.");
        }
    }

    private static void ejecutarSumaArreglo() {
        int n = leerEntero("¿Cuántos elementos tendrá el arreglo?: ");
        if (n < 0) {
            throw new IllegalArgumentException("El tamaño no puede ser negativo.");
        }

        int[] arreglo = new int[n];
        for (int i = 0; i < n; i++) {
            arreglo[i] = leerEntero("Elemento [" + i + "]: ");
        }

        System.out.println("Suma = " + Recursividad.sumaArreglo(arreglo));
    }

    private static void ejecutarSumaMatriz() {
        int filas = leerEntero("Número de filas: ");
        int columnas = leerEntero("Número de columnas: ");

        if (filas < 0 || columnas < 0) {
            throw new IllegalArgumentException("Las dimensiones no pueden ser negativas.");
        }

        int[][] matriz = new int[filas][columnas];

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                matriz[i][j] = leerEntero(
                        "Elemento [" + i + "][" + j + "]: ");
            }
        }

        System.out.println("Suma de la matriz = " + Recursividad.sumaMatriz(matriz));
    }

    private static void ejecutarFibonacci() {
        long limite = leerLong("Ingrese el límite de la serie: ");
        System.out.print("Fibonacci hasta " + limite + ": ");
        Recursividad.imprimirFibonacciHasta(limite);
        System.out.println();

        if (limite <= 92) {
            int n = leerEntero(
                    "Si desea consultar Fib(n), ingrese n (0-92): ");
            if (n >= 0 && n <= 92) {
                System.out.println("Fib(" + n + ") = "
                        + Recursividad.fibonacci(n));
            }
        }
    }

    private static void ejecutarAckermann() {
        long m = leerLong("Ingrese m: ");
        long n = leerLong("Ingrese n: ");


        if (m > 3 || n > 10) {
            throw new IllegalArgumentException(
                    "Use valores pequeños (por ejemplo m <= 3 y n <= 10) "
                    + "para evitar un crecimiento excesivo.");
        }

        System.out.println("Ackermann(" + m + ", " + n + ") = "
                + Recursividad.ackermann(m, n));
    }

    private static int leerEntero(String mensaje) {
        while (true) {
            try {
                System.out.print(mensaje);
                int valor = Integer.parseInt(sc.nextLine().trim());
                return valor;
            } catch (NumberFormatException e) {
                System.out.println("Ingrese un número entero válido.");
            }
        }
    }

    private static long leerLong(String mensaje) {
        while (true) {
            try {
                System.out.print(mensaje);
                long valor = Long.parseLong(sc.nextLine().trim());
                return valor;
            } catch (NumberFormatException e) {
                System.out.println("Ingrese un número válido.");
            }
        }
    }
}
