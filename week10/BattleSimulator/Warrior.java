import java.util.Random.*;

class Warrior extends Character implements Attacker {
    private int stamina;
    private int strength;

    public Warrior(String name) {
        super(name, new Random().nextInt(101) + 100); // HP entre 100 y 200
        this.stamina = new Random().nextInt(41) + 10; // Stamina entre 10 y 50
        this.strength = new Random().nextInt(10) + 1; // Strength entre 1 y 10
    }

    public void attack(Character opponent) {
        if (!isAlive()) return;

        int damage;
        String attackType;

        if (stamina >= 5) {
            damage = strength; // Heavy attack
            stamina -= 5;
            attackType = "Heavy Attack";
        } else if (stamina > 0) {
            damage = strength / 2; // Weak attack
            stamina += 1;
            attackType = "Weak Attack";
        } else {
            damage = 0; // No attack
            stamina += 2;
            attackType = "No Attack";
        }

        opponent.setHp(opponent.getHp() - damage);
        System.out.printf("%s realiza un %s a %s, causando %d de daño!%n", getName(), attackType, opponent.getName(), damage);
    }
}
