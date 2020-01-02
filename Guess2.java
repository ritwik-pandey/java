import java.util.*;
class Guess2{
	public static void main(String[] args){
			Menu();
		}
	public static void Menu(){
		Scanner in = new Scanner(System.in);
                System.out.println("	\nHey ! welcome to the game");
                System.out.println("           \n Main Menu");
                System.out.println("Press 1 for playing the game");
                System.out.println("Press 2 for instruction");
                System.out.println("Press 3 to know about the game ");
                System.out.println("Press 4 to quit");
                int choice = in.nextInt();
                if(choice == 1){
                        Game();
		}else if(choice == 2){
			System.out.println("Computer will guess the number between 1 - 50");
			System.out.println("You have to guess that number");
			System.out.println("You have infinite chances");
			System.out.println("if you guess the wrong number");
			System.out.println("computer will tell that the actual number is greater or smaller accordingly");
			Game();
		}else if(choice == 3){
			System.out.println("This is made by Ritwik a boy of class 8");
			Game();
		}else if(choice == 4){
			System.out.println("\nThanks for playing");
		}
	}
	public static void Game(){
		Scanner in = new Scanner(System.in);
		int number = (int)(Math.random()*50 + 1);
		System.out.println("\nGuess the number");
		int a = in.nextInt();
		int c =0;
		while((a != number) && (a != 0)){
			System.out.println("You have Guessed the wrong number");
			if(number < a){
				System.out.println("Number is smaller");
			}else{
				System.out.println("Number is greater");
			}
			System.out.println("you can also press 0 for going to main menu");
			System.out.println("\nGuess the number again");
                        a = in.nextInt();
			if(a == 0){
				Menu();
			}
			++c;
		}
		if(a != 0){
			System.out.println("\nCongratulations!!");
			System.out.println("You have guessed the Right number");
			System.out.println("You have taken " + c + " chances");
			Menu();
		}
	}
}
