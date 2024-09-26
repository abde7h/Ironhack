public class SmallestElements {

    public static void findSmallestAndSecondSmallest(int[] numbers) {
        // Validación: El array debe tener al menos dos elementos
        if (numbers.length < 2) {
            throw new IllegalArgumentException("El array debe tener al menos dos elementos.");
        }
        
        // Inicializar los valores más pequeños
        int smallest = Integer.MAX_VALUE;
        int secondSmallest = Integer.MAX_VALUE;
        
        // Recorrer el array para encontrar el más pequeño y el segundo más pequeño
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] < smallest) {
                secondSmallest = smallest;
                smallest = numbers[i];
            } else if (numbers[i] < secondSmallest && numbers[i] != smallest) {
                secondSmallest = numbers[i];
            }
        }
        
        // Imprimir los valores más pequeños
        System.out.println("El elemento más pequeño es: " + smallest);
        System.out.println("El segundo elemento más pequeño es: " + secondSmallest);
    }

    public static void main(String[] args) {
        int[] array = {12, 13, 1, 10, 34, 1};
        findSmallestAndSecondSmallest(array);
    }
}