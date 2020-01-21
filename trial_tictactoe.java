import java.util.*;
class trial_tictactoe{
		public static void main(String[] args){
			Menu();
		}
//GAME
	public static void Game(){
		Scanner in = new Scanner(System.in);
		Scanner in1 = new Scanner(System.in);
		System.out.println("You want to select X or O");
		System.out.println("Enter 1 for X or any digit for O");
		int a = in1.nextInt();
		String user = "";
		if(a == 1){
			user = "X";
		}else{
			user = "O";
		}
		int tie = 0;
		String main = "";
		int check = 1;
		String array[][] = {{"a","b","c"},{"d","e","f"},{"g","h","i"}};
		board(array);
		do{
			System.out.println("Enter the alphabet where you want to move");
			main = in.nextLine();
			tie = tie + 1;
			move(main,array,user);
			board(array);
			check = Check(array);
			if(check == 0){
				Win(user);
				break;
			}
			System.out.println("Enter the alphabet where other player wants to move");
			main = in.nextLine();
			tie = tie + 1;
			move2(main,array,user);
			board(array);
			check = Check(array);
			if(check == 0){
				if(user == "X"){
					user = "O";
				}else{
					user = "X";
				}
				Win(user);
				break;
			}
		}while(tie < 9);
		if(tie == 9){
			System.out.println("Sorry! but the the game is tied");
		}
	}
//MENU
	public static void Menu(){
		Scanner in = new Scanner(System.in);
		System.out.println("		Enter	1	to	play");
		System.out.println("		Enter	2	for	instruction");
		System.out.println("		Enter	3	to	quit");
		int choice = in.nextInt();
		if(choice == 1){
			Game();
		}else if(choice == 2){
			instruction();
			Game();
		}else if(choice == 3){
			System.out.println("	Thanks for playing");
		}
	}
//1st PLAYER MOVE
	public static void move(String main,String array[][],String user){
		for(int i = 0 ; i < 3 ; ++i){
			for(int j = 0 ; j < 3 ; ++j){	
				if(array[i][j].equalsIgnoreCase(main)){
					array[i][j] = user;
				}
			}
		}
	}
//2nd PLAYER CHANCE
	public static void move2(String main,String array[][],String user){
		if(user.equalsIgnoreCase("X")){
			user = "O";
		}else{
			user = "X";
		}
                for(int i = 0 ; i < 3 ; ++i){
                        for(int j = 0 ; j < 3 ; ++j){
                                if(array[i][j].equalsIgnoreCase(main)){
                                        array[i][j] = user;
                                }
                        }
                }
		
	}
//INSTRUCTIONS
	public static void instruction(){
		System.out.println("This is a tic tac game");
		try{Thread.sleep(1000);}catch(Exception e){}
		System.out.println("The game will finish when similar charcter 'X' Or 'O'");
		System.out.println("They form 3 pair diagonally or on boundary");
		System.out.println("Enter the alphabet where you want to move the chance");
		try{Thread.sleep(3000);}catch(Exception e){}
		System.out.println("The board will look like this :-");
		System.out.println("  a |   b   |  c ");
		System.out.println("----|-------|-----");
		System.out.println(" d  |   e   |  f  ");
		System.out.println("----|-------|-----");
		System.out.println(" g  |   h   |  i");
		try{Thread.sleep(500);}catch(Exception e){}
	}
//BOARD
	public static void board(String array[][]){
		System.out.println("\t\t\t\t"+array[0][0]+" | "+array[0][1]+" | "+array[0][2]);
		System.out.println("\t\t\t      ----|---|----");
		System.out.println("\t\t\t\t"+array[1][0]+" | "+array[1][1]+" | "+array[1][2]);
		System.out.println("\t\t\t      ----|---|----");
		System.out.println("\t\t\t\t"+array[2][0]+" | "+array[2][1]+" | "+array[2][2]);
		System.out.println();
	}
//CHECK
	public static int Check(String array[][]){
		int win = 1;
		for(int i = 0 ; i < 3; ++i){
			for(int j = 0 ; j < 1 ; ++j){
				if(array[i][j] == array[i][j +1] && array[i][j + 1] == array[i][j + 2]){
					win = 0;		
				}
			}
		}
		for(int i = 0 ; i < 3 ; ++i){
			for(int j = 0 ; j < 1 ; ++j){
				if(array[j][i] == array[j + 1][i] && array[j + 1][i] == array[j + 2][i]){
					win = 0;
				}
			}
		}
		if(array[0][0] == array[1][1] && array[1][1] == array[2][2]){
			win = 0;
		}
		if(array[0][1] == array[1][1] && array[1][1] == array[2][0]){
			win = 0;
		}
		return(win);
	}
//WIN
	public static void Win(String user){
		System.out.println("\t\t\tCONGRATULATIONS!!!!");
		System.out.println("The player who was playing with " + user + " has won");
		System.out.println("Hope you liked the game");
		Menu();
	}

}
