import java.util.Scanner;
import java.util.regex.*;
public class Room {

    private Enemy enemy;
    private boolean hasPotion;

    public Room(Enemy enemy, boolean hasPotion) {
        this.enemy = enemy;
        this.hasPotion = hasPotion;
    }

    public void enter(Player player, Scanner input) {
        System.out.println("You enter a new room.");

        if (enemy != null) {
            System.out.println("A " + enemy.getType() + " appears!");
            System.out.println("It has " + enemy.getHealth() + " HP!");

            System.out.println("You have " + player.getHealth() + " HP");

            while (enemy.isAlive() && player.isAlive()) {
                System.out.println("1. Attack");
                System.out.println("2. Heal");
                System.out.print("Choose: ");
                String choice = input.nextLine();
                while (choice.matches(".*[a-zA-Z].*") || Integer.parseInt(choice) != 1 && Integer.parseInt(choice) != 2){
                    System.out.println("Invalid option.");
                    choice = input.nextLine();
                }
                if (Integer.parseInt(choice) == 1) {
                    enemy.takeDamage(player.getAttack());
                    System.out.println("You attack the enemy!");

                    if (enemy.isAlive()) {
                        enemy.attackPlayer(player);
                    }
                } else if (Integer.parseInt(choice) == 2) {
                    player.heal();
                }
            }
        } else {
            System.out.println("The room is empty.");
        }

        if (hasPotion) {
            System.out.println("You found a potion!");
            player.increasePotions();
        }
    }
}
