import java.util.Random;
import java.util.Scanner;

public class PlayerComputer implements Player{
Random random = new Random();
    int points ;
    String name;
    @Override
    public int getPoints() {
        return points;
    }

    @Override
    public void addPoints() {
        points++;
    }

    @Override
    public int getMove() {
        int movecomputer = random.nextInt(100);
        System.out.println( " Twój ruch ");
        return movecomputer;
    }
    @Override
    public void setName(String name) {
        this.name = name;

    }

    @Override
    public String getName() {
        return name;
    }
}
