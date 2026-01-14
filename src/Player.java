import java.util.Scanner;
import java.util.regex.*;

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
        Scanner s = new Scanner(System.in);
        if (potions > 0) {
            System.out.println("Would you like to use all your potions? \n1. Yes\n2. No");
            System.out.print("Choose: ");
            String choice = s.nextLine();
            while (choice.matches(".*[a-zA-Z].*") || Integer.parseInt(choice) != 1 && Integer.parseInt(choice) != 2){
                System.out.println("Invalid option.");
                choice = s.nextLine();
            }
            if (Integer.parseInt(choice) == 1){
                health += 20 * potions;
                potions = 0;
                System.out.println("You healed! Health is now " + health);
            } else {
                health += 20;
                potions--;
                System.out.println("You healed! Health is now " + health);
            }
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
