package com.mycompany.tallerrecursividad;

public final class Recursividad {

    private Recursividad() {
    }

    // 1. Factorial
    public static long factorial(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("El número debe ser >= 0.");
        }
        if (n == 0 || n == 1) {
            return 1;
        }
        return n * factorial(n - 1);
    }

    // 2. Invertir un número
    public static long invertirNumero(long numero) {
        long valor = Math.abs(numero);
        long invertido = invertirNumero(valor, 0);
        return numero < 0 ? -invertido : invertido;
    }

    private static long invertirNumero(long numero, long acumulado) {
        if (numero < 10) {
            return acumulado * 10 + numero;
        }
        return invertirNumero(numero / 10, acumulado * 10 + numero % 10);
    }

    // 3. Sumatoria 1 + 1/2 + 1/3 
    public static double sumatoriaFraccion(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("n debe ser mayor que 0.");
        }
        if (n == 1) {
            return 1.0;
        }
        return (1.0 / n) + sumatoriaFraccion(n - 1);
    }

    // 4. Sumar los dígitos de un número
    public static long sumaDigitos(long numero) {
        numero = Math.abs(numero);
        if (numero < 10) {
            return numero;
        }
        return (numero % 10) + sumaDigitos(numero / 10);
    }

    // 5. Sumatoria 1 + 2 +3...
    public static long sumatoriaHastaN(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("n debe ser >= 0.");
        }
        if (n == 0) {
            return 0;
        }
        return n + sumatoriaHastaN(n - 1);
    }

    // 6. Potencia base exponente
    public static long potencia(long base, int exponente) {
        if (exponente < 0) {
            throw new IllegalArgumentException("El exponente debe ser >= 0.");
        }
        if (exponente == 0) {
            return 1;
        }
        return base * potencia(base, exponente - 1);
    }

    // 7. MCD mediante algoritmo de Euclides
    public static long mcd(long m, long n) {
        m = Math.abs(m);
        n = Math.abs(n);
        if (n == 0) {
            return m;
        }
        return mcd(n, m % n);
    }

    // 8. Copiar una cadena en otra mediante recursividad
    public static String copiarCadena(String cadena) {
        if (cadena == null || cadena.isEmpty()) {
            return "";
        }
        return cadena.charAt(0) + copiarCadena(cadena.substring(1));
    }

    // 9. Cociente de división entera mediante restas sucesivas
    public static long cocienteDivision(long dividendo, long divisor) {
        if (divisor == 0) {
            throw new ArithmeticException("No se puede dividir entre cero.");
        }

        long a = Math.abs(dividendo);
        long b = Math.abs(divisor);

        if (a < b) {
            return 0;
        }

        long cociente = 1 + cocienteDivision(a - b, b);
        return ((dividendo < 0) ^ (divisor < 0)) ? -cociente : cociente;
    }

    // 10. Multiplicación mediante sumas sucesivas
    public static long multiplicacion(long a, long b) {
        if (b < 0) {
            return -multiplicacion(a, -b);
        }
        if (b == 0) {
            return 0;
        }
        return a + multiplicacion(a, b - 1);
    }

    // 11. Suma de los elementos de un arreglo
    public static long sumaArreglo(int[] arreglo) {
        if (arreglo == null) {
            throw new IllegalArgumentException("El arreglo no puede ser null.");
        }
        return sumaArreglo(arreglo, 0);
    }

    private static long sumaArreglo(int[] arreglo, int indice) {
        if (indice == arreglo.length) {
            return 0;
        }
        return arreglo[indice] + sumaArreglo(arreglo, indice + 1);
    }

    // 12. Suma de todos los elementos de una matriz 
    public static long sumaMatriz(int[][] matriz) {
        if (matriz == null) {
            throw new IllegalArgumentException("La matriz no puede ser null.");
        }
        return sumaMatriz(matriz, 0, 0);
    }

    private static long sumaMatriz(int[][] matriz, int fila, int columna) {
        if (fila == matriz.length) {
            return 0;
        }
        if (columna == matriz[fila].length) {
            return sumaMatriz(matriz, fila + 1, 0);
        }
        return matriz[fila][columna]
                + sumaMatriz(matriz, fila, columna + 1);
    }

    // 13. Fibonacci e impresión de la serie hasta un valor límite
    public static long fibonacci(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("n debe ser >= 0.");
        }
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    public static void imprimirFibonacciHasta(long limite) {
        if (limite < 0) {
            throw new IllegalArgumentException("El límite debe ser >= 0.");
        }
        imprimirFibonacciHasta(limite, 0, 1);
    }

    private static void imprimirFibonacciHasta(long limite, long a, long b) {
        if (a > limite) {
            return;
        }
        System.out.print(a + " ");
        if (Long.MAX_VALUE - a < b) {
            return;
        }
        imprimirFibonacciHasta(limite, b, a + b);
    }

    // 14. Función de Ackermann
    public static long ackermann(long m, long n) {
        if (m < 0 || n < 0) {
            throw new IllegalArgumentException("m y n deben ser >= 0.");
        }
        if (m == 0) {
            return n + 1;
        }
        if (n == 0) {
            return ackermann(m - 1, 1);
        }
        return ackermann(m - 1, ackermann(m, n - 1));
    }
}
