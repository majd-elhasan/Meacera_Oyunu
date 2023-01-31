import character.GoodCharacter;
import character.goodCharacters.Archer;
import character.goodCharacters.Knight;
import character.goodCharacters.Samurai;
import location.dangerous.Cave;
import location.dangerous.Forest;
import location.dangerous.River;
import location.safe.Store;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        StartGame();
    }
    static void StartGame() throws NoSuchFieldException, IllegalAccessException {
        Scanner sc = new Scanner(System.in);

        showPlayerOptions();
        int in = Integer.parseInt(sc.nextLine());
        switch (in){
            case 1 : fight(new Samurai()); break;
            case 2 : fight(new Archer()); break;
            case 3 : fight(new Knight()); break;
            case 0 : break;
        }

        sc.close();
    }
    static void showPlaceOptions(){
        System.out.println("where do you want to go ?");
        System.out.println("""
                1. Cave
                2. Forest
                3. River
                4. Store
                5. safe Home

                0. Exit
                """);
        System.out.println();
    }

    static void showPlayerOptions(){
        System.out.println("where do you want to go ?");
        System.out.println("""
                1. Samurai
                2. Archer
                3. Knight

                0. Exit
                """);
    }
    static void fight(GoodCharacter player) throws NoSuchFieldException, IllegalAccessException {
        Scanner sc = new Scanner(System.in);
        outer :
        while (true){

            if(player.getHealth()<= 0){
                System.out.println("you lost \nPress 'r' to restart");
                if(!Objects.equals(sc.nextLine(), "r"))
                    break ;
                System.out.println("******************************************\n");
                StartGame();
            }
            showPlaceOptions();
            int in = Integer.parseInt(sc.nextLine());

            switch (in){
                case 1 : new Cave().battle(player); break;
                case 2 : new Forest().battle(player); break;
                case 3 : new River().battle(player); break;
                case 4 : Store.Receive(player); break;
                //case 5 : Safe_Home.Receive(samurai); break;
                case 0 : break outer;
            }
            System.out.println(player);

        }

    }
}