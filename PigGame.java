package pig2;

public class PigGame {
    public static void main(String[] args) {
        printRules();
        System.out.println();

        Player player1 = new Player("Player 1");
        Player player2 = new Player("Player 2");
        System.out.println("Playing Pig");
        player1.play();
        while(player1.totalPoints < 100){
            player2.play();
            if(player2.totalPoints < 100){
                player1.play();
            }
        }



        printResults(player1, player2);
        System.out.println();


        System.out.println("Thank you for playing Pig.");
    }

    public static void printRules() {
        System.out.println("=====================================================");
        System.out.println("Pig: first person to hit 100 points wins!");
        System.out.println("=====================================================");
    }

    public static void printResults(Player player1, Player player2) {
        if(player1.totalPoints > player2.totalPoints){
            System.out.println("Player 1 wins!");
        }
        else{
            System.out.println("Player 2 wins!");
        }

    }

}
