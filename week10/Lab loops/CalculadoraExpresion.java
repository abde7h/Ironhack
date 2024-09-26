public class CalculadoraExpresion {

    // Método para calcular la expresión
    public static double calcularExpresion(double x, double y) {
        double termino1 = Math.pow(x, 2); // x^2
        double termino2 = (4 * y / 5) - x; // (4y/5) - x
        double termino2AlCuadrado = Math.pow(termino2, 2); // ((4y/5) - x)^2

        return termino1 + termino2AlCuadrado; // x^2 + ((4y/5) - x)^2
    }

    public static void main(String[] args) {
        // Valores predefinidos para x e y
        double x = 2.0; // valor de ejemplo para x
        double y = 5.0; // valor de ejemplo para y

        // Calcular y mostrar el resultado
        double resultado = calcularExpresion(x, y);
        System.out.println("Resultado de la expresión: " + resultado);
    }
}
