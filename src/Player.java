public class Player {

    private int health;
    private int attack;
    private int potions;

    public Player() {
        health = 100;
        attack = 15;
        potions = 3;
    }

    public void takeDamage(int damage) {
        health -= damage;
        if (health < 0) {
            health = 0;
        }
    }

    public void heal() {
        if (potions > 0) {
            health += 20;
            potions--;
            System.out.println("You healed! Health is now " + health);
        } else {
            System.out.println("No potions left!");
        }
    }

    public boolean isAlive() {
        return health > 0;
    }

    public int getAttack() {
        return attack;
    }

    public int getHealth() {
        return health;
    }

    public void increasePotions() {
        potions++;
    }
}
