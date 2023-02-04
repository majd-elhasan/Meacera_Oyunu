import character.Fighter;
import character.fighters.Archer;
import character.fighters.Knight;
import character.fighters.Samurai;
import location.dangerous.Cave;
import location.dangerous.Desert;
import location.dangerous.Forest;
import location.dangerous.River;
import location.safe.Safe_Home;
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
                1. Store
                2. safe Home
                3. Cave
                4. Forest
                5. River
                6. Desert
                
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
    static void fight(Fighter player) throws NoSuchFieldException, IllegalAccessException {
        Scanner sc = new Scanner(System.in);
        outer :
        while (true){
            if(player.prizes.size()== 3){
                System.out.println("******************************\n*       CONGRATULATION       *\n******************************");
                System.out.println(player.prizes);
            }
            else if(player.getHealth()<= 0){
                System.out.println("******************************\n*          you lost          *\n*    Press 'r' to restart    *\n******************************");
                if(!Objects.equals(sc.nextLine(), "r"))
                    break ;
                System.out.println("******************************************\n");
                StartGame();
            }
            showPlaceOptions();
            int in = Integer.parseInt(sc.nextLine());

            switch (in){
                case 1 : Store.Receive(player); break;
                case 2 : Safe_Home.Receive(player); break;
                case 3 : if (!Cave.IS_FOOD_TAKEN) new Cave().battle(player,3);else System.out.println("you have food already");
                    break;
                case 4 : if(!Forest.IS_WOOD_TAKEN) new Forest().battle(player,3); else System.out.println("you have wood already");
                    break;
                case 5 : if (!River.IS_WATER_TAKEN) new River().battle(player,3); else System.out.println("you have water already");
                    break;
                case 6 : new Desert().battle(player,5); break;
                case 0 : break outer;
            }
            System.out.println(player);

        }

    }
}