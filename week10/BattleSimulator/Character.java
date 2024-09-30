import java.util.Random;

abstract class Character {
    private String id;
    private String name;
    private int hp;
    private boolean isAlive;

    private static final Random random = new Random();
    
    public Character(String name, int hp) {
        this.id = generateId();
        this.name = name;
        this.hp = hp;
        this.isAlive = true;
    }

    private String generateId() {
        return "ID" + random.nextInt(1000);
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getHp() {
        return hp;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void setHp(int hp) {
        this.hp = hp;
        if (this.hp <= 0) {
            this.isAlive = false;
            this.hp = 0;
        }
    }
}
