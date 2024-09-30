import java.util.Random;

class Wizard extends Character implements Attacker {
    private int mana;
    private int intelligence;

    public Wizard(String name) {
        super(name, new Random().nextInt(51) + 50); // HP entre 50 y 100
        this.mana = new Random().nextInt(41) + 10; // Mana entre 10 y 50
        this.intelligence = new Random().nextInt(50) + 1; // Intelligence entre 1 y 50
    }

    public void attack(Character opponent) {
        if (!isAlive()) return;

        int damage;
        String attackType;

        if (mana >= 5) {
            damage = intelligence; // Fireball
            mana -= 5;
            attackType = "Fireball";
        } else if (mana > 0) {
            damage = 2; // Staff hit
            mana += 1;
            attackType = "Staff Hit";
        } else {
            damage = 0; // No attack
            mana += 2;
            attackType = "No Attack";
        }

        opponent.setHp(opponent.getHp() - damage);
        System.out.printf("%s lanza un %s a %s, causando %d de daño!%n", getName(), attackType, opponent.getName(), damage);
    }
}
