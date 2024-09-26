
    public class ArrayDifference {

        public static int findDifference(int[] nums) {
            if (nums.length == 0) {
                throw new IllegalArgumentException("Tiene que haber almenos un elemento.");
            }
            
            int max = nums[0];
            int min = nums[0];
            
            for (int i = 1; i < nums.length; i++) {
                if (nums[i] > max) {
                    max = nums[i];
                }
                if (nums[i] < min) {
                    min = nums[i];
                }
            }
            
            return max - min;
        }
    
        
        public static void main(String[] args) {
            int[] numbers = {10, 3, 5, 7, 9};
            int difference = findDifference(numbers);
            System.out.println("La diferencia entre el elemento mas grande y el mas pequeno es: " + difference);
        }
    }
    
