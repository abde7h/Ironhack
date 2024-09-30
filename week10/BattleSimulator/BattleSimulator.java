import java.util.Scanner;

public class BattleSimulator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Attacker character1, character2;  // Cambiado a Attacker

        // Creación de personajes
        System.out.println("Crear Personaje 1:");
        System.out.print("Ingresa el nombre para Guerrero o Mago: ");
        String name1 = scanner.nextLine();
        System.out.print("Elige tipo (1 para Guerrero, 2 para Mago): ");
        int type1 = scanner.nextInt();
        character1 = (Attacker) createCharacter(name1, type1);  // Casting a Attacker

        scanner.nextLine(); // Consumir nueva línea

        System.out.println("Crear Personaje 2:");
        System.out.print("Ingresa el nombre para Guerrero o Mago: ");
        String name2 = scanner.nextLine();
        System.out.print("Elige tipo (1 para Guerrero, 2 para Mago): ");
        int type2 = scanner.nextInt();
        character2 = (Attacker) createCharacter(name2, type2);  // Casting a Attacker

        // Bucle de batalla
        while (character1 instanceof Character && character2 instanceof Character &&
               ((Character) character1).isAlive() && ((Character) character2).isAlive()) {
            character1.attack((Character) character2);
            character2.attack((Character) character1);

            // Mostrar HP después de los ataques
            System.out.printf("%s HP: %d | %s HP: %d%n", 
                ((Character) character1).getName(), ((Character) character1).getHp(),
                ((Character) character2).getName(), ((Character) character2).getHp());
        }

        // Determinar el ganador
        if (((Character) character1).isAlive()) {
            System.out.println(((Character) character1).getName() + " gana!");
        } else if (((Character) character2).isAlive()) {
            System.out.println(((Character) character2).getName() + " gana!");
        } else {
            System.out.println("¡Es un empate!");
        }

        scanner.close();
    }

    private static Character createCharacter(String name, int type) {
        if (type == 1) {
            return new Warrior(name);
        } else {
            return new Wizard(name);
        }
    }
}
