import java.util.Scanner;

public class PlayerHuman implements Player {
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
        Scanner scanner = new Scanner(System.in);
        System.out.println( " Twój ruch ");
        return scanner.nextInt();
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


