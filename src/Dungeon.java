import java.util.Random;
import java.util.Scanner;

public class Dungeon {

    private Player player;
    private Random rand;
    private Scanner input;
    private int roomsCleared;

    public Dungeon() {
        player = new Player();
        rand = new Random();
        input = new Scanner(System.in);
        roomsCleared = 0;
    }

    public void startGame() {
        System.out.println("Welcome to the Dungeon!");

        while (player.isAlive()) {
            Room room = generateRoom();
            room.enter(player, input);

            if (!player.isAlive()) {
                break;
            }

            roomsCleared++;
            System.out.println("Rooms cleared: " + roomsCleared);
            System.out.println();
        }

        System.out.println("Game over!");
        System.out.println("Total rooms cleared: " + roomsCleared);
    }

    private Room generateRoom() {
        boolean hasEnemy = rand.nextBoolean();
        boolean hasPotion = rand.nextBoolean();

        Enemy enemy = null;
        if (hasEnemy) {
            enemy = new Enemy("Goblin", 20 + rand.nextInt(10), 5 + rand.nextInt(5));
        }

        return new Room(enemy, hasPotion);
    }
}
