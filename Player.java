package pig2;

import java.util.Scanner;

public class Player {

    private Die die;

    public int totalPoints;

    public int roundPoints;

    public String name;



    public Player(String playerName){
        this.die = new Die();
        this.totalPoints = 0;
        this.roundPoints = 0;
        this.name = playerName;
    }

    public void throwDice(){
        die.roll();
    }

    public void play(){
        Scanner scanner = new Scanner(System.in);
        System.out.println(name + " Roll?");
        scanner.nextLine();
        boolean finished = false;
        while(!finished){
            throwDice();
            System.out.printf("Rolling... %d\n", die.getFaceValue());
            if(die.getFaceValue() == 1){
                System.out.println(name + " lost round points.");
                roundPoints = 0;
                finished = true;
            }
            else{
                roundPoints += die.getFaceValue();
                System.out.println(name + " current score is: " + (roundPoints + totalPoints));
                System.out.println("Roll again? (Y/n)");
                String again = scanner.nextLine();
                if(roundPoints + totalPoints >= 100){
                    totalPoints += roundPoints;
                }
                if (again.toLowerCase().equals("n")) {
                    totalPoints += roundPoints;
                    roundPoints = 0;
                    finished = true;
                }
            }
        }
    }
}
