public class Enemy {

    private String type;
    private int health;
    private int damage;

    public Enemy(String type, int health, int damage) {
        this.type = type;
        this.health = health;
        this.damage = damage;
    }

    public void takeDamage(int dmg) {
        health -= dmg;
        if (health < 0) {
            health = 0;
        }
    }

    public void attackPlayer(Player player) {
        player.takeDamage(damage);
        System.out.println(type + " hits you for " + damage + " damage!");
    }

    public boolean isAlive() {
        return health > 0;
    }

    public int getHealth() {
        return health;
    }

    public String getType() {
        return type;
    }
}
