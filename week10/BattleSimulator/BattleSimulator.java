import java.util.Scanner;

public class BattleSimulator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Attacker character1, character2;

        // Creación de personajes
        System.out.println("Crear Personaje 1:");
        System.out.print("Ingresa el nombre para Guerrero o Mago: ");
        String name1 = scanner.nextLine();
        System.out.print("Elige tipo (1 para Guerrero, 2 para Mago): ");
        int type1 = scanner.nextInt();
        scanner.nextLine(); // Consumir la nueva línea sobrante

        character1 = createCharacter(name1, type1);  // Cambiado: no necesita casteo

        System.out.println("Crear Personaje 2:");
        System.out.print("Ingresa el nombre para Guerrero o Mago: ");
        String name2 = scanner.nextLine();
        System.out.print("Elige tipo (1 para Guerrero, 2 para Mago): ");
        int type2 = scanner.nextInt();
        scanner.nextLine(); // Consumir la nueva línea sobrante

        character2 = createCharacter(name2, type2);  // Cambiado: no necesita casteo

        // Bucle de batalla
        while (((Character) character1).isAlive() && ((Character) character2).isAlive()) {
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

    // Cambia el tipo de retorno a Attacker
    private static Attacker createCharacter(String name, int type) {
        if (type == 1) {
            return new Warrior(name);  // Warrior implementa Attacker
        } else {
            return new Wizard(name);   // Wizard implementa Attacker
        }
    }
}
